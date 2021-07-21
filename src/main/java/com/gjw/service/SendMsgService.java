package com.gjw.service;

public interface SendMsgService {

    String sendPhoneMsg(String phone, String templateCode, String code);

}
