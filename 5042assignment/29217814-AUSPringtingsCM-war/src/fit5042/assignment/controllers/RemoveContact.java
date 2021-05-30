package fit5042.assignment.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.ContactManagedBean;
import fit5042.assignment.mbeans.CustomerManagedBean;
import fit5042.assignment.repository.entities.Contact;

import javax.faces.bean.ManagedProperty;

/**
 * @autor Qixin HE Reference: Tutorial materials.
 */
@RequestScoped
@Named("removeContact")
public class RemoveContact {
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;

	// new implemented
	@ManagedProperty(value = "#{contactManagedBean}")
	ContactManagedBean contactManagedBean;

	private boolean showForm = true;
	// private Customer customer;
	ContactViewController contactViewController;

//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
//
//	public Customer getCustomer() {
//		return customer;
//	}

	public boolean isShowForm() {
		return showForm;
	}

	public RemoveContact() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		//indexViewController = (IndexViewController) FacesContext.getCurrentInstance().getApplication().getELResolver()
				//.getValue(context, null, "indexViewController");

		//indexViewController.updateCustomerList();

		// instantiate customerManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");

		// instantiate contactManagedBean
		ELContext contactContext = FacesContext.getCurrentInstance().getELContext();
		contactManagedBean = (ContactManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(contactContext, null, "contactManagedBean");
	}

	/**
	 * @param customer Id
	 */
	public void removeContact(int contactId) {
		try {
			// remove this customer from its contact from db via EJB
			//zoe:since that the contact's Customer is null, let me try to set the Customer's 
			//contact Set to null then remove it.
			//Contact contact = contactManagedBean.searchContactById(contactId);
			/*
			 * List<Contact> allContacts = customerManagedBean.getAllContactPeople();
			 * //.searchContactByCustomerid(customerId);
			 * System.out.println("you have reached here"); if (allContacts != null) {
			 * 
			 * for (Contact c : allContacts) { if (c.getCustomer().getCustomerId() ==
			 * customerId) { contactManagedBean.setContactCustomerToNull(c); } } }
			 */
			
			
			// remove this customer from db via EJB
			contactManagedBean.removeContact(contactId);

			// refresh the list in CustomerApplication bean
			contactViewController.updateContactList();
			//ArrayList<fit5042.assignment.repository.entities.Customer> customers = indexViewController.getCustomers();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Contact with id " + contactId + " has been deleted succesfully !"));
		} catch (Exception ex) {
			String errorString = ex.toString();
			
			System.out.println("BUUUUUUUUUUUUUUUUG ooohoooou You got a Bug: " + errorString);
		}
		showForm = true;

	}
}