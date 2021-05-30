package fit5042.assignment.repository.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials.
 */

@Entity
@NamedQueries({
    @NamedQuery(name = Order.GET_ALL_QUERY_NAME, query = "SELECT o FROM Order o order by o.orderId desc")})

public class Order implements Serializable{

	public static final String GET_ALL_QUERY_NAME = "Order.getAll";
	
	private int orderId;

	public Order(int orderId) {
		super();
		this.orderId = orderId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}
