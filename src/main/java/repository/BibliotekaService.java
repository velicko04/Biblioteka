package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Biblioteka;
import model.BibliotekaClan;
import model.Clan;

@ApplicationScoped
public class BibliotekaService {
	
	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void addBiblioteka(Biblioteka biblioteka) {
		entityManager.merge(biblioteka);
	}

	public List<Biblioteka> getAll() {
		return entityManager.createQuery("SELECT b FROM Biblioteka b", Biblioteka.class).getResultList();
	}
	
	@Transactional
 	public BibliotekaClan createBibliotekaClan(BibliotekaClan b) {
 		return entityManager.merge(b);
 	}

}
