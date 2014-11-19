package br.edu.unisep.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class TweetVO {

	@Id
	@Column(name = "tweet_id")
	private Long tweetId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "screen_name")
	private String screenName;
	
	@Column(name = "text_tweet")
	private String text;

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

// CREATE DATABASE twitter_on_java;
//
// \c twitter_on_java;
//
// CREATE TABLE tweets(
// tweet_id BIGINT DEFAULT 0 NOT NULL PRIMARY KEY,
// screen_name VARCHAR(20) DEFAULT 'Person Name!' NOT NULL,
// user_id BIGINT DEFAULT 0 NOT NULL,
// text_tweet VARCHAR(140) DEFAULT 'Tweeet Teeextt!' NOT NULL
// );