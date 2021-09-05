package com.valkymorie.csvtoxml;

import com.valkymorie.csvtoxml.controller.ConvertController;
import com.valkymorie.csvtoxml.controller.UserController;
import com.valkymorie.csvtoxml.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import freemarker.template.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class CsvtoxmlApplication {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TemplateException {
        SpringApplication.run(CsvtoxmlApplication.class, args);

        final UserController userController = new UserController();
        final ConvertController convertController= new ConvertController();

        List<User> userList = new ArrayList<>();
        userController.readUsers(userList);
        convertController.converToXml(userList);

    }
}
