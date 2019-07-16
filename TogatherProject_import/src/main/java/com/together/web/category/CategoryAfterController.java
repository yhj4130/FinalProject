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
public class CategoryAfterController {

	@Autowired
	private SqlSession sqlSession;

	// Best
	@RequestMapping(value = "/bestlistafter.do")
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

		String url = "/web/bestlistafterafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/BestList";
	}

	// 테마 전체
	@RequestMapping(value = "/themalistallafterafter.do")
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

		String url = "/web/themelistallafterafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/ThemeListAll";
	}

	// 테마 자연
	@RequestMapping(value = "/themalistnatureafterafter.do")
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

		String url = "/web/themalistnatureafterafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/ThemeListNature";
	}

	// 테마 문화/관광
	@RequestMapping(value = "/themalistctafterafter.do")
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

		String url = "/web/themalistctafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/ThemeListCT";
	}

	// 테마 레저/스포츠
	@RequestMapping(value = "/themalistlsafter.do")
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

		String url = "/web/themalistlsafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/ThemeListLS";
	}

	// 테마 쇼핑/맛집
	@RequestMapping(value = "/themalistsfafter.do")
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

		String url = "/web/themalistsfafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/ThemeListSF";
	}

	// 테마 기타
	@RequestMapping(value = "/themalistotherafter.do")
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

		String url = "/web/themalistotherafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/ThemeListOther";
	}

	// 기간 검색 - 전체 검색
	@RequestMapping(value = "/periodlistallafter.do")
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

		String url = "/web/periodlistallafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/PeriodListAll";
	}

	// 기간 검색 - 1박2일
	@RequestMapping(value = "/periodlist12after.do")
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

		String url = "/web/periodlist12after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/PeriodList12";
	}

	// 기간 검색 - 2박 3일
	@RequestMapping(value = "/periodlist23after.do")
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

		String url = "/web/periodlist23after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/PeriodList23";
	}

	// 기간 검색 - 3박 4일
	@RequestMapping(value = "/periodlist34after.do")
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

		String url = "/web/periodlist34after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/PeriodList34";
	}

	// 기간 검색 - 4박 5일
	@RequestMapping(value = "/periodlist45after.do")
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

		String url = "/web/periodlist45after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/PeriodList45";
	}

	// 기간 - 장기여행
	@RequestMapping(value = "/periodlistotherafter.do")
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

		String url = "/web/periodlistotherafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/PeriodListOther";
	}

	// 지역 검색 - 전체 검색
	@RequestMapping(value = "/regionlistallafter.do")
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

		String url = "/web/regionlistallafter.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListAll";
	}

	// 지역 검색 - 서울
	@RequestMapping(value = "/regionlist1after.do")
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

		String url = "/web/regionlist1after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListSeoul";
	}

	// 지역 검색 - 경기
	@RequestMapping(value = "/regionlist2after.do")
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

		String url = "/web/regionlist2after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListGyenggi";
	}

	// 지역 검색 - 인천
	@RequestMapping(value = "/regionlist3after.do")
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

		String url = "/web/regionlist3after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListInchen";
	}

	// 지역 검색 - 강원
	@RequestMapping(value = "/regionlist4after.do")
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

		String url = "/web/regionlist4after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListGangwon";
	}

	// 지역 검색 - 제주
	@RequestMapping(value = "/regionlist5after.do")
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

		String url = "/web/regionlist5after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListJeju";
	}

	// 지역 검색 - 대전
	@RequestMapping(value = "/regionlist6after.do")
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

		String url = "/web/regionlist6after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListDaejeon";
	}

	// 지역 검색 - 충북
	@RequestMapping(value = "/regionlist7after.do")
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

		String url = "/web/regionlist7after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListChungbug";
	}

	// 지역 검색 - 충남/세종
	@RequestMapping(value = "/regionlist8after.do")
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

		String url = "/web/regionlist8after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListChungSe";
	}

	// 지역 검색 - 부산
	@RequestMapping(value = "/regionlist9after.do")
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

		String url = "/web/regionlist9after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListBusan";
	}

	// 지역 검색 - 울산
	@RequestMapping(value = "/regionlist10after.do")
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

		String url = "/web/regionlist10after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListUlsan";
	}

	// 지역 검색 - 경남
	@RequestMapping(value = "/regionlist11after.do")
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

		String url = "/web/regionlist11after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListGyeongnam";
	}

	// 지역 검색 - 대구
	@RequestMapping(value = "/regionlist12after.do")
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

		String url = "/web/regionlist12after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListDaegu";
	}

	// 지역 검색 - 경북
	@RequestMapping(value = "/regionlist13after.do")
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

		String url = "/web/regionlist13after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListGyengbug";
	}

	// 지역 검색 - 광주
	@RequestMapping(value = "/regionlist14after.do")
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

		String url = "/web/regionlist14after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListGwangju";
	}

	// 지역 검색 - 전남
	@RequestMapping(value = "/regionlist15after.do")
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

		String url = "/web/regionlist15after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListJeonnam";
	}

	// 지역 검색 - 전북
	@RequestMapping(value = "/regionlist16after.do")
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

		String url = "/web/regionlist16after.do";
		String pageIndexList = paging.pageIndexList(current_page, total_page, url);

		model.addAttribute("pageIndexList", pageIndexList);

		return "category/after/RegionListJeonbug";
	}

	// 관심테마
	@RequestMapping(value = "/favorthemalistafter.do")
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

				String url = "/web/favorthemalistafter.do";
				String pageIndexList = paging.pageIndexList(current_page, total_page, url);

				model.addAttribute("pageIndexList", pageIndexList);

				return "category/after/FavorThemeList";
			}

			else
				return "category/after/FavorThemeNone";
		}
	}

	// 관심작가
	@RequestMapping(value = "/favorwriterlistafter.do")
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

				String url = "/web/favorwriterlistafter.do";
				String pageIndexList = paging.pageIndexList(current_page, total_page, url);

				model.addAttribute("pageIndexList", pageIndexList);

				return "category/after/FavorWriterList";
			}

			else
				return "category/after/FavorWriterNone";
		}
	}
}
