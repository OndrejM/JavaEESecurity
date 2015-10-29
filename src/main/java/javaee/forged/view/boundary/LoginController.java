package javaee.forged.view.boundary;

import javaee.forged.view.control.Current;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginController {
    
    @Inject
    @Current
    private HttpServletRequest request;
    
    public String logout() throws ServletException {
        request.logout();
        return "/index.xhtml?faces-redirect=true";
    }
}