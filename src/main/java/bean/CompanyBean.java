package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Company;
import service.CompanyService;

@Named
@ViewScoped
public class CompanyBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Company company;
	
	/* private boolean isHot; */

	private List<Company> comList;
	

	@EJB
	private CompanyService service;

	@PostConstruct
	private void init() {

		comList = service.findAll();

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = params.get("companyid");
		if (id != null) {
			
			company = service.findById(Integer.parseInt(id));
			/* isHot=(company.getIshot().equals("yes")) ? true:false; */
		}else {

			company = new Company();
			/* hotList=service.findHot(); */
		}
			
	}

	public String saveCompany() {

		 company.setIshot("yes"); 
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

}
