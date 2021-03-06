package bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Candidate;
import model.JobPipeline;
import model.Joborder;
import service.CandidateJoborderStatusService;
import service.CandidateService;
import service.JobPipelineService;
import service.JoborderService;

@Named
@ViewScoped
public class JobPipelineBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private Map<Integer, Boolean> checkedCandidates = new HashMap<Integer, Boolean>();
	
	private JobPipeline jobpipeline;
	
	private Joborder joborder;
	
	private List<JobPipeline> jobPipelineList;
	private List<JobPipeline> jjList;
	private List<Candidate> cjList;
	
	@Inject
	private RecruiterBean recrubean;
	
	
	@EJB
	private JobPipelineService service;
	
	@EJB
	private CandidateService candidateService;
	
	@EJB
	private JoborderService jobOrderService;
	
	@EJB
	private CandidateJoborderStatusService cjsService;
	
	
	
	@PostConstruct
	private void initialize() {
		String jobid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("joborderid");
		String canid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("candidateid");
		if(jobid != null) {
			if(canid != null) {
				jobpipeline = service.findById(Integer.parseInt(canid));
				jobPipelineList = service.findByCandidate(jobpipeline.getId());
			}else {
				 cjList = candidateService.getUnworkedCandidates(Integer.parseInt(jobid));
				 for (Candidate candidate : cjList) 
				 { 
					 checkedCandidates.put(candidate.getId(), false);
					
					 }
				 for (Entry<Integer, Boolean> entry : checkedCandidates.entrySet()) {
					 System.out.println("key: "+ entry.getKey() +"value:" +entry.getValue() );
				 }
				
			}
			
			
			joborder = jobOrderService.findById(Integer.parseInt(jobid));
			jjList = service.findByJobOrder(Integer.parseInt(jobid));
		}else {
			if(canid != null) {
				
				jobpipeline = service.findById(Integer.parseInt(canid));
				if(jobpipeline != null)
					jobPipelineList = service.findByCandidate(jobpipeline.getId());
			}
		}
		
		
	}
	
	
	public String saveJobPipline() {
        for (Entry<Integer, Boolean> can : checkedCandidates.entrySet()) {
        	System.out.println("key: "+ can.getKey() +"value:" +can.getValue() );
                if(can.getValue() == true) {
                	Candidate candidate = candidateService.findById( can.getKey());
                	JobPipeline jobPipeline = new JobPipeline();
                	jobPipeline.setJoborder(joborder);
                	jobPipeline.setCandidate(candidate);
                	jobPipeline.setCandidatejoborderstatus(cjsService.findById(100));
                	jobPipeline.setEntryBy(recrubean.getRecruiter());
        			jobPipeline.setEntry_date(LocalDate.now());	
                	service.save(jobPipeline);
                }
            
        }
        return "/views/joborder-detail?faces-redirect=true&joborderid=" + joborder.getId();
		
		
	}
	public String removeJobpipeline(int id) {
	
		service.delete(id);
		 return "/views/joborder-detail?faces-redirect=true&joborderid=" + joborder.getId();

	}


	public Map<Integer, Boolean> getCheckedCandidates() {
		return checkedCandidates;
	}


	public void setCheckedCandidates(Map<Integer, Boolean> checkedCandidates) {
		this.checkedCandidates = checkedCandidates;
	}


	public JobPipeline getJobpipeline() {
		return jobpipeline;
	}


	public void setJobpipeline(JobPipeline jobpipeline) {
		this.jobpipeline = jobpipeline;
	}


	public Joborder getJoborder() {
		return joborder;
	}


	public void setJoborder(Joborder joborder) {
		this.joborder = joborder;
	}


	public List<JobPipeline> getJobPipelineList() {
		return jobPipelineList;
	}


	public void setJobPipelineList(List<JobPipeline> jobPipelineList) {
		this.jobPipelineList = jobPipelineList;
	}

	public List<JobPipeline> getJjList() {
		return jjList;
	}


	public void setJjList(List<JobPipeline> jjList) {
		this.jjList = jjList;
	}


	public List<Candidate> getCjList() {
		return cjList;
	}


	public void setCjList(List<Candidate> cjList) {
		this.cjList = cjList;
	}


	public RecruiterBean getRecrubean() {
		return recrubean;
	}


	public void setRecrubean(RecruiterBean recrubean) {
		this.recrubean = recrubean;
	}


	public JobPipelineService getService() {
		return service;
	}


	public void setService(JobPipelineService service) {
		this.service = service;
	}


	public CandidateService getCandidateService() {
		return candidateService;
	}


	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}


	public JoborderService getJobOrderService() {
		return jobOrderService;
	}


	public void setJobOrderService(JoborderService jobOrderService) {
		this.jobOrderService = jobOrderService;
	}


	public CandidateJoborderStatusService getCjsService() {
		return cjsService;
	}


	public void setCjsService(CandidateJoborderStatusService cjsService) {
		this.cjsService = cjsService;
	}
	



}
