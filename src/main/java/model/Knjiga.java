package model;


import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Knjiga.GET_ALL_KNJIGAS, query = "Select k from Knjiga k")
public class Knjiga {
	
	public static final String GET_ALL_KNJIGAS = "Knjiga.getallKnjigas";
	
	@Id
	@SequenceGenerator(name="knjigaSeq", sequenceName = "knjiga_id_seq", allocationSize = 1,
	initialValue = 1)
	@GeneratedValue(generator = "knjigaSeq")
	private Long id;
	private String naslov;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "knjiga_id_autor")
	private Set<Autor> autori;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "knjiga_id_zanr")
	private Set<Zanr> zanrovi;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "knjiga_id_biblioteka")
	private Set<Biblioteka> biblioteke;
	
	
	public Knjiga(String naslov, Set<Autor> autori, Set<Zanr> zanrovi, Set<Biblioteka> biblioteke) {
		super();
		this.naslov = naslov;
		this.autori = autori;
		this.zanrovi = zanrovi;
		this.biblioteke = biblioteke;
	}
	
	


	public Knjiga() {
		super();
	}
	
	
	




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNaslov() {
		return naslov;
	}


	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}


	public Set<Autor> getAutori() {
		return autori;
	}


	public void setAutori(Set<Autor> autori) {
		this.autori = autori;
	}


	public Set<Zanr> getZanrovi() {
		return zanrovi;
	}


	public void setZanrovi(Set<Zanr> zanrovi) {
		this.zanrovi = zanrovi;
	}


	public Set<Biblioteka> getBiblioteke() {
		return biblioteke;
	}


	public void setBiblioteke(Set<Biblioteka> biblioteke) {
		this.biblioteke = biblioteke;
	}




	@Override
	public int hashCode() {
		return Objects.hash(autori, biblioteke, id, naslov, zanrovi);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		return Objects.equals(autori, other.autori) && Objects.equals(biblioteke, other.biblioteke)
				&& Objects.equals(id, other.id) && Objects.equals(naslov, other.naslov)
				&& Objects.equals(zanrovi, other.zanrovi);
	}




	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naslov=" + naslov + ", autori=" + autori + ", zanrovi=" + zanrovi
				+ ", biblioteke=" + biblioteke + "]";
	}


	
	
}
