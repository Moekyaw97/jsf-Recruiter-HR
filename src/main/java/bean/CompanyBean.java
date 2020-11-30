package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Company;
import model.Joborder;
import service.CompanyService;
import service.JoborderService;


@Named
@ViewScoped
public class CompanyBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Company company;



	private List<Company> comList;
	private List<Joborder> company_joborderlist;
	

	@EJB
	private CompanyService service;
	@EJB
	private JoborderService joborderservice;

	@PostConstruct
	private void init() {

		String comid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("companyid");
		if(comid != null) {
			company_joborderlist = joborderservice.findbyCompany(Integer.parseInt(comid));
			company = service.findById(Integer.parseInt(comid));
			if(company.getIshot().equals("yes")) {
				company.setIshot("true");
			}else {
				company.setIshot("false");
			}
			
		}else {
			company = new Company();
		}
		comList = service.findAll();
	}

	public String saveCompany() {

		if(company.getIshot().equals("true")) {
			company.setIshot("yes");
		}else {
			company.setIshot("no");
		}
		service.save(company);

		return "/views/companies?faces-redirect=true";

	}

	public String removeCompany(int cid) {
		service.delete(cid);
		return "/views/companies?faces-redirect=true";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getComList() {
		return comList;
	}

	public void setComList(List<Company> comList) {
		this.comList = comList;
	}

	public CompanyService getService() {
		return service;
	}

	public void setService(CompanyService service) {
		this.service = service;
	}

	public List<Joborder> getCompany_joborderlist() {
		return company_joborderlist;
	}

	public void setCompany_joborderlist(List<Joborder> company_joborderlist) {
		this.company_joborderlist = company_joborderlist;
	}

	public JoborderService getJoborderservice() {
		return joborderservice;
	}

	public void setJoborderservice(JoborderService joborderservice) {
		this.joborderservice = joborderservice;
	}
	

}
