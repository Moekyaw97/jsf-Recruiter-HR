package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Recruiter;

@Stateless
public class RecruiterService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	public List<Recruiter> findAll() {
		TypedQuery<Recruiter> query = em.createQuery("SELECT r FROM Recruiter r", Recruiter.class);
		return query.getResultList();
	}
	public Recruiter check(String username,String password) throws EntityNotFoundException{
		TypedQuery<Recruiter> query = em.createNamedQuery("Recruiter.login", Recruiter.class);
		query.setParameter("name", username);
		query.setParameter("pass", password);
		
		return query.getSingleResult();
		
	}

	public void save(Recruiter recruiter) {
		
		if (recruiter.getId() == 0)
			em.persist(recruiter);
		else
			em.merge(recruiter);

	}

	public Recruiter findById(int id) {

		return em.find(Recruiter.class, id);
	}

	public void delete(int id) {
		Recruiter r = em.find(Recruiter.class, id);
		em.remove(r);

	}

}
