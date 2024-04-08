package com.projects.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public HelloWorldBean helloWorld(){
        HelloWorldBean bean = new HelloWorldBean("hello World");
        System.out.println(bean);
        return bean;

    }
}
