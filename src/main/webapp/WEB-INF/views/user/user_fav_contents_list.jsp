<%@page import="com.example.demo.contents.ContentsDo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="kr" data-bs-theme="auto">
<script src="/resources/css/assets/js/color-modes.js"></script>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.122.0">
<title>운동 EASY - 사용자 즐겨찾기 리스트</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/album/">

<!-- <script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script> -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<link href="/resources/css/assets/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	width: 100%;
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

.btn-bd-primary { -
	-bd-violet-bg: #712cf9; -
	-bd-violet-rgb: 112.520718, 44.062154, 249.437846; -
	-bs-btn-font-weight: 600; -
	-bs-btn-color: var(- -bs-white); -
	-bs-btn-bg: var(- -bd-violet-bg); -
	-bs-btn-border-color: var(- -bd-violet-bg); -
	-bs-btn-hover-color: var(- -bs-white); -
	-bs-btn-hover-bg: #6528e0; -
	-bs-btn-hover-border-color: #6528e0; -
	-bs-btn-focus-shadow-rgb: var(- -bd-violet-rgb); -
	-bs-btn-active-color: var(- -bs-btn-hover-color); -
	-bs-btn-active-bg: #5a23c8; -
	-bs-btn-active-border-color: #5a23c8;
}

.bd-mode-toggle {
	z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
	display: block !important;
}

	.side-bar {
	  margin-top: 100px; /* 내비게이션 바의 높이에 맞게 조정하세요 */
	  margin-right: 100px; /* 내비게이션 바의 높이에 맞게 조정하세요 */
	  position: fixed;
	  top: 0;
	  left: 0;
	  width: 300px;
	  height: 100%;
	  background-color: rgba(248, 249, 250, 0); /* 사이드바 배경색 지정 */
	  padding-top: 70px; /* 상단 여백 */
	  display: flex;
	  float: left;
	  flex-direction: column; /* 세로로 아이템을 나열하도록 설정 */
	  align-items: center; /* 아이템을 수직 중앙에 정렬 */
	}
	
	.side-bar button {
	  margin-bottom: 20px; /* 각 버튼 사이의 간격 조정 */
	  width: 200px; /* 버튼을 꽉 차게 만들어 세로 정렬될 수 있도록 함 */
	  display: block; /* 버튼을 블록 요소로 지정하여 줄바꿈이 가능하도록 함 */
	  font-size: 14px;  /* 버튼의 글자 크기 조정 */
	}
	
</style>


</head>
<body>
	<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
      <symbol id="check2" viewBox="0 0 16 16">
        <path
			d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path
			d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z" />
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path
			d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z" />
        <path
			d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z" />
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path
			d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z" />
      </symbol>
    </svg>

	<div
		class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
		<button
			class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
			id="bd-theme" type="button" aria-expanded="false"
			data-bs-toggle="dropdown" aria-label="Toggle theme (auto)">
			<svg class="bi my-1 theme-icon-active" width="1em" height="1em">
				<use href="#circle-half"></use></svg>
			<span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
		</button>
		<ul class="dropdown-menu dropdown-menu-end shadow"
			aria-labelledby="bd-theme-text">
			<li>
				<button type="button"
					class="dropdown-item d-flex align-items-center"
					data-bs-theme-value="light" aria-pressed="false">
					<svg class="bi me-2 opacity-50" width="1em" height="1em">
						<use href="#sun-fill"></use></svg>
					Light
					<svg class="bi ms-auto d-none" width="1em" height="1em">
						<use href="#check2"></use></svg>
				</button>
			</li>
			<li>
				<button type="button"
					class="dropdown-item d-flex align-items-center"
					data-bs-theme-value="dark" aria-pressed="false">
					<svg class="bi me-2 opacity-50" width="1em" height="1em">
						<use href="#moon-stars-fill"></use></svg>
					Dark
					<svg class="bi ms-auto d-none" width="1em" height="1em">
						<use href="#check2"></use></svg>
				</button>
			</li>
			<li>
				<button type="button"
					class="dropdown-item d-flex align-items-center active"
					data-bs-theme-value="auto" aria-pressed="true">
					<svg class="bi me-2 opacity-50" width="1em" height="1em">
						<use href="#circle-half"></use></svg>
					Auto
					<svg class="bi ms-auto d-none" width="1em" height="1em">
						<use href="#check2"></use></svg>
				</button>
			</li>
		</ul>
	</div>


	<jsp:include page="../nav/user_nav.jsp" />

	<main style="min-height:700px">


		<section class="py-5 text-center container">
			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-bold">즐겨찾기한 컨텐츠 목록입니다</h1>
					<p class="lead text-body-secondary">컨텐츠를 클릭해서 시청하세요</p>
				</div>
			</div>
		</section>

		<div class="album py-5 bg-body-tertiary">


			<div class="container">
    <!-- 사이드바 시작 -->
	<div class="side-bar">
	  <a href="/user/user_myPage" style="width: 200px;"><button class="w-100 btn btn-primary btn-lg" type="button">정보수정</button></a>
	  <a href="/user/user_fav_tr" style="width: 200px;"><button class="w-100 btn btn-primary btn-lg" type="button">트레이너 즐겨찾기</button></a>
	  <a href="/user/user_fav_con" style="width: 200px;"><button class="w-100 btn btn-primary btn-lg" type="button">영상 즐겨찾기</button></a>
	  <a href="/apply/apply_applylist" style="width: 200px;"><button class="w-100 btn btn-primary btn-lg" type="button">상담내역</button></a>
	  <a href="/user/logoutConfirm" style="width: 200px;"><button class="w-100 btn btn-primary btn-lg" type="button">로그아웃</button></a>
	</div>
	<!-- 사이드바 끝 -->
	
				<c:if test="${favconDos == null}">
				<section class="py-5 text-center container">
					<div class="row py-lg-5">
						<div class="col-lg-6 col-md-8 mx-auto">
							<h1 class="fw-bold">즐겨찾기한 컨텐츠가 없습니다!</h1>

						</div>
					</div>
				</section>
			</c:if>
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<c:forEach var="favconDos" items="${favconDos}">
						<div class="col">
							<div class="card shadow-sm">
								<!-- <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg> -->
<%-- 								<video
									src="<c:url value="/content/${favconDos.ez_con_video}"></c:url>"></video> --%>
									
									            <c:url value="/videos/${favconDos.ez_con_video}" var="videoUrl"/>
             <video src="${videoUrl}" ></video>
								<!-- C:/library/upload/ -->
								<div class="card-body">
									<p class="card-text"> ${favconDos.ez_con_title}</p>
									<p class="card-text">키워드 : ${favconDos.ez_con_keyword}</p>
									<p class="card-text">운동난이도 : ${favconDos.ez_con_level}</p>
									<p class="card-text">업로드 날짜 : ${favconDos.ez_con_mod_date.substring(0,10)}</p>
									<div class="d-flex justify-content-between align-items-center">
										<div class="btn-group">



											<c:url value='/con/condetail' var='detail_url'>
													<c:param name="ez_con_no" value='${favconDos.ez_con_no}'>
													</c:param>
											</c:url>
														<%-- <a href="${detail_url}">상세보기</a> --%>
													<button type="button" onclick="location.href='${detail_url}'"
														class="btn btn-sm btn-outline-secondary">상세보기
													</button>
											<!-- <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button> -->
										</div>
										<!-- <small class="text-body-secondary">9 mins</small> -->
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>

		</div>


  <!-- 자바스크립트 -->
  <!--     // 메뉴 바를 스크롤과 함께 움직이도록 설정 -->
	  <script>  
	  window.addEventListener("scroll", () => {
	  const sideBar = document.querySelector(".side-bar");
	  sideBar.style.top = `${window.scrollY}px`;
	});
	  </script>

		<!--     <div class="container">

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
            <div class="card-body">
              <p class="card-text">{contentsList.ez_con_info}</p>
              <p class="card-text">{contentsList.ez_con_keyword}</p>
              <p class="card-text">{contentsList.ez_con_level}</p>
              <p class="card-text">{contentsList.ez_con_mod_date}</p>
              <p class="card-text">{contentsList.ez_con_mod_date}</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                </div>
                <small class="text-body-secondary">9 mins</small>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div> -->
		</div>
	</main>

	<!-- <footer class="text-body-secondary py-5">
		<div class="container">
			<p class="float-end mb-1">
				<a href="#">Back to top</a>
			</p>
			<p class="mb-1">Album example is &copy; Bootstrap, but please
				download and customize it for yourself!</p>
			<p class="mb-0">
				New to Bootstrap? <a href="/">Visit the homepage</a> or read our <a
					href="../getting-started/introduction/">getting started guide</a>.
			</p>
		</div>
	</footer> -->
	<jsp:include page="../nav/footer.jsp" />
	<!-- <script src="../assets/dist/js/bootstrap.bundle.min.js"></script> -->



</body>
</html>
