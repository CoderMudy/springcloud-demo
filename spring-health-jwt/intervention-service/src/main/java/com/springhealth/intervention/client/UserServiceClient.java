package com.springhealth.intervention.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);
    
    @Autowired
    RestTemplate restTemplate;
   
   
    public UserMapper getUserByUserName(String userName){
    	
    	logger.debug("Get user: {}", userName);
    	
    	ResponseEntity<UserMapper> restExchange =
                restTemplate.exchange(
                        "http://localhost:5555/springhealth/user/users/username/{userName}",
                        HttpMethod.GET,
                        null, UserMapper.class, userName);
                
        UserMapper user = restExchange.getBody();
        
        return user;
    }
}