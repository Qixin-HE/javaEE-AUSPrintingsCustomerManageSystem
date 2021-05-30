package fit5042.assignment.repository.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials.
 */

@Entity
@Table(name = "CONTACT")
@NamedQueries({
    @NamedQuery(name = Contact.GET_ALL_QUERY_NAME, query = "SELECT c FROM Contact c order by c.contactId desc")})
public class Contact implements Serializable{

	public static final String GET_ALL_QUERY_NAME = "Contact.getAll";
	
	private int contactId;
	private String lastName;
	private String contactEmail;
	private String contactPhone;
	private String firstName;
	private Customer customer;
	
//2020.10.08:to fix"Exception Description: The instance creation method [fit5042.assignment.repository.entities.Contact.<Default Constructor>], with no parameters, does not exist, or is not accessible."
    public Contact() {
    }
    public Contact(int contactId, String lastName, String contactEmail, String contactPhone, String firstName,
			Customer customer) {
		super();
		this.contactId = contactId;
		this.lastName = lastName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.firstName = firstName;
		this.customer = customer;
	}
	//enforce the relationship between a customer and its contact person using annotation(s). Each contact has one and only one customer/company. Each company might have zero to many customer.
    @ManyToOne
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Id
    @GeneratedValue
    @Column(name = "contact_id")
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.contactId;
        return hash;
    }

	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
    @Column(name = "contact_phone_number")
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.contactId != other.contactId) {
            return false;
        }
        return true;
	}

	@Override
	public String toString() {
		
		return this.contactId + " - " + firstName + " - " +
				lastName + " - " + customer + " - " + contactPhone + " - " + contactEmail;
	}
	
    
}
