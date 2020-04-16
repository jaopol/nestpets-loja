package br.com.nestpets.loja.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class LojaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Código da loja", hidden = true)
	private String id;
	
	@ApiModelProperty(value = "CPNJ da empresa")
	@NotNull
	private String cnpj;
	
	@NotNull
	@ApiModelProperty(value = "Razão sócial da empresa")
	@Length(min = 3, max = 150, message = "Razão sócial da empresa deve possuir o minimo de 3 e o maximo de 150 caracteres.")
	private String razaoSocial;
	
	@ApiModelProperty(value = "Nome fantasia da empresa")
	@Length(min = 3, max = 150, message = "Razão sócial da empresa deve possuir o minimo de 3 e o maximo de 150 caracteres.")
	private String nomeFantasia;
	
	@ApiModelProperty(value = "Númeroa da filial da empresa")
	private Integer numeroFilial;
	
	@ApiModelProperty(value = "Inscrição Estadual da empresa")
	private String inscricaoEstadual;
	
	@ApiModelProperty(value = "Endereço da empresa")
	@NotNull
	private String logradouro;
	
	@ApiModelProperty(value = "Número do endereço da empresa")
	@NotNull
	private String numeroLoja;
	
	@ApiModelProperty(value = "Complemento do endereço da empresa")
	private String complemento;
	
	@ApiModelProperty(value = "Bairro da empresa")
	@NotNull
	private String bairro;
	
	@ApiModelProperty(value = "CEP da empresa")
	@NotNull
	private String cep;
	
	@ApiModelProperty(value = "Cidade da empresa")
	@NotNull
	private String cidade;
	
	@ApiModelProperty(value = "IBGE da empresa")
	private String ibge;
	
	@ApiModelProperty(value = "E-mail do responsável")
	@Email(message = "E-mail invalido")
	private String email;
	
	@ApiModelProperty(value = "Telefone da empresa")
	@NotNull
	private String telefone;
	
	@ApiModelProperty(value = "Celular da empresa")
	private String celular;
	
	@ApiModelProperty(value = "Responsável pela empresa")
	@NotNull
	private String responsavel;
	
	@ApiModelProperty(value = "Logo da empresa")
	private Byte[] logo;
	
	@ApiModelProperty(value = "Classificação da empresa")
	private String classificação;
	
	@ApiModelProperty(value = "Link da empresa no Twitter")
	private String linkTwitter;
	
	@ApiModelProperty(value = "Link da empresa no Instagran")
	private String linkInstagran;
	
	@ApiModelProperty(value = "Link da empresa no Facebook")
	private String linkFaceBook;

	
}
