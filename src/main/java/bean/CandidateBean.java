package bean;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import model.Candidate;
import service.CandidateService;

@Named
@ViewScoped
public class CandidateBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
private Candidate candidate;
private List<Candidate> canList;
private Part cv_form;

@EJB
private CandidateService service;


	@PostConstruct
	private void initialize() {

		String canid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("candidateid");
		if(canid != null) {
			candidate = service.findById(Integer.parseInt(canid));
			if(candidate.getIs_active().equals("yes")) {
				candidate.setIs_active("true");
			}else {
				candidate.setIs_active("false");
			}
			
		}else {
			candidate = new Candidate();
		}
		
		canList = service.findAll();
	}
	public void uploadFile() {
		
	
	}
	public String removeCandidate(int cid) {
		service.delete(cid);
		return "/views/candidates?faces-redirect=true";

	}

	public String saveCandidate() {
		try {
			String uploadFileName = cv_form.getSubmittedFileName();
			
			ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			
			String dirPath = context.getRealPath("") + File.separator + "CV_Uploads";
			File rootDir = new File(dirPath);
			if(!rootDir.exists())
				rootDir.mkdirs();
			
			cv_form.write(rootDir + File.separator + uploadFileName);
			candidate.setCv_form(uploadFileName);
	} catch (Exception e) {
				FacesMessage message = new FacesMessage(e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, message);
			
			}
		if(candidate.getIs_active().equals("true")) {
			candidate.setIs_active("yes");
		}else {
			candidate.setIs_active("no");
		}

		service.save(candidate);
		return "/views/candidates?faces-redirect=true";

	}

	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public List<Candidate> getCanList() {
		return canList;
	}
	public void setCanList(List<Candidate> canList) {
		this.canList = canList;
	}
	
	public Part getCv_form() {
		return cv_form;
	}
	public void setCv_form(Part cv_form) {
		this.cv_form = cv_form;
	}
	public CandidateService getService() {
		return service;
	}
	public void setService(CandidateService service) {
		this.service = service;
	}
}
