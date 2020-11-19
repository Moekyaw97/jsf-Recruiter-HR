package bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Company;
import service.CompanyService;

@Named
@RequestScoped
public class CompanyBean {
	private Company company;

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
			System.out.println("enty by in init :" + company.getEntryBy());
		}else {

			company = new Company();
			System.out.println("this is new company");
		}
			
	}

	public String saveCompany() {

		System.out.println("entry by in savecompany:"+company.getEntryBy());
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
