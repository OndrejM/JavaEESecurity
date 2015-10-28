package javaee.forged.view.boundary;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class IndexPage {

    private String welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (welcomeMessage != null && !welcomeMessage.trim().isEmpty()) {
            result += "welcomeMessage: " + welcomeMessage;
        }
        return result;
    }
}
