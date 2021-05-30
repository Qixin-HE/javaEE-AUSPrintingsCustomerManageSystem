package fit5042.assignment.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
/**
 * @autor Qixin HE
 * Reference: Tutorial materials(@author Guan).
 */

@Named(value = "titleController")
@RequestScoped
public class TitleController {

	private String pageTitle;

    public TitleController() {
        // Set the page title 
        pageTitle = "AUSPrintings CM";
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
