package fit5042.assignment.controllers;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.assignment.repository.entities.Address;
import fit5042.assignment.repository.entities.Contact;

/**
 * @autor Qixin HE Reference: Tutorial materials(Guan).
 */

@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable {

	private String streetNumber;
	private String streetAddress;
	private String suburb;
	private String postcode;
	private String state;

	private int customerId;
	private String email;
	private Address address;
	private String phone;
	private int industry;
	private Set<Contact> contacts;
	private String customerName;
	private int staffId;

	private Set<String> tags;

	private int contactId;
	private String lastName;
	private String contactEmail;
	private String contactPhone;
	private String firstName;
	private Customer customer;

	private Set<fit5042.assignment.repository.entities.Customer> customers;

	public Customer() {
		this.tags = new HashSet<>();
	}

	// non-defaut constructor
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

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

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

	public int getIndustry() {
		return industry;
	}

	public void setIndustry(int industry) {
		this.industry = industry;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<fit5042.assignment.repository.entities.Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<fit5042.assignment.repository.entities.Customer> customers) {
		this.customers = customers;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result + contactId;
		result = prime * result + ((contactPhone == null) ? 0 : contactPhone.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + industry;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + staffId;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
		result = prime * result + ((suburb == null) ? 0 : suburb.hashCode());
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
		if (contactEmail == null) {
			if (other.contactEmail != null) {
				return false;
			}
		} else if (!contactEmail.equals(other.contactEmail)) {
			return false;
		}
		if (contactId != other.contactId) {
			return false;
		}
		if (contactPhone == null) {
			if (other.contactPhone != null) {
				return false;
			}
		} else if (!contactPhone.equals(other.contactPhone)) {
			return false;
		}
		if (contacts == null) {
			if (other.contacts != null) {
				return false;
			}
		} else if (!contacts.equals(other.contacts)) {
			return false;
		}
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
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
		if (customers == null) {
			if (other.customers != null) {
				return false;
			}
		} else if (!customers.equals(other.customers)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (industry != other.industry) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (postcode == null) {
			if (other.postcode != null) {
				return false;
			}
		} else if (!postcode.equals(other.postcode)) {
			return false;
		}
		if (staffId != other.staffId) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (streetAddress == null) {
			if (other.streetAddress != null) {
				return false;
			}
		} else if (!streetAddress.equals(other.streetAddress)) {
			return false;
		}
		if (streetNumber == null) {
			if (other.streetNumber != null) {
				return false;
			}
		} else if (!streetNumber.equals(other.streetNumber)) {
			return false;
		}
		if (suburb == null) {
			if (other.suburb != null) {
				return false;
			}
		} else if (!suburb.equals(other.suburb)) {
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
