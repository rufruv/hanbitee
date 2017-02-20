package util;

import dao.PatientDao;
import daoImpl.PatientDaoImpl;
import domain.PatientBean;

public class DAOTest {
	public static void main(String[] args) {
		PatientDao dao = new PatientDaoImpl();
		PatientBean member = new PatientBean();
		try {
			member = PatientDaoImpl.getInstance().selectById("hong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("회원이름 :" + member.getName());		
	}
}
