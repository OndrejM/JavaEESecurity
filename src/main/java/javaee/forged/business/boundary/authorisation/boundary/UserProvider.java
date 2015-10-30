package javaee.forged.business.boundary.authorisation.boundary;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UserProvider {

    @Resource
    private EJBContext eJBContext;
    
    public User getCurrentUser() {
        return retrieveUser(eJBContext.getCallerPrincipal().getName());
    }
    
    public boolean currentÚserHasRight(Right right) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            return false;
        } else {
            for (Role role : currentUser.getRoles()) {
                if (role.getRights().contains(right)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean currentUserHasRole(Role role) {
        return true;
    }
    
    private static User retrieveUser(String userName) {
        if ("anonymous".equals(userName)) {
            return null;
        } else {
            User user = new User();
            user.setUsername(userName);
            user.setFirstName(userName);
            user.setLastName("Novák");
            //user.getRoles().add(new Role(Right.ADMIN));
            return user;
        }
    }
}
