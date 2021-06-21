package com.life.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jc
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Object Hello() {
        return "hello ";
    }
}
