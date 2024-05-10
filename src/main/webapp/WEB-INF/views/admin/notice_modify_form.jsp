<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
    <jsp:include page="../nav/user_nav.jsp" />
  <body>

    <!-- Example Code -->
    <div class="container">
      <main style="min-height:700px">
     
     <div class="py-5 text-center">
	      <img class="d-block mx-auto mb-4" src="/resources/img/ez_easy1.png" alt="운동EASY" width="150" height="36">
	      <h2>공지사항 수정</h2>
	      <p class="lead"></p>
     </div>
         <form method="post" action ="/admin/notice_modify_conFirm">
         <input type="hidden" name="ez_notice_no" id ="ez_notice_no" value ='${noticeDo.ez_notice_no}'>
	    <div class="row justify-content-center col-12">
		   <div class="mb-3"    style="width: 800px;">
		     <label for="ez_notice_title" class="form-label">제목</label>
		     <input type="text" class="form-control" id="ez_notice_title" name = "ez_notice_title"  value='${noticeDo.ez_notice_title}'>
		   </div>
		   
		  <div class="mb-3"  style="width: 800px;">
		     <label for="ez_notice_content" class="form-label">내용</label>
		     <textarea class="form-control" id="ez_notice_content" name="ez_notice_content" rows="3" style="height: 500px;" >${noticeDo.ez_notice_content}
		     </textarea>
		   </div>
	    </div>
	    
		<div class="row justify-content-center col-12">
		    <div class="col-6 text-end">
		        <button class="w-50 btn btn-primary btn-lg" type="submit">수정하기</button>
		    </div>
		    <div class="col-6 text-start">
		        <a href="#" onclick="history.back();" class="w-50 btn btn-primary btn-lg" type="reset">취소하기</a>
		    </div>
		</div>
   		</form>

	 </main>
    </div>
      
    <!-- End Example Code -->
  </body>
  
    
  <jsp:include page="../nav/footer.jsp" />
</html>