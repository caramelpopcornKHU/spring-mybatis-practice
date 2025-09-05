package lx.edu.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{

	// 인터셉터가 없으면, 컨트롤러에 로그인 체크 기능을 넣어야해
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		// login 체크 수행
		String userId = (String) request.getSession().getAttribute("userId");
		System.out.println("prehandle() userId=" + userId);
		
		if(userId != null && userId.length() > 0) {
			return true;
		}
		
		// 로그인 X 상황 로그인으로 넘어가라
		response.sendRedirect("login_form.do");
		return false;
	}
	
}
