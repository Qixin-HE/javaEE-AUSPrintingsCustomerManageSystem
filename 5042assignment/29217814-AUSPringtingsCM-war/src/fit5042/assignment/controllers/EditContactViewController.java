package fit5042.assignment.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.ContactManagedBean;
import fit5042.assignment.mbeans.CustomerManagedBean;
import fit5042.assignment.repository.entities.Contact;
import fit5042.assignment.repository.entities.Customer;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * @author Qixin HE Reference: Tutorial materials（@author Messom, Guan）.
 */
@Named(value = "editContactViewController")
@RequestScoped
public class EditContactViewController {
	private int contactIndex; // this contactIndex is the index, don't confuse with the Customer Id
	private Contact contact;
	private Customer customer;
	private ArrayList<Customer> customers;


	
    private boolean showForm = true;

	public int getContactIndex() {
		return contactIndex;
	}

	public void setContactIndex(int contactIndex) {
		this.contactIndex = contactIndex;
	}

	public EditContactViewController() {
	        // Assign customer identifier via GET param 
	        //this customerID is the index, don't confuse with the Customer Id
	    	contactIndex = Integer.valueOf(FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getRequestParameterMap()
	                .get("contactIndex"));
	        // Assign customer based on the id provided 
	        contact = getContact();
	        //customerId = customer.getCustomerId();
	        customer = getCustomer();
	        //customers = getCustomers();
	    }

	public Contact getContact() {
		if (contact == null) {
			// Get application context bean CustomerApplication
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			ContactViewController app = (ContactViewController) FacesContext.getCurrentInstance().getApplication()
					.getELResolver().getValue(context, null, "contactViewController");
			// -1 to customerId since we +1 in JSF (to always have positive customer id!)
			Contact contact = app.getContacts().get(--contactIndex);
			if (contact.getCustomer() == null)
			{
				Customer customer = new Customer();
				contact.setCustomer(customer);
			}
			return contact;
			}
			return contact; // this customerId is the index, don't confuse with the
															// Customer Id
		}
		
	

	public Customer getCustomer() {
		if (customer == null) {
			/*
			 * // Get application context bean CustomerApplication ELContext context =
			 * FacesContext.getCurrentInstance().getELContext(); IndexViewController app =
			 * (IndexViewController) FacesContext.getCurrentInstance().getApplication()
			 * .getELResolver().getValue(context, null, "indexViewController"); customer =
			 * app.searchCustomerById(contact.getCustomer());; // int index = 0;
			 * ArrayList<Contact> customercontacts = new ArrayList<>(); int customerid =
			 * customer.getCustomerId(); for (Contact c : contacts) {
			 * fit5042.assignment.repository.entities.Customer customeridValue =
			 * c.getCustomer(); if (customeridValue != null) { if
			 * (c.getCustomer().getCustomerId() == customerid) { customercontacts.add(c); //
			 * index++; } } } return customercontacts;
			 */
			
			customer = contact.getCustomer();
			if (customer == null)
			{
				customer = new Customer();
			}
			return customer;
		}
		return customer;
	}

//	public ArrayList<Customer> getCustomers() {
//		ArrayList<Customer> customers = new ArrayList<>();
//		
//
//			// Get application context bean IndexViewController
//			ELContext context = FacesContext.getCurrentInstance().getELContext();
//			IndexViewController app = (IndexViewController) FacesContext.getCurrentInstance().getApplication()
//					.getELResolver().getValue(context, null, "indexViewController");
//			customers = app.getCustomers(); // int index = 0;
//			
//
//			return customers;
//		
//	}

}
