package com.gjw.service.impl;

import com.gjw.bean.MsgTemplate;
import com.gjw.mapper.MsgTemplateMapper;
import com.gjw.service.MsgTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgTemplateImpl implements MsgTemplateService {

    @Autowired
    private MsgTemplateMapper msgTemplateMapper;

    @Override
    public MsgTemplate queryAllTempByCode(String templateCode) {
        return msgTemplateMapper.queryAllTempByCode(templateCode);
    }

}
