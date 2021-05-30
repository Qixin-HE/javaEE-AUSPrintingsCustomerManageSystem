package fit5042.assignment.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import fit5042.assignment.controllers.Customer;
import fit5042.assignment.repository.CustomerRepository;



@ManagedBean
@ApplicationScoped
public class CustomerConverter implements Converter {

	@EJB
	private CustomerRepository customerRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		if (submittedValue == null || submittedValue.isEmpty()) {
			return null;
		}

		try {
			try {
				return customerRepository.searchCustomerById(Integer.valueOf(submittedValue));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)),
					e);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
			return "";
		}
		try {
			if (modelValue instanceof Customer) {
				return String.valueOf(((Customer) modelValue).getCustomerId());
			}
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage(String.format("%s is not a valid Customer", modelValue)), e);

		}
		return null;
	}

}
