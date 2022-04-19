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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private String cognome;

	private LocalDate dateOfBirth;

	private String birthPlace;

	@Column(nullable=false)
	private String matricola;

	private String email;
	
	/**
	 * Cascade per il persist perché quando memorizzo un allievo, memorizzo anche la società per cui lavora
	 **/
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Societa societa;
	
	/**
	 * Strategia di fetch EAGER perchè quando voglio le informazioni di un allievo, voglio sapere anche
	 * tutti i corsi che frequenta
	 **/
	@ManyToMany(mappedBy = "allievi", fetch = FetchType.EAGER)
	private List<Corso> corsi;

	public Allievo(String nome, String cognome, LocalDate dateOfBirth, String birthPlace, String matricola, String email,
			Societa societa, List<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		this.matricola = matricola;
		this.email = email;
		this.societa = societa;
		this.corsi = corsi;
	}

	public Societa getSocieta() {
		return this.societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public List<Corso> getCorsi() {
		return this.corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public Long getId() {
		return id;
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

	public String getMatricola() {
		return this.matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object obj) {
		Allievo allievo = (Allievo)obj;
		return this.getMatricola().equals(allievo.getMatricola());
	}

	public int hashCode() {
		return this.matricola.hashCode();
	}


}
