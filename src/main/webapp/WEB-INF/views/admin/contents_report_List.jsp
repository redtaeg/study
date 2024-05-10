 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!doctype html>
<html lang="en" data-bs-theme="auto">
 <head>
 	<script src="/resources/css/assets/js/color-modes.js"></script>
    <script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
 </head>

 
  <body class=" m-0 border-0 bd-example m-0 border-0"  style="min-height:700px; padding:0" >
   	<jsp:include page="../nav/user_nav.jsp" />
	<div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="/resources/img/ez_easy1.png" alt="운동EASY" width="150" height="36">
      <p class="lead"></p>
      <h2>신고 영상 목록</h2>
    </div>
    <div  style="min-height: 600px;">
 	 <c:if test="${contentsDos == null}">
			<section class="py-5 text-center container">
				<div class="row py-lg-5">
					<div class="col-lg-6 col-md-8 mx-auto">
						<h1 class="fw-bold">신고된 영상이 없습니다!</h1>

					</div>
				</div>
			</section>
	</c:if>
	<c:if test="${contentsDos != null}">
  	<table class="table">
      <thead>
        <tr>
          <th scope="col">영상번호</th>
          <th scope="col">제목</th>
          <th scope="col">아이디</th>
          <th scope="col">등록자</th>
          <th scope="col">영상소개</th>
          <th scope="col">영상키워드</th>
          <th scope="col">업로드 날짜</th>
          <th scope="col">수정 날짜</th>
          <th scope="col">삭제</th>
        </tr>
        
       
      </thead>
      	<tbody class="table-group-divider">
    	  <c:forEach var="item" items="${contentsDos}">  
       		 <tr>
		          <td>${item.ez_con_no}</td>
				  <td>
					<c:url value='/con/condetail' var='detail_url'>
						<c:param name='ez_con_no' value='${item.ez_con_no}'/>
					</c:url>
					<a href="${detail_url}" style="text-decoration: none; font-weight: bold;">${item.ez_con_title}</a>
				  </td>
		           <td>${item.trainerDo.ez_tr_user_id}</td>
		          <td>${item.ez_con_tr_name}</td>
		          <td>${item.ez_con_info}</td>
		          <td>${item.ez_con_keyword}</td>
		          <td>${item.ez_con_reg_date}</td>
		   		  <td>${item.ez_con_mod_date}</td>
		          <td>
    		   		<c:url value='/admin/contents_del' var='delete_url'>
					  <c:param name='ez_con_no' value='${item.ez_con_no}'/>
					</c:url>
		        	<a href="${delete_url}" class="btn btn-danger" onclick="return confirm('정말로 삭제하시겠습니까?')">삭제</a>
		          </td>
        	 </tr>
         </c:forEach>
      </tbody>
    </table>
    </c:if>
    </div>
    

<jsp:include page="../nav/footer.jsp" />
</body>
</html>