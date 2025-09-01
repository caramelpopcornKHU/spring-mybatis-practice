package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		
		// 스프링 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

		// 스프링 컨테이너가 스프링 객체를 가지고 있다가 이렇게 이름을 출력
		String[] nameList = context.getBeanDefinitionNames();
		for (String name : nameList) {
			System.out.print("bean객체 :");
			System.out.println("<bean id=\"" + name + "\">");
		}

		EmpService service = (EmpService) context.getBean("empService");
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);

		for (Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
