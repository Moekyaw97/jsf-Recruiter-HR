package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Recruiter;

import service.RecruiterService;


@Named
@SessionScoped
public class RecruiterBean implements Serializable{
	
	private String username;
	private String password;
	private Recruiter recruiter;

	private List<Recruiter> recruList;

	@EJB
	private RecruiterService service;

	@PostConstruct
	public void initialize() {
		
		String recruid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("recruiterid");
		if (recruid != null)
			recruiter = service.findById(Integer.parseInt(recruid));
		else
			recruiter = new Recruiter();
		recruList = service.findAll();
	}
	public void checkUser() {
		FacesContext context=FacesContext.getCurrentInstance();
	try {
		recruiter=service.check(username,password);
	}catch(Exception e) {
		FacesMessage msg=new FacesMessage("Invalid Login!");
		context.addMessage(null, msg);
		context.isValidationFailed();
	}
		
	}
	public String authenticateUser() {
		FacesContext context=FacesContext.getCurrentInstance();
		if(context.isValidationFailed())
			return null;
		return "/views/companies?faces-redirect=true";
	}
	public String processLogOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "/index?faces-redirect=true";
	}

	public String saveRecruiter() {

		service.save(recruiter);

		return "/views/recruiters?faces-redirect=true";

	}
	
	public String removeRecruiter(int id) {
		service.delete(id);
		return "/views/recruiters?faces-redirect=true";
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public List<Recruiter> getRecruList() {
		return recruList;
	}

	public void setRecruList(List<Recruiter> recruList) {
		this.recruList = recruList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RecruiterService getService() {
		return service;
	}
	public void setService(RecruiterService service) {
		this.service = service;
	}
	
	
}
