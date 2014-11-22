package br.edu.unisep.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import br.edu.unisep.hibernate.GenericDAO;
import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.TweetVO;

@SuppressWarnings("unchecked")
public class TweetDAO extends GenericDAO<TweetVO>{

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

	// This method transform objects from Status (object in API) to another but
	// in this time serializable in the database
	public void persistTweets(String q) throws Exception {
		try {

			List<Status> tweets = getTweets(q);
			GenericDAO<TweetVO> dao = new GenericDAO<TweetVO>();

			TweetVO vo = null;
			for (Status tweet : tweets) {
				vo = new TweetVO();
				vo.setScreenName(tweet.getUser().getScreenName());
				vo.setText(tweet.getText());
				vo.setTweetId(tweet.getId());
				vo.setCreatedAt(tweet.getCreatedAt());
				vo.setUserId(tweet.getUser().getId());
				vo.setImage(tweet.getUser().getProfileImageURL());

				dao.save(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<TweetVO> list() {
		
		Session session = HibernateSessionFactory.getSession();
		Criteria crit = session.createCriteria(TweetVO.class);

		crit.addOrder(Order.desc("created_at"));
		List<TweetVO> list = crit.list();
		
		session.close();
		
		return list;
	}
}