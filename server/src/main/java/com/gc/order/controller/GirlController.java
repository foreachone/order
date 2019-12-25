package com.gc.order.controller;

import com.gc.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {

    @Autowired
    GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {
        return girlConfig.getName() + "-" + girlConfig.getAge();
    }
}
