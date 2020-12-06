package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.CandidateJoborderStatus;

@Stateless
public class CandidateJoborderStatusService {

	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	

	public CandidateJoborderStatus findById(int id) {
		return em.find(CandidateJoborderStatus.class, id);
	}

	public List<CandidateJoborderStatus> findAll() {
		TypedQuery<CandidateJoborderStatus> query = em.createNamedQuery("CandidateJoborderStatus.findAll", CandidateJoborderStatus.class);
		return query.getResultList();
	}
}
