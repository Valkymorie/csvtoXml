package com.valkymorie.csvtoxml.controller;


import com.valkymorie.csvtoxml.model.User;
import com.csvreader.CsvReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    public void readUsers(List<User> userList) {

        String fileName = "input.csv";
        boolean control = new File(fileName).exists();
        try {
            if (!control)
                throw new FileNotFoundException(fileName + " can not found in classpath");
            else {
                CsvReader input = new CsvReader("input.csv");
                input.readHeaders();
                int j = 0;
                while (input.readRecord()) {

                    String username = input.get("username");
                    String firstname = input.get("firstname");
                    String lastname = input.get("lastname");
                    String email = input.get("email");
                    String role = input.get("role");

                    List<String> stringRole = new ArrayList<String>();
                    stringRole.add(role);

                    for (int i = 0; i < userList.size(); i++) {

                        if (username.equals(userList.get(i).getUserName())) {
                            userList.get(i).addRole(role);
                            j++;
                            break;
                        }
                    }
                    if (j == 0) {
                        User newUser = new User(username, firstname, lastname, email, stringRole);
                        userList.add(newUser);
                    }
                    j = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
