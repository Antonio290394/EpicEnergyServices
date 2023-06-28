package com.hans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hans.model.Provincia;
import java.util.List;


public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

	public Provincia findByNome(String nome);

	
}
