package com.java.feign;

import com.java.entity.Student;
import com.java.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient(value = "provider",fallback = FeignError.class)
public interface FeignProviderClient {

    @RequestMapping("/findAll")
    public Collection<Student> findAll();

    @RequestMapping("/index")
    public String index();

}
