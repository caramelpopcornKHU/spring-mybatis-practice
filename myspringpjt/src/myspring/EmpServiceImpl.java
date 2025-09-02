package myspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// EmpServiceImpl이 EmpDAO를 의존하고 있구나.
@Service("empService") // <- 이게 없으면 Spring bean으로 X -> 힙에 빈이 없어서 주소값도 스택에 객체명에 못 넘겨 @Component
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO dao; // <- 스택에 dao라는 이름 - 주소값: (자바 스프링이 auto하게 빈 객체와 wire해줄거야)

	@Override
	public void setDAO(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return this.dao.getEmpListByDeptNo(deptNo);
	}

	@Override
	public List<Emp> getEmpListByJobId(String jobId) throws Exception {
		return this.dao.getEmpListByJobId(jobId);
	}

}
