package com.example.demo.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.contents.ContentsDo;
import com.example.demo.trainer.TrainerDo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;



	//	-------------------------------------------권한 부여(시작)-----------------------------------------
	//권한부여 및 트레이너 리스트 호출
	@GetMapping("/trList")
	public String trList(Model model, HttpSession session) {
		System.out.println("[AdminController] trList"); 

		String nextPage = "redirect:/user/user_main";
		TrainerDo loginedAdminDo = (TrainerDo) session.getAttribute("loginedTrDo");

		if (loginedAdminDo != null) {  //세션 
			if ("super admin".equals(loginedAdminDo.getEz_tr_user_id())) {
				List<TrainerDo> trainerDos = adminService.listupTr();
				model.addAttribute("trainerDos", trainerDos);
				nextPage = "admin/trList";
			} else {
				nextPage = "redirect:/user/user_main";
			}
		}

		return nextPage;
	}

	//승인처리
	@GetMapping("/setAdminApproval")
	public String setAdminApproval(@RequestParam("ez_tr_user_id") String ez_tr_user_id) {
		System.out.println("AdminController : setAdminApproval ");

		String nextPage = "redirect:/admin/trList";

		adminService.setAdminApproval(ez_tr_user_id,0);
		return nextPage;
	}

	//로그인 권한 뺏기
	@GetMapping("/outAdminApproval")
	public String outAdminApproval(@RequestParam("ez_tr_user_id") String ez_tr_user_id) {
		System.out.println("AdminMemberController : outAdminApproval ");

		String nextPage = "redirect:/admin/trList";

		adminService.outAdminApproval(ez_tr_user_id,1);

		return nextPage;
	}

	//	-------------------------------------------권한 부여(끝)-----------------------------------------


	//영상 리스트 호출
	@GetMapping("/contentsList")
	public String contentsList(Model model, HttpSession session) {
		System.out.println("[AdminController] contentsList");

		String nextPage = "redirect:/user/user_main";
		TrainerDo loginedAdminDo = (TrainerDo) session.getAttribute("loginedTrDo");

		if (loginedAdminDo != null) {  //세션 
			if ("super admin".equals(loginedAdminDo.getEz_tr_user_id())) {
				List<ContentsDo> contentsDos = adminService.listupContents();
				model.addAttribute("contentsDos", contentsDos);
				nextPage = "admin/contentsList";
			} else {
				nextPage = "redirect:/user/user_main";
			}
		}



		return nextPage;
	}


	//	영상삭제
	@GetMapping("/contents_del")
	public String contents_del(@RequestParam("ez_con_no") int ez_con_no ) {

		adminService.deleteFavCon(ez_con_no);
		adminService.deleteCon(ez_con_no);

		return "redirect:/admin/contentsList;";

	}

	//영상 신고리스트 호출
	@GetMapping("/contents_report_List")
	public String contents_report_List(Model model, HttpSession session) {
		System.out.println("[AdminController] contentsList");

		String nextPage = "redirect:/user/user_main";
		TrainerDo loginedAdminDo = (TrainerDo) session.getAttribute("loginedTrDo");

		if (loginedAdminDo != null) {  //세션 
			if ("super admin".equals(loginedAdminDo.getEz_tr_user_id())) {
				List<ContentsDo> contentsDos = adminService.reportContents();
				model.addAttribute("contentsDos", contentsDos);
				nextPage = "admin/contents_report_List";
			} else {
				nextPage = "redirect:/user/user_main";
			}
		}

		return nextPage;
	}

	//	공지사항 등록폼 이동  테스트용이라 세션안넣음
	@GetMapping("/insert_notice_form")
	public String insert_notice() {
		System.out.println("[어드민 컨트롤러]공지사항 등록창 이동");

		return "/admin/insert_notice";
	}

	//공지사항 등록 확인
	@PostMapping("/insert_notice_conFirm")
	public String insert_notice_conFirm(NoticeDo noticeDo) {
		System.out.println("[어드민 컨트롤러]공지사항 확인(등록실행)" + noticeDo);

		adminService.insert_notice_conFirm(noticeDo);

		return "redirect:/admin/notice_list";
	}

	//공지사항 리스트 조회
	@GetMapping("/notice_list")
	public String notice_info(Model model) {
		System.out.println("[어드민 컨트롤러]공지사항 리스트 조회");

		String nextPage = "admin/notice";

		List<NoticeDo> noticeDos = adminService.notice_List();
		model.addAttribute("noticeDos", noticeDos);

		return nextPage;
	}

	//공지사항 상세조회
	@GetMapping("/notice_detail")
	public String notice_detail(@RequestParam("ez_notice_no") int Nno, Model model) {
		System.out.println("[어드민 컨트롤러]공지사항 상세 조회");

		String nextPage = "admin/notice_detail";


		NoticeDo noticeDo = adminService.notice_detail_list(Nno);
		model.addAttribute("noticeDo", noticeDo);
		return nextPage;
	}


	//공지사항 수정폼
	@GetMapping("/notice_modify_form")
	public String notice_modify_form(HttpSession session, @RequestParam("no") int no
			, Model model) {
		System.out.println("[어드민 컨트롤러]공지사항 폼");

		String nextPage = "redirect:/admin/notice_detail";

		TrainerDo adminloginDo = (TrainerDo)session.getAttribute("loginedTrDo");
		if(adminloginDo.getEz_tr_user_id().equals("super admin")) {
			nextPage = "admin/notice_modify_form";

			NoticeDo noticeDo = adminService.notice_detail_list(no);
			model.addAttribute("noticeDo", noticeDo);
		}

		return nextPage;
	}

	//공지사항 수정 확인
	@PostMapping("/notice_modify_conFirm")
	public String notice_modify_conFirm(NoticeDo noticeDo , Model model, HttpSession session) {
		System.out.println("[어드민 컨트롤러]공지사항 수정" + noticeDo);

		String nextPage = "redirect:/admin/notice_list";

		TrainerDo adminloginDo = (TrainerDo)session.getAttribute("loginedTrDo");
		if(adminloginDo.getEz_tr_user_id().equals("super admin")) {	
			int result = adminService.notice_modify_conFirm(noticeDo);
			model.addAttribute("noticeDo", noticeDo);	
		}

		return nextPage;
	}


	//공지사항 삭제
	@GetMapping("/notice_delete")
	public String notice_delete(@RequestParam("no") int no, HttpSession session) {
		System.out.println("[어드민 컨트롤러]공지사항 삭제");

		String nextPage = "redirect:/admin/notice_list";

		TrainerDo adminloginDo = (TrainerDo)session.getAttribute("loginedTrDo");
		if(adminloginDo.getEz_tr_user_id().equals("super admin")) {
			int result = adminService.notice_delete(no);
		}

		return nextPage;
	}


}

