package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		String jobId = "IT_PROG";

		// 스프링 컨테이너 - xml로 되어있는걸 사용하겟다
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		// 스프링 컨테이너 - annotation 되어있는걸 사용하겟다
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		
		// 스프링 컨테이너가 스프링 객체를 가지고 있다가 이렇게 이름을 출력
		String[] nameList = context.getBeanDefinitionNames();
		for (String name : nameList) {
			System.out.print("bean객체 :");
			System.out.println("<bean id=\"" + name + "\">");
		}

		// EmpService service = (EmpService) context.getBean("empService");
		EmpService service = (EmpService) context.getBean(EmpService.class); // EmpService 타입의 빈 객체 그냥 쓸래
		
		
//		System.out.println(" dept 번호로 불러오기 ");
//		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
//		for (Emp emp : empList) {
//			System.out.println(emp);
//		}
//
//		System.out.println(" job id로 불러오기 ");
//		List<Emp> empList2 = service.getEmpListByJobId(jobId);
//		for (Emp emp : empList2) {
//			System.out.println(emp);
//		}
		
		String firstName = "Steven";
		String lastName = null;
		List<Emp> empList = service.getEmpByFirstNLastName(firstName,lastName);
		
		for(Emp emp : empList) {
			System.out.println(emp);
		}
		
		
	}
}
