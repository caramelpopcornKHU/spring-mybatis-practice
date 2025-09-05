package lx.edu.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lx.edu.springmvc.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lx.edu.springmvc")
public class WebMvcConfig implements WebMvcConfigurer {

	// servlet-context.xml 이 밑에처럼 맵핑된다.
	// Annotation 방식
	
	/*
	 * <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * 	<beans:property name="prefix" value="/WEB-INF/views/" /> 
	 * 	<beans:property name="suffix" value=".jsp" /> 
	 * </beans:bean>
	 */
	@Bean
	public InternalResourceViewResolver jspResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/*
	 * 
  <!-- 로그인 기능을 위하여 인터셉트함 컨트롤러 가기전에 잡아 놓음 -->
  <interceptors>
  	<interceptor>
  		<mapping path="/addrbook_list.do"/>
  		<mapping path="/insert.do"/>
  		<beans:bean class="lx.edu.springmvc.interceptor.LoginInterceptor"></beans:bean>
  	</interceptor>
  </interceptors>
  
	 */
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor())
		.addPathPatterns("/addrbook_list.do", "/insert.do");
		
		
	}
	
	/*
	 * <resources mapping="/resources/**" location="/resources/" />
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	
	}
	
	
	
	
	
	     
}
