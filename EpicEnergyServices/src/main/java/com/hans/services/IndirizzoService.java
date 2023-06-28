package com.hans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.model.Indirizzo;
import com.hans.repository.IndirizzoRepository;

@Service
public class IndirizzoService {

	@Autowired
	 IndirizzoRepository indirizzoRepository;
	
     public Indirizzo saveIndirizzo(Indirizzo indirizzo) {
    	 return indirizzoRepository.save(indirizzo);
     }
     
	 public Indirizzo searchIndirizzo(Long id) {
		 return indirizzoRepository.findById(id).get();
	 }
	 
	 public Indirizzo updateIndirizzo (Indirizzo indirizzo) {
	    return indirizzoRepository.save(indirizzo);
	 }
}
