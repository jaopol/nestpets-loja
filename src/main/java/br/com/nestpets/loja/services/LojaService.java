package br.com.nestpets.loja.services;

import java.util.Optional;

import br.com.nestpets.loja.models.Loja;

public interface LojaService {
	
	/**
	 * Grava uma loja
	 * 
	 * @param loja
	 * @return
	 */
	Optional<Loja> createLoja( Loja loja );

}
