package com.gjw.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgTemplate implements Serializable {

    private int id;
    private String keyID;
    private String keySecret;
    private String signName;
    private String templateCode;

}
