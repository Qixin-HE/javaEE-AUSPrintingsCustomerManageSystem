package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.assignment.mbeans.CustomerManagedBean;

import javax.faces.bean.ManagedProperty;

/**
 * @autor Qixin HE
 * Reference: Tutorial materials.
 */
@RequestScoped
@Named("addViewController")
public class AddViewController {

	@ManagedProperty(value="#{customerManagedBean}") 
    CustomerManagedBean customerManagedBean;
	
    private boolean showForm = true;

    private Customer customer;
    
    IndexViewController app;
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public AddViewController() 
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app  = (IndexViewController) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "indexViewController");
        
        //instantiate customerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "customerManagedBean");
    }

    public void addCustomer(Customer localCustomer) {
        //this is the local customer, not the entity
       try
       {
            //add this customer to db via EJB
            customerManagedBean.addCustomer(localCustomer);

            //refresh the list in CustomerApplication bean
            app.searchAll();
            //updateCustomerListInCustomerApplicationBean();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added succesfully"));
            //refresh the customer list in customerApplication bean
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;
    }
}
