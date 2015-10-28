package javaee.forged.view.control;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestScoped
public class JSFProducer {

    @Produces
    @Current
    @RequestScoped
    public HttpServletRequest request() {
        return HttpServletRequest.class.cast(
                FacesContext.getCurrentInstance().getExternalContext().getRequest());
    }

    @Produces
    @Current
    @RequestScoped
    public HttpServletResponse response() {
        return HttpServletResponse.class.cast(
                FacesContext.getCurrentInstance().getExternalContext().getResponse());
    }
    
    @Produces
    @Current
    @RequestScoped
    public FacesContext facesCtx() {
        return FacesContext.getCurrentInstance();
    }
    
    @Produces
    @CurrentRequestIsAjax
    public boolean isAjax() {
        return facesCtx().getPartialViewContext().isAjaxRequest();
    }
}
