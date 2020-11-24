package service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.RecruiterBean;
import model.Joborder;

@Stateless
public class JoborderService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	@Inject
	private RecruiterBean recrubean;
	

	public void save(Joborder joborder) {

		
		if (joborder.getId() == 0) {
			joborder.setEntryBy(recrubean.getRecruiter());
			joborder.setEntry_date(LocalDate.now());
			em.persist(joborder);
		}

		else {

			joborder.setModifyBy(recrubean.getRecruiter());
			joborder.setModifyDate(LocalDate.now());
			em.merge(joborder);

		}

	}

	public List<Joborder> findAll() {
		return em.createQuery("SELECT j FROM Joborder j", Joborder.class).getResultList();
	}

	public Joborder findById(int id) {

		return em.find(Joborder.class, id);

	}

	public void delete(int jid) {
		Joborder j = em.find(Joborder.class, jid);
		em.remove(j);

	}

}
