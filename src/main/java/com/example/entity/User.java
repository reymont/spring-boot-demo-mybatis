package com.example.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Zhangkh on 2017/3/6.
 */
@Data
@XmlRootElement(name = "user")
public class User implements Serializable {
    @XmlElement
    private String dep;
    @XmlElement
    private String name;
    @XmlElement
    private String employeeNumber;
}
