package service;

import java.time.LocalDate;
import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.RecruiterBean;
import model.Company;


@Stateless
public class CompanyService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	@Inject
	private RecruiterBean recrubean;
	
	public void save(Company company) {

		
		if (company.getId() == 0) {
			company.setEntryBy(recrubean.getRecruiter());
			company.setEntry_date(LocalDate.now());
			em.persist(company);
		}

		else {

		
			company.setModifyBy(recrubean.getRecruiter());
			company.setModifyDate(LocalDate.now());
			em.merge(company);

		}

	}

	public List<Company> findAll() {
		return em.createQuery("SELECT c FROM Company c", Company.class).getResultList();
	}

	public Company findById(int id) {

		return em.find(Company.class, id);

	}

	public void delete(int cid) {
		Company c = em.find(Company.class, cid);
		em.remove(c);

	}

	/*
	 * public Object findHot(String hotList) { return em.find(Company.class,
	 * hotList); }
	 */

}
