package com.forezp.serviceribbon.controller;

import com.forezp.serviceribbon.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String hi() {
        return hiService.sayHi();
    }
}
