package service;

import domain.ArticleBean;
import java.util.*;

public interface BoardService {
	public int add(ArticleBean param) throws Exception;
	public ArticleBean findOne(ArticleBean param) throws Exception;
	public List<ArticleBean> findSome(ArticleBean param) throws Exception;
	public List<ArticleBean> list() throws Exception;
	public int update(ArticleBean param) throws Exception;
	public int delete(ArticleBean param) throws Exception;	
}
