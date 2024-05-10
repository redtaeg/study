package com.example.demo.apply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.trainer.TrainerDo;
import com.example.demo.user.UserDo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/apply")
public class ApplyController {

	@Autowired
	private ApplyService applyService;
	
	
	
	// (사용자기준)상담 신청 리스트 조회
	@GetMapping("/apply_applylist") 
	public String apply_applyList(Model model, HttpSession session,
								ApplyDo applyDo, UserDo userDo) {
		System.out.println("[컨트롤러]apply_applyList");
		
		String nextPage = "apply/apply_list";
		
		//세션 확인
		UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
		if(loginedUserDo == null) nextPage = "/user/user_login";

		
		
		List<ApplyDo> applyDos = applyService.selectAllApply(loginedUserDo, applyDo);
		model.addAttribute("applyDos",applyDos);
		
		return nextPage;
	}
	
	
 	// 상담신청 취소(유저)
	 @GetMapping("/apply_cancleApply")    
	 //상담 시퀀스 넘버를 통해 진행
	  public String apply_cancleApply(@RequestParam("applyNo") int Ano, HttpSession session) {
		  System.out.println("[컨트롤러] apply_cancleApply" + Ano);

		  UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo");
		  
		  applyService.cancleApply(loginedUserDo, Ano);
		  
		  
		  return "redirect:/apply/apply_applylist";
	 }

	// ------------------------------트레이너 기준--------------------------------------------------
	 
	// (트레이너)상담 신청 리스트 조회
	@GetMapping("/apply_applylistTr") 
	public String apply_applylistTr(Model model, HttpSession session,
								ApplyDo applyDo,TrainerDo trainerDo) {
		System.out.println("apply_applylistTr");
		
		String nextPage = "apply/apply_listTr";
		
		//세션 확인
		TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		System.out.println("로그인 정보 확인 : " + loginedTrDo);
		if(loginedTrDo == null) nextPage = "tr/tr_login";
		
		List<ApplyDo> applyDos = applyService.selectAllApplyTr(loginedTrDo, applyDo);
		model.addAttribute("applyDos",applyDos);
		
		return nextPage;
	}
	

	 @GetMapping("/apply_cancleApplyTr")    
	 //상담 시퀀스 넘버를 통해 진행
	 //(트레이너) 상담 취소
	  public String apply_cancleApplyTr(@RequestParam("applyNo") int Ano, HttpSession session) {
		  System.out.println("[컨트롤러] apply_cancleApplyTr");

		  TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		  
		  applyService.cancleApplyTr(loginedTrDo, Ano);
		  
		  return "redirect:/apply/apply_applylistTr";
	 }
	 
	 
	 //상담 시퀀스 넘버를 통해 진행
	 //(트레이너) 상담 승인
	 @GetMapping("/apply_approvalApplyTr")    
	  public String apply_approvalApplyTr(@RequestParam("applyNo") int Ano, HttpSession session) {
		  System.out.println("[컨트롤러] apply_cancleApplyTr");

		  TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		  
		  applyService.approvalApplyTr(loginedTrDo, Ano);
		  
		  return "redirect:/apply/apply_applylistTr";
	 }
}
