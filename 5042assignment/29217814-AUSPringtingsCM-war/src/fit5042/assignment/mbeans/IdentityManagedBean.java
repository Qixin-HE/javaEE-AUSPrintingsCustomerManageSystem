package fit5042.assignment.mbeans;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "identityManagedBean")
@SessionScoped
public class IdentityManagedBean implements Serializable {
	@Inject
	Principal principal;

	@Inject
	HttpSession session;

	// @EJB
	// private UserRepository userRepository;
	/*
	 * private Appuser currentUser;
	 * 
	 * @PostConstruct public void init() { String username = principal.getName();
	 * try { currentUser = userRepository.getUserByEmail(username); } catch
	 * (Exception e) {} }
	 * 
	 * public Appuser getCurrentUser() { return currentUser; }
	 * 
	 * public void setCurrentUser(Appuser user) { this.currentUser = user; }
	 */

	public void invalidate() {
//    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//    	   //HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//    	   try {
    	       session.invalidate();
    	       String url = "http://localhost:8080/29217814-AUSPringtingsCM-war/"; 
    	       try {
    	    	FacesContext.getCurrentInstance().getExternalContext().redirect(url); } 
    	       catch
    	    		(IOException e) { // TODO Auto-generated catch block e.printStackTrace(); 
    	    	   }
    	       }
    	       //request.logout();
//    	   } catch (Exception ex) {
//    	       Logger.getLogger(IdentityManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//    	   }
//    }
	/*
	 * public void logOut() {
	 * FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	 * String url = "http://localhost:8080/29217814-AUSPringtingsCM-war/"; try {
	 * FacesContext.getCurrentInstance().getExternalContext().redirect(url); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	 * HttpSession session = (HttpSession)
	 * FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	 * session.invalidate(); }
	 */
    }

