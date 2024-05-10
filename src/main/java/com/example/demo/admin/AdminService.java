package com.example.demo.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.contents.ContentsDo;
import com.example.demo.trainer.TrainerDo;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
//	-------------------------------------------권한 부여(시작)-----------------------------------------
	
	//관리자 리스트 호출
	public List<TrainerDo> listupTr(){
		System.out.println("AdminService : listupAdmin" );
		return adminDao.selectTr();
	}
	
	//권한 부여
		public void setAdminApproval(String ez_tr_user_id,int num) {
			System.out.println("AdminService : setAdminApproval");
			adminDao.updateAdminAccount(ez_tr_user_id, num);
		}
		
	//권한 삭제
	public void outAdminApproval(String ez_tr_user_id, int num) {
		System.out.println("AdminService : outAdminApproval");
		adminDao.updateAdminAccount(ez_tr_user_id, num);
	}
	
	
//	-------------------------------------------권한 부여(끝)-----------------------------------------
	
	
	//영상 컨텐츠 리스트 호출
	public List<ContentsDo> listupContents(){
		System.out.println("AdminService : listupContents" );
		
		return adminDao.selectContents();
	}
//	관리자 페이지에서 영상삭제를 위한 의존 컨텐츠 삭제
	public int deleteFavCon(int ez_con_no) {
	      return adminDao.deleteFavCon(ez_con_no);
	      
	   }
	
	
//	관리자 페이지에서 영상삭제
	public int deleteCon(int ez_con_no) {
		return adminDao.deleteCon(ez_con_no);
	}
	
	//영상 신고리스트 출력
	public List<ContentsDo> reportContents(){
		System.out.println("AdminService : listupContents" );
		
		return adminDao.reportContents();
	}
	
	
//	공지사항 등록 확인
	public int insert_notice_conFirm(NoticeDo noticeDo) {
		System.out.println("어드민 서비스 : 공지사항 등록 확인" );
		return adminDao.insert_notice_conFirm(noticeDo);
	}
	
	
//공지사항 리스트 호출
		public List<NoticeDo> notice_List(){
			System.out.println("[어드민 서비스]공지사항 리스트 조회");
			
			return adminDao.select_notice();
		}
		
//공지사항 상세 조회"
		public NoticeDo notice_detail_list(int Nno){
			System.out.println("[어드민 서비스]공지사항 상세 조회");
			
			return adminDao.select_notice_list(Nno);
		}
		
		
		//공지사항 수정 확인
				public int notice_modify_conFirm(NoticeDo noticeDo){
					System.out.println("[어드민 서비스]공지사항 수정 확인");
					
					return adminDao.upadte_notice_list(noticeDo);
				}
				
		//공지사항 삭제
				public int notice_delete(int no){
					System.out.println("[어드민 서비스]공지사항 삭제");
					
					return adminDao.delete_notice(no);
				}
				
	
	
	
}
