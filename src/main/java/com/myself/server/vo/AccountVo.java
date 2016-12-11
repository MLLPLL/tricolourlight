package com.myself.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Alex.Chen on 2016/12/8.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel
public class AccountVo {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "数据库ID,新增请求时不需要传递这个参数")
    private Integer id;

    @ApiModelProperty(value = "token,post,get请求时不需要传递这个参数")
    private String token;

    @ApiModelProperty(value = "密码")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
