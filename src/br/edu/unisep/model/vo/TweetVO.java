package br.edu.unisep.model.vo;

// Import's try: CTRL + SHIF + O

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class TweetVO {

	// Attributes from business model.
	@Id
	@Column(name = "tweet_id")
	private Long tweetId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "screen_name")
	private String screenName;

	@Column(name = "text_tweet")
	private String text;

	@Column(name = "user_image")
	private String image;

	// Accessor methods. 
	// Try: CTRL + 3 > then write 'gga' > ENTER > Select All > OK

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}