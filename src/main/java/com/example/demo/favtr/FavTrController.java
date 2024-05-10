package com.example.demo.favtr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/favtr")
public class FavTrController {
	
	@Autowired
	FavTrService favTrService;
	
	//트레이너 즐겨찾기 추가하기
	@GetMapping("/addFavTr")
	public String AddFavTr(@RequestParam("ez_tr_user_id") String ez_tr_user_id,
						   @RequestParam("ez_user_id") String ez_user_id) {
		System.out.println("FavTrController : AddFavTr");
		
		String nextPage = "redirect:/tr/tr_list_info";
		
		favTrService.AddFavTr(ez_tr_user_id,ez_user_id);
		
		return nextPage;
	}
}
