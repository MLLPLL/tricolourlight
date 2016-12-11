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
public class PhoneNumber implements Serializable {
	
	private static final long serialVersionUID = -1413731156973693201L;
	
	@XmlElement(name = "nationcode")
	@ApiModelProperty(value = "国家码", required = true, example = "国家码,默认86")
	private String nationcode;
	
	@XmlElement(name = "phone")
	@ApiModelProperty(value = "手机号", required = true, example = "手机号")
	private String phone;
	
	public String getNationcode() {
		return nationcode;
	}
	public void setNationcode(String nationcode) {
		this.nationcode = nationcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
