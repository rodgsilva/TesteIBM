package br.com.testeibm.controller.exception;

import java.io.Serializable;

public class StandardError  implements Serializable{
		private static final long serialVersionUID = 1L;
		
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}


	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}


	public StandardError(long currentTimeMillis, int value, String string, String message, String requestURI) {
		// TODO Auto-generated constructor stub
	}
	
	

}
