package lx.edu.springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddrBookDAO {
	
	@Autowired
	SqlSession session;
	
	
	public int insertDB(AddrBookVO ab) throws Exception {
		return session.insert("insertDB",ab);
	}

	public List<AddrBookVO> getDBList() throws Exception {
		List<AddrBookVO> result = new ArrayList<AddrBookVO>();
		result = session.selectList("getDBList");
		return result;
	}

	public AddrBookVO getDB(int abId) throws Exception {
		AddrBookVO vo = new AddrBookVO();
		Connection con = getConnection();
		String sql = "select * from addrbook where ab_id = ?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setInt(1, abId);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			vo.setAbName(rs.getString("ab_name"));
			vo.setAbTel(rs.getString("ab_tel"));
			vo.setAbEmail(rs.getString("ab_email"));
			vo.setAbComdept(rs.getString("ab_comdept"));
			vo.setAbMemo(rs.getString("ab_memo"));
			vo.setAbId(rs.getInt("ab_id"));
			vo.setAbBirth(rs.getString("ab_birth"));
		}
		con.close();
		return vo;
	}
	public boolean updateDB(AddrBookVO ab) throws Exception {
		return false;
	}
	public boolean deleteDB(int abId) throws Exception {
		return false;
	}
	
	private static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/mydb");
		Connection connection = dataSource.getConnection();
		return connection;
	}
}
