# Spring

이클립스 - help - Eclipse Marketplace - Spring Tools 설치

# mybatis

이클립스 - help - Eclipse Marketplace - MyBatipse 설치

# Servers

**Apache Tomcate v10.1** <- 거의 이거 쓸듯 버전 충돌때문에  
Apache Tomcate v9

# **spring** 진행

New - Maven Project - Next - Filter: com.huongdan.java springmvc

Propertiles탭 - Project Facet - Dynamic Web Module Version 5.0

# **java Project** 진행

configure - convert to maven

프로젝트 오른쪽마우스 - new - other - MyBatis XML Mapper

configuration.xml  
인식 실패시 properties - java build path - missing remove다 해주고 - add folder로 folder: sources 만들어주고 여기에 configuration.xml, mapper-emp.xml 넣어주기

Default output folder for source - folders mybatisproject/target/classes

# **spring**

maven 사이트가서 - 관련 프레임워크 및 jar파일 , mavan dependency 클릭해서 복사  
pom.xml에 가서, dependencies가서 넣기

## pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>lx.edu</groupId>
	<artifactId>myspringpjt</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<version>8.2.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.5.19</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>6.2.10</version>
		</dependency>
	</dependencies>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<resources>
			<resource>
				<directory>src</directory>
				<excludes>
					<exclude>**/*.java</exclude>
				</excludes>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<release>17</release>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```

Java Build Path - Add folder resources라는 이름으로 만들기

**xml방식**

## resources/spring-context.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

  xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">

  <!-- Root Context: defines shared resources visible to all other web components -->
	<bean id="service" class="myjdbc.EmpServiceImpl">
		<property name="dAO" ref="empDAO"></property>
	</bean>
	<bean id="empDAO" class="myjdbc.EmpDAO"></bean>
</beans>
```

## java main 메서드 부분 EmpMainSpring.java

```java
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


```

## 스프링 컨테이너

```java
new ClassPathXmlApplicationContext("spring-context.xml"); <- 이거 스프링 컨테이너
```

## 스프링 bean 객체

```xml
<bean id="service" class="myjdbc.EmpServiceImpl">
	<property name="dAO" ref="empDAO"></property>
</bean>
```

## Annotation 방식

```java
package basic;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotaionTest {
	public static void main(String[] args) {
		// Annotaion 뭘까?
		// 변수는 아니다. 함수, 클래스, 패키지도 아니다.
		// 주로 어노테이션은 마킹용도로 사용한다.
		MyClass myclass = new MyClass();
		Annotation[] annotationList = myclass.getClass().getAnnotations();
		for (Annotation annotation : annotationList) {
			System.out.println(annotation);
		}
	}
}

//Annotation 정의하기
@Retention(RetentionPolicy.RUNTIME)

@interface MyAnnotation {

}

//MyClass라는 클래스는 @MyAnnotation으로 마킹한 것, 도장 찍은 것
@MyAnnotation
class MyClass {

}
```

## Mybatis와 Spring Maven

**spring-context와 spring-jdbc 버전이 같아야해!!**  
pom.xml

```xml
<dependencies>
		<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<version>8.2.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.5.19</version>
		</dependency>
		<!--
		https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>6.2.10</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>6.2.10</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-dbcp2</artifactId>
			<version>2.13.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>3.0.5</version>
		</dependency>

	</dependencies>
```
