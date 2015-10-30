package javaee.forged.business.boundary;

import javaee.forged.business.boundary.authorisation.boundary.Guarded;
import javaee.forged.business.boundary.authorisation.boundary.Right;
import javaee.forged.business.boundary.authorisation.boundary.RightsAllowed;
import javaee.forged.business.boundary.authorisation.boundary.UserProvider;
import javaee.forged.business.boundary.authorisation.boundary.User;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
@Guarded
public class AppService {

    @Inject
    private UserProvider userProvider;
    
    @RightsAllowed({Right.ADMIN, Right.ADMIN})
    public String updateName(String name) {
        return name + "(Zmenené používateľom " + getCurrentUser() + ")";
    }
    
    public User getCurrentUser() {
        return userProvider.getCurrentUser();
    }
}
