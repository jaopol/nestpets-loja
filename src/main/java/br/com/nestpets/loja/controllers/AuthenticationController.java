package br.com.nestpets.loja.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nestpets.loja.dtos.AuthenticationRequestDto;
import br.com.nestpets.loja.dtos.UsuarioDTO;
import br.com.nestpets.loja.models.Usuario;
import br.com.nestpets.loja.response.Response;
import br.com.nestpets.loja.services.UsuarioService;
import br.com.nestpets.loja.util.TokenUtil;
import io.swagger.annotations.Api;

@Api( tags = "autenticacao" )
@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "*")
public class AuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";

	/*@Autowired
	private AuthenticationManager authenticationManager;
*/
	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Gera e retorna um novo token JWT.
	 * 
	 * @param authenticationDto
	 * @param result
	 * @return ResponseEntity<Response<UsuarioDto>>
	 * @throws AuthenticationException
	 */
	@PostMapping
	public ResponseEntity<Response<UsuarioDTO>> generateTokenJwt(
			@Valid @RequestBody AuthenticationRequestDto authenticationDto, BindingResult result)
			throws AuthenticationException {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();

		if (result.hasErrors()) {
			log.error("Erro validando lançamento: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		log.info("Gerando token para o usuario {}.", authenticationDto.getUsername() );
		/*Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(), authenticationDto.getSenha()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
*/
		UserDetails userDetails = userDetailsService.loadUserByUsername( authenticationDto.getUsername() );
		Optional<Usuario> usuarioOpt = usuarioService.getUsuarioByUsername( authenticationDto.getUsername() );

		String token = tokenUtil.getToken(userDetails);
		UsuarioDTO usuarioAutenticado = new UsuarioDTO();
		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			usuarioAutenticado.setId( usuario.getId() );
			usuarioAutenticado.setEmail( usuario.getEmail() );
			usuarioAutenticado.setNome( usuario.getNome() );
			usuarioAutenticado.setPerfis( usuario.getPerfis() );
			usuarioAutenticado.setUsername( usuario.getUsername() );
			usuarioAutenticado.setToken( token );
		}
		response.setData(usuarioAutenticado);

		return ResponseEntity.ok(response);
	}

	/**
	 * Gera um novo token com uma nova data de expiração.
	 * 
	 * @param request
	 * @return ResponseEntity<Response<UsuarioDto>>
	 */
	@PostMapping(value = "/refresh")
	public ResponseEntity<Response<UsuarioDTO>> genarateRefreshTokenJwt(HttpServletRequest request) {
		log.info("Gerando refresh token JWT.");
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));

		if (token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}

		if (!token.isPresent()) {
			response.getErros().add("Token não informado.");
		} else if (!tokenUtil.isTokenValidate(token.get())) {
			response.getErros().add("Token inválido ou expirado.");
		}

		if (!response.getErros().isEmpty()) {
			return ResponseEntity.badRequest().body(response);
		}

		String refreshedToken = tokenUtil.refreshToken(token.get());
		response.setData(new UsuarioDTO(refreshedToken));
		return ResponseEntity.ok(response);
	}

}
