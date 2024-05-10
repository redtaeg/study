<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="kr" data-bs-theme="auto">
  <head><script src="/resources/css/assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>Carousel Template · Bootstrap v5.3</title>

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
      a {
  	  text-decoration: none;
  	  }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="/resources/css/trainer/carousel.css" rel="stylesheet">
  </head>
  <body>
    <jsp:include page="../nav/user_nav.jsp" />
 <!--  <header data-bs-theme="dark">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">HOME</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample04">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">모든 영상</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">트레이너</a>
          </li>
                    <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">스트레칭</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">상체</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">하체</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
        <form role="search">
          <input class="form-control" type="search" placeholder="Search" aria-label="Search">
        </form>
      </div>
    </div>
  </nav>
</header> -->
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


<main>

  <div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
   <!--  <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption text-start">
            <h1>Example headline.</h1>
            <p class="opacity-75">Some representative placeholder content for the first slide of the carousel.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Sign up today</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption">
            <h1>Another example headline.</h1>
            <p>Some representative placeholder content for the second slide of the carousel.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Learn more</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="var(--bs-secondary-color)"/></svg>
        <div class="container">
          <div class="carousel-caption text-end">
            <h1>One more for good measure.</h1>
            <p>Some representative placeholder content for the third slide of this carousel.</p>
            <p><a class="btn btn-lg btn-primary" href="#">Browse gallery</a></p>
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
    </button> -->
  </div>


  <!-- Marketing messaging and featurettes
  ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing" style="min-height:700px">

    <!-- Three columns of text below the carousel -->
    <div class="row featurette">
      <div class="col-md-6">
 <!-- 제목 -->
    <h2 class="fw-normal">${contentsDo.ez_con_title}</h2>
	<br>
    <!-- 작성자 / 등록일 -->
    <p class="lead">
       <c:url value='/tr/tr_list_info' var='detail_tr_url'>
          <c:param name='ez_tr_user_id' value='${contentsDo.trainerDo.ez_tr_user_id}'/>
       </c:url>
        작성자 : <a href="${detail_tr_url}" style="text-decoration: none; font-weight: bold;">${contentsDo.ez_con_tr_name}</a>
        <span style="float: right;">${contentsDo.ez_con_reg_date.substring(0,10)}</span>
    </p>

    <!-- 키워드 / 레벨 -->
    <p class="lead"> 키워드 : ${contentsDo.ez_con_keyword}</p>
    <p class="lead">레벨 : ${contentsDo.ez_con_level}</p>

    <!-- 내용 -->  
     <p class="lead">   </p><br>
    <p class="lead">${contentsDo.ez_con_info}</p>

      
        
        
         <!-- 유저 로그인 정보가 있을때 (유저 로그인시) -->
		<c:if test="${!empty loginedUserDo}">  
<c:url value='/user/user_fav_con_confirm' var='addFavCon_url'>
    <c:param name='ez_con_no' value='${contentsDo.ez_con_no}'/>
</c:url>

<!-- 즐겨찾기 버튼 -->
<a href="${addFavCon_url}" class="btn btn-primary" onclick="toggleFavorite();">즐겨찾기</a>

<script>
    var ez_con_no = '${ez_con_no}';
    var ez_user_id = '${loginedUserDo.ez_user_id}';
    var isFavoritecon = localStorage.getItem(ez_con_no + ez_user_id + '_favorite') === 'true'; // 수정: 누락된 '+' 추가

    updateButtonText();

    function toggleFavorite() {
        isFavoritecon = !isFavoritecon;
        localStorage.setItem(ez_con_no + ez_user_id + '_favorite', isFavoritecon);
        updateButtonText();
    }

    function updateButtonText() {
        var button = document.querySelector('.btn-primary');
        if (isFavoritecon) {
            button.textContent = '즐겨찾기 취소';
        } else {
            button.textContent = '즐겨찾기';
        }
    }
</script>
        </c:if>
        
                <!-- ----jsp세션에 따라서 보이기--- -->
			<c:if test="${!empty loginedTrDo and !(loginedTrDo.ez_tr_user_id eq 'super admin') and contentsDo.trainerDo.ez_tr_user_id eq loginedTrDo.ez_tr_user_id}">
        
            		<c:url value='/con/contents_del' var='delete_url'>
					  <c:param name='ez_con_no' value='${contentsDo.ez_con_no}'/>
					</c:url>

		
		<script>
        function Delalret(ez_con_no){
        	
          if(confirm( "${contentsDo.ez_con_title}" + " 영상을 삭제하시겠습니까?") == true){
        	location.href='/con/contents_del?ez_con_no='+${contentsDo.ez_con_no}; 
          }
          else {
        	  return false;
          }
        }
      </script>
      
      <a onclick="Delalret(${contentsDo.ez_con_no})" class="btn btn-danger">삭제</a>
      
        <!-- <button >삭제</button> -->
        <%-- <a href="${delete_url}">삭제</a> --%>
       </c:if>
       
       <!-- ------------------------------------- -->
       
       
       
        <c:if test="${loginedTrDo.ez_tr_user_id eq 'super admin'}">
            		<c:url value='/admin/contents_del' var='delete_url'>
					  <c:param name='ez_con_no' value='${contentsDo.ez_con_no}'/>
					</c:url>
        
		<script>
        function Delalret(ez_con_no){
        	
          if(confirm( "${contentsDo.ez_con_title}" + " 영상을 삭제하시겠습니까?") == true){
        	location.href='/admin/contents_del?ez_con_no='+${contentsDo.ez_con_no}; 
          }
          else {
        	  return false;
          }
        }
      </script>
      <a onclick="Delalret(${contentsDo.ez_con_no})" class="btn btn-danger">삭제</a>
        <!-- <button >삭제</button> -->
        <%-- <a href="${delete_url}">삭제</a> --%>
       </c:if>
     
     	<!-- --------------- -->


		<c:url value='/con/content_report' var='report_con_url'>
			<c:param name='ez_con_no' value='${contentsDo.ez_con_no}' />
		</c:url>


<%-- 		<c:if
			test="${!empty loginedTrDo and !(loginedTrDo.ez_tr_user_id eq 'super admin') or !empty loginedUserDo }">
			<a href="${report_con_url}" class="btn btn-danger">신고하기</a>
			
		</c:if> --%>
		<script>
			function confirmReport() {
			    var confirmed = confirm('정말로 신고하시겠습니까?');
			    if (confirmed) {
			        alert('신고가 완료되었습니다.');
			        return true;
			    } else {
			        alert('신고가 취소되었습니다.');
			        return false;
			    }
			}
		</script>
		<c:if test="${!empty loginedTrDo and !(loginedTrDo.ez_tr_user_id eq 'super admin') or !empty loginedUserDo}">
		    <a href="${report_con_url}" class="btn btn-danger" onclick="return confirmReport()">신고하기</a>
		</c:if>
		
		<a href="/con/conlist" class="btn btn-primary">목록</a>

		<!-- --------------- -->
      </div>
      
      <div class="col-md-5">
      <!-- 트레이너 이미지 출력 구간 -->
		<c:url value="/videos/${contentsDo.ez_con_video}" var="videoUrl"/>
		<video src="${videoUrl}"  controls width = "700px"  height = "400px" style=" padding-top: 10px"></video>

		    <!-- 다른 비디오 포맷에 대한 추가 <source> 태그들 -->
<!-- 		</video> -->
      <!-- 트레이너 이미지 출력 구간 -->  
      </div>
    </div>


    

    <hr class="featurette-divider">

    <!-- /END THE FEATURETTES -->

  </div><!-- /.container -->


<jsp:include page="../nav/footer.jsp" />
  <!-- FOOTER -->
<!--   <footer class="container">
    <p class="float-end"><a href="#">Back to top</a></p>
    <p>&copy; 2017–2024 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
  </footer> -->
</main>
    </body>
</html>
