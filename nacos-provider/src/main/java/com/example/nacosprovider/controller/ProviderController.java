package com.example.nacosprovider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.wap.models.AlipayTradeWapPayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: jiliugang
 * @Date: 2020/7/23 17:17
 * @Description:
 */
@RestController
@RefreshScope
public class ProviderController {
    Logger logger= LoggerFactory.getLogger(ProviderController.class);
    @Value("${username}")
    private String username;
    @GetMapping("/hi")
    @SentinelResource(value="hi")
    public String hi(@RequestParam(value = "name",
            defaultValue = "forezp",required = false)String name){
        return "hi "+name;
    }
    @RequestMapping("/username")
    public String get() {
        return username;
    }
    @RequestMapping("/test")
    public void test(HttpServletResponse response) throws IOException {
        // 2. 发起API调用（以创建当面付收款二维码为例）
        try {
            AlipayTradeWapPayResponse pay = Factory.Payment.Wap().pay(
                    "aasdads", "316516131354312", "5678.9", "asda", "asda");
            response.setContentType( "text/html;charset="  + "UTF-8");
            response.getWriter().write(pay.body);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
