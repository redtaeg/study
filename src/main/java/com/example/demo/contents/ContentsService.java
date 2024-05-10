package com.example.demo.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.trainer.TrainerDo;

@Service
public class ContentsService {

	final static public int CON_ISBN_ALREADY_EXIST = 0;
	final static public int CON_REGISTER_SUCCESS = 1;
	final static public int CON_REGISTER_FAIL = -1;

	@Autowired
	ContentsDao contentsDao;


	//영상 등록 확인
	public int registerConConfirm(ContentsDo contentsDo, TrainerDo loginedTrDo) {
		System.out.println("[ContentsService] registerBookConfirm");

		boolean isISBN =contentsDao.isISBN(contentsDo.getEz_con_title());
		System.out.println(!isISBN); //테스트용
		if(!isISBN) {
			int result = contentsDao.insertContent(contentsDo, loginedTrDo);

			if(result >0)
				return CON_REGISTER_SUCCESS;
			else
				return CON_REGISTER_FAIL;	
		}else {
			return CON_REGISTER_FAIL;
		}
	}

	//  영상 검색조회
	public List<ContentsDo> search_con(ContentsDo contentsDo,String search_name) {
		return contentsDao.search_con(contentsDo, search_name);
	}



	//영상 상세 페이지
	public ContentsDo conDetail(int ez_con_no) {
		System.out.println("[ContentsService] conDetail");

		return contentsDao.selectContents(ez_con_no);
	}
	
//	관리자 페이지에서 영상삭제를 위한 의존 컨텐츠 삭제
	public int deleteFavCon(int ez_con_no) {
	      return contentsDao.deleteFavCon(ez_con_no);
	      
	   }
	
	
//	관리자 페이지에서 영상삭제
	public int deleteCon(int ez_con_no) {
		return contentsDao.deleteCon(ez_con_no);
	}


	//		모든영상 조회

	public List<ContentsDo> selectAllCon(ContentsDo contentsDo) {
		return contentsDao.selectAllCon(contentsDo);

	}


	//		상체 운동영상 조회
	public List<ContentsDo> selectStrengthCon_1(ContentsDo contentsDo) {
		System.out.println("[ContentsService] selectStrengthCon_1");
		return contentsDao.selectStrengthCon_1(contentsDo);
	}

	//		하체 운동영상 조회
	public List<ContentsDo> selectStrengthCon_2(ContentsDo contentsDo) {
		System.out.println("[ContentsService] selectStrengthCon_2");
		return contentsDao.selectStrengthCon_2(contentsDo);
	}

	//		다이어트 영상조회
	public List<ContentsDo> selectOther1(ContentsDo contentsDo) {
		return contentsDao.selectOther1(contentsDo);

	}

	//		스트레칭 영상조회
	public List<ContentsDo> selectOther2(ContentsDo contentsDo) {
		return contentsDao.selectOther2(contentsDo);

	}

	//		유산소 영상조회
	public List<ContentsDo> selectOther3(ContentsDo contentsDo) {
		return contentsDao.selectOther3(contentsDo);

	}

	//		재활 영상조회
	public List<ContentsDo> selectOther4(ContentsDo contentsDo) {
		return contentsDao.selectOther4(contentsDo);

	}
	
	
//  유저 메인페이지 상위6개 영상 조회

  public List<ContentsDo> selectTopCon(ContentsDo contentsDo) {
     return contentsDao.selectTopCon(contentsDo);
     
  }
  
  
//사용자 -> 영상 신고 어드민한테
  public int conReport(ContentsDo contentsDo , int ez_con_no) {
	  
	return contentsDao.conReport(contentsDo,ez_con_no);
}




}
