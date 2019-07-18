package com.together.web.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.together.web.Pagination;

@Controller
public class CategoryMainController {

	@Autowired
	private SqlSession sqlSession;

	// Best
	@RequestMapping(value = "/bestlist.do")
	public String bestList(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {

		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);

		int totalNum = 0;
		totalNum = dao.nowRecruitTravelNum();
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		TravelDTO dto = new TravelDTO();
		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END");
		else if (selectValue.equals("2"))
			dto.setOrderBy("VIEWNUM");
		else if (selectValue.equals("3"))
			dto.setOrderBy("T_JJIM");
		else if (selectValue.equals("4"))
			dto.setOrderBy("W_JJIM");

		ArrayList<TravelDTO> list = dao.travelInfoBasic(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/bestlist.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/BestList";
	}

	// 테마 전체
	@RequestMapping(value = "/themalistall.do")
	public String themaListAll(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);

		int totalNum = 0;
		totalNum = dao.nowRecruitTravelNum();
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		TravelDTO dto = new TravelDTO();
		dto.setStart(start);
		dto.setEnd(end);

		// 최신 인기 조회 찜 인기작가 여행시작
		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themaAll(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/themelistall.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/ThemeListAll";
	}

	// 테마 자연
	@RequestMapping(value = "/themalistnature.do")
	public String themaListNature(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("1");
		totalNum = dao.themaNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		// 최신 인기 조회 찜 인기작가 여행시작
		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themalist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/themalistnature.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/ThemeListNature";
	}

	// 테마 문화/관광
	@RequestMapping(value = "/themalistct.do")
	public String themaListCT(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("2");
		totalNum = dao.themaNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		// 최신 인기 조회 찜 인기작가 여행시작
		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themalist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/themalistct.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/ThemeListCT";
	}

	// 테마 레저/스포츠
	@RequestMapping(value = "/themalistls.do")
	public String themaListLS(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("3");
		totalNum = dao.themaNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		// 최신 인기 조회 찜 인기작가 여행시작
		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themalist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());

		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/themalistls.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/ThemeListLS";
	}

	// 테마 쇼핑/맛집
	@RequestMapping(value = "/themalistsf.do")
	public String themaListSF(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("4,5");
		totalNum = dao.themaNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		// 최신 인기 조회 찜 인기작가 여행시작
		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themalist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/themalistsf.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/ThemeListSF";
	}

	// 테마 기타
	@RequestMapping(value = "/themalistother.do")
	public String themaListOther(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("6");
		totalNum = dao.themaNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		// 최신 인기 조회 찜 인기작가 여행시작
		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themalist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/themalistother.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/ThemeListOther";
	}

	// 기간 검색 - 전체 검색
	@RequestMapping(value = "/periodlistall.do")
	public String periodListAll(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);

		int totalNum = 0;
		totalNum = dao.nowRecruitTravelNum();
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();
		TravelDTO dto = new TravelDTO();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themaAll(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/periodlistall.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/PeriodListAll";
	}

	// 기간 검색 - 1박2일
	@RequestMapping(value = "/periodlist12.do")
	public String periodList12(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("2");
		totalNum = dao.periodNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.periodlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/periodlist12.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/PeriodList12";
	}

	// 기간 검색 - 2박 3일
	@RequestMapping(value = "/periodlist23.do")
	public String periodList23(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("3");
		totalNum = dao.periodNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.periodlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/periodlist23.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/PeriodList23";
	}

	// 기간 검색 - 3박 4일
	@RequestMapping(value = "/periodlist34.do")
	public String periodList34(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("4");
		totalNum = dao.periodNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.periodlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/periodlist34.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/PeriodList34";
	}

	// 기간 검색 - 4박 5일
	@RequestMapping(value = "/periodlist45.do")
	public String periodList45(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("5");
		totalNum = dao.periodNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.periodlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/periodlist45.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/PeriodList45";
	}

	// 기간 - 장기여행
	@RequestMapping(value = "/periodlistother.do")
	public String periodListOther(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("6");
		totalNum = dao.periodNumOther(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.periodlistOther(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/periodlistother.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/PeriodListOther";
	}

	// 지역 검색 - 전체 검색
	@RequestMapping(value = "/regionlistall.do")
	public String regionListAll(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);

		int totalNum = 0;
		totalNum = dao.nowRecruitTravelNum();
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();
		TravelDTO dto = new TravelDTO();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.themaAll(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlistall.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListAll";
	}

	// 지역 검색 - 서울
	@RequestMapping(value = "/regionlist1.do")
	public String regionList1(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("1");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist1.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListSeoul";
	}

	// 지역 검색 - 경기
	@RequestMapping(value = "/regionlist2.do")
	public String regionList2(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("2");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist2.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListGyenggi";
	}

	// 지역 검색 - 인천
	@RequestMapping(value = "/regionlist3.do")
	public String regionList3(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("3");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist3.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListInchen";
	}

	// 지역 검색 - 강원
	@RequestMapping(value = "/regionlist4.do")
	public String regionList4(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("4");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist4.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListGangwon";
	}

	// 지역 검색 - 제주
	@RequestMapping(value = "/regionlist5.do")
	public String regionList5(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("5");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist5.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListJeju";
	}

	// 지역 검색 - 대전
	@RequestMapping(value = "/regionlist6.do")
	public String regionList6(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("6");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist6.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListDaejeon";
	}

	// 지역 검색 - 충북
	@RequestMapping(value = "/regionlist7.do")
	public String regionList7(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("7");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist7.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListChungbug";
	}

	// 지역 검색 - 충남/세종
	@RequestMapping(value = "/regionlist8.do")
	public String regionList8(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("8");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist8.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListChungSe";
	}

	// 지역 검색 - 부산
	@RequestMapping(value = "/regionlist9.do")
	public String regionList9(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("9");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist9.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListBusan";
	}

	// 지역 검색 - 울산
	@RequestMapping(value = "/regionlist10.do")
	public String regionList10(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("10");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist10.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListUlsan";
	}

	// 지역 검색 - 경남
	@RequestMapping(value = "/regionlist11.do")
	public String regionList11(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("11");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist11.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListGyeongnam";
	}

	// 지역 검색 - 대구
	@RequestMapping(value = "/regionlist12.do")
	public String regionList12(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("12");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist12.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListDaegu";
	}

	// 지역 검색 - 경북
	@RequestMapping(value = "/regionlist13.do")
	public String regionList13(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("13");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist13.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListGyengbug";
	}

	// 지역 검색 - 광주
	@RequestMapping(value = "/regionlist14.do")
	public String regionList14(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("14");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist14.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListGwangju";
	}

	// 지역 검색 - 전남
	@RequestMapping(value = "/regionlist15.do")
	public String regionList15(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("15");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist15.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListJeonnam";
	}

	// 지역 검색 - 전북
	@RequestMapping(value = "/regionlist16.do")
	public String regionList16(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {
		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		dto.setOrderNum("16");
		totalNum = dao.regionNum(dto);
		model.addAttribute("totalNum", totalNum);

		Pagination paging = new Pagination();

		String pageNum = request.getParameter("pageNum");
		int current_page = 1;

		if (pageNum != null)
			current_page = Integer.parseInt(pageNum);

		int numPerPage = 16;
		int total_page = paging.getPageCount(numPerPage, totalNum);

		if (current_page > total_page)
			current_page = total_page;

		int start = (current_page - 1) * numPerPage + 1;
		int end = current_page * numPerPage;

		dto.setStart(start);
		dto.setEnd(end);

		if (selectValue.equals("1"))
			dto.setOrderBy("RECRUIT_END DESC");
		else if (selectValue.equals("2"))
			dto.setOrderBy("RATIO DESC");
		else if (selectValue.equals("3"))
			dto.setOrderBy("VIEWNUM DESC");
		else if (selectValue.equals("4"))
			dto.setOrderBy("T_JJIM DESC");
		else if (selectValue.equals("5"))
			dto.setOrderBy("W_JJIM DESC");
		else if (selectValue.equals("6"))
			dto.setOrderBy("T_START");

		ArrayList<TravelDTO> list = dao.regionlist(dto);

		for (TravelDTO travel : list) {
			ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
			travel.setThemaType(themaType);

			TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
			travel.setRegion_Start(startDTO.getRegion_Start());
			travel.setCity_Start(startDTO.getCity_Start());

			TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
			travel.setRegion_End(endDTO.getRegion_End());
			travel.setCity_End(endDTO.getCity_End());
		}

		model.addAttribute("travelList", list);
		model.addAttribute("selectValue", selectValue);

		String url = "/web/regionlist16.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/RegionListJeonbug";
	}

	// 관심테마
	@RequestMapping(value = "/favorthemalist.do")
	public String favorThemaList(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {

		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("sessionId") == null) {

			return "login/Login";
		} else {
			int userCode = (Integer) session.getAttribute("sessionId");
			dto.setUserCode(userCode);
			totalNum = dao.favorthemaNum(dto);
			model.addAttribute("totalNum", totalNum);

			if (totalNum > 0) {

				Pagination paging = new Pagination();

				String pageNum = request.getParameter("pageNum");
				int current_page = 1;

				if (pageNum != null)
					current_page = Integer.parseInt(pageNum);

				int numPerPage = 16;
				int total_page = paging.getPageCount(numPerPage, totalNum);

				if (current_page > total_page)
					current_page = total_page;

				int start = (current_page - 1) * numPerPage + 1;
				int end = current_page * numPerPage;

				dto.setStart(start);
				dto.setEnd(end);

				if (selectValue.equals("1"))
					dto.setOrderBy("RECRUIT_END DESC");
				else if (selectValue.equals("2"))
					dto.setOrderBy("RATIO DESC");
				else if (selectValue.equals("3"))
					dto.setOrderBy("VIEWNUM DESC");
				else if (selectValue.equals("4"))
					dto.setOrderBy("T_JJIM DESC");
				else if (selectValue.equals("5"))
					dto.setOrderBy("W_JJIM DESC");
				else if (selectValue.equals("6"))
					dto.setOrderBy("T_START");

				ArrayList<TravelDTO> list = dao.favorthemalist(dto);

				for (TravelDTO travel : list) {
					ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
					travel.setThemaType(themaType);

					TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
					travel.setRegion_Start(startDTO.getRegion_Start());
					travel.setCity_Start(startDTO.getCity_Start());

					TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
					travel.setRegion_End(endDTO.getRegion_End());
					travel.setCity_End(endDTO.getCity_End());
				}

				model.addAttribute("travelList", list);
				model.addAttribute("selectValue", selectValue);

				String url = "/web/favorthemalist.do";
				String pageIndexList = paging.pageIndexList(current_page, total_page, url);

				model.addAttribute("pageIndexList", pageIndexList);

				return "category/FavorThemeList";
			}

			else
				return "category/FavorThemeNone";
		}
	}

	// 관심작가
	@RequestMapping(value = "/favorwriterlist.do")
	public String favorWriterList(ModelMap model, HttpServletRequest request,
			@RequestParam(name = "selectValue", defaultValue = "1") String selectValue) throws IOException {

		ITravelDAO dao = sqlSession.getMapper(ITravelDAO.class);
		TravelDTO dto = new TravelDTO();

		int totalNum = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute("sessionId") == null) {

			return "login/Login";
			
		} 
		else 
		{
			int userCode = (Integer) session.getAttribute("sessionId");
			dto.setUserCode(userCode);
			totalNum = dao.favorwriterNum(dto);
			model.addAttribute("totalNum", totalNum);

			if (totalNum > 0) {

				Pagination paging = new Pagination();

				String pageNum = request.getParameter("pageNum");
				int current_page = 1;

				if (pageNum != null)
					current_page = Integer.parseInt(pageNum);

				int numPerPage = 16;
				int total_page = paging.getPageCount(numPerPage, totalNum);

				if (current_page > total_page)
					current_page = total_page;

				int start = (current_page - 1) * numPerPage + 1;
				int end = current_page * numPerPage;

				dto.setStart(start);
				dto.setEnd(end);

				if (selectValue.equals("1"))
					dto.setOrderBy("RECRUIT_END DESC");
				else if (selectValue.equals("2"))
					dto.setOrderBy("RATIO DESC");
				else if (selectValue.equals("3"))
					dto.setOrderBy("VIEWNUM DESC");
				else if (selectValue.equals("4"))
					dto.setOrderBy("T_JJIM DESC");
				else if (selectValue.equals("5"))
					dto.setOrderBy("W_JJIM DESC");
				else if (selectValue.equals("6"))
					dto.setOrderBy("T_START");

				ArrayList<TravelDTO> list = dao.favorwriterlist(dto);

				for (TravelDTO travel : list) {
					ArrayList<String> themaType = dao.tThemaType(travel.getTravelCode());
					travel.setThemaType(themaType);

					TravelDTO startDTO = dao.tCityStart(travel.getTravelCode());
					travel.setRegion_Start(startDTO.getRegion_Start());
					travel.setCity_Start(startDTO.getCity_Start());

					TravelDTO endDTO = dao.tCityEnd(travel.getTravelCode());
					travel.setRegion_End(endDTO.getRegion_End());
					travel.setCity_End(endDTO.getCity_End());
				}

				model.addAttribute("travelList", list);
				model.addAttribute("selectValue", selectValue);

				String url = "/web/favorwriterlist.do";
				String pageIndexList = paging.pageIndexList(current_page, total_page, url);

				model.addAttribute("pageIndexList", pageIndexList);

				return "category/FavorWriterList";
			}

			else
				return "category/FavorWriterNone";
		}
	}
}
