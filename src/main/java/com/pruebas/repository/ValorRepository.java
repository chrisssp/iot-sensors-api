package com.pruebas.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.pruebas.model.Valor;

public interface ValorRepository extends MongoRepository<Valor, String> {
    
    @Query("{'elemento': ?0}")
    List<Valor> findByElemento(String elemento);
    
}
