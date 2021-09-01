package com.valkymorie.csvtoxml.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;

    public void addRole(String newRole){
        roles.add(newRole);
    }
}
