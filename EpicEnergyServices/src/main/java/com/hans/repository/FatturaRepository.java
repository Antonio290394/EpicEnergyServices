package com.hans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hans.enumeration.Stato_Fatture;
import com.hans.model.Fattura;
import java.time.LocalDateTime;


@Repository
public interface FatturaRepository extends JpaRepository<Fattura, Long> {

	@Query("SELECT f FROM Fattura f WHERE f.stato.statoFatture = :statoFat")
	List<Fattura> ricercaPerStatoFattura(Stato_Fatture statoFat);
	
	List<Fattura> findByDataAfter(LocalDateTime data);
	
	List<Fattura> findByAnno(Integer anno);
	
	List<Fattura> findByImportoBetween(double importo, double importo2);
	
	
}
