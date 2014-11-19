package br.edu.unisep.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.edu.unisep.hibernate.DAOGenerico;
import br.edu.unisep.model.dao.TweetDAO;
import br.edu.unisep.model.vo.TweetVO;

@ManagedBean
public class TweetsBean {

	private List<TweetVO> tweets;
	private String query;

	@PostConstruct
	public void list() {
		// Retornar apenas os dados salvos na tabela
		DAOGenerico<TweetVO> dao = new DAOGenerico<TweetVO>();
		tweets = dao.listar(TweetVO.class);
	}
	
	public String search() {
		
		// Salvar os primeiros 20 resultados da busca do Twitter no banco
		TweetDAO tDao = new TweetDAO();
		try {
			tDao.persistTweets(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
	
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