package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Autor;
import model.Clan;

@ApplicationScoped
public class AutorService {
	
	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void addAutor(Autor autor) {
        entityManager.merge(autor);
    }

	@Transactional
	public List<Autor> getAll() {
		return entityManager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
	}

}
