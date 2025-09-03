package test01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// 스프링 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml");
		// 스프링 컨테이너가 스프링 객체를 가지고 있다가 이렇게 이름을 출력
		String[] nameList = context.getBeanDefinitionNames();
		for (String name : nameList) {
			System.out.print("bean객체 :");
			System.out.println("<bean id=\"" + name + "\">");
		}

		// EmpService타입의 자바 빈객체
		EmpService service = (EmpService) context.getBean(EmpService.class);

		int way = 10;
		while (way != 0) {
			System.out.println("<원하는 검색방법 번호를 입력하세요>(0 입력시 종료됩니다)");
			System.out.println("1.이름 2.입사년도 3. 부서번호 4. 도시이름 5.통계자료 6. 부서장이름을 통한 부서원검색");
			try {
				way = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("숫자로 다시 입력해주세요.");
				scan.nextLine();
				continue;
			}
			switch (way) {
			case 1:
				printEmpInstance(service.findEmpByName());
				break;
			case 2:
				System.out.print("연도: ");
				printEmpInstance(service.findEmpByYear(scan.nextInt()));
				break;
			case 3:
				System.out.print("번호: ");
				printEmpInstance(service.findEmpByDeptId(scan.nextInt()));
				break;
			case 4:
				System.out.println("city: ");
				printEmpInstance(service.findByCity(scan.next()));
				break;
			case 5:
				// EmpDAO.printStat();
				break;
			case 6:
				printEmpInstance(service.findEmpByManagerName());
				break;
			default:
				System.out.println("선택지에 없는 번호입니다.");
				break;
			}
		}
		System.out.println("-프로그램 종료-");
	}

	static void printEmpInstance(List<Emp> emp) {
		for (Emp e : emp) {
			System.out.println(e);
		}
	}

}
