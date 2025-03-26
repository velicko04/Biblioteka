package model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = Autor.GET_AUTORS_FOR_KNJIGA, query = "Select a from Autor a where a.knjiga.id = :id")
public class Autor {
	
	public static final String GET_AUTORS_FOR_KNJIGA = "Autor.getAutorsForKnjiga";
	
	@Id
	@SequenceGenerator(name="autorSeq", sequenceName = "autor_id_seq", allocationSize = 1,
	initialValue = 1)
@GeneratedValue(generator = "autorSeq")
	private Long id;
	private String ime;
	private String prezime;
	
	
	@ManyToOne
	private Knjiga knjiga;
	
	public Autor(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public Autor() {
		super();
	}
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ime, knjiga, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && Objects.equals(knjiga, other.knjiga)
				&& Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", knjiga=" + knjiga + "]";
	}
	
	
	
	
}
