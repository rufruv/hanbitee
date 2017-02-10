package dao;

import domain.MemberBean;

public interface MemberDao {
	public void insert(MemberBean member) throws Exception;
	public MemberBean selectById(String id) throws Exception;
	public boolean login(MemberBean member) throws Exception;
	public void update(MemberBean member) throws Exception;
	public void delete(MemberBean member) throws Exception;
}
