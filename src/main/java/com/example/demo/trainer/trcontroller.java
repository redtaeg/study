    package com.example.demo.trainer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.contents.ContentsDo;
import com.example.demo.contents.ContentsService;
import com.example.demo.trainer.util.UploadFileService;
import com.example.demo.user.UserService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/tr")

public class trcontroller {

	@Autowired
	TrService trService;

	@Autowired
	UserService userService;  //사용자 즐겨찾기용;;


	@Autowired
	UploadFileService uploadFileService;
	
	@Autowired
    ContentsService contentsService;  //메인페이지용 의존


	@GetMapping("/tr_main") // 메인페이지
	public String user_main(Model model, ContentsDo contentsDo
							, TrainerDo trainerDo, HttpSession session) {
		System.out.println("유저컨트롤러 : 유저 메인페이지");
		
		String nextPage = "/trainer/tr_main";
		
		List<ContentsDo> contentsList = contentsService.selectAllCon(contentsDo);
		model.addAttribute("contentsList",contentsList);
		
		List<TrainerDo> trainerDos = trService.selectAlltr(trainerDo);
		model.addAttribute("trainerDos",trainerDos);
		
		return nextPage;
	}
	



	//	------------------------------------------------------
	//	트레이너 로그인 폼으로 이동
	@GetMapping("/tr_login")
	public String tr_login() {
		System.out.println("tr_login_Controller");
		return "trainer/tr_login";
	}
	
	//	로그인 하기
	@PostMapping("/tr_confirm_login")
	public String tr_confirm_login(TrainerDo trainerDo , HttpSession session) {
		String nextPage = "redirect:/tr/tr_main";
		TrainerDo loginedTrDo = trService.loginConfirm(trainerDo); 

		if (loginedTrDo == null) {
			nextPage ="trainer/login_ng";
		}
		else {
			session.setAttribute("loginedTrDo", loginedTrDo);
			session.setMaxInactiveInterval(60*30);
		}
		return nextPage;
	}

	//	-------------------------------------------------------
	//	트레이너 회원가입 폼으로 이동

	@GetMapping("/tr_create")
	public String create_tr(){
		System.out.println("tr_create_tr_Controller");
		return "trainer/tr_create_member";
	}

	//아이디 중복체크 확인
	@PostMapping("/checkId")
	public Boolean checkId(@RequestParam("ez_tr_user_id") String id) {
		System.out.println("중복체크");
		return trService.createtrAccountIdConfirm(id);
	}
	
	   //회원가입 입력정보 확인
    @PostMapping("/tr_confirm_member")
    public String tr_confirm_member(TrainerDo trainerDo,
          @RequestParam("file1") MultipartFile photo
          ,@RequestParam("file2") MultipartFile image
          ) {
         System.out.println("[컨트롤러] 회원가입 정보확인");
       String nextPage="redirect:/tr/tr_main";

    
       
       String savedFileName1 = uploadFileService.upload(photo); //추가 (김홍택)
       trainerDo.setEz_tr_user_photo(savedFileName1);
       
       
       String savedFileName2 = uploadFileService.upload(image); //추가 (김홍택)
       trainerDo.setEz_tr_user_image(savedFileName2);
       
      
       System.out.println("image : "+trainerDo.getEz_tr_user_image());
       System.out.println("파일 업로드 완료");
    
          int result = trService.createtrAccountConfirm(trainerDo);

          System.out.println("회원가입");
          
          if (result <=0 ) {
             nextPage="trainer/tr_create_member_ng";
          }

       return nextPage;
    }
    

	//	-------------------------------------------------------

//  트레이너 마이페이지
  @GetMapping("/tr_myPage")
  public String tr_Mypage() {
     return "/trainer/tr_self_conlist";
  }      

	
	
	//  트레이너 정보수정창으로 이동
	@GetMapping("/tr_update")
	public String modifyAccountForm(HttpSession session) {
		System.out.println("[trcontroller] modifyAccountConfirm()");
		String nextPage = "trainer/myPage";
		TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		if(loginedTrDo == null)
			nextPage = "redirect:/tr/tr_login";
		return nextPage;
	}


	//트레이너 정보수정확인 메서드
	@PostMapping("/modifyAccountConfirm")
	public String modifyAccountConfirm(TrainerDo trainerDo, HttpSession session
								       ,@RequestParam("file1") MultipartFile photo
								       ,@RequestParam("file2") MultipartFile image
			) {
		System.out.println("[trcontroller] modifyAccountConfirm()");
		String nextPage = "redirect:/tr/tr_myPage";
		
		
	       String savedFileName1 = uploadFileService.upload(photo); //프로필
	       trainerDo.setEz_tr_user_photo(savedFileName1);
	       
	       String savedFileName2 = uploadFileService.upload(image); //증빙서류
	       trainerDo.setEz_tr_user_image(savedFileName2);
	       
	       System.out.println("파일 업로드 완료");
	       
	       if(savedFileName1 != null) {
	          int result = trService.modifyAccountConfirm(trainerDo);
	          
				if(result > 0) {
					TrainerDo loginedTrDo = trService.getLoginedTrDo(trainerDo.getEz_tr_user_id());
					session.setAttribute("loginedTrDo", loginedTrDo);
					session.setMaxInactiveInterval(60 * 30);
				}
		} else {
			nextPage = "trainer/modify_ng";
		}
		return nextPage;
	}


	//트레이너 로그아웃 메서드
	@GetMapping("/logoutConfirm")
	public String logoutConfirm(HttpSession session) {
		System.out.println("[trcontroller] logoutConfirm()");
		String nextPage = "redirect:/tr/tr_main";
		session.invalidate();
		return nextPage;
	}



	//  트레이너 리스트 목록 보기   
	@GetMapping("/tr_list")
	public String tr_list(Model model , TrainerDo trainerDo) {

		List<TrainerDo> trainerDos = trService.selectAlltr(trainerDo);

		model.addAttribute("trainerDos",trainerDos);

		return "trainer/tr_list";
	}


	//	사용자 -> 트레이너 목록 - > 트레이너 상세보기
	//	트레이너 상세보기
	@GetMapping("/tr_list_info") 
	public String tr_list_info(@RequestParam("ez_tr_user_id")String trId,
			Model model) {
		System.out.println("[컨트롤러] 트레이너상세" + trId);

		TrainerDo trainerDo = trService.trDetail(trId);
		model.addAttribute("trainerDo",trainerDo);
		return "/trainer/tr_list_info";
	}

	   //트레이너 상세보기 관리자 전용
		@GetMapping("/tr_list_info_ad") 
		public String tr_list_info_ad(@RequestParam("ez_tr_user_id")String trId,
									Model model, HttpSession session) {
			System.out.println("[컨트롤러]트레이너상세 관리자용");
			
			TrainerDo loginedAdminDo = (TrainerDo)session.getAttribute("loginedTrDo");
			System.out.println(loginedAdminDo);
			TrainerDo trainerDo = trService.trDetail2(trId, loginedAdminDo);
			
			model.addAttribute("trainerDo",trainerDo);
			return "/trainer/tr_list_info";
		}
	

	//	트레이너 본인이 등록한 영상 보기 목록
	@GetMapping("/tr_selfconlist")
	public String tr_selfcon(TrainerDo trainerDo, HttpSession session,Model model) {
		TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		List<ContentsDo> contentsDos = trService.tr_selfcon(loginedTrDo);
		model.addAttribute("contentsDos",contentsDos);
		return "trainer/tr_self_conlist";

	}
	
	//	트레이너 본인이 등록한 영상 수정폼 이동 
	@GetMapping("/tr_con_modify")
	public String tr_con_modify(TrainerDo trainerDo, HttpSession session,
								@RequestParam("ez_con_no") int cNo, Model model) {
		System.out.println("컨트롤러 : 영상 수정폼" + cNo);
		TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		String nextPage = "trainer/tr_con_modify";
		
		ContentsDo contentsDo = trService.tr_con_modify(loginedTrDo, cNo);
		if(loginedTrDo == null) nextPage = "ez/login_route";
		model.addAttribute("contentsDo",contentsDo);
		return nextPage;

	}
	
	// 트레이너 본인이 등록한 영상 수정 확인
	@PostMapping("/tr_con_modifyConfirm")
	public String tr_con_modifyConfirm(TrainerDo trainerDo, HttpSession session,
								  ContentsDo contentsDo) {
		System.out.println("컨트롤러 : 영상 수정확인" + contentsDo);
		TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		String nextPage = "redirect:/tr/tr_selfconlist";
		
		int result = trService.tr_con_modifyConfirm(contentsDo);
		
		if(loginedTrDo == null || result == 0) nextPage = "ez/login_route";

		return nextPage;
	}

}
