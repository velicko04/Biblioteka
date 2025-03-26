package model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Zanr.GET_ZANRS_FOR_KNJIGA, query = "Select z from Zanr z where z.knjiga.id = :id")
public class Zanr {
	
	public static final String GET_ZANRS_FOR_KNJIGA = "Zanr.getZanrsForKnjiga";
	
	@Id
	@SequenceGenerator(name="zanrSeq", sequenceName = "zanr_id_seq", allocationSize = 1,
	initialValue = 1)
	@GeneratedValue(generator = "zanrSeq")
	private Long id;
	private String naziv;

	
	@ManyToOne
	private Knjiga knjiga;
	
	public Zanr(String naziv) {
		super();
		this.naziv = naziv;
	}
	
	public Zanr() {
		super();
	}
	
	

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, knjiga, naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zanr other = (Zanr) obj;
		return Objects.equals(id, other.id) && Objects.equals(knjiga, other.knjiga)
				&& Objects.equals(naziv, other.naziv);
	}

	@Override
	public String toString() {
		return "Zanr [id=" + id + ", naziv=" + naziv + ", knjiga=" + knjiga + "]";
	}
	
	

	
}
