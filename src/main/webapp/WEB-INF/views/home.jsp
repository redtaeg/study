<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><script src="/resources/css/assets/js/color-modes.js"></script>

    <script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>운동 EASY 메인</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/carousel/">

    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">


        <script src="/resources/css/trainer/checkout.js"></script>
    <script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script>
    <link href="/resources/css/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/trainer/sign-in.css" rel="stylesheet">
    

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
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
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
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

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }

      .bd-mode-toggle {
        z-index: 1500;
      }

      .bd-mode-toggle .dropdown-menu .active .bi {
        display: block !important;
      }
      
      h2 {
       text-align: center;
       font-weight: bold;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="/resources/css/trainer/carousel.css" rel="stylesheet">
  </head>
  <body>

  <jsp:include page="nav/user_nav.jsp" />
  
    <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
      <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
      </symbol>
    </svg>

    <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
      <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
              id="bd-theme"
              type="button"
              aria-expanded="false"
              data-bs-toggle="dropdown"
              aria-label="Toggle theme (auto)">
        <svg class="bi my-1 theme-icon-active" width="1em" height="1em"><use href="#circle-half"></use></svg>
        <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
      </button>
      <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#sun-fill"></use></svg>
            Light
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
            Dark
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto" aria-pressed="true">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#circle-half"></use></svg>
            Auto
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
      </ul>
    </div>



<main style="min-height:700px">

  <div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
      <img class="d-block mx-auto mb-4" src="/resources/img/main1.jpg" alt="캐로셀1" width="100%">
        <!-- <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg> -->
        <div class="container">
          <div class="carousel-caption text-start">
            <h1>운동, 어렵게 생각하지 마세요.</h1>
            <p class="opacity-75">"운동은 건강한 생활의 핵심이다." - 로버트 케네디</p>
            <p> <br> </p>
            <p> <br> </p>
            <p> <br> </p>
            <!-- <p><a class="btn btn-lg btn-primary" href="#">운동easy 공지사항</a></p> -->
          </div>
        </div>
      </div>
      <div class="carousel-item">
            <img class="d-block mx-auto mb-4" src="/resources/img/main2.jpg" alt="캐로셀2" width="100%">
        <!-- <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg> -->
        <div class="container">
          <div class="carousel-caption">
            <h1>오늘부터 시작할까요?</h1>
            <p>"운동은 건강한 삶을 살기 위한 기초이며, 더 나은 삶을 위한 투자이다." - 키아누 리브스</p>
            <p> <br> </p>
            <p> <br> </p>
            <!-- <p><a class="btn btn-lg btn-primary" href="/con/conlist">모든 영상 보기</a></p> -->
          </div>
        </div>
      </div>
      <div class="carousel-item">
   <img class="d-block mx-auto mb-4" src="/resources/img/main3.jpg" alt="캐로셀3" width="100%">      
        <!-- <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg> -->
        <div class="container">
          <div class="carousel-caption text-end">
            <h1>행복하고 건강해지는 법.</h1>
            <p>"운동은 우리가 행복하고 건강한 삶을 살 수 있게 하는 일종의 약이다." - 오스카 와일드</p>
            <p><a class="btn btn-lg btn-primary" href="/admin/notice_list">운동easy 공지사항</a></p>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>


  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

<!-- ----------------------------------------------------------------영상 리스트 시작 --------------------------------------------------------- -->
<!-- ----------------------------------------------------------------영상 리스트 시작 --------------------------------------------------------- -->
	
	  <div class="album py-5 bg-body-tertiary">
  	<h2>컨텐츠</h2>
	<br>
	<div class="container">

			<c:if test="${contentsList == null}">
				<section class="py-5 text-center container">
					<div class="row py-lg-5">
						<div class="col-lg-6 col-md-8 mx-auto">
							<h1 class="fw-bold">등록된 영상이 없습니다!</h1>

						</div>
					</div>
				</section>
			</c:if>
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
      <c:forEach var="conlist" items="${contentsList}">
        <div class="col">
          <div class="card shadow-sm">
            <!-- <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg> -->
            		<c:url value="/videos/${conlist.ez_con_video}" var="videoUrl"/>
          			<video src="${videoUrl}" ></video>
            <!-- C:/library/upload/ -->
            <div class="card-body">
              <p class="card-text">${conlist.ez_con_title}</p>
<%--               <p class="card-text">영상정보 : ${conlist.ez_con_info}</p> --%>
              <p class="card-text">키워드 : ${conlist.ez_con_keyword}</p>
              <p class="card-text">운동난이도 : ${conlist.ez_con_level}</p>
              <p class="card-text">업로드 날짜 : ${conlist.ez_con_mod_date.substring(0,10)}</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group"> 
                  <button type="button" class="btn btn-sm btn-outline-secondary">
                   	 <c:url value='/con/condetail' var='detail_url'>   <!-- tr 상세포기 페이지로 이동 (param trid) -->
				        <c:param name='ez_con_no' value='${conlist.ez_con_no}'/>
				    </c:url>
  					 <a href="${detail_url}" class="btn btn-sm btn-outline-danger">상세보기</a>
                  </button>
                  
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


    
<!-- ----------------------------------------------------------------영상 리스트 끝 --------------------------------------------------------- -->
<!-- ----------------------------------------------------------------영상 리스트 끝 --------------------------------------------------------- -->

	<hr class="featurette-divider">

<!-- ----------------------------------------------------------------트레이너 출력 시작  --------------------------------------------------------- -->
<!-- ----------------------------------------------------------------트레이너 출력 시작  --------------------------------------------------------- -->
	
		<div class="container marketing">
		
	<h2>트레이너</h2>
	<br>
			<!-- Three columns of text below the carousel -->
			<div class="row">

			<c:if test="${trainerDos == null}">
				<section class="py-5 text-center container">
					<div class="row py-lg-5">
						<div class="col-lg-6 col-md-8 mx-auto">
							<h1 class="fw-bold">등록된 트레이너가 없습니다!</h1>

						</div>
					</div>
				</section>
			</c:if>

				<c:forEach var="trlist" items="${trainerDos}">
					<div class="col-lg-4">
						<c:url value="/images/${trlist.ez_tr_user_photo}"  var = "profile"/>
						<img src = "${profile}" width="40%" height="40%" fill="var(--bs-secondary-color)" />
						<br>
						<h4 class="fw-bold">${trlist.ez_tr_user_name}</h4>
<%-- 						<p>${trlist.ez_tr_user_profile}</p> --%>
						<p>나이 : ${trlist.ez_tr_user_age}</p>
						<p>성별 : ${trlist.ez_tr_user_gender}</p>
						<p>지역 : ${trlist.ez_tr_user_region}</p>
<!-- 						<p>
							<a class="btn btn-secondary" href="#">트레이너 상세보기&raquo;</a>
						</p> -->

						<c:url value='/tr/tr_list_info' var='detail_url'>
							<c:param name="ez_tr_user_id" value='${trlist.ez_tr_user_id}'>
							</c:param>
						</c:url>
						<p>
							<a class="btn btn-secondary" href="${detail_url}">트레이너 상세보기&raquo;</a>
						</p>

<%-- 						<c:url value='/con/condetail' var='detail_url'>
							<c:param name="ez_con_no" value='${conlist.ez_con_no}'>
							</c:param>
						</c:url>
						<button type="button" onclick="location.href='${detail_url}' "
							class="btn btn-sm btn-outline-secondary">상세보기</button> --%>



					</div>
				</c:forEach>


<!-- ----------------------------------------------------------------트레이너 끝  --------------------------------------------------------- -->
<!-- ----------------------------------------------------------------트레이너 끝  --------------------------------------------------------- -->




    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


  <!-- FOOTER -->
<jsp:include page="nav/footer.jsp" />
</main>
    
    <!-- <script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script> -->

    </body>
</html>
