package com.together.web.posts;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.together.web.login.IUserDAO;
import com.together.web.login.UserDTO;

@Controller
public class PostsMainController {

	private static final Logger logger = LoggerFactory.getLogger(PostsMainController.class);

	@Autowired
	private SqlSession sqlSession;

	// 주소찾기 팝업창
	@RequestMapping(value = "/addrSearchForm.do", method = RequestMethod.GET)
	public String SearchAddr(@RequestParam String lonName, @RequestParam String latName, @RequestParam String addr,
			Model model) {
		/* return "home"; */
		logger.debug("==> SearchAddr 진입");
		model.addAttribute("lonName", lonName);
		model.addAttribute("latName", latName);
		model.addAttribute("addr", addr);
		return "posts/Map";
	}
	// 글쓰기폼 이동
	@RequestMapping(value = "/writercheck.do", method = RequestMethod.GET)
	public String writerCheck(Model model,HttpSession session, HttpServletRequest request) {
		
		IPostMemberDAO dao = sqlSession.getMapper(IPostMemberDAO.class);
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {

			return "redirect:/loginform.do";
		
		} else {
			int sessionId = (int) session.getAttribute("sessionId");
			model.addAttribute("t_resDate",dao.travelLists(sessionId)) ;
			model.addAttribute("m_resDate",dao.memberLists(sessionId)) ;
			return "posts/writeForm";
		}

	}

}
