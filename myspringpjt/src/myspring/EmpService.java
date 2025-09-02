package myspring;

import java.util.List;

public interface EmpService {

	void setDAO(EmpDAO dao);
	// EmpDAO에서 메서드를 선언한 것
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception;
	
	public List<Emp> getEmpListByJobId(String jobId) throws Exception;
}
