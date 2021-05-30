package fit5042.assignment.repository.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * @author Qixin HE
 * Reference: Tutorial materials.
 */

@Entity
@NamedQueries({
    @NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId desc")})
public class Customer implements Serializable {

	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
	
	private int customerId;
	private String email;
	private Address address;
	private String phone;
	private int industry;
	private Set<Contact> contacts;
	private String customerName;
	private int staffId;
	
	private Set<String> tags;
	
	public Customer() {
        this.tags = new HashSet<>();
    }
	


	public Customer(int customerId, String email, Address address, String phone, int industry, Set<Contact> contacts,
			String customerName, int staffId, Set<String> tags) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.industry = industry;
		this.contacts = contacts;
		this.customerName = customerName;
		this.staffId = staffId;
		this.tags = tags;
	}



	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	

	
    public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	//enforce the relationship between a customer and its contact person using annotation(s). Each property has one and only one customer. Each customer might have zero to many contacts.
    @OneToMany(mappedBy = "customer")
	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	//insert annotation here to make addess as embeded to Customer entity and stored as part of Customer - reference Eddie
    @Embedded
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/*
	Bank - 1
	Building - 2
	Data Communication Education - 3
	Farm - 4
	Health - 5
	Mining - 6
	Publishing - 7
	*/
	@Column(name = "type_of_industry")
	public int getIndustry() {
		return industry;
	}
	public void setIndustry(int industry) {
		this.industry = industry;
	}


	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

    //annotate the attribute tags in Property class so that the tags of a property will be stored in a table called TAG. The tags of a property should be eagerly fetched and the value of each tag must be stored in a column VALUE in the TAG table
    @ElementCollection
    @CollectionTable(name = "tag")
    @Column(name = "value")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + industry;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + staffId;
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (contacts == null) {
			if (other.contacts != null) {
				return false;
			}
		} else if (!contacts.equals(other.contacts)) {
			return false;
		}
		if (customerId != other.customerId) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (industry != other.industry) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (staffId != other.staffId) {
			return false;
		}
		if (tags == null) {
			if (other.tags != null) {
				return false;
			}
		} else if (!tags.equals(other.tags)) {
			return false;
		}
		return true;
	}
	

	
	
}
