package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String cognome;

	private LocalDate dateOfBirth;

	private String birthPlace;
	
	@Column(nullable=false)
	private String partitaIVA;
	
	/**
	 * Cascade per il persist perché quando memorizzo un docente, memorizzo anche i suoi corsi
	 * Strategia di fetch EAGER perchè quando voglio le informazioni di un docente, voglio sapere anche
	 * tutti i corsi che tiene
	 **/
	@OneToMany(mappedBy = "docente", cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private List<Corso> corsi;

	public Docente(String nome, String cognome, LocalDate dateOfBirth, String birthPlace, String partitaIVA, List<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		this.partitaIVA = partitaIVA;
		this.corsi = corsi;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getPartitaIVA() {
		return this.partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public List<Corso> getCorsi() {
		return this.corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public boolean equals(Object obj) {
		Docente docente = (Docente)obj;
		return this.getPartitaIVA().equals(docente.getPartitaIVA());
	}

	public int hashCode() {
		return this.partitaIVA.hashCode();
	}


}
