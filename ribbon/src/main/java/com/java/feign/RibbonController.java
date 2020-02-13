package com.java.feign;

import com.java.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForObject("http://provider/findAll",Collection.class);
    }

    @RequestMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://provider/index",String.class);
    }
}
