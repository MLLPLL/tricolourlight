package com.myself.server.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel
public class SendSmsRequest implements Serializable {
	
	private static final long serialVersionUID = 1108667621036433585L;
	
	@XmlElement(name = "phoneNumber")
	@ApiModelProperty(value = "手机号", required = true, example = "手机号")
	private String phoneNumber;
	
	@XmlElement(name = "tel")
	@ApiModelProperty(value = "国家码+手机号", required = true, example = "国家码+手机号")
	private PhoneNumber tel;
	
	@XmlElement(name = "type")
	@ApiModelProperty(value = "0:普通短信;1:营销短信", required = true, example = "0:普通短信;1:营销短信")
	private String type;
	
	@XmlElement(name = "msg")
	@ApiModelProperty(value = "发送内容", required = true, example = "发送内容")
	private String msg;
	
	@XmlElement(name = "sig")
	@ApiModelProperty(value = "签名", required = true, example = "签名:为appkey + phone字段的 md5值")
	private String sig;
	
	@XmlElement(name = "extend")
	@ApiModelProperty(value = "可选字段，不需要就填空", required = false, example = "可选字段，不需要就填空")
	private String extend;
	
	@XmlElement(name = "ext")
	@ApiModelProperty(value = "可选字段，不需要就填空", required = false, example = "可选字段，不需要就填空")
	private String ext;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumber getTel() {
		return tel;
	}
	public void setTel(PhoneNumber tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
}
