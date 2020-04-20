package br.com.nestpets.loja.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.nestpets.loja.models.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	Usuario findByUsername(String username);

}
