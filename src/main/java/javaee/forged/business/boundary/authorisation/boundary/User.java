package javaee.forged.business.boundary.authorisation.boundary;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javaee.forged.business.boundary.authorisation.boundary.Right;
import javaee.forged.business.boundary.authorisation.boundary.Role;

public class User {
    private String username;
    private String firstName;
    private String lastName;
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
}
