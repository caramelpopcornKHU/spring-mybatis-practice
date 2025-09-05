package lx.edu.springmvc.aop;

import lx.edu.springmvc.dao.RequestLogDAO;
import lx.edu.springmvc.vo.RequestLogVO;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class RequestLogAdvice {
	
	@Autowired
	RequestLogDAO logDAO;

	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))")
	public void beforeLog(JoinPoint joinPoint) throws Exception {
		System.out.println("LogAdvice.beforeLog()");
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		//System.out.printf("class=%s, method=%s\n", targetClass.getName(),methodName);
		
		
		System.out.println(targetClass.getName());
		System.out.println(methodName);
		logDAO.insertRequestLogDB(targetClass.getName(), methodName);
		
		
	}
	
}
