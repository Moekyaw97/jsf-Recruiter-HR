package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Ava;



@Stateless
public class AvaService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	public List<Ava> findAll() {
		TypedQuery<Ava> query = em.createQuery("SELECT a FROM Ava a", Ava.class);
		return query.getResultList();
	}

	public Ava findById(int id) {
		return em.find(Ava.class, id);
	}

	public void save(Ava ava) {
		if (ava.getId() == 0)
			em.persist(ava);
		else
			em.merge(ava);
		
	}

	public void delete(int id) {
		Ava a = em.find(Ava.class, id);
		em.remove(a);
		
	}

}
