package com.hans.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hans.model.Cliente;
import java.time.LocalDate;
import com.hans.model.Fattura;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //GreaterThan indica maggiore di
    //perciò con questa quesry andiamo a cercare ogni cliente con un fatturato annuale
    //di quello che gli passiamo come parametro

		public List<Cliente> findByFatturatoAnnualeGreaterThanEqual(double FatturatoAnnuale);
		
	 
		public List<Cliente> findByDataInserimentoAfter(LocalDate dataInserimento);
		
		public List<Cliente> findByDataUltimoContattoAfter(LocalDate dataUltimoContatto);
    
		public List<Cliente> findByNomeContattoContainsAllIgnoreCase(String nomeContatto);
		
		public Cliente findByNomeContattoAllIgnoreCase(String nomeContatto);
		
		public List<Cliente> getByOrderByNomeContatto();
		
		public List<Cliente> getByOrderByFatturatoAnnuale();
		
		public List<Cliente> getByOrderByDataInserimento();
		
		public List<Cliente> getByOrderByDataUltimoContatto();
	
}
