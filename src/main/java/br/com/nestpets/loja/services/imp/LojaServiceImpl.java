package br.com.nestpets.loja.services.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nestpets.loja.models.Loja;
import br.com.nestpets.loja.repositories.LojaRepository;
import br.com.nestpets.loja.services.LojaService;

@Service
public class LojaServiceImpl implements LojaService {

	@Autowired
	private LojaRepository lojaRepository;

	@Override
	public Optional<Loja> createLoja(Loja loja) {
		return Optional.ofNullable( lojaRepository.save( loja ) );
	}
	
}
