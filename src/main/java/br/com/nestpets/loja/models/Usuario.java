package br.com.nestpets.loja.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document( collection = "usuario" )
public class Usuario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String nome;
	
	private String email;
	
	private String username;
	
	private String senha;
	
	private List<Perfil> perfis;
	
}
