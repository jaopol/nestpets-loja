package br.com.nestpets.loja.services;

import java.util.Optional;

import br.com.nestpets.loja.models.Usuario;

/**
 * @author jp
 *
 */
public interface UsuarioService {

	/**
	 * Grava um usuário
	 * 
	 * @param usuario
	 * @return
	 */
	Optional<Usuario> createUsuario( Usuario usuario );

	/**
	 * Recupera o usuario pelo username
	 * @param username
	 * @return
	 */
	Optional<Usuario> getUsuarioByUsername(String username);
}
