package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HelloMyBatis {
	public static void main(String[] args) throws Exception {
		String resource = "configuration.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EmpDAOMybatis dao = new EmpDAOMybatis();
		
		Emp vo = session.selectOne("getEmpById", 110);
		
		System.out.println(vo);
		
		// JobId로 불러오기
		List<Emp> vo2 = session.selectList("getEmpListByJobId", "SA_REP");
		for(Emp o: vo2) {
			System.out.println(o);
		}
	}
}
