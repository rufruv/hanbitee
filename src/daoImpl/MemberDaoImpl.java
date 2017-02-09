package daoImpl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import constants.Database;
import dao.MemberDao;
import domain.MemberBean;

public class MemberDaoImpl implements MemberDao{
	private Connection connection;
	private Statement stmt;
	private ResultSet set;
	public MemberDaoImpl() {
		try {
			Class.forName(Database.ORACLE_DRIVER);
			connection = DriverManager.getConnection(Database.ORACLE_URL, 
													 Database.USERNAME, 
													 Database.PASSWORD);	
			stmt = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
	}
	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		String sql = "SELECT * FROM Member WHERE id=id";		
		try {
			set = stmt.executeQuery(sql);
			while(set.next()){
				member.setName(set.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public boolean login(MemberBean member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

}
