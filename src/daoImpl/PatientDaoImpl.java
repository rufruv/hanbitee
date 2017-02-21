package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import constants.Database;
import dao.PatientDao;
import domain.PatientBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class PatientDaoImpl implements PatientDao {
	/*private static MemberDaoImpl instance = new MemberDaoImpl();*/
	public static PatientDaoImpl getInstance() {return new PatientDaoImpl();}

	@Override
	public int insert(PatientBean member) throws SQLException {
		/*String sql = String.format("INSERT INTO Member(id, name, ssn, password, profileImg, phone, email, rank) "
				                 + "VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
				                   member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail(),member.getRank());
		Statement stmt = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				                        .getConnection()
				                        .createStatement();
		int rowCount = stmt.executeUpdate(sql);*/
		return DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
                			  .getConnection()
                			  .createStatement()
                			  .executeUpdate("");
	}

	@Override
	public PatientBean selectById(String id) throws SQLException {
		PatientBean member = new PatientBean();
		ResultSet set = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				       .getConnection()
				       .createStatement()
				       .executeQuery("");
		if (set.next()) {
			/*member.setId(set.getString("id"));
			member.setName(set.getString("name"));
			member.setSsn(set.getString("ssn"));
			member.setPassword(set.getString("password"));
			member.setProfileImg(set.getString("profileImg"));
			member.setPhone(set.getString("phone"));
			member.setEmail(set.getString("email"));
			member.setRank(set.getString("rank"));*/
		}
		return member;
	}

	/*@Override
	public boolean login(PatientBean member) throws SQLException {
		boolean check = false;
		
		return check;
	}*/

	@Override
	public int update(PatientBean member) throws SQLException {
		return DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
							  .getConnection()
		                      .createStatement()
		                      .executeUpdate("");
	}
	@Override
	public int delete(PatientBean member) throws SQLException {
		return DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
							  .getConnection()
							  .createStatement()
							  .executeUpdate("");

	}

}