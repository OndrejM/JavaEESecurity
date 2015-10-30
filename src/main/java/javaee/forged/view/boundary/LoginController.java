package javaee.forged.view.boundary;

import javaee.forged.business.boundary.AppService;
import javaee.forged.business.boundary.authorisation.model.User;
import javaee.forged.view.control.Current;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginController {

    private static final String FACESREDIRECT = "faces-redirect=true";
    
    @Inject
    @Current
    private HttpServletRequest request;
    
    @Inject
    private AppService appService;

    private String username;

    private String password;

    public String logout() throws ServletException {
        request.logout();
        return navigationToIndex();
    }

    private static String navigationToIndex() {
        return "/index.xhtml?" + FACESREDIRECT;
    }

    public String login() throws ServletException {
        request.login(username, password);
        return navigationToIndex();
    }
    
    public User getCurrentUser() {
        return appService.getCurrentUser();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
