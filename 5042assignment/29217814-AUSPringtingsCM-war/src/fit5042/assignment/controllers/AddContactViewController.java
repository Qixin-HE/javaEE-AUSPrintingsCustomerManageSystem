package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.ContactManagedBean;
import fit5042.assignment.mbeans.CustomerManagedBean;
import fit5042.assignment.repository.entities.Contact;
import fit5042.assignment.repository.entities.Customer;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials.
 */
@RequestScoped
@Named("addContactViewController")
public class AddContactViewController {
	
	@ManagedProperty(value="#{contactManagedBean}") 
    ContactManagedBean contactManagedBean;
	
	@ManagedProperty(value="#{customerManagedBean}") 
    CustomerManagedBean customerManagedBean;
	
	ContactViewController contactViewController;
	 private boolean showForm = true;
	 private Contact contact;
	 
	 
	 
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
    public AddContactViewController() 
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        contactViewController  = (ContactViewController) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "contactViewController");
        
        //instantiate customerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        contactManagedBean = (ContactManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "contactManagedBean");
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerManagedBean");
        contact = new Contact();
        Customer customer = new Customer();
		contact.setCustomer(customer);
    }

	public void addContact(Contact contact) {
        //this is the local customer, not the entity
       try
       {
    	   contact = this.contact;
    	   int customerid = contact.getCustomer().getCustomerId();
    	   Customer customer = customerManagedBean.searchCustomerById(customerid);
    	   contact.setCustomer(customer);
            //add this customer to db via EJB
            contactManagedBean.addContact(contact);

            //refresh the list in CustomerApplication bean
            ELContext context = FacesContext.getCurrentInstance().getELContext();
			ContactViewController app = (ContactViewController) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(context, null, "contactViewController");
			app.updateContactList();
            //updateCustomerListInCustomerApplicationBean();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact has been added succesfully"));
            //refresh the customer list in customerApplication bean
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;
    }
	
	public boolean isShowForm() {
        return showForm;
    }
}
