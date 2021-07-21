package com.gjw.utils;

import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dysmsapi20170525.Client;

public class SendMsgUtil {

    public static Client createClient(String accessKeyId, String accessKeySecret) {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "dysmsapi.aliyuncs.com";
        Client client = null;
        try {
            client = new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }


}
