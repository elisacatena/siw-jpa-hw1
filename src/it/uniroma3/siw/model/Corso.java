package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	private LocalDate inizio;

	private String duarata;
	
	/**
	 * Cascade per il persist perché quando memorizzo un corso, memorizzo anche il docente
	 **/
	@ManyToOne(cascade={CascadeType.PERSIST})
	private Docente docente;
	
	/**
	 * Cascade per il persist perché quando memorizzo un corso, memorizzo anche gli allievi
	 **/
	@ManyToMany(cascade={CascadeType.PERSIST})
	private List<Allievo> allievi;

	public Corso(String nome, LocalDate inizio, String duarata, Docente docente, List<Allievo> allievi) {
		this.nome = nome;
		this.inizio = inizio;
		this.duarata = duarata;
		this.docente = docente;
		this.allievi = allievi;
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

	public LocalDate getInizio() {
		return this.inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public String getDuarata() {
		return this.duarata;
	}

	public void setDuarata(String duarata) {
		this.duarata = duarata;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public List<Allievo> getAllievi() {
		return this.allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public boolean equals(Object obj) {
		Corso corso = (Corso)obj;
		return this.getId().equals(corso.getId());
	}

	public int hashCode() {
		return this.id.hashCode();
	}

}
