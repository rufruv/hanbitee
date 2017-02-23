package serviceImpl;

import dao.PatientDao;
import daoImpl.PatientDaoImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDao dao;
	private static PatientServiceImpl instance = new PatientServiceImpl();
	public static PatientServiceImpl getInstance() {return instance;}
	
	public PatientServiceImpl() {
		dao = PatientDaoImpl.getInstance();
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
	public PatientBean login(PatientBean patient) throws Exception {
		/*
		if(patient.getPatPass().equals(temp.getPatPass())){
			session = temp;     
			ck = true;
		}else{
			
		}*/
		return this.findById(patient.getPatID());
	}
	@Override
	public boolean logout() throws Exception {
		
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

	@Override
	public String getBirth(String patJumin) {
		String temp = "";
		return temp;
	}

	

}