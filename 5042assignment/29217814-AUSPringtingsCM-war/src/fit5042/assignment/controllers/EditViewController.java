package fit5042.assignment.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.assignment.repository.entities.Contact;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials（@author Messom
 * @author Guan）.
 */
@Named(value = "editViewController")
@RequestScoped
public class EditViewController {
	private int customerIndex; //this customerIndex is the index, don't confuse with the Customer Id
	private fit5042.assignment.repository.entities.Customer customer;
	private ArrayList<Contact> contacts;
	
    public int getCustomerIndex() {
        return customerIndex;
    }

    public void setCustomerIndex(int customerId) {
        this.customerIndex = customerId;
    }
    
    

    public EditViewController() {
        // Assign customer identifier via GET param 
        //this customerID is the index, don't confuse with the Customer Id
    	customerIndex = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerID"));
        // Assign customer based on the id provided 
        customer = getCustomer();
        //customerId = customer.getCustomerId();
        contacts = getContacts();
    }

    public fit5042.assignment.repository.entities.Customer getCustomer() {
        if (customer == null) {
            // Get application context bean CustomerApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            IndexViewController app
                    = (IndexViewController) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "indexViewController");
            // -1 to customerId since we +1 in JSF (to always have positive customer id!) 
            return app.getCustomers().get(--customerIndex); //this customerId is the index, don't confuse with the Customer Id
        }
        return customer;
    }
    
    public ArrayList<Contact> getContacts() {
        if (contacts == null) {
            // Get application context bean CustomerApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            IndexViewController app
                    = (IndexViewController) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "indexViewController");
            contacts = app.getContacts();
            //int index = 0;
            ArrayList<Contact> customercontacts = new ArrayList<>();
			int customerid = customer.getCustomerId();
			for (Contact c : contacts) {
				fit5042.assignment.repository.entities.Customer customeridValue = c.getCustomer();
				if (customeridValue != null) {
					if (c.getCustomer().getCustomerId() == customerid) {
						customercontacts.add(c);
						// index++;
					}
				}
			}
            return customercontacts; 
        }
        return contacts;
    }
}
