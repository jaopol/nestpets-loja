package br.com.nestpets.loja.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import br.com.nestpets.loja.models.Perfil;
import br.com.nestpets.loja.models.Usuario;

public class UserFactory {

	private UserFactory() {
	}

	/**
	 * Converte e gera um AwsUser com base nos dados de um funcionário.
	 * 
	 * @param usuario
	 * @return AwsUser
	 */
	public static UserCredential create( Usuario usuario) {
		return new UserCredential( usuario.getId(), usuario.getEmail(), usuario.getSenha(),
				mapToGrantedAuthorities( usuario.getPerfis() )  );
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	 * 
	 * @param roles
	 * 
	 * @param perfilEnum
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Perfil> perfis) {

		if( !CollectionUtils.isEmpty( perfis ) ) {
			return perfis.stream().map(perfil -> perfil).collect( ArrayList::new, ArrayList::add, ArrayList::addAll );
		}
		
		return new ArrayList<GrantedAuthority>();
	}

}
