package org.java.controller;

import org.java.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "rest")
public class RestController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "findAll")
    public Collection<Student> findAll() {
        return restTemplate.getForEntity("http://localhost:8010/findAll",Collection.class).getBody();
    }

    @RequestMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/findAll",Collection.class);
    }

    @RequestMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return restTemplate.getForEntity("http://localhost:8010/findById/{id}",Student.class,id).getBody();
    }

    @RequestMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8010/findById/{id}",Student.class,id);
    }

    @RequestMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8010/save",student,null).getBody();
    }

    @RequestMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8010/save",student,null);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8010/update",student);
    }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/deleteById/{id}",id);
    }

}



