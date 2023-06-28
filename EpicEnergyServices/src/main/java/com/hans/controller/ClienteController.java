package com.hans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hans.model.Cliente;
import com.hans.services.ClienteService;

@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

	@Autowired 
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(clienteService.searchAllClienti());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		return ResponseEntity.ok(clienteService.searchCliente(id));
	}
	@PostMapping
	public ResponseEntity<?> creaPrenotazione(@RequestBody Cliente c){
		return ResponseEntity.ok(clienteService.saveCliente(c));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificaPrenotazione(@PathVariable Long id,@RequestBody Cliente c){
		return ResponseEntity.ok(clienteService.updateCliente(id, c));
		
	}
	
}