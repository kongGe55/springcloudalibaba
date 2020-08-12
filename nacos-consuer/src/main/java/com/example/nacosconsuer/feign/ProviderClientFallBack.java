package com.example.nacosconsuer.feign;

import org.springframework.stereotype.Component;

/**
 * @Auther: jiliugang
 * @Date: 2020/8/11 14:00
 * @Description:
 */
@Component
public class ProviderClientFallBack implements ProviderClient{
    @Override
    public String hi(String name) {
        return "fall back";
    }
}
