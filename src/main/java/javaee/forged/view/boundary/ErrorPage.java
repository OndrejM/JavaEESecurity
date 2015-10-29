package javaee.forged.view.boundary;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaee.forged.view.control.Current;
import javaee.forged.view.control.CurrentRequestIsAjax;
import javax.annotation.PostConstruct;
import javax.ejb.EJBAccessException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestScoped
@Named
public class ErrorPage {

    @Inject
    @Current
    private HttpServletRequest request;

    @Inject
    @Current
    private HttpServletResponse response;

    @Inject
    @CurrentRequestIsAjax
    private boolean ajax;

    private Exception exception;

    private boolean responseInitialized = false;

    private int errorStatus = 0;

    @PostConstruct
    public void init() {
        Object exceptionInRequest = request.getAttribute("javax.servlet.error.exception");
        if (exceptionInRequest instanceof Exception) {
            this.exception = Exception.class.cast(exceptionInRequest);
        }
    }

    public void initializeResponse() {
        if (!responseInitialized) {
            responseInitialized = true;
            if (exception instanceof EJBAccessException || exception instanceof SecurityException) {
                setErrorStatus(HttpServletResponse.SC_FORBIDDEN);
            } else {
                setErrorStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    public String getErrorMessage() {
        switch (errorStatus) {
            case HttpServletResponse.SC_FORBIDDEN:
                return "Neoprávnený prístup";
            default:
                return "Všeobecná chyba";
        }
    }

    private void setErrorStatus(int status) {
        errorStatus = status;
        if (!ajax) {
            response.setStatus(status);
        }
    }
}
