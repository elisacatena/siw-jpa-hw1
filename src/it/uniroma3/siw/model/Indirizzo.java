package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String via;

	private int numeroCivico;

	private String comune;

	private String cap;

	private String provincia;

	public Indirizzo(String via, int numeroCivico, String comune, String cap, String provincia) {
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumeroCivico() {
		return this.numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getComune() {
		return this.comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public boolean equals(Object obj) {
		Indirizzo indirizzo = (Indirizzo)obj;
		return ( this.getCap().equals(indirizzo.getCap()) ) && 
					( this.getVia().equals(indirizzo.getVia()) ) &&
					( this.getNumeroCivico() == (indirizzo.getNumeroCivico()) ) ;
	}

	public int hashCode() {
		return this.cap.hashCode() + this.via.hashCode() + this.numeroCivico;
	}
	
}
