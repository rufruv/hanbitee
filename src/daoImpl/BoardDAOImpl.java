package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import constants.Database;
import dao.BoardDAO;
import domain.ArticleBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class BoardDAOImpl implements BoardDAO{
	public static BoardDAOImpl instance = new BoardDAOImpl(); 
	public static BoardDAOImpl getInstance() {return instance;}

	@Override
	public int insert(ArticleBean param) throws Exception {
		String sql = String.format("INSERT INTO Article(art_seq, id, title, contents, regdate, read_count) "
								 + "VALUES(art_seq.nextval, '%s', '%s', '%s', '%s', '%s')", 
									param.getId(),param.getTitle(),param.getContents(),param.getRegdate(),param.getReadCount());
		int rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
								.getConnection()
								.createStatement()
								.executeUpdate(sql);
		return rs;
	}

	@Override
	public ArticleBean selectBySeq(ArticleBean param) throws Exception {
		ArticleBean article = new ArticleBean();
		String sql = String.format("SELECT art_seq, id, title, contents, regdate, read_count FROM Article WHERE art_seq=%d", param.getSeq());
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		if(rs.next()){
			article.setSeq(rs.getString("seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContents(rs.getString("contents"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("readCount"));
		}
		return article;
	}

	@Override
	public List<ArticleBean> selectByWord(ArticleBean param) throws Exception {
		List<ArticleBean> listSome = new ArrayList<ArticleBean>();
		ArticleBean article = new ArticleBean();				
		String sql = String.format("SELECT art_seq, id, title, contents, regdate, read_count FROM Article"
								 + "WHERE id='%s' or "
								 + "title='%s' or "
								 + "regdate='%s' or "
								 + "read_count='%s'", 
									param.getId(), param.getTitle(), param.getRegdate(), param.getReadCount());
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		while(rs.next()){
			article.setSeq(rs.getString("seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContents(rs.getString("contents"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("readCount"));
			listSome.add(article);
		}
		return listSome;
	}

	@Override
	public List<ArticleBean> selectAll() throws Exception {
		List<ArticleBean> listAll = new ArrayList<ArticleBean>();
		ArticleBean article = new ArticleBean();
		String sql = String.format("SELECT art_seq, id, title, contents, regdate, read_count FROM Article");
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		while(rs.next()){
			article.setSeq(rs.getString("seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContents(rs.getString("contents"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("readCount"));
			listAll.add(article);
		}
		
		return listAll;
	}

	@Override
	public int update(ArticleBean param) throws Exception {
		String sql = String.format("UPDATE ArticleBean SET (id='%s', "
														 + "title='%s', "
														 + "contents='%s', "
														 + "regdate='%s', "
														 + "read_count='%s' "
														 + "WHERE art_seq = %d)", 
														   param.getId(),param.getTitle(),param.getContents(),param.getRegdate(),param.getReadCount(),param.getSeq());
		int rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
								.getConnection()
								.createStatement()
								.executeUpdate(sql);
		return rs;
	}

	@Override
	public int delete(ArticleBean param) throws Exception {
		String sql = String.format("DELETE FROM Article WHERE art_seq='%d'", param.getSeq());
		int rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
							    .getConnection()
							    .createStatement()
							    .executeUpdate(sql);
		return rs;
	}

}
