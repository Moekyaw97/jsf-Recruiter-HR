package service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bean.RecruiterBean;
import model.Company;
import model.Recruiter;

@Stateless
public class CompanyService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	@Inject
	private RecruiterBean recrubean;
	@EJB
	private RecruiterService recru;

	public void save(Company company) {
	
		System.out.println("entry by in save: "+company.getEntryBy());
		if (company.getId() == 0) {
			company.setEntryBy(recrubean.getRecruiter());
			company.setEntry_date(LocalDate.now());
			em.persist(company);
		}

		else {
			
			Recruiter re=recru.findById(company.getEntryBy().getId());
			/* company = findById(company.getId()); */
			company.setEntryBy(re);
			company.setEntry_date(LocalDate.now());
			company.setModifyBy(recrubean.getRecruiter());
			company.setModifyDate(LocalDate.now());
			em.merge(company);
			

		}

	}

	public List<Company> findAll() {
		return em.createQuery("SELECT c FROM Company c", Company.class).getResultList();
	}

	public Company findById(int id) {
		Company c=em.find(Company.class, id);
	System.out.println("entry in findById:" + c.getEntryBy() );
	return c;
	
	}

	public void delete(int cid) {
		Company c = em.find(Company.class, cid);
		em.remove(c);

	}

}
