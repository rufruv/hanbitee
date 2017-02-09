package dao;

import domain.MemberBean;

public interface MemberDao {
	public void insert(MemberBean member);
	public MemberBean selectById(String id);
	public boolean login(MemberBean member);
	public void update(MemberBean member);
	public void delete(MemberBean member);
}
