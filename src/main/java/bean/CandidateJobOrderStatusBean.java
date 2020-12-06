package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.CandidateJoborderStatus;
import service.CandidateJoborderStatusService;

@Named
@RequestScoped
public class CandidateJobOrderStatusBean {
	
	private CandidateJoborderStatus joborderStatus; 
	private List<CandidateJoborderStatus> joborderStatusList;
	
	@EJB
	private CandidateJoborderStatusService service;
	
	@PostConstruct
	private void initialize() {
		joborderStatus = new CandidateJoborderStatus();
		joborderStatusList = service.findAll();
		
		
	}

	public CandidateJoborderStatus getJoborderStatus() {
		return joborderStatus;
	}

	public void setJoborderStatus(CandidateJoborderStatus joborderStatus) {
		this.joborderStatus = joborderStatus;
	}

	public List<CandidateJoborderStatus> getJoborderStatusList() {
		return joborderStatusList;
	}

	public void setJoborderStatusList(List<CandidateJoborderStatus> joborderStatusList) {
		this.joborderStatusList = joborderStatusList;
	}

}
