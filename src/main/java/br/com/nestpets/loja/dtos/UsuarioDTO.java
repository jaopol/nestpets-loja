package br.com.nestpets.loja.dtos;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.nestpets.loja.models.Perfil;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {
	
	public UsuarioDTO(String refreshedToken) {
		this.token = refreshedToken;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "ID do usuário", hidden = true)
	private String id;
	
	@ApiModelProperty(value = "Nome do usário")
	@NotNull
	private String nome;
	
	@ApiModelProperty(value = "Nome de autenticação do usuário")
	private String username;
	
	@ApiModelProperty(value = "Senha do usuário")
	private String senha;
	
	@ApiModelProperty(value = "E-mail do usuário")
	@NotNull
	@Email
	private String email;
	
	@ApiModelProperty(value = "Token gerado para o acesso do usuário", hidden = true)
	private String token;
	
	private List<Perfil> perfis;

}
