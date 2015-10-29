package javaee.forged.business.boundary;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;

@RolesAllowed("user")
@Stateless
public class AppService {
    
    @Resource
    private EJBContext eJBContext;
    
    @PermitAll
    public String updateName(String name) {
        if (eJBContext.isCallerInRole("user")) {
            return name + "(Zmenené používateľom " + eJBContext.getCallerPrincipal().getName() + ")";
        } else {
            throw new SecurityException("Nedostatočné oprávnenie");
        }
    }
}
