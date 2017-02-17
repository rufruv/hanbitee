package serviceImpl;

import java.util.*;
import dao.BoardDAO;
import daoImpl.BoardDAOImpl;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService{
	private static BoardServiceImpl instance = new BoardServiceImpl();
	public static BoardServiceImpl getInstance() {return instance;}
	
	BoardDAO dao;
	private BoardServiceImpl() {
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
	public List<ArticleBean> findSome(String[] param) throws Exception{
		List<ArticleBean> listSome = new ArrayList<>();
		System.out.println("서비스에 넘어간 파라미터1:"+param[0]);
		System.out.println("서비스에 넘어간 파라미터1:"+param[1]);
		listSome = dao.selectByWord(param);
		System.out.println("서비스에서 본 리스트결과:"+listSome);
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
	@Override
	public int count() throws Exception{
		return dao.count();
	}
}


