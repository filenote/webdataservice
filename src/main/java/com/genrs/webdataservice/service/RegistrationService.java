package com.genrs.webdataservice.service;

import com.genrs.webdataservice.model.server.entity.PlayerCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Service
public class RegistrationService {

    public boolean registerPlayer(PlayerCredentials playerCredentials) {
        final String uri = "http://localhost:8080/api/v0/register/";

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.postForObject(uri, playerCredentials, Boolean.class);
        stopWatch.stop();

        System.out.println(result + " " + stopWatch.getTotalTimeMillis());
        return false;
    }
}
