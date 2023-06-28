package com.hans.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hans.model.Cliente;
import com.hans.model.Fattura;
import com.hans.repository.ClienteRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	
	public Cliente searchCliente(Long id) {
		return clienteRepository.findById(id).get();
	}
	
	public Cliente updateCliente(Long id, Cliente cliente) {
		if(!clienteRepository.existsById(id)) {
			throw new EntityExistsException("Cliente già esistente!");
		}
		return clienteRepository.save(cliente);
	}
	

	public List<Cliente> cercaPerFatturatoAnnualeMaggiore(double importo){
		return clienteRepository.findByFatturatoAnnualeGreaterThanEqual(importo);
	}
	
	
    public List<Cliente> searchAllClienti(){
    	return clienteRepository.findAll();
    	
    } 
    
    public List<Cliente> cercaPerDataInserimento(LocalDate dataInsert){
    	return clienteRepository.findByDataInserimentoAfter(dataInsert);
    }
    
    public List<Cliente> cercaPerDataUltimoContatto(LocalDate ultimoContatto){
    	return clienteRepository.findByDataUltimoContattoAfter(ultimoContatto);
    }
    
    public List<Cliente> cercaPerParteDelNome(String partName){
    	return clienteRepository.findByNomeContattoContainsAllIgnoreCase(partName);
    }
    
    public List<Fattura>  cercaFatturaByCliente(String clienteFattura){
    	return clienteRepository.findByNomeContattoAllIgnoreCase(clienteFattura).getFattura();
    }
    
    public List<Cliente> ordinaPerNomeCliente(){
    	return clienteRepository.getByOrderByNomeContatto();
    }
    
    public List<Cliente> ordinaPerFatturatoAnnuale(){
    	return clienteRepository.getByOrderByFatturatoAnnuale();
    }
    
    public List<Cliente> ordinaPerDataInserimento(){
    	return clienteRepository.getByOrderByDataInserimento();
    }
    
    public List<Cliente> ordinaPerDataUltimoContatto(){
    	return clienteRepository.getByOrderByDataUltimoContatto();
    }
}
  