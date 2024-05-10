package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.contents.ContentsDo;
import com.example.demo.contents.ContentsService;
import com.example.demo.trainer.TrService;
import com.example.demo.trainer.TrainerDo;
import com.example.demo.user.UserService;

@Controller
@RequestMapping("/ez")
public class SamplController {
   
   @Autowired
    UserService userService;

   
   @Autowired
   TrService trService; //메인페이지용 의존
   
   
   @Autowired
    ContentsService contentsService;  //메인페이지용 의존

   @GetMapping("/home")
   public String home(Model model, ContentsDo contentsDo, TrainerDo trainerDo) {
      System.out.println("홈 컨트롤러 : 홈 메인페이지");
      
      String nextPage = "/home";
      
          List<ContentsDo> contentsList = contentsService.selectTopCon(contentsDo);
          model.addAttribute("contentsList",contentsList);
          
          List<TrainerDo> trainerDos = trService.selectToptr(trainerDo);
          model.addAttribute("trainerDos",trainerDos);
      
      return nextPage;
   }
   
   @GetMapping("/login_route")
   public String login_route() {   
      return "/ez/login_route";
   }

}