package br.com.nestpets.loja.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.nestpets.loja.models.Loja;

@Repository
public interface LojaRepository extends MongoRepository<Loja, String> {

}
