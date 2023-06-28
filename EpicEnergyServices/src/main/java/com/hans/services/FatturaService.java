package com.hans.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.enumeration.Stato_Fatture;
import com.hans.model.Fattura;
import com.hans.repository.FatturaRepository;

@Service
public class FatturaService {

	@Autowired
	FatturaRepository fatturaRepository;
	
    public Fattura saveFattura(Fattura fattura) {
    	return fatturaRepository.save(fattura);
    }
    public Fattura searchFattura(Long id) {
    	return fatturaRepository.findById(id).get();
    }
    public Fattura updateFattura(Fattura fattura) {
    	return fatturaRepository.save(fattura);
    }
   public List<Fattura> searchAllFatture(){
	   return fatturaRepository.findAll();
   }
   
   public List<Fattura> ricercaStatus(Stato_Fatture statofattura){
	   return fatturaRepository.ricercaPerStatoFattura(statofattura);
   }
   
   public List<Fattura> ricercaPerDataFattura(LocalDateTime data) {
	   return fatturaRepository.findByDataAfter(data);
   }
   
   public List<Fattura> ricercaFatturaPerAnno(Integer anno) {
	   return fatturaRepository.findByAnno(anno);
   }
   
   public List<Fattura> ricercaPerImporto(double importo, double importo2){
	   return fatturaRepository.findByImportoBetween(importo, importo2);
   }
}
 