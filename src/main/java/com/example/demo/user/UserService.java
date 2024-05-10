package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.apply.ApplyDo;
import com.example.demo.contents.ContentsDo;
import com.example.demo.favcon.FavconDo;
import com.example.demo.favtr.FavTrDo;
import com.example.demo.trainer.TrainerDo;

@Service
public class UserService {

	
	// 회원가입 확인
	final static public int USER_ACCOUNT_ALREADY_EXIST = 0;
	final static public int USER_ACCOUNT_CREATE_SUCCESS = 1;
	final static public int USER_ACCOUNT_CREATE_FAIL = -1;
	
	@Autowired
	UserDao userDao;
	
	public int createAccountConfirm(UserDo userDo) {
		System.out.println("[UserService] createAccountConfirm()");
		
		boolean isMember = userDao.isUserMember(userDo.getEz_user_id());
		
		if(!isMember) {
			int result = userDao.insertUserAccount(userDo);
			
			if(result > 0)
				return USER_ACCOUNT_CREATE_SUCCESS;
			else
				return USER_ACCOUNT_CREATE_FAIL;
		} else {
			return USER_ACCOUNT_ALREADY_EXIST;
		}
	}
	
	//로그인 확인
	public UserDo loginConfirm(UserDo userDo) {
		System.out.println("[UserService] loginConfirm()");
		UserDo loginedUserDo = userDao.selectUser(userDo);
		System.out.println("확인용1");
		if(loginedUserDo != null)
			System.out.println("[UserService] USER MEMBER LOGIN SECCESS");
		else	
			System.out.println("[UserService] USER MEMBER LOGIN FAIL");
		return loginedUserDo;
			
	}
	
	// 개인정보수정
	  public int modifyAccountConfirm(UserDo userDo) {
	  System.out.println("[UserService] modifyAcoountConfirm()"); 
	  return userDao.updateUserAccount(userDo); 
	  }
	  
	  public UserDo getLoginedUserDo(String ez_user_id) {
	  System.out.println("[UserService] getLoginedUserDo()"); 
	  return userDao.selectUser(ez_user_id); 
	  }
		  
		  
	//영상 즐겨찾기 추가
	public void addFavCon(UserDo userDo, ContentsDo contentsDo) {
		System.out.println("UserService : addFavTr()");
		
		userDao.addFavTr(userDo, contentsDo);
	
	}
	
	//사용자 상세 페이지
	public UserDo userDetail(String userId) {
		System.out.println("[서비스] 트레이너 상세");
		
		return userDao.selectTrUsers(userId);
	}
	
	
	  //상담 신청(확인)
	  public int applyConfirm(ApplyDo applyDo, UserDo userDo, String ez_tr_user_id, String trname) {
		  System.out.println("[UserService] applyConfirm()");
		  applyDo.setUserDo(userDo);
		  int result = userDao.insertApply(applyDo, userDo, ez_tr_user_id, trname);
		  return result;
	  }
	  
//    사용자 트레이너 즐겨찾기
    public int insertFavtr(UserDo userDo , String ez_tr_id , FavTrDo favTrDo) {
       System.out.println("insertFavtr_service");
  return userDao.toggleFavtr(userDo , ez_tr_id , favTrDo);   
  }


	
	  
//	  사용자별 즐겨찾기한 영상조회
	  public List<TrainerDo> selectAllFavTr(FavTrDo favTrDo ,TrainerDo trainerDo ,UserDo userDo) {
		  return userDao.selectAllFavTr(favTrDo,trainerDo,userDo);
	}
	  
	  
////	  사용자 트레이너 approval 별로 보이기
//	  public List<FavTrDo> showFavtr(UserDo loginedUserDo,String ez_tr_user_id,FavTrDo favTrDo) {
//		  return userDao.showFavtr(loginedUserDo,ez_tr_user_id,favTrDo);
//		
//	}
	  
//	  사용자 영상 즐겨찾기 추가
	  public int insterFavCon(UserDo loginedUserDo,String ez_con_no,FavconDo favconDo,ContentsDo contentsDo) {
		  return userDao.insterFavCon(loginedUserDo,ez_con_no,favconDo,contentsDo);
		
	}
	  
	  
//	  사용자 영상 즐겨찾기
	  public List<ContentsDo> selectAllFavCon(FavconDo favconDo, TrainerDo trainerDo, UserDo loginedUserDo) {
		return userDao.selectAllFavCon(favconDo,trainerDo,loginedUserDo);
	}
}
