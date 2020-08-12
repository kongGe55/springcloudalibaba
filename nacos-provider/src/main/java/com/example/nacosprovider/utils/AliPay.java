package com.example.nacosprovider.utils;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import org.springframework.stereotype.Component;

/**
 * @Auther: jiliugang
 * @Date: 2020/8/3 14:01
 * @Description:
 */
@Component
public class AliPay {
    public static void main(String[] args) throws Exception {
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePagePayResponse aasdads = Factory.Payment.Page().pay(
                    "aasdads", "3165161", "99.9", "www.baidu.com"
            );
            System.out.println(aasdads);
            // 3. 处理响应或异常
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    static {
        // 1. 设置参数（全局只需设置一次）

        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";
        config.appId = "2016100100639881";
            // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHIp3Ky/QWsW53upCAMk6E4W/G24V86LC1TdjNIGLKEP0Df/H1+tFMHxIyVrASAzNonSxt/0UCuEZjU0ez7zToeOCJ+syi5cxh14zbwPtuhFwd9v+KeA0itYYwkUA/argat5P83C/Y1e7AmcV9jbueDMT/83LB0XewELMFHZrc2rhkwm7w4o+rAbWQawDIW8C0UitjN7DmFc4nwkSrcOiMi6eiN4EV1lGC9/x72Vhprj+tguHqevf7UovKJJZDJg6hC2j720fgP+iIWRIVTewbputcN0CrmTHA9AweAmXJfJApPgcrVardnsNgpKNMKPkwvmfxCCIjNnZTCbP38HQLAgMBAAECggEAI6r9XxOqH3tBnxR9I3kjxGsEZ8Z1W1zHl3MusCXGLXOCdLQGl1hWefMRiHvdCUQTA5/IpFfmTSt6WKkYmeOfYWTWT1UFQlHJOmH8adxsAOWqsrYJCPFa9jhXbOZJwPNYGKUvyGQNtPvygp+TwunwBW11aeFF/uZc4vnlZopD39rtiTCw/X4VoH5IiKrGU/UNhBAYbjdt2ekxEfrt7f1SbhJ2E9ozF9+BR6CUSaQAV5pKdWvBP2k4i195n3ZljUj6VhsUjk0uCZjC9yKZbGlJE6I2pc8d3cmpLbCdTVlDjmNopYWWFr0UCVev9Gg2U94VLzeqOpJvlx7B3Y+pdo+44QKBgQDyADXa1d40x9UDeKrD3M2UgRN9s7QiZ6meuUMFxc8udvPROUhb8Y+0Qc71LLpIIWAe+qGKgweeDyxe6W/1Xa5YBX/02kD5zD85q6U8y5oco92JJKHQyNNRxBkyo0kUHMoefjIDxUGsv8HC2rFK6l9eHckRZJfxn36bAzLRpFXyIwKBgQCO89Vjj4+o9eHiYkp6rpdMAJtneP63WZYVKP/D11i65Hm7vJsZoG8Wn1iBm6jYpH7+k1q3WJ1aRNOrMQlTQ2+b3STxdjM1FdNyoU3bZl+FR5w9x9oNR2Lh3K8eD3MRVPtFdp+/I5yMzmUE1+CoU8BqIMS3J9J0gnC3WDkMUu9Q+QKBgE18M8I16EgOE+5gnIzKDikWix8cgvjhKDZiK0uV4piGDdtX9As8dT7KM3HdOGgQB67joQWwnqfFQ/e/1tFBhak5WZcUqulQtI3Kn8Wvi1DQRwa6a/Vl2AO+PjMwhR2jejP5RBpg9n5Rh8DUNSA/mvmPn+mpw9zhrLAFfigR7lLxAoGAfb4Pkp7h//4grlBFMTrHzMuv5slwTHkZ4g0JRQv0eZilV7TkPRt4+844PPFeCQpQxr95CVOCPbfS9H+Ss1HbJ5/Tci3Fh0lmkCtA399h4EuILHPR4uJLIV9MDkYKslEtIQHiLHA3sUePZj451/arhu7B+lWl8mQWn7+TlrqQ1YkCgYEAtLtje1H3YRGk/ZRwN4Rag+uuYOVR2Jb038xkGA2A8gZdYJYHJEXFo3dM0gXX1kw+9Tn4Ch4/5CsURrlypIc8oRgciSsh9oKrgNG4kKNEM1c+THKY7zILbM3OzbJ8weOxhWiZNgGGNfVIDOgh9GOB2JXp3K5pU0yjoBAzRajHM5o=";
//注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlvaRKBG3kMj46s+dM8kNfasoF53UwKw8tIptHsnqhaWzmUZ/oO0uvKK+2IAvgj9r7PrzVi9srcikmsAH9EWP43ovqgk18L2TYN2753j7t9qfAwaMMaiQn095MDN+VMznCdWg9ERu4ybD2ford9/l+ZDEwb9CK+tkkc7HuXhEb+UjWTFThkZGdiRVVlBz0gtqSTAKS2GNe/iQ2dT9aOGpmEj6hPn2NGlJ3b+9H3SP93/RsBxEif3k4ac+EtfuopvsI7f6Ly+OnGGmnN//gYU8rfpQgxoMSjP+wrtGtUffvxPCSWQrCT4lwPl1gFV+dqEqRNXSgXX/+RWlj01KeyNVxwIDAQAB";

        //可设置异步通知接收服务地址（可选）
//        config.notifyUrl = "<-- 请填写您的支付类接口异步通知接收服务地址，例如：https://www.test.com/callback -->";

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
//        config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";
        Factory.setOptions(config);
    }
}
