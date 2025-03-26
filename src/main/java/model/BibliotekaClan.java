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
import jakarta.persistence.SequenceGenerator;

@Entity

public class BibliotekaClan {
	
	
	@Id
	@SequenceGenerator(name="bibliotekaClanSeq", sequenceName = "bibliotekaclan_id_seq", allocationSize = 1,
	initialValue = 1)
	@GeneratedValue(generator = "bibliotekaClanSeq")
	private Long id;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
	    name = "biblioteka_clan",
	    joinColumns = @JoinColumn(name = "clan_id"),
	    inverseJoinColumns = @JoinColumn(name = "biblioteka_id")
	)
	private Set<Biblioteka> biblioteke;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		    name = "biblioteka_clan",
		    joinColumns = @JoinColumn(name = "biblioteka_id"),
		    inverseJoinColumns = @JoinColumn(name = "clan_id")
		)
	private Set<Clan> clanovi;
	
	public BibliotekaClan(Set<Biblioteka> biblioteke, Set<Clan> clanovi) {
		super();
		this.biblioteke = biblioteke;
		this.clanovi = clanovi;
	}
	
	public BibliotekaClan() {
		super();
	}

	public Set<Biblioteka> getBiblioteke() {
		return biblioteke;
	}

	public void setBiblioteke(Set<Biblioteka> biblioteke) {
		this.biblioteke = biblioteke;
	}

	public Set<Clan> getClanovi() {
		return clanovi;
	}

	public void setClanovi(Set<Clan> clanovi) {
		this.clanovi = clanovi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(biblioteke, clanovi, id);
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
		return Objects.equals(biblioteke, other.biblioteke) && Objects.equals(clanovi, other.clanovi)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BibliotekaClan [id=" + id + ", biblioteke=" + biblioteke + ", clanovi=" + clanovi + "]";
	}
	
	
	
	
}
