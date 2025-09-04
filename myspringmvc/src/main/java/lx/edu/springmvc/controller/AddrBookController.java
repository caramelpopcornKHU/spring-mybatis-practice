package lx.edu.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.edu.springmvc.dao.AddrBookDAO;
import lx.edu.springmvc.vo.AddrBookVO;

@Controller
public class AddrBookController {

	// 이러면 생성된 빈들의 목록을 다 얻을 수 있다.
	@Autowired
	ApplicationContext context;
	
	@Autowired
	AddrBookDAO dao;

	@RequestMapping(value = "/addrbook_form.do")
	public String form() {
		return "addrbook_form"; // jsp file name
	}

	@RequestMapping(value = "/update.do")
	public String update(AddrBookVO vo) throws Exception {
		dao.updateDB(vo);
		return "redirect:addrbook_list.do";
	}

	@RequestMapping(value = "/edit.do")
	public ModelAndView edit(AddrBookVO vo) throws Exception {
		ModelAndView result = new ModelAndView();
		AddrBookVO ab = dao.getDB(vo.getAbId());
		result.addObject("ab", ab);
		result.setViewName("addrbook_edit_form");
		return result;
	}

	@RequestMapping(value = "/insert.do")
	public String insert(AddrBookVO vo, String abBirth) throws Exception {
		dao.insertDB(vo);
		return "redirect:addrbook_list.do";
	}

	/*
	 * @RequestMapping("/addrbook_list.do") public String list(HttpServletRequest
	 * req) throws Exception { List<AddrBookVO> list = dao.getDBList(); // list를
	 * request에 넣는다. req.setAttribute("data", list); return "addrbook_list"; }
	 */

	@RequestMapping("/addrbook_list.do")
	public String list(HttpSession session, HttpServletRequest req) throws Exception {
		if(session.getAttribute("userId")==null) {
			return "login";
		}
		
		List<AddrBookVO> list = dao.getDBList();
		return "addrbook_list";

		// req.setAttribute("data", list);
		// 이렇게 안하고 모델 앤 뷰에 담아서 보내기
		//ModelAndView result = new ModelAndView();
		//result.addObject("data", list);
		//result.setViewName("addrbook_list");
		//return result;
	}

}
