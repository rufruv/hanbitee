package serviceImpl;

import dao.PatientDao;
import daoImpl.PatientDaoImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDao dao;
	private PatientBean session;
	private static PatientServiceImpl instance = new PatientServiceImpl();
	public static PatientServiceImpl getInstance() {return instance;}
	
	public PatientServiceImpl() {
		dao = PatientDaoImpl.getInstance();
		session = new PatientBean();
	}

	@Override
	public int join(PatientBean patient) throws Exception {
		return dao.insert(patient);
	}

	@Override
	public PatientBean findById(String id) throws Exception {
		return dao.selectById(id);
	}

	@Override
	public boolean login(PatientBean patient) throws Exception {
		boolean ck = false;
		PatientBean temp = this.findById(patient.getPatID());
		if(patient.getPatPass().equals(temp.getPatPass())){
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
	public int change(PatientBean patient) throws Exception{
		return dao.update(patient);
	}

	@Override
	public int remove(PatientBean patient) throws Exception{
		return dao.delete(patient);
	}

	

}