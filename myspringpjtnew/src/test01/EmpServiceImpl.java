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
	public List<Emp> findEmpByYear(int year) throws Exception {
		return this.dao.findEmpByYear(year);
	}

	@Override
	public List<Emp> findEmpByDeptId(int deptId) throws Exception {
		return this.dao.findEmpByDeptId(deptId);
	}

	@Override
	public void printStat() throws Exception {
	}

	@Override
	public List<Emp> findEmpByManagerName() throws Exception {
		return this.dao.findEmpByManagerName();
	}

	@Override
	public List<Emp> findByCity(String city) throws Exception {
		return this.dao.findByCity(city);
	}

	@Override
	public List<Emp> findEmpByName() throws Exception {
		return this.dao.findEmpByName();
	}

	

	

	

}
