<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!doctype html>
<html lang="kr" data-bs-theme="auto">
<head>
<script src="/resources/css/assets/js/color-modes.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
   content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.122.0">
<title>운동 EASY - 트레이너 회원가입</title>

<link rel="canonical"
   href="https://getbootstrap.com/docs/5.3/examples/checkout/">


<script
   src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
   integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
   crossorigin="anonymous"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
   integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
   crossorigin="anonymous"></script>
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<script src="/resources/css/trainer/checkout.js"></script>
</body>
<script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script>
<link href="/resources/css/assets/dist/css/bootstrap.min.css"
   rel="stylesheet">
<link href="/resources/css/trainer/sign-in.css" rel="stylesheet">


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

.checkbox-item {
   margin-bottom: 10px;
}

.form-check-label {
   padding-right: 10px;
}
</style>


<!-- Custom styles for this template -->
<link href="/resources/css/trainer/checkout.css" rel="stylesheet">
</head>
<body class="bg-body-tertiary">
   <!--   <header data-bs-theme="dark">
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
   <jsp:include page="../nav/user_nav.jsp" />
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


      <main>
   <div class="container">  <!-- 1 -->

         <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/resources/img/ez_easy1.png"
               alt="운동EASY" width="150" height="36">
            <h2>트레이너 회원가입</h2>
            <p class="lead"></p>
         </div>

         <div class="row justify-content-center g-5">  <!-- 2 -->
            <div class="col-md-7 col-lg-8">
               <h4 class="mb-3">정보를 입력하세요</h4>
               <form method="post" action="/tr/tr_confirm_member"
                  class="needs-validation" novalidate onsubmit="return validateForm();" 
                   enctype="multipart/form-data" name="tr_user_create_form" >

                     <div class="row g-3">
                        <div class="col-12">
                           <label for="trusername" class="form-label">이름</label>
                           <div class="input-group has-validation">
                              <input type="text" class="form-control" id="trusername"
                                 placeholder="이름" required name="ez_tr_user_name">
                              <div class="invalid-feedback">이름을 입력하지 않았습니다</div>
                           </div>
                        </div>

                        <div class="col-12">
                           <label for="userage" class="form-label">나이</label>
                           <div class="input-group has-validation">
                              <input type="text" class="form-control" id="userage"
                                 placeholder="나이" required name="ez_tr_user_age">
                              <div class="invalid-feedback">나이를 입력하지 않았습니다</div>
                           </div>
                        </div>

                        <div class="col-12">
                           <label for="usergender" class="form-label">성별</label>
                           <div class="form-check">
                              <input class="form-check-input" type="radio"
                                 id="flexRadioMale" name="ez_tr_user_gender" value="남자" checked>
                              <label class="form-check-label" for="flexRadioMale">
                                 남자 </label>
                           </div>
                           <div class="form-check">
                              <input class="form-check-input" type="radio"
                                 id="flexRadioFemale" name="ez_tr_user_gender" value="여자">
                              <label class="form-check-label" for="flexRadioFemale">
                                 여자 </label>
                           </div>
                        </div>

                        <div class="col-12">
                           <label for="userid" class="form-label">아이디</label>
                           <div class="input-group has-validation">
                              <input type="text" class="form-control" id="userid"
                                 placeholder="ID" required name="ez_tr_user_id">
                              <div class="invalid-feedback">아이디를 입력하지 않았습니다</div>
                              <a class="btn btn-primary" onclick = "checkId()">중복확인</a>
                           </div>
                        </div>
                        


                        <div class="col-12">
                           <label for="ez_user_pw" class="form-label">비밀번호</label>
                           <div class="input-group has-validation">
                              <input type="password" class="form-control" id="ez_tr_user_pw"
                                 placeholder="비밀번호" required name="ez_tr_user_pw">
                              <div class="invalid-feedback">비밀번호를 입력하지 않았습니다</div>
                           </div>
                        </div>

                        <div class="col-12">
                           <label for="ez_user_pw2" class="form-label">비밀번호 확인</label>
                           <div class="input-group has-validation">
                              <input type="password" class="form-control" id="ez_tr_user_pw2"
                                 placeholder="비밀번호 재입력" required name="ez_tr_user_pw2">
                              <div class="invalid-feedback">비밀번호를 입력하지 않았습니다> </div>
                              <div id="pw_match_error" class="invalid-feedback"
                                 style="display: none;">비밀번호가 일치하지 않습니다.</div>
                           </div>
                        </div>

                        <div class="col-12">
                           <label for="userphone" class="form-label">핸드폰</label>
                           <div class="input-group has-validation">

                              <input type="text" class="form-control" id="userphone"
                                 placeholder="휴대폰 번호" required name="ez_tr_user_phone">
                              <div class="invalid-feedback">핸드폰번호를 입력하지 않았습니다</div>
                           </div>
                        </div>
                        

                        <div class="col-12">
                           <label for="usermail" class="form-label">이메일</label>
                           <div class="input-group has-validation">
                              <input type="email" class="form-control" id="usermail"
                                 placeholder="이메일 주소" required name="ez_tr_user_mail">
                              <div class="invalid-feedback">이메일을 입력하지 않았습니다</div>
                           </div>
                        </div>

                        <div class="col-12">
                           <label for="userregion" class="form-label">주소</label>
                           <div class="input-group has-validation">
                              <input type="text" class="form-control" id="userregion"
                                 placeholder="지역" required name="ez_tr_user_region">
                              <div class="invalid-feedback">주소를 입력하지 않았습니다</div>
                           </div>
                        </div>

                        <!-- 관심운동 체크박스 -->
                        <div class="col-12">
                           <label for="ez_user_keyword" class="form-label">관심분야</label>
                           <div class="input-group has-validation">
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="upper" name="ez_tr_user_keyword" value="상체" checked> <label
                                    class="form-check-label" for="upper" >상체 </label>
                              </div>
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="arm" name="ez_tr_user_keyword" value="팔" > <label
                                    class="form-check-label" for="arm">팔 </label>
                              </div>
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="belly" name="ez_tr_user_keyword" value="복부"> <label
                                    class="form-check-label" for="belly">복부 </label>
                              </div>
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="lower" name="ez_tr_user_keyword" value="하체"> <label
                                    class="form-check-label" for="lower">하체 </label>
                              </div>
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="cardio" name="ez_tr_user_keyword" value="유산소"> <label
                                    class="form-check-label" for="cardio">유산소 </label>
                              </div>
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="diet" name="ez_tr_user_keyword" value="다이어트"> <label
                                    class="form-check-label" for="diet">다이어트 </label>
                              </div>
                              <div class="form-check form-switch">
                                 <input class="form-check-input" type="checkbox" role="switch"
                                    id="stretching" name="ez_tr_user_keyword" value="스트레칭">
                                 <label class="form-check-label" for="stretching">스트레칭
                                 </label>
                              </div>
                              <div class="invalid-feedback">관심 분야를 선택하세요</div>
                           </div>
                        </div>



                        <!-- 한줄소개 텍스트 에어리아 -->
                        <div class="col-12">
                           <label for="userprofile" class="form-label">간단한 한 줄 소개</label>
                           <div class="input-group has-validation">
                              <textarea id="ez_tr_user_profile" cols="20" rows="5"
                                 class="form-control" id="userprofile"
                                 placeholder="한 줄 소개를 입력하세요" required style="resize: none;"
                                 name="ez_tr_user_profile"></textarea>
                              <div class="invalid-feedback">한줄소개를 입력하세요</div>
                           </div>
                        </div>

                        <!-- 이력 텍스트 에어리아 -->
                        <div class="col-12">
                           <label for="usercareer" class="form-label">이력을 작성하세요</label>
                           <div class="input-group has-validation">
                              <textarea id="ez_tr_user_career" cols="20" rows="5"
                                 class="form-control" id="usercareer" placeholder="이력을 입력하세요"
                                 required style="resize: none;" name="ez_tr_user_career"></textarea>
                              <div class="invalid-feedback">이력을 작성하세요</div>
                           </div>
                        </div>


                        <!--       프로필 이미지 -->
                        <div class="col-12">
                           <label for="userphoto" class="form-label">프로필사진</label>
                           <div class="input-group has-validation">
                              <div class="input-group mb-3">
                                 <input type="file" class="form-control" id="userphoto" required name="file1">
                                 <div id="profile_error" class="invalid-feedback" style="display: none;">
                                	 프로필 이미지를 선택해주세요.
                                 </div>
                              </div>
                              <div id="profile_type_error" class="invalid-feedback" style="display: none;">
                             	 프로필 이미지는 jpg, jpeg, png 형식이어야 합니다.
                              </div>
                           </div>
                        </div>

                        
                        
                        
                        <!--       첨부파일 -->
                        <div class="col-12">
                           <label for="userimage" class="form-label">첨부파일</label>
                           <div class="input-group has-validation">
                              <div class="input-group mb-3">
                                 <input type="file" class="form-control" id="userimage" required name="file2">
                                 <div id="image_error" class="invalid-feedback" style="display: none;">
                                 	첨부 파일을 선택해주세요.
                                 </div>
                              </div>
                           </div>
                           
                       </div>

                     </div>
            <!--           <hr class="my-4"> -->
            <button class="w-100 btn btn-primary btn-lg" type="submit" style="margin-top:15px">트레이너로
               회원가입하기</button>
               
            </form>
         </div>
         
                                           <script type="text/javascript">
                           function checkId() {
                        	  var userId = document.getElementById("userid").value;
							 var xhr = new XMLHttpRequest();
							 xhr.open("POST", "/tr/checkId", true); /* post 방식, 경로,  */
							 xhr.setRequestHeader( "Content-Type", "application/json"); /* 제이슨 형식으로 설정 */
							 xhr.onreadystatechange = function(){  /* 변화하는 요청을 실시간으로 감지하여 처리 */
								 if(xhr.readyState === XMLHttpRequest.DONE) {  /* 상태가 4(done) */
									 if(xhr.status === 200){
										 var isDuplicate = JSON.parse(xhr.responseText);  /* 제이슨 형식으로 파싱  "isDuplicate": 리턴값(트루,펄스) */
							               if (isDuplicate) {
							                    alert("이미 사용중인 아이디입니다.");
							                } else {
							                    alert("사용 가능한 아이디입니다.");
							                }
							            } else {
							                alert("오류가 발생했습니다. 다시 시도해주세요.");
							            }
							        }
							    };
							    xhr.send(userId); // JSON.stringify()를 사용하지 않고 그대로 userId를 전달
						   }
                        </script>
         
           <script type="text/javascript">
                           function validateForm() {
                              console.log('유저 회원가입 정보 스크립트 확인');

                              let form = document.tr_user_create_form;
                              let password = form.ez_tr_user_pw.value;
                              let confirmPassword = form.ez_tr_user_pw2.value;

                              // 비밀번호 일치 여부 검사
                              if (password !== confirmPassword) {
                                 document
                                       .getElementById('pw_match_error').style.display = 'block';
                                 form.ez_tr_user_pw2.focus();
                                 return false;
                              } else {
                                 document
                                       .getElementById('pw_match_error').style.display = 'none';
                              }
                              
                                  // 프로필 이미지 파일 첨부 필드 유효성 검사
                                let profileFileInput = document.getElementById('userphoto');
                                let profileFile = profileFileInput.files[0];
                                if (!profileFile) {
                                      document.getElementById('profile_error').style.display = 'block';
                                       return false;
                                }else{
                                   document.getElementById('profile_error').style.display = 'none';
                                }
                                
                                
                                let profileFileName = profileFile.name;
                                let profileFileExtension = profileFileName.split('.').pop().toLowerCase();
                                if (profileFileExtension !== 'jpg' && profileFileExtension !== 'jpeg' && profileFileExtension !== 'png') {
                                    document.getElementById('profile_type_error').style.display = 'block';
                                    return false;
                                }else{
                                   document.getElementById('profile_type_error').style.display = 'none';
                                }

                                
                                // 증빙서류 필드 유효성 검사
                                let attachmentFileInput = document.getElementById('userimage');
                                let attachmentFile = attachmentFileInput.files[0];
                                if (!attachmentFile) {
                                    document.getElementById('image_error').style.display = 'block';
                                    return false;
                                }else{
                                   document.getElementById('image_error').style.display = 'none';
                                }
                                
                                
                                let attachmentFileName = attachmentFile.name;
                                let attachmentFileExtension = attachmentFileName.split('.').pop().toLowerCase();

                                
                              return true; // 모든 유효성 검사 통과 시 폼 제출
                           }
                        </script>
         </div> <!-- 2 -->
   </div> <!-- 1 -->
   </main>

<jsp:include page="../nav/footer.jsp" />

<!--    <footer class="my-5 pt-5 text-body-secondary text-center text-small">
      <p class="mb-1">&copy; 2024 운동easy</p>
      <ul class="list-inline">
         <li class="list-inline-item"><a href="#">Privacy</a></li>
         <li class="list-inline-item"><a href="#">Terms</a></li>
         <li class="list-inline-item"><a href="#">Support</a></li>
      </ul>
   </footer> -->
   </div>
   <script src="/resources/css/trainer/checkout.js"></script>
</body>
<!-- <script src="/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script> -->
<link href="/resources/css/assets/dist/css/bootstrap.min.css"
   rel="stylesheet">
<link href="/resources/css/trainer/sign-in.css" rel="stylesheet">
</html>