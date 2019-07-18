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
	public String loginMain(HttpSession session, HttpServletRequest request, Model model) {

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

			session = request.getSession();

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

			session = request.getSession();

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
	@RequestMapping(value = "/category.do", method = RequestMethod.GET)
	public String theme(@RequestParam(name = "value", defaultValue = "allTheme") String value, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			if (value.equals("allTheme"))
				return "category/before/ThemeListAll";
			else if (value.equals("nature"))
				return "category/before/ThemeListNature";
			else if (value.equals("culture"))
				return "category/before/ThemeListCT";
			else if (value.equals("sports"))
				return "category/before/ThemeListLS";
			else if (value.equals("shopping"))
				return "category/before/ThemeListSF";
			else
				return "category/before/ThemeListOther";
		} else {
			if (value.equals("allTheme"))
				return "category/after/ThemeListAll";
			else if (value.equals("nature"))
				return "category/after/ThemeListNature";
			else if (value.equals("culture"))
				return "category/after/ThemeListCT";
			else if (value.equals("sports"))
				return "category/after/ThemeListLS";
			else if (value.equals("shopping"))
				return "category/after/ThemeListSF";
			else
				return "category/after/ThemeListOther";
		}
	}

	// 전체카테고리 - 지역
	@RequestMapping(value = "/region.do", method = RequestMethod.GET)
	public String region(@RequestParam(name = "value", defaultValue = "allPeriod") String value, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			if (value.equals("seoul"))
				return "category/before/RegionListSeoul";
			else if (value.equals("gyenggi"))
				return "category/before/RegionListGyenggi";
			else if (value.equals("inchen"))
				return "category/before/RegionListInchen";
			else if (value.equals("gangwon"))
				return "category/before/RegionListGangwon";
			else if (value.equals("jeju"))
				return "category/before/RegionListJeju";
			else if (value.equals("daejeon"))
				return "category/before/RegionListDaejeon";
			else if (value.equals("chungbug"))
				return "category/before/RegionListChungbug";
			else if (value.equals("chungSe"))
				return "category/before/RegionListChungSe";
			else if (value.equals("busan"))
				return "category/before/RegionListBusan";
			else if (value.equals("ulsan"))
				return "category/before/RegionListUlsan";
			else if (value.equals("gyeongnam"))
				return "category/before/RegionListGyeongnam";
			else if (value.equals("daegu"))
				return "category/before/RegionListDaegu";
			else if (value.equals("gyeongbug"))
				return "category/before/RegionListGyengbug";
			else if (value.equals("gwangju"))
				return "category/before/RegionListGwangju";
			else if (value.equals("jeonnam"))
				return "category/before/RegionListJeonnam";
			else if (value.equals("jeonbug"))
				return "category/before/RegionListJeonbug";
			else
				return "category/before/RegionListAll";
		} else {
			if (value.equals("seoul"))
				return "category/after/RegionListSeoul";
			else if (value.equals("gyenggi"))
				return "category/after/RegionListGyenggi";
			else if (value.equals("inchen"))
				return "category/after/RegionListInchen";
			else if (value.equals("gangwon"))
				return "category/after/RegionListGangwon";
			else if (value.equals("jeju"))
				return "category/after/RegionListJeju";
			else if (value.equals("daejeon"))
				return "category/after/RegionListDaejeon";
			else if (value.equals("chungbug"))
				return "category/after/RegionListChungbug";
			else if (value.equals("chungSe"))
				return "category/after/RegionListChungSe";
			else if (value.equals("busan"))
				return "category/after/RegionListBusan";
			else if (value.equals("ulsan"))
				return "category/after/RegionListUlsan";
			else if (value.equals("gyeongnam"))
				return "category/after/RegionListGyeongnam";
			else if (value.equals("daegu"))
				return "category/after/RegionListDaegu";
			else if (value.equals("gyeongbug"))
				return "category/after/RegionListGyengbug";
			else if (value.equals("gwangju"))
				return "category/after/RegionListGwangju";
			else if (value.equals("jeonnam"))
				return "category/after/RegionListJeonnam";
			else if (value.equals("jeonbug"))
				return "category/after/RegionListJeonbug";
			else
				return "category/after/RegionListAll";
		}
	}

	// 전체카테고리 - 기간
	@RequestMapping(value = "/period.do", method = RequestMethod.GET)
	public String time(@RequestParam(name = "value", defaultValue = "allRegion") String value, HttpSession session,
			HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null) {
			if (value.equals("allPeriod"))
				return "category/before/PeriodListAll";
			else if (value.equals("12"))
				return "category/before/PeriodList12";
			else if (value.equals("23"))
				return "category/before/PeriodList23";
			else if (value.equals("34"))
				return "category/before/PeriodList34";
			else if (value.equals("45"))
				return "category/before/PeriodList45";
			else
				return "category/before/PeriodListOther";
		} else {
			if (value.equals("allPeriod"))
				return "category/after/PeriodListAll";
			else if (value.equals("12"))
				return "category/after/PeriodList12";
			else if (value.equals("23"))
				return "category/after/PeriodList23";
			else if (value.equals("34"))
				return "category/after/PeriodList34";
			else if (value.equals("45"))
				return "category/after/PeriodList45";
			else
				return "category/after/PeriodListOther";
		}
	}

	// 베스트
	@RequestMapping(value = "/best.do", method = RequestMethod.GET)
	public String best(HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null)
			return "category/before/BestList";
		else
			return "category/after/BestList";

	}

	// 관심작가
	@RequestMapping(value = "/favorWriter.do", method = RequestMethod.GET)
	public String favorWriter(HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null)
			return "login/Login";
		else
			return "favor/FavorWriterList";
	}

	// 관심테마
	@RequestMapping(value = "/favorTheme.do", method = RequestMethod.GET)
	public String favorTheme(HttpSession session, HttpServletRequest request) {
		session = request.getSession();

		if (session.getAttribute("sessionId") == null)
			return "login/Login";
		else
			return "favor/FavorThemeList";
	}
}
