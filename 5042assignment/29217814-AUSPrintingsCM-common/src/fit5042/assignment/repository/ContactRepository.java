package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

import fit5042.assignment.repository.entities.Contact;


/**
 * @author Qixin HE Reference: Tutorial materials.
 */

@Remote
public interface ContactRepository {

	/**
	 * Add the contact being passed as parameter into the repository
	 *
	 * @param contact - the contact to add
	 */
	public void addContact(Contact contact) throws Exception;

	/**
	 * Search for a contact by its contact ID
	 *
	 * @param id - the contactId of the contact to search for
	 * @return the contact found
	 */
	public Contact searchContactById(int id) throws Exception;


	/**
	 * Return all the contact people in the repository
	 *
	 * @return all the contact people in the repository
	 */
	public List<Contact> getAllContacts() throws Exception;

	/**
	 * Remove the contact, whose contact ID matches the one being passed as
	 * parameter, from the repository
	 *
	 * @param contactId - the ID of the contact to remove
	 */
	public void removeContact(int contactId) throws Exception;

	/**
	 * Update a contact in the repository
	 *
	 * @param contact - the updated information regarding a contact
	 */
	public void editContact(Contact contact) throws Exception;



	
	
	public void setContactCustomerToNull(Contact contact) throws Exception;
	
	public List<Contact> searchContactByCustomerid(int customerid) throws Exception;

	
}