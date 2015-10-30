package javaee.forged.business.boundary.authorisation.boundary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Role {
    
    private Set<Right> rights;
    
    public Role(Right... rights) {
        this.rights = new HashSet<>(Arrays.asList(rights));
    }

    public Set<Right> getRights() {
        return rights;
    }

    public void setRights(Set<Right> rights) {
        this.rights = rights;
    }
    
}
