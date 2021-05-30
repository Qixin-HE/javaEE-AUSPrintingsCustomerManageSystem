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

import fit5042.assignment.repository.entities.Customer;
import fit5042.assignment.repository.entities.Contact;

/**
 * @author Qixin HE Reference: Tutorial materials.
 */

@Stateless
public class JPAContactRepositoryImpl implements ContactRepository {

	// insert code (annotation) here to use container managed entity manager to
	// complete these methods
	@PersistenceContext(unitName = "29217814-AUSPringtingsCM-ejb")

	private EntityManager entityManager;

	@Override
	public void addContact(Contact contact) throws Exception {
		List<Contact> contacts = entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList();
		contact.setContactId(contacts.get(0).getContactId() + 1);
		entityManager.persist(contact);

	}

	@Override
	public Contact searchContactById(int id) throws Exception {
		Contact contact = entityManager.find(Contact.class, id);
		//contact.getTags();
		return contact;
	}

//	@Override
//	public List<Contact> getAllProperties() throws Exception {
//		return entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList();
//	}

	@Override
	public void removeContact(int contactId) throws Exception {
		Contact contact = this.searchContactById(contactId);
		contactContactsSetNull(contact);
		Boolean containDeletedItem = true;
		try {
			if (contact != null)
				entityManager.remove(contact);

			containDeletedItem = entityManager.contains(contact);
		} catch (Exception ex) {
			System.out.print(ex);
		}
	}

	// to successfully delete the contact, this method setting the contact's
	// contacts' contactid(fk) as null, then the removeContact() can move to
	// next process.
	public void contactContactsSetNull(Contact contact) {
//		ArrayList<Contact> contacts = (ArrayList<Contact>) contact.getContacts();
//		for (Contact c : contacts) {
//			try {
//				editContact(c);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	@Override
	public void editContact(Contact contact) throws Exception {
		//contact.setCustomer(null);
		try {
			entityManager.merge(contact);
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}


	

	@Override
	public List<Contact> searchContactByCustomerid(int customerid) throws Exception {
	List<Contact> contacts = getAllContacts();
	for (Contact c : contacts) {
		if (c.getCustomer().getCustomerId() != customerid) {
			contacts.remove(c);
		}
	}
	return contacts;
	}

	@Override
	public List<Contact> getAllContacts() throws Exception {
		List<Contact> contacts = entityManager.createNamedQuery(Contact.GET_ALL_QUERY_NAME).getResultList();
		return contacts;
	}



	@Override
	public void setContactCustomerToNull(Contact contact) throws Exception {
		contact.setCustomer(null);
		try {
			if (contact != null)
				entityManager.merge(contact);

			
		} catch (Exception ex) {
			System.out.print(ex);
		}
		
	}


}
