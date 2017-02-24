package dao;

import domain.DoctorBean;

public interface DoctorDAO {
	public int insert(DoctorBean bean) throws Exception;
	public DoctorBean selectById(String id) throws Exception;
	public int update(DoctorBean bean) throws Exception;
	public int delete(DoctorBean bean) throws Exception;
}
