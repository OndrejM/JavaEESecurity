package javaee.forged.business.boundary;

import javaee.forged.business.boundary.authorisation.boundary.Right;
import javaee.forged.business.boundary.authorisation.boundary.UserProvider;
import javaee.forged.business.boundary.authorisation.model.User;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AppService {

    @Inject
    private UserProvider userProvider;
    
    @PermitAll
    public String updateName(String name) {
        if (userProvider.currentÚserHasRight(Right.ADMIN)) {
            return name + "(Zmenené používateľom " + getCurrentUser() + ")";
        } else {
            throw new SecurityException("Nedostatočné oprávnenie");
        }
    }
    
    @PermitAll
    public User getCurrentUser() {
        return userProvider.getCurrentUser();
    }
}
