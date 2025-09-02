package myspring;

import java.util.List;

public interface EmpService {

	// EmpDAO에서 메서드를 선언한 것
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;
	
	public List<Emp> getEmpListByJobId(String jobId) throws Exception;

	public List<Emp> getEmpByFirstNLastName(String firstName, String lastName) throws Exception;
}
