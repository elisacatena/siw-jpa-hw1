package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Societa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String ragioneSociale;

	private String telefono;
	
	/**
	 * Cascade per il persist perché quando memorizzo una società ne memorizzo anche l'indirizzo
	 **/
	@OneToOne(cascade={CascadeType.PERSIST} )
	private Indirizzo indirizzo;

	public Societa(String ragioneSociale, Indirizzo indirizzo, String telefono) {
		this.ragioneSociale = ragioneSociale;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public boolean equals(Object obj) {
		Societa societa = (Societa)obj;
		return this.getTelefono().equals(societa.getTelefono());
	}

	public int hashCode() {
		return this.telefono.hashCode();
	}

}
