package com.techsoap.springbootsoapexample.service;

import com.techsoap.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    public static final Map<String, User> users= new HashMap<>();
    @PostConstruct
    public void initialize(){
        User user1= new User();
        user1.setName("Parla");
        user1.setEmpId(1);
        user1.setSalary(1200);

        User user2 = new User();
        user2.setName("Ömer");
        user2.setEmpId(2);
        user2.setSalary(1300);

        users.put(user1.getName(),user1);
        users.put(user2.getName(),user2);
    }

    public User getUser(String name){
        return users.get(name);
    }
}
