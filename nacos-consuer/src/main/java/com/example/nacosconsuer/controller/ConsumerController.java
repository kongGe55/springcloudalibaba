package com.example.nacosconsuer.controller;

import com.example.nacosconsuer.feign.ProviderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger= LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    ProviderClient providerClient;
    @GetMapping("/hi-feign")
    public String hiFeign(){
        logger.info("11111111111111111");
        return providerClient.hi("feign");
    }
    @GetMapping("/test")
    public String test(){
        return "gateway";
    }
}
