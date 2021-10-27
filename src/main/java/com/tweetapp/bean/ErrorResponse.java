package com.tweetapp.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = -5998300576105749889L;

	private String errMessage;
	private String errDetails;
	private int statusCode;
	private LocalDateTime timeStamp;
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public String getErrDetails() {
		return errDetails;
	}
	public void setErrDetails(String errDetails) {
		this.errDetails = errDetails;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
