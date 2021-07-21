package com.gjw.mapper;

import com.gjw.bean.MsgTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MsgTemplateMapper {

    MsgTemplate queryAllTempByCode(String templateCode);

}
