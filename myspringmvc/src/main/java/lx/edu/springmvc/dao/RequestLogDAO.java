package lx.edu.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
