package service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import bean.RecruiterBean;
import model.Candidate;

@Stateless
public class CandidateService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;
	@Inject
	private RecruiterBean recrubean;

	public List<Candidate> findAll() {

		TypedQuery<Candidate> query = em.createNamedQuery("Candidate.findAll", Candidate.class);
		return query.getResultList();
	}

	public Candidate findById(int id) {

		return em.find(Candidate.class, id);
	}

	public void save(Candidate candidate) {

		if (candidate.getId() == 0) {
			candidate.setEntryBy(recrubean.getRecruiter());
			candidate.setEntry_date(LocalDate.now());
			em.persist(candidate);
		}

		else {
			candidate.setModifyBy(recrubean.getRecruiter());
			candidate.setModifyDate(LocalDate.now());
			em.merge(candidate);
		}

	}

	public void delete(int cid) {

		Candidate c = em.find(Candidate.class, cid);
		em.remove(c);
	}

	public List<Candidate> getUnworkedCandidates(int joborderid) {
		TypedQuery<Candidate> query = em.createNamedQuery("Candidate.getUnworkedCandidates", Candidate.class);
		query.setParameter("joborderid", joborderid);
		return query.getResultList();
	}

}
