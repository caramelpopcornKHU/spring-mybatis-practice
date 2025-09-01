package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMainMybatis {
	public static void main(String[] args) throws Exception {
		Emp emp = EmpDAOMybatis.getEmpById(145);
		System.out.println(emp);
		
		List<Emp> empList = EmpDAOMybatis.getEmpListByJobId("IT_PROG");
		
		for (Emp vo : empList) {
			System.out.println(vo);
		}
		

	}
}
