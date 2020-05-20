package com.forezp.servicefeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-hi",fallback = ServiceHiClientHystrix.class)
public interface ServiceHiClient {
    @GetMapping("/hi")
    public String sayHiFromClientOne();
}
