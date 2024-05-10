package com.example.demo.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.trainer.TrainerDo;
import com.example.demo.trainer.util.UploadFileService;
import com.example.demo.user.UserDo;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/con")
public class ContentsController {
	
	@Autowired
	ContentsService contentsService;
	
	@Autowired
	UploadFileService uploadFileService;
	
//	트레이너 영상등록 입력
	@GetMapping("/tr_insert_con")
	public String tr_insert_con() {
		System.out.println("트레이너 컨트롤러 : 영상 등록폼");
		
		return "/contents/tr_insert_contents";
	}
	
//	영상 등록 확인
	@PostMapping("/insert_conConfirm")
	public String tr_insert_conConfirm(ContentsDo contentsDo, HttpSession session,
										@RequestParam("file") MultipartFile file) {
		System.out.println("트레이너 컨트롤러 : 영상 등록 확인작업");
	      String nextPage = "redirect:/tr/tr_selfconlist";
		
		
		TrainerDo loginedTrDo = (TrainerDo) session.getAttribute("loginedTrDo");
		if(loginedTrDo == null) {
       	 nextPage = "/tr/tr_login";
		}
		
		String svaedConName = uploadFileService.upload(file);
		System.out.println(loginedTrDo);
		if(svaedConName != null) {
			contentsDo.setEz_con_video(svaedConName);
			int result = contentsService.registerConConfirm(contentsDo, loginedTrDo);
			
			if(result <=0)
				nextPage = "/contents/insert_content_ng";
		}
		return nextPage;
	}
	
	
	//  영상검색 기능
  @GetMapping("/search_con")
  public String search_con(ContentsDo contentsDo,@RequestParam("search_name") String search_name,Model model) {
     System.out.println("영상 검색하기");
     List<ContentsDo> contentsList =contentsService.search_con(contentsDo,search_name);
     model.addAttribute("contentsList" ,contentsList);
     model.addAttribute("search_name" ,search_name);
     return "contents/contents_search_list";
  }

	
	  //영상 상세 페이지
	  @GetMapping("/condetail")
	  public String conDetail(@RequestParam("ez_con_no")int ez_con_no, Model model) {
	     System.out.println("[컨트롤러] conDetail");
	     
	     String nextPage = "contents/content_detail";
	     
	     ContentsDo contentsDo = contentsService.conDetail(ez_con_no);
	     
	     model.addAttribute("contentsDo",contentsDo);
	     model.addAttribute("ez_con_no", ez_con_no);
	     
	     return nextPage;
	  }
			
//			영상삭제
			@GetMapping("/contents_del")
			public String contents_del(@RequestParam("ez_con_no") int ez_con_no ) {
				System.out.println("나와라" + ez_con_no);
				
			      contentsService.deleteFavCon(ez_con_no);
			      contentsService.deleteCon(ez_con_no);
				
				return "redirect:/tr/tr_selfconlist";
				
			}
		
//		모든영상 조회
		@GetMapping("/conlist")
		public String conlist(ContentsDo contentsDo,Model model) {
			System.out.println("conlist_모든 영상조회");
			String nextPage ="contents/contents_list";
			
			List<ContentsDo> contentsList = contentsService.selectAllCon(contentsDo);
			model.addAttribute("contentsList",contentsList);
			return nextPage;
			
		}
		//-------------------------------선택 영상 조회(근력) ----------------------
		
		//상체 운동영상조회
		@GetMapping("/conlist_strength_1")
		public String conlist_strength_1(ContentsDo contentsDo,Model model) {
			System.out.println("conlist_strength_1 상체운동영상 조회");
			String nextPage ="contents/contents_strength_list_1";
			
			List<ContentsDo> contentsList = contentsService.selectStrengthCon_1(contentsDo);
			model.addAttribute("contentsList",contentsList);
			return nextPage;
		}
		
		//하체 운동영상조회
		@GetMapping("/conlist_strength_2")
		public String conlist_strength_2(ContentsDo contentsDo,Model model) {
			System.out.println("conlist_strength_2 상체운동영상 조회");
			String nextPage ="contents/contents_strength_list_2";
			
			List<ContentsDo> contentsList = contentsService.selectStrengthCon_2(contentsDo);
			model.addAttribute("contentsList",contentsList);
			return nextPage;
		}
		
		
		//-------------------------------선택 영상 조회(기타) ----------------------
//		다이어트 영상조회
		@GetMapping("/conlist_other_1")
		public String other_1(ContentsDo contentsDo , Model model){
		List<ContentsDo> contentsDos = contentsService.selectOther1(contentsDo);
			model.addAttribute("contentsDos" ,contentsDos);
		
			return "contents/contents_other_list1";
		}
		
//		스트레칭 영상조회
		@GetMapping("/conlist_other_2")
		public String other_2(ContentsDo contentsDo , Model model){
			List<ContentsDo> contentsDos = contentsService.selectOther2(contentsDo);
			model.addAttribute("contentsDos" ,contentsDos);
			return "contents/contents_other_list2";
		}
		
//		유산소 영상조회
		@GetMapping("/conlist_other_3")
		public String other_3(ContentsDo contentsDo , Model model){
			List<ContentsDo> contentsDos = contentsService.selectOther3(contentsDo);
			model.addAttribute("contentsDos" ,contentsDos);
			return "contents/contents_other_list3";
		}
		
//		재활 영상조회
		@GetMapping("/conlist_other_4")
		public String other_4(ContentsDo contentsDo , Model model){
			List<ContentsDo> contentsDos = contentsService.selectOther4(contentsDo);
			model.addAttribute("contentsDos" ,contentsDos);
			return "contents/contents_other_list4";
		}
		
//      사용자 - > 영상 신고 어드민한테 보이기
      @GetMapping("/content_report")
      public String content_report(ContentsDo contentsDo ,@RequestParam("ez_con_no") int ez_con_no,HttpSession session) {
         String nextPage = "/ez/login_route";
         UserDo loginedUserDo = (UserDo) session.getAttribute("loginedUserDo"); //세션확인
         TrainerDo loginedtrDo = (TrainerDo) session.getAttribute("loginedTrDo"); //세션확인
         if (loginedUserDo ==null && loginedtrDo == null) {
            return nextPage;
         }
         else {
            int result =contentsService.conReport(contentsDo,ez_con_no);
            return "redirect:/con/condetail?ez_con_no=" + ez_con_no; 
         }
      }
		
		
  
}
