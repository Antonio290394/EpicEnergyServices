package com.hans.model;

import java.time.LocalDate;
import java.util.List;
import com.hans.enumeration.TipoCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clienti")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ragione_sociale;
	
	private Long partita_iva;
	
	private String email;
	
	// data inserimento cliente
	@Column(name = "data_inserimento")
	private LocalDate dataInserimento;
	
	@Column(name = "data_ultimo_contatto")
	private LocalDate dataUltimoContatto;
	
	@Column(name = "fatturato_annuale")
	private double fatturatoAnnuale;
	
	private String pec;
	
	private String telefono;
	
	@Column(name = "email_contatto")
	private String emailContatto;

	@Column(name = "nome_contatto")
	private String nomeContatto;
	
	@Column(name = "cognome_contatto")
	private String congomeContatto;
	
	@Column(name = "telefono_contatto")
	private String telefonoContatto;
	
	@JoinColumn(name = "sede_legale")
	@ManyToOne
	private Indirizzo sedeLegale;
	
	@JoinColumn(name = "sede_operativa")
	@ManyToOne
	private Indirizzo sedeOperativa; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_cliente")
	private TipoCliente tipoCliente;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Fattura> fattura;

}
