package lx.edu.springmvc.dao;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.vo.AddrBookVO;

@Component
public class AddrBookDAO {
	
	@Autowired
	SqlSession session;
	
	public int insertDB(AddrBookVO ab) throws Exception {
		return session.insert("insertDB",ab);
	}
	
	public int updateDB(AddrBookVO ab) throws Exception {
		System.out.println(ab + "dao");
		return session.update("updateDB",ab);
	}
	
	public AddrBookVO getDB(int abId) throws Exception {
		return session.selectOne("getDB", abId);
	}
	
	public List<AddrBookVO> getDBList() throws Exception {
		List<AddrBookVO> result = new ArrayList<AddrBookVO>();
		result = session.selectList("getDBList");
		return result;
	}
	public boolean deleteDB(int abId) throws Exception {
		return false;
	}
	
	
}
