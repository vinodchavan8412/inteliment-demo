package com.inteliment.demo.util;

public class MyResponse {
	private int responseCode;
	private String responseMessage;
	private String comment;
	private Object result;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comments) {
		this.comment = comments;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "MyResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", comments="
				+ comment + ", result=" + result + "]";
	}

}
