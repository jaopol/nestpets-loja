package br.com.nestpets.loja.converters;

import org.springframework.stereotype.Component;

import br.com.nestpets.loja.dtos.LojaDTO;
import br.com.nestpets.loja.models.Loja;

/**
 * @author jp
 *
 */
@Component
public class LojaConverter {
	
	
	public LojaDTO transformEntityToDto( Loja entity ) {

		LojaDTO dto = new LojaDTO();
		
		if( entity != null ) {
			
			dto.setBairro( entity.getBairro() );
			dto.setCelular( entity.getCelular() );
			dto.setCep( entity.getCep() );
			dto.setCidade( entity.getCidade() );
			dto.setClassificação( entity.getClassificação() );
			dto.setCnpj( entity.getCnpj() );
			dto.setComplemento( entity.getComplemento() );
			dto.setEmail( entity.getEmail() );
			dto.setIbge( entity.getIbge() );
			dto.setInscricaoEstadual( entity.getInscricaoEstadual() );
			dto.setLinkFaceBook( entity.getLinkFaceBook() );
			dto.setLinkInstagran( entity.getLinkInstagran() );
			dto.setId( entity.getId() );
			dto.setLinkTwitter( entity.getLinkTwitter() );
			dto.setLogo( entity.getLogo() );
			dto.setLogradouro( entity.getLogradouro() );
			dto.setNomeFantasia( entity.getNomeFantasia() );
			dto.setNumeroFilial( entity.getNumeroFilial() );
			dto.setNumeroLoja( entity.getNumeroLoja() );
			dto.setRazaoSocial( entity.getRazaoSocial() );
			dto.setResponsavel( entity.getResponsavel() );
			dto.setTelefone( entity.getTelefone() );
			
		}
		
		return dto;
	}
	

	public Loja transformDtoToEntity( LojaDTO dto ) {
		
		Loja entity = new Loja();
		
		if( entity != null ) {

			entity.setBairro( dto.getBairro() );
			entity.setCelular( dto.getCelular() );
			entity.setCep( dto.getCep() );
			entity.setCidade( dto.getCidade() );
			entity.setClassificação( dto.getClassificação() );
			entity.setCnpj( dto.getCnpj() );
			entity.setComplemento( dto.getComplemento() );
			entity.setEmail( dto.getEmail() );
			entity.setIbge( dto.getIbge() );
			entity.setInscricaoEstadual( dto.getInscricaoEstadual() );
			entity.setLinkFaceBook( dto.getLinkFaceBook() );
			entity.setLinkInstagran( dto.getLinkInstagran() );
			entity.setId( dto.getId() );
			entity.setLinkTwitter( dto.getLinkTwitter() );
			entity.setLogo( dto.getLogo() );
			entity.setLogradouro( dto.getLogradouro() );
			entity.setNomeFantasia( dto.getNomeFantasia() );
			entity.setNumeroFilial( dto.getNumeroFilial() );
			entity.setNumeroLoja( dto.getNumeroLoja() );
			entity.setRazaoSocial( dto.getRazaoSocial() );
			entity.setResponsavel( dto.getResponsavel() );
			entity.setTelefone( dto.getTelefone() );
			
		}

		return entity;
	}
	
}