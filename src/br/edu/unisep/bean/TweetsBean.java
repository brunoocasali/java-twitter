package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.unisep.model.dao.TweetDAO;
import br.edu.unisep.model.vo.TweetVO;

@ManagedBean
public class TweetsBean {

	private List<TweetVO> tweets;
	private String query;

	@PostConstruct
	public void list() {
		// Return only the data that lives in database
		TweetDAO dao = new TweetDAO();
		tweets = dao.list(TweetVO.class);
	}

	public String search() {
		try {
			// Persist all of the new tweets.
			TweetDAO dao = new TweetDAO();
			dao.persistTweets(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index?faces-redirect=true";
	}

	// Acessor methods
	public List<TweetVO> getTweets() {
		return tweets;
	}

	public void setTweets(List<TweetVO> tweets) {
		this.tweets = tweets;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}