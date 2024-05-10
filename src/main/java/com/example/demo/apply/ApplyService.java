package com.example.demo.apply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.trainer.TrainerDo;
import com.example.demo.user.UserDo;

@Service
public class ApplyService {
	
	@Autowired
	private ApplyDao applyDao;
	
	//(유저기준) 상담신청 리스트 조회
	public List<ApplyDo> selectAllApply(UserDo userDo, ApplyDo applyDo) {
		System.out.println("[서비스][사용자] 상담신청 내역 조회");
		
		
		return applyDao.selectAllApply(userDo, applyDo);
	}
	
	
	//(유저기준)상담신청 취소
	//ez_apply_result 필드가 0=대기, -1=취소, 1=승인
	public void cancleApply(UserDo userDo, int Ano) {
		System.out.println("[서비스]cancleApply");
		
		applyDao.updateApply(userDo, Ano);
	}
	
	
	//(트레이너) 상담신청 리스트 조회
	public List<ApplyDo> selectAllApplyTr(TrainerDo trainerDo, ApplyDo applyDo) {
		System.out.println("[서비스] [트레이너]상담신청 내역 조회");
		
		
		return applyDao.selectAllApplyTr(trainerDo, applyDo);
	}
	
	
	//(트레이너)상담신청 취소
	//ez_apply_result 필드가 0=대기, -1=취소, 1=승인
	public void cancleApplyTr(TrainerDo trainerDo, int Ano) {
		System.out.println("[서비스]cancleApply");
		
		applyDao.updateApplyTr(trainerDo, Ano);
	}
	
	//(트레이너)상담신청 취소
	//ez_apply_result 필드가 0=대기, -1=취소, 1=승인
	public void approvalApplyTr(TrainerDo trainerDo, int Ano) {
		System.out.println("[서비스]cancleApply");
		
		applyDao.updateApplyTrapproval(trainerDo, Ano);
	}


}
