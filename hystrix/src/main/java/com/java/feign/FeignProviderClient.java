package com.java.feign;

import com.java.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient(value = "provider")
public interface FeignProviderClient {

    @RequestMapping("/findAll")
    public Collection<Student> findAll();

    @RequestMapping("/index")
    public String index();

}
