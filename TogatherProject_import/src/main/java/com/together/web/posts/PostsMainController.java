package com.together.web.posts;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostsMainController {

	private static final Logger logger = LoggerFactory.getLogger(PostsMainController.class);

	@Autowired
	private SqlSession sqlSession;

	@Resource(name = "uploadPath")
	String uploadPath;

	// 주소찾기 팝업창
	@RequestMapping(value = "/addrSearchForm.do", method = RequestMethod.GET)
	public String SearchAddr(@RequestParam String lonName, @RequestParam String latName, @RequestParam String addr,
			Model model) {
		/* return "home"; */
		logger.debug("==> addrSearchForm 진입");
		model.addAttribute("lonName", lonName);
		model.addAttribute("latName", latName);
		model.addAttribute("addr", addr);
		return "posts/Map";
	}

	// 글쓰기폼 이동
	@RequestMapping(value = "/writercheck.do", method = RequestMethod.GET)
	public String writerCheck(Model model, HttpSession session, HttpServletRequest request) {

		IPostMemberDAO dao = sqlSession.getMapper(IPostMemberDAO.class);
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			return "redirect:/loginform.do";
		} else {
			return "posts/writeForm";
		}
	}

	// 임시게시물 게시글 카운트 ajax
	@RequestMapping(value = "/countTemp.do", method = RequestMethod.POST)
	public void countTemp(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		IPostMemberDAO dao = sqlSession.getMapper(IPostMemberDAO.class);
		int result = 0;
		session = request.getSession();
		int userCode = (int) session.getAttribute("sessionId");
		/* String[] s_temp = request.getParameterValues("test1"); */

		result = dao.countTemp(userCode);
		response.getWriter().print(result);

	}

	

	// 주소 컷팅 메서드
	private String[] changeAddr(String[] addr) {

		String[] words = new String[addr.length * 2];
		for (int i = 0; i < addr.length; i++) {

			String[] array = addr[i].split("\\s");
			int n = i;
			if (array[0].equals("서울특별시")) {
				words[i + n] = "서울";
				words[i + n + 1] = "서울시";
			} else if (array[0].equals("경기도")) {
				words[i + n] = "경기";
				words[i + n + 1] = array[2];
			} else if (array[0].equals("인천광역시")) {
				words[i + n] = "인천";
				words[i + n + 1] = "인천";
			} else if (array[0].equals("제주특별자치도")) {
				words[i + n] = "제주";
				words[i + n + 1] = "제주";
			} else if (array[0].equals("대전광역시")) {
				words[i + n] = "대전";
				words[i + n + 1] = "대전";
			} else if (array[0].equals("충청북도")) {
				words[i + n] = "충청";
				words[i + n + 1] = array[2];
			} else if (array[0].equals("충청남도")) {
				words[i + n] = "충남/세종";
				words[i + n + 1] = array[2];
			} else if (array[0].equals("울산광역시")) {
				words[i + n] = "울산";
				words[i + n + 1] = "울산";
			} else if (array[0].equals("부산광역시")) {
				words[i + n] = "부산";
				words[i + n + 1] = "부산";
			} else if (array[0].equals("경상남도")) {
				words[i + n] = "경남";
				words[i + n + 1] = array[2];
			} else if (array[0].equals("대구광역시")) {
				words[i + n] = "대구";
				words[i + n + 1] = "대구";
			} else if (array[0].equals("경상북도")) {
				words[i + n] = "경북";
				words[i + n + 1] = array[2];
			} else if (array[0].equals("광주광역시")) {
				words[i + n] = "광주";
				words[i + n + 1] = "광주";
			} else if (array[0].equals("전라남도")) {
				words[i + n] = "전남";
				words[i + n + 1] = array[2];
			} else if (array[0].equals("세종특별자치시")) {
				words[i + n] = "충남/세종";
				words[i + n + 1] = "충남/세종";
			} else {
				words[i + n] = "전북";
				words[i + n + 1] = array[2];
			}

		}

		/*
		 * for (String wo : words ){ logger.info("주소 :" + wo); }
		 */

		return words;

	}

}
