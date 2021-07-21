package com.gjw.controller;

import com.gjw.service.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class PhoneMsgApiController {

    @Autowired
    @Qualifier("sendMsgServiceImpl")
    private SendMsgService sendMsgService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/sendPhoneMsg/{phone}")
    public String sendPhoneMsg(@PathVariable("phone") String phone) {

        String code = redisTemplate.opsForValue().get(phone);
        if (code != null) return phone + ":" + code + "已存在，验证码未过期";

        code = UUID.randomUUID().toString().substring(0, 4);
        String isSend = sendMsgService.sendPhoneMsg(phone, "SMS_219749033", code);
        if (isSend.equals("OK")) {
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return phone + ":" + code + "发送成功";
        } else {
            return phone + ":" + code + "发送失败";
        }

    }


}
