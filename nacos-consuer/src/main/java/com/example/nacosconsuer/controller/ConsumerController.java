package com.example.nacosconsuer.controller;

import com.example.nacosconsuer.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: jiliugang
 * @Date: 2020/7/23 17:21
 * @Description:
 */
@RestController
public class ConsumerController {
    @Autowired
    ProviderClient providerClient;
    @GetMapping("/hi-feign")
    public String hiFeign(){
        return providerClient.hi("feign");
    }
    @GetMapping("/test")
    public String test(){
        return "gateway";
    }
}
