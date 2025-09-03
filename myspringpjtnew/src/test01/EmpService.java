package test01;

import java.util.List;

public interface EmpService {
	public List<Emp> findEmpByYear(int year) throws Exception;
	public List<Emp> findEmpByDeptId(int deptId) throws Exception;
	public void printStat() throws Exception;
	public List<Emp> findEmpByManagerName() throws Exception;
	public List<Emp> findByCity(String city) throws Exception;
	public List<Emp> findEmpByName() throws Exception;
}
