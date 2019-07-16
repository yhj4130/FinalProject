package com.together.web.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.together.web.best.BestMainDTO;
import com.together.web.best.IBestMainDAO;
import com.together.web.newMain.INewMainDAO;
import com.together.web.newMain.NewMainDTO;

@Controller
public class MainController {
	@Autowired
	private SqlSession sqlSession;

	// 진입하자마자 메인페이지로 연결
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginMain(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			// BEST10
			IBestMainDAO bestMainDAO = sqlSession.getMapper(IBestMainDAO.class);

			ArrayList<BestMainDTO> bestMainList = bestMainDAO.bestMainTravelInfoBasic();
			for (BestMainDTO bestMainDTO : bestMainList) {
				ArrayList<String> themaType = bestMainDAO.bestMainThemeType(bestMainDTO.getTravelCode());
				bestMainDTO.setThemaType(themaType);

				BestMainDTO start = bestMainDAO.bestMainCityStart(bestMainDTO.getTravelCode());
				bestMainDTO.setRegion_Start(start.getRegion_Start());
				bestMainDTO.setCity_Start(start.getCity_Start());

				BestMainDTO end = bestMainDAO.bestMainCityEnd(bestMainDTO.getTravelCode());
				bestMainDTO.setRegion_End(end.getRegion_End());
				bestMainDTO.setCity_End(end.getCity_End());

			}
			model.addAttribute("bestMainList", bestMainList);

			// NEW10
			INewMainDAO newMainDAO = sqlSession.getMapper(INewMainDAO.class);

			ArrayList<NewMainDTO> newMainList = newMainDAO.newMainTravelInfoBasic();

			for (NewMainDTO newMainDTO : newMainList) {
				ArrayList<String> themaType = newMainDAO.newMainThemeType(newMainDTO.getTravelCode());
				newMainDTO.setThemaType(themaType);

				NewMainDTO start = newMainDAO.newMainCityStart(newMainDTO.getTravelCode());
				newMainDTO.setRegion_Start(start.getRegion_Start());
				newMainDTO.setCity_Start(start.getCity_Start());

				NewMainDTO end = newMainDAO.newMainCityEnd(newMainDTO.getTravelCode());
				newMainDTO.setRegion_End(end.getRegion_End());
				newMainDTO.setCity_End(end.getCity_End());

				System.out.println(newMainDTO.getImg());
			}
			model.addAttribute("newMainList", newMainList);

			return "main/before/beforeLogin";
			
		} else {
			// BEST10
			IBestMainDAO bestMainDAO = sqlSession.getMapper(IBestMainDAO.class);

			ArrayList<BestMainDTO> bestMainList = bestMainDAO.bestMainTravelInfoBasic();
			for (BestMainDTO bestMainDTO : bestMainList) {
				ArrayList<String> themaType = bestMainDAO.bestMainThemeType(bestMainDTO.getTravelCode());
				bestMainDTO.setThemaType(themaType);

				BestMainDTO start = bestMainDAO.bestMainCityStart(bestMainDTO.getTravelCode());
				bestMainDTO.setRegion_Start(start.getRegion_Start());
				bestMainDTO.setCity_Start(start.getCity_Start());

				BestMainDTO end = bestMainDAO.bestMainCityEnd(bestMainDTO.getTravelCode());
				bestMainDTO.setRegion_End(end.getRegion_End());
				bestMainDTO.setCity_End(end.getCity_End());

				System.out.println(bestMainDTO.getImg());
			}
			model.addAttribute("bestMainList", bestMainList);

			// NEW10
			INewMainDAO newMainDAO = sqlSession.getMapper(INewMainDAO.class);

			ArrayList<NewMainDTO> newMainList = newMainDAO.newMainTravelInfoBasic();

			for (NewMainDTO newMainDTO : newMainList) {
				ArrayList<String> themaType = newMainDAO.newMainThemeType(newMainDTO.getTravelCode());
				newMainDTO.setThemaType(themaType);

				NewMainDTO start = newMainDAO.newMainCityStart(newMainDTO.getTravelCode());
				newMainDTO.setRegion_Start(start.getRegion_Start());
				newMainDTO.setCity_Start(start.getCity_Start());

				NewMainDTO end = newMainDAO.newMainCityEnd(newMainDTO.getTravelCode());
				newMainDTO.setRegion_End(end.getRegion_End());
				newMainDTO.setCity_End(end.getCity_End());

				System.out.println(newMainDTO.getImg());
			}
			model.addAttribute("newMainList", newMainList);

			return "main/after/afterLogin";
		}
	}

	// 로그인 후 로고 클릭시 메인화면
	@RequestMapping(value = "/afterlogin.do", method = RequestMethod.GET)
	public String afterLoginMain(HttpSession session, HttpServletRequest request, Model model) {
		return "main/after/afterLogin";
	}

	// 로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("sessionId");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:beforemain.do");
		return mav;

	}

	// 글 작성
	/*
	 * @RequestMapping(value = "/111.do", method = RequestMethod.GET) public String
	 * afterLogin(HttpSession session, HttpServletRequest request) { session =
	 * request.getSession();
	 * 
	 * if (session.getAttribute("userCode") == null) { return "login/Login"; } else
	 * { return "posts/writeForm.jsp"; } }
	 */

	// 전체카테고리 - 테마
	@RequestMapping(value = "/thema.do")
	public String theme(@RequestParam(name = "value", defaultValue = "allTheme") String value, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			if (value.equals("allTheme"))
				return "redirect:/themalistallbefore.do";
			else if (value.equals("nature"))
				return "redirect:/themalistnaturebefore.do";
			else if (value.equals("culture"))
				return "redirect:/themalistctbefore.do";
			else if (value.equals("sports"))
				return "redirect:/themalistlsbefore.do";
			else if (value.equals("shopping"))
				return "redirect:/themalistsfbefore.do";
			else
				return "redirect:/themalistotherbefore.do";
		} else {
			if (value.equals("allTheme"))
				return "redirect:/themalistallafter.do";
			else if (value.equals("nature"))
				return "redirect:/themalistnatureafter.do";
			else if (value.equals("culture"))
				return "redirect:/themalistctafter.do";
			else if (value.equals("sports"))
				return "redirect:/themalistlsafter.do";
			else if (value.equals("shopping"))
				return "redirect:/themalistsfafter.do";
			else
				return "redirect:/themalistotherafter.do";
		}
	}

	// 전체카테고리 - 지역
	@RequestMapping(value = "/region.do", method = RequestMethod.GET)
	public String region(@RequestParam(name = "value", defaultValue = "allPeriod") String value, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			if (value.equals("allRegion"))
				return "redirect:/regionlistallbefore.do";
			else if (value.equals("seoul"))
				return "redirect:/regionlist1before.do";
			else if (value.equals("gyenggi"))
				return "redirect:/regionlist2before.do";
			else if (value.equals("inchen"))
				return "redirect:/regionlist3before.do";
			else if (value.equals("gangwon"))
				return "redirect:/regionlist4before.do";
			else if (value.equals("jeju"))
				return "redirect:/regionlist5before.do";
			else if (value.equals("daejeon"))
				return "redirect:/regionlist6before.do";
			else if (value.equals("chungbug"))
				return "redirect:/regionlist7before.do";
			else if (value.equals("chungSe"))
				return "redirect:/regionlist8before.do";
			else if (value.equals("busan"))
				return "redirect:/regionlist9before.do";
			else if (value.equals("ulsan"))
				return "redirect:/regionlist10before.do";
			else if (value.equals("gyeongnam"))
				return "redirect:/regionlist11before.do";
			else if (value.equals("daegu"))
				return "redirect:/regionlist12before.do";
			else if (value.equals("gyeongbug"))
				return "redirect:/regionlist13before.do";
			else if (value.equals("gwangju"))
				return "redirect:/regionlist14before.do";
			else if (value.equals("jeonnam"))
				return "redirect:/regionlist15before.do";
			else 
				return "redirect:/regionlist16before.do";
		} else {
			if (value.equals("allRegion"))
				return "redirect:/regionlistallafter.do";
			else if (value.equals("seoul"))
				return "redirect:/regionlist1after.do";
			else if (value.equals("gyenggi"))
				return "redirect:/regionlist2after.do";
			else if (value.equals("inchen"))
				return "redirect:/regionlist3after.do";
			else if (value.equals("gangwon"))
				return "redirect:/regionlist4after.do";
			else if (value.equals("jeju"))
				return "redirect:/regionlist5after.do";
			else if (value.equals("daejeon"))
				return "redirect:/regionlist6after.do";
			else if (value.equals("chungbug"))
				return "redirect:/regionlist7after.do";
			else if (value.equals("chungSe"))
				return "redirect:/regionlist8after.do";
			else if (value.equals("busan"))
				return "redirect:/regionlist9after.do";
			else if (value.equals("ulsan"))
				return "redirect:/regionlist10after.do";
			else if (value.equals("gyeongnam"))
				return "redirect:/regionlist11after.do";
			else if (value.equals("daegu"))
				return "redirect:/regionlist12after.do";
			else if (value.equals("gyeongbug"))
				return "redirect:/regionlist13after.do";
			else if (value.equals("gwangju"))
				return "redirect:/regionlist14after.do";
			else if (value.equals("jeonnam"))
				return "redirect:/regionlist15after.do";
			else 
				return "redirect:/regionlist16after.do";
		}
	}

	// 전체카테고리 - 기간
	@RequestMapping(value = "/period.do", method = RequestMethod.GET)
	public String time(@RequestParam(name = "value", defaultValue = "allRegion") String value, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			if (value.equals("allPeriod"))
				return "redirect:/periodlistallbefore.do";
			else if (value.equals("12"))
				return "redirect:/periodlist12before.do";
			else if (value.equals("23"))
				return "redirect:/periodlist23before.do";
			else if (value.equals("34"))
				return "redirect:/periodlist34before.do";
			else if (value.equals("45"))
				return "redirect:/periodlist45before.do";
			else
				return "redirect:/periodlistotherbefore.do";
		} else {
			if (value.equals("allPeriod"))
				return "redirect:/periodlistallafter.do";
			else if (value.equals("12"))
				return "redirect:/periodlist12after.do";
			else if (value.equals("23"))
				return "redirect:/periodlist23after.do";
			else if (value.equals("34"))
				return "redirect:/periodlist34after.do";
			else if (value.equals("45"))
				return "redirect:/periodlist45after.do";
			else
				return "redirect:/periodlistotherafter.do";
		}
	}

	// 베스트
	@RequestMapping(value = "/best.do", method = RequestMethod.GET)
	public String best(HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null)
			return "redirect:/bestlistbefore.do";
		else
			return "redirect:/bestlistafter.do";

	}

	// 관심작가
	@RequestMapping(value = "/favorWriter.do", method = RequestMethod.GET)
	public String favorWriter(HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null)
			return "login/Login";
		else
			return "redirect:/favorwriterlistafter.do";
	}

	// 관심테마
	@RequestMapping(value = "/favorTheme.do", method = RequestMethod.GET)
	public String favorTheme(HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null)
			return "login/Login";
		else
			return "redirect:/favorthemalistafter.do";
	}
}
