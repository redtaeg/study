package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.apply.ApplyDo;
import com.example.demo.contents.ContentsDo;
import com.example.demo.contents.ContentsService;
import com.example.demo.favcon.FavconDo;
import com.example.demo.favtr.FavTrDo;
import com.example.demo.trainer.TrService;
import com.example.demo.trainer.TrainerDo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@EnableJpaAuditing
public class userController {

	@Autowired
    UserService userService;

	
	@Autowired
	TrService trService; //메인페이지용 의존
	
	
	@Autowired
    ContentsService contentsService;  //메인페이지용 의존
	

    @GetMapping("/user_main") // 메인페이지
    public String user_main(Model model, ContentsDo contentsDo, TrainerDo trainerDo) {
       System.out.println("유저컨트롤러 : 유저 메인페이지");
       
       String nextPage = "/user/user_main";
       
       List<ContentsDo> contentsList = contentsService.selectTopCon(contentsDo);
       model.addAttribute("contentsList",contentsList);
       
       List<TrainerDo> trainerDos = trService.selectToptr(trainerDo);
       model.addAttribute("trainerDos",trainerDos);
       
       return nextPage;
    }


	@GetMapping("/user_create_member") // 회원가입
	public String user_create_member() {
		System.out.println("user_create_member");
		return "/user/user_create_member";
	}

	   // 회원가입 확인 240411
	   @PostMapping("/user_confirm_member")
	   public String user_confirm_member(UserDo userDo) {
	      System.out.println("[userControlloer] user_comfirm_member()");

	      String nextPage = "redirect:/user/user_main";

	      int result = userService.createAccountConfirm(userDo);

	      if (result <= 0) {
	         System.out.println("sdfsdf");
	         nextPage = "user/user_create_ng";
	      }

	      return nextPage;
	   }

	@GetMapping("/user_login") // 로그인
	public String user_login() {
		System.out.println("user_login");
		return "/user/user_login";
	}

	@PostMapping("/user_login_confirm") // 로그인 확인
	public String user_login_Confirm(UserDo userDo, HttpSession session) {
		System.out.println("user_login_confirm()");
		String nextPage = "redirect:/user/user_main";
		UserDo loginedUserDo = userService.loginConfirm(userDo);
		System.out.println("확인용2");
		if (loginedUserDo == null) {
			nextPage = "user/login_ng";
			
			System.out.println("확인용3");
		} else {
			System.out.println("확인용4");
			session.setAttribute("loginedUserDo", loginedUserDo);
			session.setMaxInactiveInterval(60 * 30);
			System.out.println("확인용5");
		}
		return nextPage;
	}

	// 마이페이지 + (회원정보수정창) 		
	@GetMapping("/user_myPage") 
	public String modifyAccountForm(HttpSession session) { 
		System.out.println("[UserController] modifyAccountForm()"); 
		String nextPage = "user/user_myPage"; 
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo"); 

		if(loginedUserDo == null) 
			nextPage = "redirect:/user/user_login"; 
		return nextPage; 
	}

	// 회원정보수정확인
	@PostMapping("/modifyAccountConfirm")
	public String modifyAccountConfirm(UserDo userDo, HttpSession session) {
		System.out.println("[UserController] modifyAccountConfirm()" + userDo);
		String nextPage = "user/modify_ok";
		
		int result = userService.modifyAccountConfirm(userDo);
		
		if (result > 0) {
			UserDo loginedUserDo = userService.getLoginedUserDo(userDo.getEz_user_id());

			session.setAttribute("loginedUserDo", loginedUserDo);
			session.setMaxInactiveInterval(60 * 30);
		} else {
			nextPage = "user/modify_ng";
		}
		return nextPage;
	}

	// 로그아웃 구현
	@GetMapping("/logoutConfirm")
	public String logoutConfirm(HttpSession session) {
		System.out.println("[UserController] logoutConfirm()");
		session.invalidate();
		String nextPage = "redirect:/user/user_main";    
		return nextPage;
	}




	@GetMapping("/user_applyform")  //상담 신청 양식
	public String user_applyform(HttpSession session, Model model) {
		System.out.println("[UserController] user_applyform()");
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
		if(loginedUserDo == null)
			return "redirect:/user/user_login";
		return "user/user_applyform";
	}

	@PostMapping("/user_applyConfirm")    // 상담신청 확인
	public String applyConfirm(ApplyDo applyDo, @RequestParam("ez_tr_user_id") String ez_tr_user_id, @RequestParam("ez_apply_tr_name") String trname, HttpSession session) {
		System.out.println("[UserController] applyConfirm");
		System.out.println(trname);
		String nextPage = "user/user_myPage";
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
		if(loginedUserDo == null) {
			nextPage = "redirect:/user/user_login";
		} else {
			//            TrainerDo trainerDo = userService.getTrainerById(applyDo.getTrainerId());
			//            applyDo.setTrainerDo(trainerDo);
			int result = userService.applyConfirm(applyDo, loginedUserDo, ez_tr_user_id, trname);
			if(result <= 0)
				nextPage = "user/apply_ng";
		}
		return nextPage;
	}



	//  (사용자) 즐겨찾기 트레이너 목록 
	@GetMapping("/user_fav_tr")
	public String user_fav_tr(FavTrDo favTrDo, HttpSession session ,TrainerDo trainerDo , UserDo userDo,Model model) {
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
		List<TrainerDo> favTrDos = userService.selectAllFavTr(favTrDo,trainerDo,loginedUserDo);
		model.addAttribute("favTrDos", favTrDos);
		System.out.println("fav_tr_list : " + favTrDos);

		return "/user/user_fav_tr"; 
	}


	   //  (사용자) 트레이너 즐겨찾기 추가/삭제
	   @GetMapping("/user_fav_tr_confirm")
	   public String user_fav_tr_confirm(UserDo userDo , @RequestParam("trainerId") String ez_tr_id , FavTrDo favTrDo ,HttpSession session ,Model model) {

	      UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
	      int favTrDos = userService.insertFavtr(loginedUserDo,ez_tr_id,favTrDo);
	      model.addAttribute("favTrDos", favTrDos);

	      return "redirect:/tr/tr_list_info?ez_tr_user_id=" + ez_tr_id ;
	   }


	/*
	 * // 사용자 트레이너 즐겨찾기 취소
	 * 
	 * @GetMapping("/user_fav_del") public String
	 * user_fav_del(@RequestParam("trainerId") String ez_tr_user_id,FavTrDo favTrDo
	 * ,HttpSession session,Model model) {
	 * 
	 * UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
	 * 
	 * int delTrDos = userService.delFavtr(loginedUserDo,ez_tr_user_id,favTrDo);
	 * model.addAttribute("delTrDos", delTrDos);
	 * System.out.println("del Controller"); return "redirect:/tr/tr_list_info"; }
	 */

	
	
//	//  사용자 영상 즐겨찾기 하기
//	@GetMapping("/user_fav_con") 
//	public String user_fav_con(@RequestParam("contentsno") int no,
//			@RequestParam("ez_tr_user_id") String id,		
//			UserDo userDo, HttpSession session) {
//		System.out.println("userController : user_fav_con");
//		System.out.println(no);
//
//		ContentsDo contentsDo = userService.findCon(no); //컨텐츠 no으로 컨텐츠 정보 가져옴
//
//
//		String nextPage = "redirect:/tr/tr_list_info";
//
//		userService.addFavCon(userDo, contentsDo);
//
//		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo"); //세션확인
//		if(loginedUserDo == null) 
//			nextPage = "user/user_login";  //로그인 화면으로 이동
//
//		return nextPage; 
//	}

	
	
	//  사용자 영상 즐겨찾기 추가      
	@GetMapping("/user_fav_con_confirm")
	public String user_fav_tr_confirm(@RequestParam("ez_con_no") String ez_con_no , FavconDo favconDo ,HttpSession session ,Model model ,ContentsDo contentsDo) {
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");

		int favConDos = userService.insterFavCon(loginedUserDo,ez_con_no,favconDo,contentsDo);

		return "redirect:/con/condetail?ez_con_no=" + ez_con_no;
	}

	// 	사용자 영상 즐겨찾기 리스트 
	@GetMapping("/user_fav_con")
	public String selectFavcon(FavconDo favconDo, HttpSession session ,TrainerDo trainerDo ,Model model){
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");

		List<ContentsDo> favconDos = userService.selectAllFavCon(favconDo, trainerDo, loginedUserDo);
		model.addAttribute("favconDos", favconDos);

		return "user/user_fav_contents_list";
	}


}