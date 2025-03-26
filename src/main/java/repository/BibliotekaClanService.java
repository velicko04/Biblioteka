package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Autor;
import model.BibliotekaClan;

@ApplicationScoped
public class BibliotekaClanService {
	
	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void addBibliotekaClan(BibliotekaClan bibliotekaclan) {
		entityManager.merge(bibliotekaclan);
	}
	
	@Transactional
	public List<BibliotekaClan> getAll() {
		return entityManager.createQuery("SELECT bc FROM BibliotekaClan bc", BibliotekaClan.class).getResultList();
	}

}
