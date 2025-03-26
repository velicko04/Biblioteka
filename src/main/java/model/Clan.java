package model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "clan")
public class Clan {
	
	
	@Id
	@SequenceGenerator(name="clanSeq", sequenceName = "clan_id_seq", allocationSize = 1,
			initialValue = 1)
	@GeneratedValue(generator = "clanSeq")
	private Long id;
	private String ime;
	private String prezime;
	private int clanska_karta;
	
	
	public Clan(String ime, String prezime, int clanska_karta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.clanska_karta = clanska_karta;
	}
	
	public Clan() {
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


	public int getClanska_karta() {
		return clanska_karta;
	}


	public void setClanska_karta(int clanska_karta) {
		this.clanska_karta = clanska_karta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clanska_karta, id, ime, prezime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clan other = (Clan) obj;
		return clanska_karta == other.clanska_karta && Objects.equals(id, other.id) && Objects.equals(ime, other.ime)
				&& Objects.equals(prezime, other.prezime);
	}

	@Override
	public String toString() {
		return "Clan [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", clanska_karta=" + clanska_karta + "]";
	}
	
	


}
