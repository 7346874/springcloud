package com.java.controller;

import com.java.entity.Student;
import com.java.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return feignProviderClient.findAll();
    }

    @RequestMapping("/index")
    public String index(){
        return feignProviderClient.index();
    }


}
