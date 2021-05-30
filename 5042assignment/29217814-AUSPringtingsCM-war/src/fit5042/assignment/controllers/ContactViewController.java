package fit5042.assignment.controllers;

import fit5042.assignment.repository.entities.Contact;
import fit5042.assignment.repository.entities.Customer;
import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import fit5042.assignment.mbeans.ContactManagedBean;

import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Qixin HE Reference: Tutorial materials(Guan).
 */
@Named(value = "contactViewController")
@ApplicationScoped
public class ContactViewController {
	// dependency injection of managed bean here so that we can use its methods
	@ManagedProperty(value = "#{contactManagedBean}")
	ContactManagedBean contactManagedBean;

	private ArrayList<Contact> contacts;

	private boolean showForm = true;

	public boolean isShowForm() {
		return showForm;
	}

	// Add some customer data from db to app
	public ContactViewController() throws Exception {
		contacts = new ArrayList<>();

		// instantiate contactManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		contactManagedBean = (ContactManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "contactManagedBean");

		// get customers from db
		updateContactList();
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}

	// when loading, and after adding or deleting, the customer list needs to be
	// refreshed
	// this method is for that purpose
	public void updateContactList() {
		if (contacts != null && contacts.size() > 0) {

			if (contacts.get(1) != null && (contacts.get(0).getContactId() > contacts.get(1).getContactId()))

			{
				Collections.reverse(contacts);
				setContacts(contacts);
			}

		} else {

			contacts.clear();

			try {
				for (Contact contact : contactManagedBean.getAllContacts()) {
					contacts.add(contact);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Collections.reverse(contacts);

			setContacts(contacts);
		}

	}

	public void searchContactById(int contactId) {
		contacts.clear();

		contacts.add(contactManagedBean.searchContactById(contactId));
	}

	public void searchAll() {
		contacts.clear();

		try {
			for (Contact contact : contactManagedBean.getAllContacts()) {
				contacts.add(contact);
			}
			try {
				if (contacts.get(1) != null && (contacts.get(0).getContactId() > contacts.get(1).getContactId()))

				{
					Collections.reverse(contacts);
					// setCustomers(customers);
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setContacts(contacts);
	}

	public ArrayList<Contact> getContacts() {
		ArrayList<Contact> contacts = new ArrayList<>();

		// instantiate contactManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		contactManagedBean = (ContactManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "contactManagedBean");

		// get customers from db

		try {
			for (Contact contact : contactManagedBean.getAllContacts()) {
				contacts.add(contact);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (contacts.get(1) != null && (contacts.get(0).getContactId() > contacts.get(1).getContactId()))

			{
				Collections.reverse(contacts);
				// setCustomers(customers);
			}
		} catch (Exception e) {
		}

		return contacts;
	}

	/*
	 * public Customer getCustomer(customerid) { //instantiate contactManagedBean
	 * ELContext elContext = FacesContext.getCurrentInstance().getELContext();
	 * contactManagedBean = (ContactManagedBean)
	 * FacesContext.getCurrentInstance().getApplication()
	 * .getELResolver().getValue(elContext, null, "contactManagedBean"); //get
	 * customers from db
	 * 
	 * try { for (Customer customer : contactManagedBean.get()) {
	 * contacts.add(contact); } } catch (Exception e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * return contacts; }
	 */
}
