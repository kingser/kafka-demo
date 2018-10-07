package com.yc.kafkademo.model;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *
 * @author YC
 * @create 2018-10-07 15:26
 */
@Data
public class Message {
    private Long id;    //id

    private String msg; //消息

    private Date sendTime;  //时间戳
}
