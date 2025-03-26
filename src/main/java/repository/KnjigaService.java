package repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Autor;
import model.Biblioteka;
import model.Knjiga;
import model.Zanr;

@ApplicationScoped
public class KnjigaService {
	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void addKnjiga(Knjiga knjiga) {
		entityManager.merge(knjiga);
	}
	
	@Transactional
	public List<Knjiga> getAll() {
		List<Knjiga> knjige = entityManager.createNamedQuery(Knjiga.GET_ALL_KNJIGAS, Knjiga.class).getResultList();
		
		for(Knjiga knjiga: knjige) {
			List<Autor> autori = entityManager.createNamedQuery(Autor.GET_AUTORS_FOR_KNJIGA, Autor.class)
 					.setParameter("id", knjiga.getId()).getResultList();
 			
 			knjiga.setAutori(new HashSet<>(autori));
		}
		
		for(Knjiga knjiga: knjige) {
			List<Zanr> zanrovi = entityManager.createNamedQuery(Zanr.GET_ZANRS_FOR_KNJIGA, Zanr.class)
 					.setParameter("id", knjiga.getId()).getResultList();
 			
 			knjiga.setZanrovi(new HashSet<>(zanrovi));
		}
		
		for(Knjiga knjiga: knjige) {
			List<Biblioteka> biblioteke = entityManager.createNamedQuery(Biblioteka.GET_BIBLIOTEKAS_FOR_KNJIGA, Biblioteka.class)
 					.setParameter("id", knjiga.getId()).getResultList();
 			
 			knjiga.setBiblioteke(new HashSet<>(biblioteke));
		}
		
		return knjige;
		
	}
}
