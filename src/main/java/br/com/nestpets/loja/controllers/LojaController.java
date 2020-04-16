package br.com.nestpets.loja.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nestpets.loja.converters.LojaConverter;
import br.com.nestpets.loja.dtos.LojaDTO;
import br.com.nestpets.loja.models.Loja;
import br.com.nestpets.loja.response.Response;
import br.com.nestpets.loja.services.LojaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( tags = "loja" )
@RequestMapping( value = "/api/v1/loja" )
@RestController
public class LojaController {

	@Autowired
	private LojaService lojaService;
	@Autowired
	private LojaConverter lojaConverter;
	
	@ApiOperation( value = "Grava uma loja" )
	@PostMapping( produces = "application/json" )
	public ResponseEntity<Response<Loja>> createLoja( @Valid @RequestBody LojaDTO lojaDTO ){
		
		Response<Loja> response = new Response<Loja>();
		
		Optional<Loja> createLoja = lojaService.createLoja( lojaConverter.transformDtoToEntity( lojaDTO ) );
		
		response.setData( createLoja.get() );
		
		return ResponseEntity.ok( response );
	}

}
