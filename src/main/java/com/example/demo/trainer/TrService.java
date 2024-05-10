package com.example.demo.trainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contents.ContentsDo;

@Service
public class TrService {
	
	final static public int TR_ACCOUNT_ALREADY_EXIST=0;
	final static public int TR_ACCOUNT_ALREADY_SUCCESS=1;
	final static public int TR_ACCOUNT_ALREADY_FAIL=-1;
	
	@Autowired
	TrDao trDao;

	
	
//	트레이너 회원가입 체크
//	-----------------------------------
	
	public boolean createtrAccountIdConfirm(String id) {
		boolean isMember = trDao.istrMember(id);
		return isMember;
	}
	
	public int createtrAccountConfirm(TrainerDo trainerDo) {
		
		boolean isMember = trDao.istrMember(trainerDo.getEz_tr_user_id());
		
		System.out.println("[서비스] 회원가입 정보확인");
		
		if (!isMember) {
			int result = trDao.inserttrAccount(trainerDo);
			if (result>0) {
				return TR_ACCOUNT_ALREADY_SUCCESS;
			}
			else {
				return TR_ACCOUNT_ALREADY_FAIL;
			}
		}
		else {
			return TR_ACCOUNT_ALREADY_EXIST;
		}	
	}
//-----------------------------------	
	
//	 트레이너 로그인할시 체크
//	---------------------------------
	public TrainerDo loginConfirm(TrainerDo trainerDo) {
		TrainerDo loginedTrDo = trDao.selectTrUser(trainerDo);
		if (loginedTrDo != null) {
			System.out.println("tr_login_성공");
		}
		else {
		System.out.println("tr_login_실패");	
		}
		
		return loginedTrDo;
	}
	
	
	   //트레이너 개인정보수정
	   public int modifyAccountConfirm(TrainerDo trainerDo) {
	      System.out.println("[TrService] modifyAccountConfirm()");
	      return trDao.updateTrainerAccount(trainerDo);
	   }
	   
	   public TrainerDo getLoginedTrDo(String ez_tr_user_id) {
		      System.out.println("[TrService] getLoginedTrDo()");
		      return trDao.selectTrainer(ez_tr_user_id);
		   }
	   
	   
	
	//트레이너  상세 페이지
	public TrainerDo trDetail(String trId) {
		System.out.println("[서비스] 트레이너 상세");
		
		return trDao.selectTrUsers(trId);
	}
	
	//트레이너  상세 페이지 관리자용
		public TrainerDo trDetail2(String trId, TrainerDo loginedAdminDo) {
			System.out.println("[서비스] 트레이너 상세 관리자용");
			
			return trDao.selectTrUsers2(trId, loginedAdminDo);
		}
		
		public List<TrainerDo> selectAlltr(TrainerDo trainerDo) {
			return trDao.selectAlltr(trainerDo);
		}
	
	//	트레이너 본인이 등록한 마이페이지 버튼을 통해서 영상 확인하기
	public List<ContentsDo> tr_selfcon(TrainerDo loginedTrDo) {
		return trDao.tr_selfcon(loginedTrDo);
	}	
	
	//	영상 수정폼 불러오기
	public ContentsDo tr_con_modify(TrainerDo loginedTrDo, int cNo) {
		System.out.println("서비스 : 영상 수정폼");
		return trDao.tr_con_modify(loginedTrDo, cNo);
	}	
	
	//	영상 수정폼 불러오기
	public int tr_con_modifyConfirm(ContentsDo contentsDo) {
		System.out.println("서비스 : 영상 수정확인");
		return trDao.tr_con_modifyConfirm(contentsDo);
	}	
	
	
//  유저 메인페이지 상위6개 조회
  public List<TrainerDo> selectToptr(TrainerDo trainerDo) {
     return trDao.selectToptr(trainerDo);
  }

	
}
