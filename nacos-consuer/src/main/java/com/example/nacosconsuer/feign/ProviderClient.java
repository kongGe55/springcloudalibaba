package com.example.nacosconsuer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: jiliugang
 * @Date: 2020/7/23 17:20
 * @Description:
 */
@FeignClient(value = "provider",fallback = ProviderClientFallBack.class)
public interface ProviderClient {
    @GetMapping("/hi")
    String hi(@RequestParam(value = "name",
            defaultValue = "forezp", required = false) String name);
}
