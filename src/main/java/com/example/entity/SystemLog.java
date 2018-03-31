package com.example.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by Zhangkh on 2017/12/1.
 */
@Data
public class SystemLog {
    private String id;

    private String description;

    private String method;

    private Long logType;

    private String requestIp;

    private String exceptioncode;

    private String exceptionDetail;

    private String params;

    private String createBy;

    private Date createDate;
}