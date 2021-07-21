package com.gjw.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.gjw.service.SendMsgService;
import com.gjw.utils.SendMsgUtil;
import org.springframework.stereotype.Service;

@Service
public class SendMsgServiceImpl implements SendMsgService {
    @Override
    public String sendPhoneMsg(String phone, String templateCode, String code) {

        Client client = SendMsgUtil.createClient("LTAI5tLLpwV6Z2pK6LFLrQrt", "WbGyP7fdtiI0kbkfSkxKM4AOlVVKqd");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("18759805700")
                .setSignName("我爱学习")
                .setTemplateCode(templateCode)
                .setTemplateParam("{'code':'" + code + "'}");
        try {
            return client.sendSms(sendSmsRequest).getBody().getCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "noOK";
    }
}
