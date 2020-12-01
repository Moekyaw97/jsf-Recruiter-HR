package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Company;
import model.JobPipeline;

@Stateless
public class JobPipelineService {
	@PersistenceContext(name = "jsf-assign")
	private EntityManager em;

	public List<JobPipeline> findAll() {
		TypedQuery<JobPipeline> query = em.createNamedQuery("JobPipeline.findAll", JobPipeline.class);
		return query.getResultList();
	}

	public JobPipeline findById(int id) {
		return em.find(JobPipeline.class, id);
	}

	public List<JobPipeline> findByCandidate(int candidateId) {
		TypedQuery<JobPipeline> query = em.createNamedQuery("JobPipeline.findByCandidate", JobPipeline.class);
		query.setParameter("candidateId", candidateId);
		return query.getResultList();
	}

	public List<JobPipeline> findByJobOrder(int joborderId) {
		TypedQuery<JobPipeline> query = em.createNamedQuery("JobPipeline.findByJobOrder", JobPipeline.class);
		query.setParameter("joborderId", joborderId);
		return query.getResultList();
	}

	public void save(JobPipeline jobPipeline) {
		em.persist(jobPipeline);
		
	}

	public void delete(int jid) {
		JobPipeline j= em.find(JobPipeline.class, jid);
		em.remove(j);
		
	}
}
