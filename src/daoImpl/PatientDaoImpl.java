package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import constants.Database;
import dao.PatientDao;
import domain.PatientBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class PatientDaoImpl implements PatientDao {
	/*private static MemberDaoImpl instance = new MemberDaoImpl();*/
	final String prop="pat_id,nur_id,doc_id,pat_pass,pat_name,pat_gen,pat_jumin,pat_addr,pat_phone,pat_email,pat_job";
	public static PatientDaoImpl getInstance() {return new PatientDaoImpl();}

	@Override
	public int insert(PatientBean member) throws SQLException {
		String sql = String.format("INSERT INTO Member(patID, nurID, docID, patPass, patName, patGen, patJumin, patAddr, patPhone, patEmail, patJob) "
				                 + "VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
				                   member.getPatID(),member.getNurID(),member.getDocID(),member.getPatPass(),member.getPatName(),member.getPatGen(),member.getPatJumin(),member.getPatAddr(),member.getPatPhone(),member.getPatEmail(),member.getPatJob());
		Statement stmt = DatabaseFactory.creatDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD)
				                        .getConnection()
				                        .createStatement();
		int rowCount = stmt.executeUpdate(sql);
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
				       .executeQuery("SELECT " +prop+ " FROM Patient WHERE pat_id='"+id+"'");
		if (set.next()) {
			
			member.setPatID(set.getString("pat_id"));
			member.setNurID(set.getString("nur_id"));
			member.setDocID(set.getString("doc_id"));
			member.setPatPass(set.getString("pat_pass"));
			member.setPatName(set.getString("pat_name"));
			member.setPatGen(set.getString("pat_gen"));
			member.setPatJumin(set.getString("pat_jumin"));
			member.setPatAddr(set.getString("pat_addr"));
			member.setPatPhone(set.getString("pat_phone"));
			member.setPatEmail(set.getString("pat_email"));
			member.setPatJob(set.getString("pat_job"));
		}else{
			member.setPatID("FAIL");
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