package model;


import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity

public class BibliotekaClan {
	
	
	@Id
	@SequenceGenerator(name="bibliotekaClanSeq", sequenceName = "bibliotekaclan_id_seq", allocationSize = 1,
	initialValue = 1)
	@GeneratedValue(generator = "bibliotekaClanSeq")
	private Long id;
	
	
	@ManyToOne(cascade =  CascadeType.ALL)
 	Biblioteka biblioteka;
	
	@ManyToOne(cascade =  CascadeType.ALL)
 	Clan clan;
	
	
	public BibliotekaClan(Biblioteka biblioteka, Clan clan) {
		super();
		this.biblioteka = biblioteka;
		this.clan = clan;
	}
	
	public BibliotekaClan() {
		super();
	}

	public Long getId() {
 		return id;
 	}
 
 	public void setId(Long id) {
 		this.id = id;
 	}
 
 	public Biblioteka getBiblioteka() {
 		return biblioteka;
 	}
 
 	public void setBiblioteka(Biblioteka biblioteka) {
 		this.biblioteka = biblioteka;
 	}
 
 	public Clan getClan() {
 		return clan;
 	}
 
 	public void setPredmet(Clan clan) {
 		this.clan = clan;
 	}

	@Override
	public int hashCode() {
		return Objects.hash(biblioteka, clan, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BibliotekaClan other = (BibliotekaClan) obj;
		return Objects.equals(biblioteka, other.biblioteka) && Objects.equals(clan, other.clan)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BibliotekaClan [id=" + id + ", biblioteka=" + biblioteka + ", clan=" + clan + "]";
	}
	
	
	
	
}
