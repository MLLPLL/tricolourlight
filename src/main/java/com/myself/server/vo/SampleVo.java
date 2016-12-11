package com.myself.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * The domain vo class
 * 
 * @author bright.zheng
 *
 */
@ApiModel
public class SampleVo implements Serializable {
    private static final long serialVersionUID = -1413731156973693202L;

    @XmlElement(name = "code")
    @ApiModelProperty(value = "请求状态码", required = true, example = "1，2，3等")
    private int code;

    @XmlElement(name = "msg")
    @ApiModelProperty(value = "请求错误信息", required = true, example = "请求失败。。。。")
    private String msg;

    @XmlElement(name = "object")
    @ApiModelProperty(value = "请求反回的对象", required = true, example = "请求反回的对象")
    private Object object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}