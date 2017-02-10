package daoImpl;

import java.sql.Statement;
import java.sql.ResultSet;
import constants.Database;
import dao.MemberDao;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class MemberDaoImpl implements MemberDao{
	/*private static MemberDaoImpl Instance = new MemberDaoImpl();*/
	public static MemberDaoImpl getInstance() {return new MemberDaoImpl();} // Singlecton Pattern
	@Override
	public void insert(MemberBean member) throws Exception {
		String sql = String.format("INSERT INTO Member(id, name, ssn, password, profileImg, phone, email, rank) "
										+ "VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
										   member.getId(),member.getName(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail(),member.getRank());
		Statement stmt = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement();
		stmt.executeUpdate(sql);
		
	}

	@Override
	public MemberBean selectById(String id) throws Exception{
		MemberBean member = new MemberBean();
		ResultSet set = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
					   .getConnection()
				       .createStatement()
				       .executeQuery(String.format("SELECT * FROM member WHERE id ='%s'", id));
		if(set.next()){
				member.setId(set.getString("id"));
				member.setName(set.getString("name"));
				member.setSsn(set.getString("ssn"));
				member.setPassword(set.getString("password"));
				member.setProfileImg(set.getString("profileImg"));
				member.setPhone(set.getString("phone"));
				member.setEmail(set.getString("email"));
				member.setRank(set.getString("rank"));
			}
		
		return member;
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		boolean check = false;
		String sql = String.format("SELECT password FROM member WHERE id ='%s' and password = '%s'", 
									member.getId(), member.getPassword());
		Statement stmt = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement();
		ResultSet set = stmt.executeQuery(sql);
		if(member.getPassword().equals(set.getString("password"))){
			check = true;
		}
		return check;
	}

	@Override
	public void update(MemberBean member) throws Exception{
		Statement stmt = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement();
		
		
	}

	@Override
	public void delete(MemberBean member) throws Exception{
		String sql = String.format("", "");
		
			Statement stmt = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement();
			stmt.executeUpdate(sql);
		
	}

}
