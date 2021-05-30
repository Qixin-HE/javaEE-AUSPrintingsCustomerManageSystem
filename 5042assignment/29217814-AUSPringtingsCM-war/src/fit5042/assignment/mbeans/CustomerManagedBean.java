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

import fit5042.assignment.repository.CustomerRepository;
import fit5042.assignment.repository.entities.Address;
import fit5042.assignment.repository.entities.Contact;
import fit5042.assignment.repository.entities.Customer;

/**
 * @author Qixin HE
 * Reference: Tutorial materials（@author messomc）.
 */
@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable{

	@EJB
    CustomerRepository customerRepository;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
    }

    public List<Customer> getAllCustomers() {
        try {
            List<Customer> customers = customerRepository.getAllCustomers();
            return customers;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addCustomer(Customer customer) 
    {
        try {
             customerRepository.addCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Search a customer by Id
     */
    public Customer searchCustomerById(int id)
    {
        try {
            return customerRepository.searchCustomerById(id);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Set<Contact> searchContactsByCustomer(Customer customer) 
    {
        try {
            return customerRepository.searchContactsByCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Contact> getAllContactPeople() throws Exception {
        try {
            return customerRepository.getAllContact();
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void removeCustomer(int customerId) 
    {
        try {
            customerRepository.removeCustomer(customerId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editCustomer(Customer customer)
    {
        try {
            String s = customer.getAddress().getStreetNumber();
            Address address = customer.getAddress();
            address.setStreetNumber(s);
            customer.setAddress(address);
            
            customerRepository.editCustomer(customer);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addCustomer(fit5042.assignment.controllers.Customer localCustomer) {
        //convert this newCustomer which is the local customer to entity customer
        Customer customer = convertCustomerToEntity(localCustomer);

        try {
            customerRepository.addCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Customer convertCustomerToEntity(fit5042.assignment.controllers.Customer localCustomer) {
        Customer customer = new Customer(); //entity
        String streetNumber = localCustomer.getStreetNumber();
        String streetAddress = localCustomer.getStreetAddress();
        String suburb = localCustomer.getSuburb();
        String postcode = localCustomer.getPostcode();
        String state = localCustomer.getState();
        String phone = localCustomer.getPhone();
        int staffid = localCustomer.getStaffId();
        Address address = new Address(streetNumber, streetAddress, suburb, postcode, state);
        customer.setAddress(address);
        //may have to change
        //customer.setContacts(localCustomer.getContacts()); - zoe
        customer.setCustomerName(localCustomer.getCustomerName());
        customer.setEmail(localCustomer.getEmail());
        customer.setIndustry(localCustomer.getIndustry());
        customer.setTags(localCustomer.getTags());
        customer.setPhone(phone);
        customer.setStaffId(staffid);
        /*
        int contactId = localCustomer.getConactId();
        int companyId = localCustomer.getCompanyId();
        String email = localCustomer.getEmail();
        String firstName = localCustomer.getFirstName();
        String lastName = localCustomer.getLastName();
        String phone = localCustomer.getPhone;
        
        Contact contact = new Contact(contactId, companyId,email, phone, firstName, lastName);
        if (contact.getContactId() == 0)
            contact = null;
        customer.setContact(contact);
        */
        return customer;
    }
}
