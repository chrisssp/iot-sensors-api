package com.pruebas.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebas.exception.ResourceNotFoundException;
import com.pruebas.model.Valor;
import com.pruebas.model.Valor;
import com.pruebas.repository.ValorRepository;

@RestController
@RequestMapping("/api")
public class ValoresController {

    @Autowired
    private ValorRepository valorRepository;

    @GetMapping("/valores")
    public List<Valor> getAllValues() {
        return valorRepository.findAll();
    }
    
    @GetMapping("/valores/{elemento}")
    public ResponseEntity<List<Valor>> getSpecificValue(@PathVariable(value= "elemento") String elemento) throws ResourceNotFoundException {
        List<Valor> valores = valorRepository.findByElemento(elemento);
        return ResponseEntity.ok().body(valores);
    }
    
    @PostMapping("/valores")
    public ResponseEntity<Valor> addValue(@RequestBody Valor valor) {
        valor.setFechaHora(new Timestamp(System.currentTimeMillis()));
        Valor nuevoValor = valorRepository.save(valor);
        return ResponseEntity.ok().body(nuevoValor);
    }
}
