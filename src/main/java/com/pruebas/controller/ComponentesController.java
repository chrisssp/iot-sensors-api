package com.pruebas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebas.exception.ResourceNotFoundException;
import com.pruebas.model.Componente;
import com.pruebas.model.Valor;
import com.pruebas.repository.ComponenteRepository;
import com.pruebas.repository.ValorRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.sql.Timestamp;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ComponentesController {

	@Autowired
	private ComponenteRepository componenteRepository;
	@Autowired
	private ValorRepository valorRepository;

	@GetMapping("/componentes")
	public Map<String, Integer> getAllComponents() {
		List<Componente> lista = componenteRepository.findAll();
		Map<String, Integer> obj = new HashMap<String, Integer>();
		lista.forEach(t -> {
			obj.put(t.getElemento(), t.getEstado());
		});
		return obj;
	}

	@GetMapping("/componentes/save-data/{data}")
	public Map<String, Integer> saveData(@PathVariable(value = "data") String data) {
		String[] arregloDatos = data.split("_");

		// Valor para dht11 (temperatura)
		Valor valor1 = new Valor();
		valor1.setElemento("dht11_temperatura");
		valor1.setValor(Integer.parseInt(arregloDatos[0]));
		valor1.setFechaHora(new Timestamp(System.currentTimeMillis()));
		valorRepository.save(valor1);

		// Valor para dht11 (humedad)
		Valor valor2 = new Valor();
		valor2.setElemento("dht11_humedad");
		valor2.setValor(Integer.parseInt(arregloDatos[1]));
		valor2.setFechaHora(new Timestamp(System.currentTimeMillis()));
		valorRepository.save(valor2);

//		// Valor para 'ledRojo'
//		Valor valor8 = new Valor();
//		valor8.setElemento("ledRojo");
//		valor8.setValor(Integer.parseInt(arregloDatos[0]));
//		valor8.setFechaHora(new Timestamp(System.currentTimeMillis()));
//		valorRepository.save(valor8);
//
//		// Valor para 'ledVerde'
//		Valor valor9 = new Valor();
//		valor9.setElemento("ledVerde");
//		valor9.setValor(Integer.parseInt(arregloDatos[1]));
//		valor9.setFechaHora(new Timestamp(System.currentTimeMillis()));
//		valorRepository.save(valor9);
//
//		// Valor para 'ledAzul'
//		Valor valor10 = new Valor();
//		valor10.setElemento("ledAzul");
//		valor10.setValor(Integer.parseInt(arregloDatos[2]));
//		valor10.setFechaHora(new Timestamp(System.currentTimeMillis()));
//		valorRepository.save(valor10);

		List<Componente> lista = componenteRepository.findAll();
		Map<String, Integer> obj = new HashMap<String, Integer>();
		lista.forEach(t -> {
			obj.put(t.getElemento(), t.getEstado());
		});
		return obj;
	}

	@GetMapping("/componentes/{elemento}/{estado}")
	public ResponseEntity<Componente> updateComponent(@PathVariable(value = "elemento") String elemento,
			@PathVariable(value = "estado") Integer estado) throws ResourceNotFoundException {
		Optional<Componente> optionalComponente = componenteRepository.findByElemento(elemento);
		Componente componenteActualizado = null;

		Componente componente = optionalComponente.get();
		componente.setEstado(estado);
		componenteActualizado = componenteRepository.save(componente);

		return ResponseEntity.ok(componenteActualizado);
	}
}
