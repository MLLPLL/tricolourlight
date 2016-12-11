package com.myself.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Alex.Chen on 2016/12/8.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel
public class RestResponse {

    @ApiModelProperty(value = "请求返回的状态码", example = "1，2，3等")
    private String statusCode;

    @ApiModelProperty(value = "出错信息", example = "后台错误等")
    private String message;

    @ApiModelProperty(value = "返回的单个对象")
    private Object object;

    @ApiModelProperty(value = "返回的对象集合")
    private List<Object> objectList;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }
}
