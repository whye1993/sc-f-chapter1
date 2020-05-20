package com.forezp.servicefeign.controller;

import com.forezp.servicefeign.client.ServiceHiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private ServiceHiClient serviceHiClient;

    @GetMapping("/hi")
    public String sayHi() {
        return serviceHiClient.sayHiFromClientOne();
    }
}
