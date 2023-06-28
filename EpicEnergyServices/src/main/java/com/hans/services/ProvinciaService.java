package com.hans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.model.Provincia;
import com.hans.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
	
	@Autowired
	ProvinciaRepository provinciaRepository;
	
	

	public Provincia cercaProvinciaConNome(String nome) {
		return provinciaRepository.findByNome(nome);
	}
	
}
  