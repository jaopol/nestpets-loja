package br.com.nestpets.loja.services.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.nestpets.loja.models.Usuario;
import br.com.nestpets.loja.security.UserFactory;
import br.com.nestpets.loja.services.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioService.getUsuarioByUsername( username );

		if ( user.isPresent() && user.get() != null ) {
			return UserFactory.create(user.get());
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
