package com.java.web;

import com.java.dao.StudentDao;
import com.java.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @Value("${server.port}")
    private String port;


    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return studentDao.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        return studentDao.findById(id);
    }

    @RequestMapping("/save")
    public void save(@RequestBody Student student){
        studentDao.saveOrUpdate(student);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Student student){
        studentDao.saveOrUpdate(student);
    }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        studentDao.deleteById(id);
    }

    @RequestMapping("/index")
    public String index(){
        return "当前端口是："+this.port;
    }


}
