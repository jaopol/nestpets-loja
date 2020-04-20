package br.com.nestpets.loja.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document
public class Perfil implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private String nome;
	

	@Override
	public String getAuthority() {
		return "ROLE_" + nome.replaceAll(" ", "_").toUpperCase();
	}

}
