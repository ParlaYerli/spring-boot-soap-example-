package com.techsoap.springbootsoapexample.endpoint;

import com.techsoap.spring_boot_soap_example.GetUserRequest;
import com.techsoap.spring_boot_soap_example.GetUserResponse;
import com.techsoap.spring_boot_soap_example.User;
import com.techsoap.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://techsoap.com/spring-boot-soap-example",localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload   GetUserRequest request){
        GetUserResponse response= new GetUserResponse();
        response.setUser(userService.getUser(request.getName()));
        return response;
    }
}
