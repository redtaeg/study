<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="kr" data-bs-theme="auto">
<header data-bs-theme="dark">

	<nav class="navbar navbar-expand-md navbar-dark bg-dark"
		aria-label="Fourth navbar example">
		<div class="container-fluid">
		
			<c:if test="${!empty loginedUserDo}">
				<a class="navbar-brand" href="/ez/home" style="padding-top:0;">
				<img src="/resources/img/ez_easy3.png"
					alt="운동EASY" width="100" height="27"></a>
			</c:if>
			
			<c:if test="${!empty loginedTrDo}">
				<a class="navbar-brand" href="/tr/tr_main" style="padding-top:0;">
				<img src="/resources/img/ez_easy3.png"
					alt="운동EASY" width="100" height="27">
				</a>
			</c:if>
			
			<c:if test="${empty loginedUserDo and empty loginedTrDo}">
				<a class="navbar-brand" href="/user/user_main" style="padding-top:0;">
				<img src="/resources/img/ez_easy3.png"
					alt="운동EASY" width="100" height="27">
				</a>
			</c:if>

					
			
			
			
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarsExample04"
				aria-controls="navbarsExample04" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>


			<div class="collapse navbar-collapse" id="navbarsExample04">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/con/conlist">운동영상</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/tr/tr_list">트레이너</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/con/conlist_other_2">스트레칭</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						data-bs-toggle="dropdown" aria-expanded="false">근력운동</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/con/conlist_strength_1">상체</a></li>
							<li><a class="dropdown-item" href="/con/conlist_strength_2">하체</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						data-bs-toggle="dropdown" aria-expanded="false">기타</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/con/conlist_other_1">다이어트</a></li>
							<li><a class="dropdown-item" href="/con/conlist_other_2">스트레칭</a></li>
							<li><a class="dropdown-item" href="/con/conlist_other_3">유산소</a></li>
							<li><a class="dropdown-item" href="/con/conlist_other_4">재활</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/admin/notice_list">공지사항</a></li>
					<c:if test="${loginedTrDo.ez_tr_user_id eq 'super admin'}">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/admin/trList">트레이너관리</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/admin/contentsList">영상관리</a></li>
			       </c:if>

                     <!-- 유저 로그인 정보가 있을때 (유저 로그인시) -->
					<c:if test="${!empty loginedUserDo}">  
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/user/user_fav_con"> 마이페이지 </a></li>
						
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/user/logoutConfirm"> 로그아웃 </a></li>
							
						<li class="nav-item">
							<a class="nav-link active"aria-current="page" href="#">      
								${loginedUserDo.ez_user_name} 님, 방문을 환영합니다!
							</a> 
						</li>
					</c:if>

					 <!-- 유저 로그인 정보가 있고  (트레이너 로그인시) -->
					<c:if test="${!empty loginedTrDo and  !(loginedTrDo.ez_tr_user_id eq 'super admin')}">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/tr/tr_selfconlist"> 마이페이지 </a></li>
							
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/tr/logoutConfirm"> 로그아웃 </a></li>
						
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">        트레이너
							${loginedTrDo.ez_tr_user_name} 님, 방문을 환영합니다!</a> <%-- <p class="nav-link active" aria-current="page">트레이너 ${loginedTrDo.ez_tr_user_name} 님, 방문을 환영합니다!</p> --%>
						</li>
					</c:if>
					
					
					 <!-- 트레이너 로그인 아이디가 슈퍼어드민일때 (관리자 로그인) -->
					<c:if test="${loginedTrDo.ez_tr_user_id eq 'super admin'}">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/admin/contents_report_List"> 신고영상관리 </a></li>
							
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/tr/logoutConfirm"> 로그아웃 </a></li>
							
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">       관리자
							${loginedTrDo.ez_tr_user_name} 님, 방문을 환영합니다!</a> <%-- <p class="nav-link active" aria-current="page">트레이너 ${loginedTrDo.ez_tr_user_name} 님, 방문을 환영합니다!</p> --%>
						</li>
					</c:if>
					
					<c:if test="${empty loginedUserDo and empty loginedTrDo}">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/ez/login_route"> 로그인/회원가입 </a></li>
					</c:if>


				</ul>
				<form role="search" method="get" action="/con/search_con">
				    <div class="input-group">
  					<input class="form-control" type="search" placeholder="Search" aria-label="Search" name="search_name" style="width: 400px;">
  					<button class="btn btn-outline-secondary" type="submit">
            		<img src="/resources/img/search.png" alt="search icon" width="20" height="20">
       				</button>
				</div>
				</form>
			</div>
		</div>
	</nav>
</header>