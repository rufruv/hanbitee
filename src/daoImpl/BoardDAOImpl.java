package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import constants.Database;
import dao.BoardDAO;
import domain.ArticleBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class BoardDAOImpl implements BoardDAO{
	public static BoardDAOImpl instance = new BoardDAOImpl(); 
	public static BoardDAOImpl getInstance() {return instance;}
	private BoardDAOImpl(){}
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
		ArticleBean article = null;  // null checking을 하기 위해서 
		
		String sql = String.format("SELECT art_seq, id, title, contents, regdate, read_count FROM Article WHERE art_seq='%s'", param.getSeq());
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		if(rs.next()){
			article = new ArticleBean();
			article.setSeq(rs.getString("art_seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContents(rs.getString("contents"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("read_count"));
		}
		return article;
	}

	@Override
	public List<ArticleBean> selectByWord(String[] param) throws Exception {
		List<ArticleBean> listSome = new ArrayList<ArticleBean>();
		ArticleBean article = null;				
		String sql = "SELECT art_seq, id, title, contents, regdate, read_count FROM Article "
				   + " WHERE "+param[0]+" LIKE '%"+param[1]+"%'";
		System.out.println("DAO에서 실행된 쿼리:"+sql);
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		while(rs.next()){
			article = new ArticleBean();
			article.setSeq(rs.getString("art_seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContents(rs.getString("contents"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("read_count"));
			listSome.add(article);
		}
		return listSome;
	}

	@Override
	public List<ArticleBean> selectAll() throws Exception {
		List<ArticleBean> listAll = new ArrayList<ArticleBean>();
		ArticleBean article = null;
		String sql = "SELECT art_seq, id, title, contents, regdate, read_count FROM Article ";
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		while(rs.next()){
			article = new ArticleBean();
			article.setSeq(rs.getString("art_seq"));
			article.setId(rs.getString("id"));
			article.setTitle(rs.getString("title"));
			article.setContents(rs.getString("contents"));
			article.setRegdate(rs.getString("regdate"));
			article.setReadCount(rs.getString("read_count"));
			listAll.add(article);
		}
		
		return listAll;
	}

	@Override
	public int update(ArticleBean param) throws Exception {
		String sql = String.format("UPDATE Article SET id='%s', "
													+ "title='%s', "
													+ "contents='%s', "
												    + "regdate='%s', "
												    + "read_count='%s' "
												    + "WHERE art_seq='%s'", 
													   param.getId(),param.getTitle(),param.getContents(),param.getRegdate(),param.getReadCount(),param.getSeq());
		int rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
								.getConnection()
								.createStatement()
								.executeUpdate(sql);
		return rs;
	}

	@Override
	public int delete(ArticleBean param) throws Exception {
		String sql = String.format("DELETE FROM Article WHERE art_seq='%s'", param.getSeq());
		int rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
							    .getConnection()
							    .createStatement()
							    .executeUpdate(sql);
		return rs;
	}
	@Override
	public int count() throws Exception {
		int count = 0;
		String sql = "SELECT COUNT(*) AS count FROM Article";
		ResultSet rs = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
									  .getConnection()
									  .createStatement()
									  .executeQuery(sql);
		if(rs.next()){
			count=Integer.parseInt(rs.getString("COUNT"));
		}
		return count;
	}

}
