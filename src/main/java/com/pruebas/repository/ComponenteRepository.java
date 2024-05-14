package com.pruebas.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pruebas.model.Componente;

public interface ComponenteRepository extends MongoRepository<Componente, String> {
	 Optional<Componente> findByElemento(String elemento);
}
