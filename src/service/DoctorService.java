package service;

import domain.DoctorBean;

public interface DoctorService {
	public int join(DoctorBean doctor);
	public DoctorBean findbyId(String id);
}
