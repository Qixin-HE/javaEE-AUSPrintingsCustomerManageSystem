package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials（@author Guan）.
 */
@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {

	 private Customer customer;
	    
	    IndexViewController app;
	    
	    private int searchByInt;
	    private double searchByDouble;

	    public IndexViewController getApp() {
	        return app;
	    }

	    public void setApp(IndexViewController app) {
	        this.app = app;
	    }
	    private double searchByBudget;

	    public double getSearchByDouble() {
	        return searchByDouble;
	    }

	    public void setSearchByDouble(double searchByDouble) {
	        this.searchByDouble = searchByDouble;
	    }

	    public int getSearchByInt() {
	        return searchByInt;
	    }

	    public void setSearchByInt(int searchByInt) {
	        this.searchByInt = searchByInt;
	    }

	    public double getSearchByBudget() {
	        return searchByBudget;
	    }

	    public void setSearchByBudget(double searchByBudget) {
	        this.searchByBudget = searchByBudget;
	    }
	    
	    public void setCustomer(Customer customer){
	        this.customer = customer;
	    }
	    
	    public Customer getCustomer(){
	        return customer;
	    }
	    
	    public SearchCustomer() {
	        ELContext context
	                = FacesContext.getCurrentInstance().getELContext();

	        app = (IndexViewController) FacesContext.getCurrentInstance()
	                        .getApplication()
	                        .getELResolver()
	                        .getValue(context, null, "indexViewController");
	        
	        //app.updateCustomerList();
	    }

	    /**
	     * Normally each page should have a backing bean but you can actually do it
	     * any how you want.
	     *
	     * @param customer Id 
	     */
	    public void searchCustomerById(int customerId) 
	    {
	       try
	       {
	            //search this customer then refresh the list in CustomerApplication bean
	            app.searchCustomerById(customerId);
	       }
	       catch (Exception ex)
	       {
	           
	       }
	    }

	    
	    public void searchAll() 
	    {
	       try
	       {
	            //return all properties from db via EJB
	             app.searchAll();
	       }
	       catch (Exception ex)
	       {
	           
	       }
	    }
}
