package lx.edu.springmvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.vo.RequestLogVO;

@Component
public class RequestLogDAO {
	
	@Autowired
	SqlSession session;
	
	public int insertRequestLogDB(String className, String methodName) throws Exception {
		/*
		Map<String,String> logMap = new HashMap<>();
		logMap.put(className, methodName);		
		 * */
		RequestLogVO vo  = new  RequestLogVO();
		vo.setReqClass(className);
		vo.setReqMethod(methodName);
		
		return session.insert("insertRequestLogDB",vo);
	}
	
	
	
}
