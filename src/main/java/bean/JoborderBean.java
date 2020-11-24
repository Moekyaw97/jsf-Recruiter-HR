package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Joborder;
import service.JoborderService;

@Named
@ViewScoped
public class JoborderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Joborder joborder;

	private List<Joborder> jobList;

	@EJB
	private JoborderService service;

	@PostConstruct
	private void init() {

		jobList = service.findAll();

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("joborderid");
		if (id != null) {

			joborder = service.findById(Integer.parseInt(id));

		} else {

			joborder = new Joborder();

		}

	}

	public String saveJoborder() {

		joborder.setIs_active("yes");
		service.save(joborder);

		return "/views/joborders?faces-redirect=true";

	}

	public String removeJoborder(int jid) {
		service.delete(jid);
		return "/views/joborder?faces-redirect=true";
	}

	public Joborder getJoborder() {
		return joborder;
	}

	public void setJoborder(Joborder joborder) {
		this.joborder = joborder;
	}

	public List<Joborder> getJobList() {
		return jobList;
	}

	public void setJobList(List<Joborder> jobList) {
		this.jobList = jobList;
	}

	public JoborderService getService() {
		return service;
	}

	public void setService(JoborderService service) {
		this.service = service;
	}
}
