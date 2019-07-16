<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
   request.setCharacterEncoding("UTF-8");
   String cp = request.getContextPath();
%>
<link href="<c:url value="/resources/css/category/themeList.css" />"
   rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/category.js" />"></script>

<div class="contentList">
   <div class="categoryB">
      <span>테마</span>
   </div>
   <div class="categorySdiv">
      <div class="categoryS">
         <a href="themalistall.do" id="themeAll" class="selectN" onmouseout="change2(this)"
            onmouseover="change1(this)">전체</a>
      </div>
      <div class="categoryS">
         <a href="themalistnature.do" id="themeNature" class="selectN"
            onmouseout="change2(this)" onmouseover="change1(this)">자연</a>
      </div>
      <div class="categoryS" style="width: 120px">
         <a href="themalistct.do" id="themeCT" class="selectN" onmouseout="change2(this)"
            onmouseover="change1(this)">문화/관광</a>
      </div>
      <div class="categoryS" style="width: 145px;">
         <a href="themalistls.do" id="themeLS" class="selectN" onmouseout="change2(this)"
            onmouseover="change1(this)">레저/스포츠</a>
      </div>
      <div class="categoryS" style="width: 120px">
         <a href="themalistsf.do" id="themeSF" class="selectB"
            style="color: rgb(60, 127, 68);">쇼핑/맛집</a>
      </div>
      <div class="categoryS">
         <a href="themalistother.do" id="themeOther" class="selectN" onmouseout="change2(this)"
            onmouseover="change1(this)">기타</a>
      </div>
   </div>
   <div class="searchDate">

      <div style="float: right;">
         <div style="width: 100px; height: 35px; margin-top: 20px;">
            <select class="custom-select"
               style="width: 120px; height: 35px; font-size: 11pt; float: right; bottom: 0px;"
               id="selectBest" name="selectBest">
               <option value="1">최신순</option>
               <option value="2">인기순</option>
               <option value="3">조회순</option>
               <option value="4">찜많은순</option>
               <option value="5">인기작가순</option>
               <option value="6">여행시작순</option>
            </select>
         </div>
      </div>
      <div style="float: left;">
			<div style="width: 100px; height: 25px; margin-top: 30px;">
				<span style="font-size: 12pt; font-family: 맑은 고딕;">총 ${totalNum } 건</span>
			</div>
	  </div>
   </div>
   <div style="width: 1140px; height: 55px;">
      <div class="listLine"></div>
   </div>
   <div style="width: 1140px; height: 1600px; margin-bottom: 20px;">
      <div style="margin: 0px 20px 20px 20px;">
         <!-- foreach -->

         <c:forEach var="travel" items="${travelList }">

            <div style="width: 275px; text-align: center; float: left;">
               <div class="card"
                  style="width: 200px; height: 400px; border: 0px; display: inline-block;">
                  <div class="selector" style="width: 200px; height: 200px;">
                     <a href=""><img
                        src="<c:url value="/resources/userimages/${travel.img }" />"
                        class="card-img-top" alt="..."></a>
                  </div>
                  <div class="cardBody">
                     <div>
                        <span class="postTitle">${travel.title}</span>
                     </div>
                     <div>
                        <span class="postContent">여행작가 : ${travel.nickName }</span>
                     </div>
                     <div>
                        <span class="postContent"> 여행테마 : <c:forEach var="thema"
                              items="${travel.themaType }">
                              ${thema} 　
                           </c:forEach>
                        </span>
                     </div>
                     <div>
                        <!-- 짤렸어 확인해 -->
                        <span class="postContent"> ${travel.region_Start }-${travel.city_Start }
                        </span>
                     </div>
                     <div>
                        <span class="postContent"> →${travel.region_End }/${travel.city_End }
                        </span>

                     </div>
                     <div>
                        <span class="postContent"> ${travel.t_Start } ~
                           ${travel.t_End } </span>
                     </div>
                     <div>
                        <span class="postContent">모집마감 ${travel.recruit_End }</span>
                     </div>
                  </div>
               </div>
            </div>

         </c:forEach>
      </div>
   </div>
   <div style="width: 1140px; height: 50px; text-align: center;">
		<p> 
		<%
		int dataCount = (Integer)request.getAttribute("totalNum");
		
		if(dataCount != 0)
		{
		%>
			${pageIndexList}
		<%
		}
		else
		{
		%>
			등록된 게시물이 존재하지 않습니다.
		<%
		}
		%>
		</p>
	</div>
</div>

<!-- script -->
<script type="text/javascript">
   
   /* $("input:checkbox[name='selectBest']:checkbox[value='"+userThema[i]+"']").prop('checked', true); */
   $("#selectBest").val("${selectValue}").prop("selected", true);

   function change1(obj) {
      obj.style.color = 'rgb(60,127,68)';
   }
   function change2(obj) {
      obj.style.color = 'gray';
   }


   $("#selectBest").change(function() {
      
      var selectValue = $("#selectBest").val();
      
      location.href="<%=cp %>/themalistsf.do?selectValue="+selectValue;
                  
      
   });
   
</script>

