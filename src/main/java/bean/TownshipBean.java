package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Township;
import service.TownshipService;


@Named
@RequestScoped
public class TownshipBean {
	private Township township;

	private List<Township> townList;

	@EJB
	private TownshipService service;

	@PostConstruct
	public void initialize() {
		String townid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("townshipid");
		if (townid != null)
			township = service.findById(Integer.parseInt(townid));
		else
			township = new Township();
		townList = service.findAll();
	}

	public String saveTownship() {

		service.save(township);

		return "/views/townships?faces-redirect=true";

	}
	
	public String removeTownship(int id) {
		service.delete(id);
		return "/views/townships?faces-redirect=true";
	}

	public Township getTownship() {
		return township;
	}

	public void setTownship(Township township) {
		this.township = township;
	}

	public List<Township> getTownList() {
		return townList;
	}

	public void setCatList(List<Township> townList) {
		this.townList = townList;
	}

	public TownshipService getService() {
		return service;
	}

	public void setService(TownshipService service) {
		this.service = service;
	}

	public void setTownList(List<Township> townList) {
		this.townList = townList;
	}
	
	
}
