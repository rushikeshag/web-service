package com.lotusstack.webservices.controllers;

import com.lotusstack.webservices.dto.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeBeansControllers {

    @GetMapping("/getOne")
    public SomeBean getSomeBeans() {
        return new SomeBean("value1", "value2", "value3");
    }
}
