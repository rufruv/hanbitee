package service;

import domain.DoctorBean;

public interface DoctorService {
	public int join(DoctorBean bean) throws Exception;
	public DoctorBean findbyId(String id) throws Exception;
	public DoctorBean login(DoctorBean bean) throws Exception;
	public boolean logout() throws Exception;
	public int change(DoctorBean bean) throws Exception;
	public int remove(DoctorBean bean) throws Exception;
}
