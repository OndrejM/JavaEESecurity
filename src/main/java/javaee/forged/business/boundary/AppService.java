package javaee.forged.business.boundary;

import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;

@RolesAllowed("ADMIN")
@Stateless
@DeclareRoles("ADMIN")
public class AppService {
    
    @Resource
    private EJBContext eJBContext;
    
    @PermitAll
    public String updateName(String name) {
        return name + "(Zmenené používateľom " + eJBContext.getCallerPrincipal().getName() + ")";
    }
}
