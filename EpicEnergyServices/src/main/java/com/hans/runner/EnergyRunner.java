package com.hans.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.hans.enumeration.Stato_Fatture;
import com.hans.enumeration.TipoCliente;
import com.hans.model.Cliente;
import com.hans.model.Comune;
import com.hans.model.Fattura;
import com.hans.model.Indirizzo;
import com.hans.model.Provincia;
import com.hans.model.StatoFattura;
import com.hans.repository.ComuneRepository;
import com.hans.repository.ProvinciaRepository;
import com.hans.repository.StatoFatturaRepository;
import com.hans.services.ClienteService;
import com.hans.services.FatturaService;
import com.hans.services.IndirizzoService;
import com.hans.services.ProvinciaService;

@Component
public class EnergyRunner implements CommandLineRunner {

	@Autowired
	StatoFatturaRepository statoFatturaRepository;
	
	@Autowired
	FatturaService fatturaService;

	@Autowired
	ProvinciaRepository provinciaRepository;

	@Autowired
	ProvinciaService provinciaService;
	
	@Autowired
	ComuneRepository comuneRepository;
	
	@Autowired
	IndirizzoService indirizzoService;
	
	@Autowired
	ClienteService clienteService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner epic energy sevrices.... ");

		if (statoFatturaRepository.findAll().size() == 0) {
			setStatoFatture();
		}

		if (provinciaRepository.findAll().size() == 0) {
			setProvince();
		}
		
		if (comuneRepository.findAll().size() == 0) {
			setComune();
		}
		
		
		 if(clienteService.searchAllClienti().size()!=60){
			for(int i = 0; i < 30; i++) {
				setClienti();
			}
		}
//
//		System.out.println("----\nLista clienti per Fatturato annuale maggiore tot:\n----");
//		List<Cliente> listaClienti=clienteService.cercaPerFatturatoAnnualeMaggiore(9000000);
//		listaClienti.forEach(c->System.out.println(c.getNomeContatto()));
//		
//		
//		 System.out.println("----\nLista clienti per data di inserimento contatto:\n----");
//		List<Cliente> listaDataInserimento=clienteService.cercaPerDataInserimento(LocalDate.of(2022, 10, 6));
//		listaDataInserimento.forEach(d->System.out.println(d.getDataInserimento() + " " +d.getNomeContatto()+" "+d.getCongomeContatto()));
//
//		
//		System.out.println("----\nLista clienti per data dell'ultimo contatto:\n----");
//		List<Cliente> listaDataUltimoContatto=clienteService.cercaPerDataUltimoContatto(LocalDate.of(2022, 1, 10));
//		listaDataUltimoContatto.forEach(u->System.out.println(u.getDataUltimoContatto()+" "+u.getNomeContatto()+" "+u.getCongomeContatto()));
//
//		System.out.println("----\nLista clienti per parte del nome del contatto:\n----");	
//		List<Cliente> listaParteDelNome=clienteService.cercaPerParteDelNome("M");
//		listaParteDelNome.forEach(n->System.out.println(n.getNomeContatto()));
//
//		System.out.println("----\nLista Fatture per cliente:\n----");	
//		List<Fattura> listaFatturePerCliente=clienteService.cercaFatturaByCliente("Fulvio");
//		listaFatturePerCliente.forEach(fc->System.out.println(fc));
//
//		System.out.println("----\nRicerca per Stato della Fattura:\n----");	
//		List<Fattura> listaStatoFattura=fatturaService.ricercaStatus(Stato_Fatture.NON_PAGATO);
//		listaStatoFattura.forEach(st->System.out.println(st));
//		 
//		System.out.println("----\nRicerca per data Fattura:\n----");	
//		List<Fattura> listaDateFattura=fatturaService.ricercaPerDataFattura(LocalDateTime.of(LocalDate.of(2022, 10, 2), LocalTime.of(17, 00)));
//		listaDateFattura.forEach(df->System.out.println(df));
//		
//		System.out.println("----\nRicerca fattura per anno:\n----");	
//		List<Fattura> listaFatturaAnno=fatturaService.ricercaFatturaPerAnno(2022);
//		listaFatturaAnno.forEach(fa->System.out.println(fa));
		
//		System.out.println("----\nRicerca importo Fattura:\n----");	
//		List<Fattura> listaImportoFattura=fatturaService.ricercaPerImporto(197132.192, 232529.501);
//		listaImportoFattura.forEach(fi->System.out.println(fi));
		
//		System.out.println("----\nOrdina per cliente:\n----");	
//		List<Cliente> listaordinePerCliente=clienteService.ordinaPerNomeCliente();
//		listaordinePerCliente.forEach(oc->System.out.println(oc.getNomeContatto()+" "+oc.getCongomeContatto()));

//		System.out.println("----\nOrdina per fattura annuala:\n----");	
//		List<Cliente> listaFatturaAnnuale=clienteService.ordinaPerFatturatoAnnuale();
//		listaFatturaAnnuale.forEach(fa->System.out.println(fa.getNomeContatto()+" "+fa.getCongomeContatto()+", fatturato annuale: "+fa.getFatturatoAnnuale()));

		 System.out.println("----\nOrdina per data inserimento:\n----");	
		 List<Cliente> listaDataInserimento=clienteService.ordinaPerDataInserimento();
		 listaDataInserimento.forEach(da->System.out.println(da.getNomeContatto()+" "+da.getCongomeContatto()+", data inserimento: "+da.getDataInserimento()));

//		 System.out.println("----\nOrdina per data ultimo contatto:\n----");	
//		 List<Cliente> listaDataUltimoContatto=clienteService.ordinaPerDataUltimoContatto();
//		 listaDataUltimoContatto.forEach(ul->System.out.println(ul.getNomeContatto()+" "+ul.getCongomeContatto()+", data ultimo contatto: "+ul.getDataUltimoContatto()));


	}
	
	
//	METODO PER GENERARE LO STATO DELLE FATTURE
	public void setStatoFatture() {
		StatoFattura st = new StatoFattura(null, Stato_Fatture.PAGATO);
		StatoFattura st2 = new StatoFattura(null, Stato_Fatture.NON_PAGATO);
		statoFatturaRepository.save(st);
		statoFatturaRepository.save(st2);
	}

//	METODO PER COLLEGARE LE PROVINCE SUL DB
	public void setProvince() {
		String provinceTotali;
		String[] rigaProvincia;
		String[] unicaProvincia;
		Scanner sc;
		
		try {
			sc = new Scanner(new File("comuniEProvince/province-italiane.csv"));
			sc.useDelimiter(","); 
			while (sc.hasNext()) 
			{
				provinceTotali = sc.next();
				rigaProvincia = provinceTotali.split("\n");
				for (int i = 0; i < rigaProvincia.length; i++) {
					unicaProvincia = rigaProvincia[i].split(";");
					Provincia p = new Provincia(null, unicaProvincia[0], unicaProvincia[1], unicaProvincia[2]);
					provinciaRepository.save(p);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
    
//	METODO PER COLLEGARE I COMUNI SUL DB
	public void setComune() {
		Scanner sc2;
		String comuniTotali;
		String[] rigaComuni;
		String[] unicoComune;
		

		try {
			sc2 = new Scanner(new File("comuniEProvince/comuni-italiani.csv"));
			sc2.useDelimiter(","); 
			while (sc2.hasNext()) 
			{
				comuniTotali = sc2.next();
				rigaComuni = comuniTotali.split("\n");
				for (int i = 0; i < rigaComuni.length; i++) {
					unicoComune = rigaComuni[i].split(";");
					
					if( !(unicoComune[1].equals("#RIF!"))  ){
						Provincia p1 = provinciaService.cercaProvinciaConNome(unicoComune[3].trim());
						if(p1!=null){
							Comune c = new Comune(null,unicoComune[0],unicoComune[1],unicoComune[2],p1);
							comuneRepository.save(c);
						}
					}
				}
				}
			sc2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	METODO PER GENERARE I CLIENTI
	public void setClienti() {
		
		//ISTANZIAMO FAKER
		Faker fake= Faker.instance(new Locale("it-IT"));
		
		//ISTANZIAMO CLASSE FATTURA
		List<Fattura> fat = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
		Fattura f = new Fattura();
		f.setData(LocalDateTime.now().minusDays(fake.number().numberBetween(1l, 2190l)));
		f.setAnno(f.getData().getYear());
		f.setImporto(fake.number().randomDouble(3, 10000, 900000));
		f.setNumeroFattura(fake.number().numberBetween(1, 1000));
		f.setStato(statoFatturaRepository.findById(fake.number().numberBetween(1l, 3l)).get());
		fat.add(fatturaService.saveFattura(f));
		}
		
		
		
		
		//ISTANZIAMO CLASSE INDIRIZZO
		List <Indirizzo> ind = new ArrayList<>();
		
		//ciclo for eseguito due volte per generare due indirizzi fake(per sedeLegale e sedeOperativa)
		for(int i = 0; i < 2; i++) {
			
		Indirizzo indirizzo = new Indirizzo();
		
		indirizzo.setVia("Via - "+fake.address().streetName());
		indirizzo.setCivico(fake.address().buildingNumber());
		indirizzo.setLocalita(fake.address().city());
		indirizzo.setCap(fake.address().zipCode());
		indirizzo.setComune(comuneRepository.findById(fake.number().numberBetween(1l, 7000l)).get());
		ind.add(indirizzoService.saveIndirizzo(indirizzo));
		
		}
		
		
	
		TipoCliente[] type = {TipoCliente.PA, TipoCliente.SAS, TipoCliente.SPA, TipoCliente.SRL};
		
		
		
		//ISTANZIAMO CLASSE CLIENTE
		Cliente c = new Cliente();
		c.setRagione_sociale(fake.company().name());
		c.setPartita_iva(fake.number().randomNumber(10, true));
		c.setNomeContatto(fake.name().firstName());
		c.setCongomeContatto(fake.name().lastName());
		c.setEmail(c.getNomeContatto()+"."+c.getCongomeContatto()+"@gmail.com");
		c.setDataInserimento(LocalDate.now().minusDays(fake.number().numberBetween(1l, 366l)));
		c.setDataUltimoContatto(c.getDataInserimento().plusDays(fake.number().numberBetween(1l, 366l)));
		c.setFatturatoAnnuale(fake.number().randomNumber(7, false));
		c.setPec(c.getNomeContatto()+"@pec.com");
		c.setTelefono(fake.phoneNumber().cellPhone());
		c.setEmailContatto(c.getNomeContatto()+"."+c.getCongomeContatto()+"@yahoo.it");
		c.setTelefonoContatto(fake.phoneNumber().phoneNumber());
		c.setSedeLegale(indirizzoService.searchIndirizzo(ind.get(0).getId()));
		c.setSedeOperativa(indirizzoService.searchIndirizzo(ind.get(1).getId()));
		int numeroCasuale= fake.number().numberBetween(0, 3);
		c.setTipoCliente(type[numeroCasuale]);
		c.setFattura(fat);
		clienteService.saveCliente(c);
		
				
		
	}
}
