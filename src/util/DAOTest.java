package util;

import dao.MemberDao;
import daoImpl.MemberDaoImpl;
import domain.MemberBean;

public class DAOTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		MemberBean member = dao.selectById("hong");
		System.out.println("회원이름 :" + member.getName());
		
	}
}
