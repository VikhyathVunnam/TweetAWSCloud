package com.tweetapp.bean.tweet;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "reply")
@Data
public class ReplyTweet {

	private String message;
	private ObjectId tweetId;
	private String userId;
	private LocalDateTime timeStamp = LocalDateTime.now();
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ObjectId getTweetId() {
		return tweetId;
	}
	public void setTweetId(ObjectId tweetId) {
		this.tweetId = tweetId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
