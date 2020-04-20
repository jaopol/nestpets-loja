package br.com.nestpets.loja.controllers;

import java.util.Arrays;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nestpets.loja.response.Response;
import br.com.nestpets.loja.services.UsuarioService;
import br.com.nestpets.loja.converters.UsuarioConverter;
import br.com.nestpets.loja.dtos.UsuarioDTO;
import br.com.nestpets.loja.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( tags = "usuaio" )
@RestController
@RequestMapping( value = "/api/v1/usuario" )
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioConverter usuarioConverter;

	@ApiOperation( value = "Grava o usuário" )
	@PostMapping( produces = "application/json" )
	public ResponseEntity<Response<UsuarioDTO>> createUsuario( @Valid @RequestBody UsuarioDTO usuarioDTO ){
		
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		
		Optional<Usuario> entity = usuarioService.createUsuario( usuarioConverter.transformDtoToEntity( usuarioDTO ) );
		
		if( entity.isPresent() ) {
			UsuarioDTO dto = usuarioConverter.transformEntityToDto( entity.get() );
			dto.setToken( "Teste token" );
			response.setData( dto );
			return ResponseEntity.status( HttpStatus.CREATED ).body( response );
		}
		
		response.setErros( Arrays.asList( "Usuário não cadastro!" ) );
		return ResponseEntity.badRequest().body( response );
		
	} 
}
