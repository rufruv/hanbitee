package serviceImpl;

import dao.PatientDao;
import daoImpl.PatientDaoImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDao dao;
	private PatientBean session;
	private static PatientServiceImpl instance = new PatientServiceImpl();
	public PatientBean getSession(){return session;}
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
	public PatientBean login(PatientBean patient) throws Exception {
		/*
		if(patient.getPatPass().equals(temp.getPatPass())){
			session = temp;     
			ck = true;
		}else{
			
		}*/
		session = this.findById(patient.getPatID());
		return session;
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
		
		int year = Integer.parseInt(session.getPatJumin().substring(0,2));
		int month = Integer.parseInt(session.getPatJumin().substring(2,4));
		int day = Integer.parseInt(session.getPatJumin().substring(4,6));
		String temp = String.format("19%d년 %d월 %d일", year,month,day);
		return temp;
	}
	@Override
	public String getAge(String patJumin) {
		return String.valueOf(117-Integer.parseInt(session.getPatJumin().substring(0,2))+1)+"세";
	}

	

}