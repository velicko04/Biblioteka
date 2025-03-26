package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Clan;

@ApplicationScoped
public class ClanService {

	@Inject
	EntityManager entityManager;
	
	@Transactional
	public void addClan(Clan clan) {
		entityManager.merge(clan);
	}

	@Transactional
	public List<Clan> getAll() {
		return entityManager.createQuery("SELECT c FROM Clan c", Clan.class).getResultList();
	}
	
}
