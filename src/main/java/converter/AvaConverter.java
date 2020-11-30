package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import model.Ava;
import service.AvaService;

@Named
public class AvaConverter implements Converter<Ava> {

	@EJB
	private AvaService service;

	@Override
	public Ava getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null)
			return service.findById(Integer.parseInt(value));
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Ava value) {
		if (value != null)
			return String.valueOf(value.getId());
		return null;
	}

}
