package br.edu.unisep.model.dao;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import br.edu.unisep.hibernate.DAOGenerico;
import br.edu.unisep.model.vo.TweetVO;

public class TweetDAO {

	// Will be responsible to retrieve all of the data from Twitter!
	public List<Status> getTweets(String q) throws Exception {
		Twitter twitter = new TwitterFactory().getInstance();
		try {
			Query query = new Query(q);
			query.setCount(20);

			QueryResult result;
			result = twitter.search(query);
			return result.getTweets();
		} catch (TwitterException te) {
			te.printStackTrace();
			throw new Exception(te.getMessage());
		}
	}

	public void persistTweets(String q) throws Exception {
		try {

			List<Status> tweets = getTweets(q);
			DAOGenerico<TweetVO> dao = new DAOGenerico<TweetVO>();
			
			TweetVO vo = null;
			for (Status tweet : tweets) {
				vo = new TweetVO();
				vo.setScreenName(tweet.getUser().getScreenName());
				vo.setText(tweet.getText());
				vo.setTweetId(tweet.getId());
				vo.setUserId(tweet.getUser().getId());
				vo.setImage(tweet.getUser().getProfileImageURL());
				
				dao.salvar(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}