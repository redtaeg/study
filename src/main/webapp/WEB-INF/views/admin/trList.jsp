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

  <body class="m-0 border-0 bd-example m-0 border-0" style="padding:0">
   	<jsp:include page="../nav/user_nav.jsp" />
	<div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="/resources/img/ez_easy1.png" alt="운동EASY" width="150" height="36">
      <h2>트레이너 목록</h2>
      <p class="lead"></p>
    </div>
    
  	 <div class="container markerting" style = "min-height:600px;">
  	<table class="table">
      <thead>
        <tr>
          <th scope="col">이름</th>
          <th scope="col">성별</th>
          <th scope="col">아이디</th>
          <th scope="col">핸드폰</th>
          <th scope="col">가입 날짜</th>
          <th scope="col">승인</th>
        </tr>
      </thead>
      <tbody class="table-group-divider">
   	 	<c:forEach var="trainer" items="${trainerDos}">  
        	<tr>
	          <td>
        	<c:url value ='/tr/tr_list_info_ad' var = 'trInfo_url'>
	          		<c:param name = 'ez_tr_user_id' value = '${trainer.ez_tr_user_id}'/>
	         	</c:url>

	         	<a href="${trInfo_url}" style="text-decoration: none; font-weight: bold;">${trainer.ez_tr_user_name}</a>
	          </td>
	          <td>${trainer.ez_tr_user_gender}</td>
	          <td>${trainer.ez_tr_user_id}</td>
	          <td>${trainer.ez_tr_user_phone}</td>
	          <td>${trainer.ez_tr_user_reg_date}</td>
	          <td>
				<c:choose>
					<c:when test="${trainer.ez_tr_user_approval eq 0}">
						<c:url value='/admin/setAdminApproval' var='approval_url'>
							<c:param name='ez_tr_user_id' value='${trainer.ez_tr_user_id}'/>
						</c:url>
						<a href="${approval_url}" class="btn btn-primary">승인처리</a>
					</c:when>
					
					<c:otherwise>
						<c:url value='/admin/outAdminApproval' var='outApproval_url'>
							<c:param name='ez_tr_user_id' value='${trainer.ez_tr_user_id}'/>
						</c:url>
						<a href="${outApproval_url}" class="btn btn-danger">승인취소</a>
					</c:otherwise>
				</c:choose>
			  </td>
       		 </tr>
         </c:forEach>
      </tbody>
    </table>
    </div>
<jsp:include page="../nav/footer.jsp" />
</body>
</html>