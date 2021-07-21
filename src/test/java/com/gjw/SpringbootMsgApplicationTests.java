package com.gjw;


import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootMsgApplicationTests {

    @Test
    void contextLoads() {
    }

    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = createClient("", "");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("")
                .setSignName("我爱学习")
                .setTemplateCode("SMS_219749033")
                .setTemplateParam("{'code':'1123'}");
        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        SendSmsResponseBody body = sendSmsResponse.getBody();
        System.out.println(body.getCode()+","+body.getBizId()+","+body.getMessage()+","+body.getRequestId());

    }


}
