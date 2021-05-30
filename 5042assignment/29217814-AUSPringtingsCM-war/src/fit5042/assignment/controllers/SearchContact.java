package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.repository.entities.Contact;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials（@author Guan）.
 */
@RequestScoped
@Named("searchContact")
public class SearchContact {

	 private Contact contact;
	    
	    ContactViewController app;
	    
	    private int searchByInt;
	    private double searchByDouble;

	    
	    public ContactViewController getApp() {
			return app;
		}

		public void setApp(ContactViewController app) {
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
	    

	    
	    public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		public SearchContact() {
	        ELContext context
	                = FacesContext.getCurrentInstance().getELContext();

	        app = (ContactViewController) FacesContext.getCurrentInstance()
	                        .getApplication()
	                        .getELResolver()
	                        .getValue(context, null, "contactViewController");
	        
	        
	    }

	    /**
	     * Normally each page should have a backing bean but you can actually do it
	     * any how you want.
	     *
	     * @param customer Id 
	     */
	    public void searchContactById(int contactId) 
	    {
	       try
	       {
	            //search this customer then refresh the list in CustomerApplication bean
	            app.searchContactById(contactId);
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
