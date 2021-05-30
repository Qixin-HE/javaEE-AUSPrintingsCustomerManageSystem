package fit5042.assignment.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import fit5042.assignment.repository.ContactRepository;
import fit5042.assignment.repository.CustomerRepository;
import fit5042.assignment.repository.entities.Address;
import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.Contact;

/**
 * @author Qixin HE
 * Reference: Tutorial materials（@author messomc）.
 */

@ManagedBean(name = "contactManagedBean")
@SessionScoped
public class ContactManagedBean implements Serializable{

	@EJB
    ContactRepository contactRepository;
	@EJB
    CustomerRepository customerRepository;

    /**
     * Creates a new instance of ContactManagedBean
     */
    public ContactManagedBean() {
    }



    
    /**
     * Search a contact by Id
     */
    public Contact searchContactById(int id)
    {
        try {
            return contactRepository.searchContactById(id);
        } catch (Exception ex) {
            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Contact> searchContactByCustomerid(int customerid) 
    {
        try {
            return contactRepository.searchContactByCustomerid(customerid);
        } catch (Exception ex) {
            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public List<Contact> getAllContacts() throws Exception {
        try {
            List<Contact> contacts = contactRepository.getAllContacts();
            return contacts;
        } catch (Exception ex) {
            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void removeContact(int contactId) 
    {
        try {
            contactRepository.removeContact(contactId);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact with id " + contactId + " has deleted from the system."));
        } catch (Exception ex) {
            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editContact(Contact contact)
    {
        try {
//            String s = contact.getAddress().getStreetNumber();
//            Address address = contact.getAddress();
//            address.setStreetNumber(s);
//            contact.setAddress(address);
        	int customerid = contact.getCustomer().getCustomerId();
        	try {
        	Customer customer = customerRepository.searchCustomerById(customerid);
        	contact.setCustomer(customer);
        	}
        	catch(Exception ex)
        	{
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company(Customer) with customer id " + customerid + " may not exist. The change will not be saved. Please check it again."));
        		return;
        	}
            
            contactRepository.editContact(contact);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setContactCustomerToNull(Contact contact) {
    	try {
            contactRepository.setContactCustomerToNull(contact);
       } catch (Exception ex) {
           Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    public void addContact(Contact contact) 
    {
        try {
             contactRepository.addContact(contact);
        } catch (Exception ex) {
            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public void addContact(Contact localContact) {
//        //convert this newContact which is the local contact to entity contact
//        Contact contact = convertContactToEntity(localContact);
//
//        try {
//            contactRepository.addContact(contact);
//        } catch (Exception ex) {
//            Logger.getLogger(ContactManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    private Contact convertContactToEntity(Contact localContact) {
        Contact contact = new Contact(); //entity
//        String streetNumber = localContact.getStreetNumber();
//        String streetAddress = localContact.getStreetAddress();
//        String suburb = localContact.getSuburb();
//        String postcode = localContact.getPostcode();
//        String state = localContact.getState();
//        Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
//        contact.setAddress(address);
//        //may have to change
//        contact.setContacts(localContact.getContacts());
//        contact.setContactName(localContact.getContactName());
//        contact.setEmail(localContact.getEmail());
//        contact.setIndustry(localContact.getIndustry());
//        contact.setTags(localContact.getTags());
        /*
        int contactId = localContact.getConactId();
        int companyId = localContact.getCompanyId();
        String email = localContact.getEmail();
        String firstName = localContact.getFirstName();
        String lastName = localContact.getLastName();
        String phone = localContact.getPhone;
        
        Contact contact = new Contact(contactId, companyId,email, phone, firstName, lastName);
        if (contact.getContactId() == 0)
            contact = null;
        contact.setContact(contact);
        */
        return contact;
    }
}
