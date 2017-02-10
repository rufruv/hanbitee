package util;

import dao.MemberDao;
import daoImpl.MemberDaoImpl;
import domain.MemberBean;

public class DAOTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		MemberBean member = new MemberBean();
		try {
			member = MemberDaoImpl.getInstance().selectById("hong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("회원이름 :" + member.getName());		
	}
}
