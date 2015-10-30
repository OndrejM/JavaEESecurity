package javaee.forged.view.boundary;

import java.io.Serializable;
import javaee.forged.business.boundary.AppService;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named
@ViewScoped
public class IndexPage implements Serializable {

    @Inject
    transient
    private AppService appService;
    
    private String welcomeMessage;

    private String name;
    
    @PostConstruct
    private void init() {
        this.name = "John";
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getName() {
        return name;
    }

    @RolesAllowed("ADMIN")  // nezafunguje - musi byt na EJB
    public void setName(String name) {
        this.name = appService.updateName(name);
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (welcomeMessage != null && !welcomeMessage.trim().isEmpty()) {
            result += "welcomeMessage: " + welcomeMessage;
        }
        if (name != null && !name.trim().isEmpty()) {
            result += ", name: " + name;
        }
        return result;
    }
}
