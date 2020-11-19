package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import model.Recruiter;
import service.RecruiterService;



@Named
public class RecruiterConverter implements Converter<Recruiter>{
	@EJB
	private RecruiterService service;

	@Override
	public Recruiter getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null)
			return service.findById(Integer.parseInt(value));

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Recruiter value) {
		if (value != null)
			return String.valueOf(value.getId());
		return null;
	}
	

	
}
