package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Autor;
import model.Zanr;

@ApplicationScoped
public class ZanrService {

	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void addZanr(Zanr zanr) {
		entityManager.merge(zanr);
	}
	
	@Transactional
	public List<Zanr> getAll() {
		return entityManager.createQuery("SELECT z FROM Zanr z", Zanr.class).getResultList();
	}
}
