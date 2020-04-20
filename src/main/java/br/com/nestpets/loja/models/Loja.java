package br.com.nestpets.loja.models;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document( collection = "loja" )
public class Loja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Integer numeroFilial;
	private String inscricaoEstadual;
	private String logradouro;
	private String numeroLoja;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String ibge;
	private String email;
	private String telefone;
	private String celular;
	private String responsavel;
	private Byte[] logo;
	private String classificação;
	private String linkTwitter;
	private String linkInstagran;
	private String linkFaceBook;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@CreatedDate
	private Instant dataCriacao;

	@LastModifiedBy
	private String lastModifiedUser;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@LastModifiedDate
	private Instant dataAtualizacao;

}
