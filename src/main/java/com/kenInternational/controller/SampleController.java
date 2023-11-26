package com.kenInternational.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/ctrl") // or use the @RestController for both of the annot @Controller and @ResponseBody
public class SampleController {

    // curl is http://localhost:8080/api/ctrl/hello-world
    @GetMapping("/hello-world")
    @ResponseBody
    public ResponseEntity<String> helloWorld(){
        return  ResponseEntity.status(HttpStatus.OK).body("Hello from Spring-Boot");
    }
}
