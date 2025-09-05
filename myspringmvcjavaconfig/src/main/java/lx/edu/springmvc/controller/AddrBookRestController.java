package lx.edu.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.edu.springmvc.dao.AddrBookDAO;
import lx.edu.springmvc.vo.AddrBookVO;

@RestController // 그냥 Controller 아니얌
public class AddrBookRestController {
	
	@Autowired
	AddrBookDAO dao; // DI
	
	// id를 전달받아서 해당 방명록을 JSON으로 리턴
	@RequestMapping(value = "/addrbooks/{id}")
	public AddrBookVO getAddrBook( @PathVariable("id") int id ) throws Exception	{
		
		// id로 dao 메서드 호출 - 방명록 정보를 조회한다.
		AddrBookVO vo = dao.getDB(id);
		return vo;
	}
	
}
