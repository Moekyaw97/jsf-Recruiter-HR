package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.CandidateJoborderStatus;

@Stateless
public class CandidateJoborderStatusService {

	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	

	public CandidateJoborderStatus findById(int id) {
		return em.find(CandidateJoborderStatus.class, id);
	}
}
