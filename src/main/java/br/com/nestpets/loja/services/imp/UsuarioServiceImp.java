package br.com.nestpets.loja.services.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nestpets.loja.models.Usuario;
import br.com.nestpets.loja.repositories.UsuarioRepository;
import br.com.nestpets.loja.services.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepositoy;
	
	@Override
	public Optional<Usuario> createUsuario(Usuario usuario) {
		return Optional.ofNullable( usuarioRepositoy.save( usuario ) );
	}

	@Override
	public Optional<Usuario> getUsuarioByUsername( String username ) {
		return Optional.ofNullable( usuarioRepositoy.findByUsername( username ) );
	}

}
