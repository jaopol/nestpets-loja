package br.com.nestpets.loja.converters;

import org.springframework.stereotype.Component;

import br.com.nestpets.loja.dtos.UsuarioDTO;
import br.com.nestpets.loja.models.Usuario;
import br.com.nestpets.loja.util.PasswordUtils;

@Component
public class UsuarioConverter {

	public UsuarioDTO transformEntityToDto( Usuario entity ) {

		UsuarioDTO dto = new UsuarioDTO();
		
		if( entity != null ) {
			
			dto.setEmail( entity.getEmail() );
			dto.setNome( entity.getNome() );
			dto.setUsername( entity.getUsername() );
		}
		
		return dto;
	}
	

	public Usuario transformDtoToEntity( UsuarioDTO dto ) {
		
		Usuario entity = new Usuario();
		
		if( entity != null ) {

			entity.setEmail( dto.getEmail() );
			entity.setNome( dto.getNome() );
			entity.setSenha( PasswordUtils.geraBCrypt( dto.getSenha() ) );
			entity.setUsername( dto.getUsername() );
			
		}

		return entity;
	}
}
