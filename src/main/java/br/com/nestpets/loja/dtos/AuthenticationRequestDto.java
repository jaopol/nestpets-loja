package br.com.nestpets.loja.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AuthenticationRequestDto {

	@NotBlank( message = "Usário não pode ser vázio" )
	private String username;
	
	@NotBlank( message = "Senha não pode ser vázio" )
	private String senha;

	public AuthenticationRequestDto() {
	}

	@Override
	public String toString() {
		return "AuthenticationRequestDto [username=" + username + ", senha=" + senha + "]";
	}

}
