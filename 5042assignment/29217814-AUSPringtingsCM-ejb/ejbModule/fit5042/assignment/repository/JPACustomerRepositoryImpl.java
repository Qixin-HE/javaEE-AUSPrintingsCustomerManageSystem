package fit5042.assignment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import fit5042.assignment.repository.entities.Contact;
import fit5042.assignment.repository.entities.Customer;

/**
 * @author Qixin HE Reference: Tutorial materials.
 */

@Stateless
public class JPACustomerRepositoryImpl implements CustomerRepository {

	// insert code (annotation) here to use container managed entity manager to
	// complete these methods
	@PersistenceContext(unitName = "29217814-AUSPringtingsCM-ejb")

	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) throws Exception {
		List<Customer> customers = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		customer.setCustomerId(customers.get(0).getCustomerId() + 1);
		entityManager.persist(customer);

	}

	@Override
	public Customer searchCustomerById(int id) throws Exception {
		Customer customer = entityManager.find(Customer.class, id);
		customer.getTags();
		return customer;
	}

//	@Override
//	public List<Customer> getAllProperties() throws Exception {
//		return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
//	}

	@Override
	public void removeCustomer(int customerId) throws Exception {
		Customer customer = this.searchCustomerById(customerId);
		customerContactsSetNull(customer);
		Boolean containDeletedItem = true;
		try {
			if (customer != null)
				entityManager.remove(customer);

			containDeletedItem = entityManager.contains(customer);
		} catch (Exception ex) {
			System.out.print(ex);
		}
	}

	// to successfully delete the customer, this method setting the customer's
	// contacts' customerid(fk) as null, then the removeCustomer() can move to
	// next process.
	public void customerContactsSetNull(Customer customer) {
		Set<Contact> contacts =  customer.getContacts();
		for (Contact c : contacts) {
			try {
				editContact(c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//set the contact's Customer to null.
	@Override
	public void editContact(Contact contact) throws Exception {
		contact.setCustomer(null);
		try {
			entityManager.merge(contact);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	@Override
	public void editCustomer(Customer customer) throws Exception {
		try {
			entityManager.merge(customer);
		} catch (Exception ex) {

		}

	}

	@Override
	public Set<Contact> searchContactsByCustomer(Customer customer) throws Exception {
		customer = entityManager.find(Customer.class, customer.getCustomerId());
		customer.getContacts().size();
		entityManager.refresh(customer);

		return customer.getContacts();
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		List<Customer> customers = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		return customers;
	}

	@Override
	public List<Contact> getAllContact() throws Exception {

		return entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList();
	}

}
