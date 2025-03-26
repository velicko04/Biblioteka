package model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Biblioteka.GET_BIBLIOTEKAS_FOR_KNJIGA, query = "Select b from Biblioteka b where b.knjiga.id = :id")
public class Biblioteka {
	
	public static final String GET_BIBLIOTEKAS_FOR_KNJIGA = "Biblioteka.getBibliotekasForKnjiga";
	
	@Id
	@SequenceGenerator(name="bibliotekaSeq", sequenceName = "biblioteka_id_seq", allocationSize = 1,
			initialValue = 1)
	@GeneratedValue(generator = "bibliotekaSeq")
	private Long id;
	private String naziv;
	private String adresa;
	
	
	@ManyToOne
	private Knjiga knjiga;
	
	public Biblioteka(String naziv, String adresa) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
	}
	
	public Biblioteka() {
		super();
	}
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresa, id, knjiga, naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biblioteka other = (Biblioteka) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(id, other.id)
				&& Objects.equals(knjiga, other.knjiga) && Objects.equals(naziv, other.naziv);
	}

	@Override
	public String toString() {
		return "Biblioteka [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", knjiga=" + knjiga + "]";
	}
	
	
	
}
