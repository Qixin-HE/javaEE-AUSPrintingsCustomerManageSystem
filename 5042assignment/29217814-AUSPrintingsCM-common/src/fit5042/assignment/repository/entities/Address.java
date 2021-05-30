package fit5042.assignment.repository.entities;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Eddie Leung
 */
/*
 * @Access(AccessType.PROPERTY) means that JPA is calling getter and setter to access the field after select or before insert or update.
 * https://stackoverflow.com/questions/48149260/jpa-accesstype-property-for-immutable-ids
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {

    private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;

    public Address() {
    }

    public Address(String streetNumber, String streetAddress, String suburb, String postcode, String state) {
        this.streetNumber = streetNumber;
        this.streetAddress = streetAddress;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
    }

    @Column(name = "street_number")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    //complete by adding annotation here for column name = "street_address"
    @Column(name = "street_address")
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

    //complete by adding annotation here for column name = "postcode"
    @Column(name = "postcode")
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

    @Override
    public String toString() {
        return streetNumber + " " + streetAddress + ", " + suburb + ", " + state + " " + postcode;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
		result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
		result = prime * result + ((suburb == null) ? 0 : suburb.hashCode());
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
		Address other = (Address) obj;
		if (postcode == null) {
			if (other.postcode != null) {
				return false;
			}
		} else if (!postcode.equals(other.postcode)) {
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
		return true;
	}
    
    
}
