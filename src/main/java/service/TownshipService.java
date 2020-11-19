package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Township;

@Stateless
public class TownshipService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	public List<Township> findAll() {
		TypedQuery<Township> query = em.createQuery("SELECT t FROM Township t", Township.class);
		return query.getResultList();
	}

	public void save(Township township) {
		if (township.getId() == 0)
			em.persist(township);
		else
			em.merge(township);

	}

	public Township findById(int id) {

		return em.find(Township.class, id);
	}

	public void delete(int id) {
		Township t = em.find(Township.class, id);
		em.remove(t);

	}
}
