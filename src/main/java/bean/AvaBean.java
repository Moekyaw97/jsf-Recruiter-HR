package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.Ava;
import service.AvaService;


@Named
@RequestScoped
public class AvaBean {
	
	private Ava ava;


	private List<Ava> avaList;
	
	@EJB
	private  AvaService service;
	
	@PostConstruct
	public void initialize() {
		String avaid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("avaid");
		if (avaid != null)
			ava = service.findById(Integer.parseInt(avaid));
		else
			ava = new Ava();
		avaList = service.findAll();
	}
	
	public String saveAva() {

		service.save(ava);

		return "/views/townships?faces-redirect=true";

	}
	
	public String removeAva(int id) {
		service.delete(id);
		return "/views/townships?faces-redirect=true";
	}

	public Ava getAva() {
		return ava;
	}

	public void setAva(Ava ava) {
		this.ava = ava;
	}

	public List<Ava> getAvaList() {
		return avaList;
	}

	public void setAvaList(List<Ava> avaList) {
		this.avaList = avaList;
	}

	public AvaService getService() {
		return service;
	}

	public void setService(AvaService service) {
		this.service = service;
	}
	





}
