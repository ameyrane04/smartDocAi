package com.smartDocAi.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Start of smart doc AI...";
    }
}
