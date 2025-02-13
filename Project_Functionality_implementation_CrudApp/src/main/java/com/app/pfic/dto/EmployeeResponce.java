package com.app.pfic.dto;

import java.util.Date;




public class EmployeeResponce {

	
	private String msg;
	private Date timestamp;
	public EmployeeResponce(String message, Date date) {
		// TODO Auto-generated constructor stub
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
