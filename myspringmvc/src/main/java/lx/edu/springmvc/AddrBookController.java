package lx.edu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AddrBookController {
	
	@Autowired
	AddrBookDAO dao;
	
	@RequestMapping(value = "/addrbook_form.do")
	public String form() {
		return "addrbook_form"; // jsp file name
	}
	
	@RequestMapping("/addrbook_list.do")
	public String list(HttpServletRequest req) throws Exception {
		List<AddrBookVO> list = dao.getDBList();
		// list를 request에 넣는다.
		req.setAttribute("data", list);
		return "addrbook_list";
	}
	
	@RequestMapping("insert.do")
	public String insert(AddrBookVO vo) throws Exception {
		//1.
		System.out.println(vo);
		dao.insertDB(vo);
		//2.
		return "redirect:addrbook_list.do";
	}
	
	
}


