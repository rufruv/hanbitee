package serviceImpl;

import java.util.*;
import dao.BoardDAO;
import daoImpl.BoardDAOImpl;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private BoardDAO dao;
	private static BoardServiceImpl instance = new BoardServiceImpl();
	public static BoardServiceImpl getInstance() {return instance;}

	public BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	@Override
	public int add(ArticleBean param) throws Exception{
		int rs = dao.insert(param);
		return rs;
	}

	@Override
	public ArticleBean findOne(ArticleBean param) throws Exception{
		ArticleBean article = dao.selectBySeq(param);
		return article;
	}

	@Override
	public List<ArticleBean> findSome(ArticleBean param) throws Exception{
		List<ArticleBean> listSome = dao.selectByWord(param);
		return listSome;
	}

	@Override
	public List<ArticleBean> list() throws Exception{
		List<ArticleBean> listAll = dao.selectAll();
		return listAll;
	}

	@Override
	public int update(ArticleBean param) throws Exception{
		int rs = dao.update(param);
		return rs;
	}

	@Override
	public int delete(ArticleBean param) throws Exception{
		int rs = dao.delete(param);
		return rs;
	}
}


