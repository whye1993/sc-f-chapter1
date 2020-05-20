package com.forezp.servicefeign.client;

import org.springframework.stereotype.Component;

@Component
public class ServiceHiClientHystrix implements ServiceHiClient {
    @Override
    public String sayHiFromClientOne() {
        return "sorry,you are stupid";
    }
}
