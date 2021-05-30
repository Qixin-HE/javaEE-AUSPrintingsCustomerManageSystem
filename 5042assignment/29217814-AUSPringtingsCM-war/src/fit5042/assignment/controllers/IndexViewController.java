package fit5042.assignment.controllers;

import fit5042.assignment.repository.entities.Contact;
import fit5042.assignment.repository.entities.Customer;

import java.io.IOException;
import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import fit5042.assignment.mbeans.CustomerManagedBean;
import fit5042.assignment.mbeans.IdentityManagedBean;

import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * @author Qixin HE Reference: Tutorial materials(Guan).
 */
@Named(value = "indexViewController")
@ApplicationScoped
public class IndexViewController {
	// dependency injection of managed bean here so that we can use its methods
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;
	
	@ManagedProperty(value = "#{identityManagedBean}")
	IdentityManagedBean identityManagedBean;

	private ArrayList<Customer> customers;
	

	private boolean showForm = true;

	public boolean isShowForm() {
		return showForm;
	}
	

	// Add some customer data from db to app
	public IndexViewController() throws Exception {
		customers = new ArrayList<>();

		// instantiate customerManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		identityManagedBean = (IdentityManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "identityManagedBean");

		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");

		// get customers from db
		updateCustomerList();
	}

	// when loading, and after adding or deleting, the customer list needs to be
	// refreshed
	// this method is for that purpose
	public void updateCustomerList() {
		
		  if (customers != null && customers.size() > 0) {
		  
		  if (customers.get(1) != null && (customers.get(0).getCustomerId() > customers.get(1).getCustomerId()))
		  
		  { Collections.reverse(customers); 
		  setCustomers(customers);
		  }
		  
		  } else {
		 
			customers.clear();

			for (Customer customer : customerManagedBean.getAllCustomers()) {
				customers.add(customer);
			}
			if (customers.get(0).getCustomerId() > customers.get(1).getCustomerId())

			{
				Collections.reverse(customers);
			}

			setCustomers(customers);
		}
	}

	public void searchCustomerById(int customerId) {
		customers.clear();

		customers.add(customerManagedBean.searchCustomerById(customerId));
	}

	public void searchAll() {
		customers.clear();
		

		for (Customer customer : customerManagedBean.getAllCustomers()) {
			
			customers.add(customer);
		}
		//for right order displayed purpose - zoe
		if (customers.get(0).getCustomerId() > customers.get(1).getCustomerId())

		{
			Collections.reverse(customers);
		}
		
		setCustomers(customers);
	}

	public ArrayList<Contact> getContacts() {
		ArrayList<Contact> contacts = new ArrayList<>();

		// instantiate customerManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "customerManagedBean");

		// get customers from db

		try {
			for (Contact contact : customerManagedBean.getAllContactPeople()) {
				contacts.add(contact);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contacts;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	private void setCustomers(ArrayList<Customer> newCustomers) {
		this.customers = newCustomers;
	}
	public void logout()
	{
		identityManagedBean.invalidate();
	}
	
	
}
