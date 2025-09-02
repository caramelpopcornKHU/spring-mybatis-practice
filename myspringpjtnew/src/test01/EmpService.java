package test01;

import java.util.ArrayList;

public interface EmpService {
	void setDAO(EmpDAO dao);
	
	public ArrayList<Emp> findEmpByYear(int year) throws Exception;
	public ArrayList<Emp> findEmpByDeptId(int deptId) throws Exception;
	public void printStat() throws Exception;
	public void findEmpByManagerName(String managerFirstName, String managerLastName, String managerFullName) throws Exception;
	public ArrayList<Emp> findByCity(String city) throws Exception;
	public ArrayList<Emp> findEmpByName(String firstName,String lastName,String fullName) throws Exception;
}
