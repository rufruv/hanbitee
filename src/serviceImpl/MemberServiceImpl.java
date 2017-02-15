package serviceImpl;

import dao.MemberDao;
import daoImpl.MemberDaoImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao;
	private MemberBean session;
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {return instance;}
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
		session = new MemberBean();
	}

	@Override
	public int join(MemberBean member) throws Exception {
		return dao.insert(member);
	}

	@Override
	public MemberBean findById(String id) throws Exception {
		return dao.selectById(id);
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		boolean ck = false;
		MemberBean temp = this.findById(member.getId());
		if(member.getPassword().equals(temp.getPassword())){
			session = temp;     
			ck = true;
		}else{
			
		}
		return ck;
	}
	@Override
	public boolean logout() throws Exception {
		session = null;
		return true;
	}
	@Override
	public int change(MemberBean member) throws Exception{
		return dao.update(member);
	}

	@Override
	public int remove(MemberBean member) throws Exception{
		return dao.delete(member);
	}

	

}