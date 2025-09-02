package test01;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("empService") 
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO dao; 

	@Override
	public void setDAO(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public ArrayList<Emp> findEmpByYear(int year) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Emp> findEmpByDeptId(int deptId) throws Exception {
		return null;
	}

	@Override
	public void printStat() throws Exception {
		
	}

	@Override
	public void findEmpByManagerName(@Param("managerFirstName") String managerFirstName, @Param("managerLastName") String managerLastName, @Param("managerFullName") String managerFullName) throws Exception {
		
	}

	@Override
	public ArrayList<Emp> findByCity(String city) throws Exception {
		return null;
	}

	@Override
	public ArrayList<Emp> findEmpByName(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("fullName") String fullName) throws Exception {
		return null;
	}

	

}
