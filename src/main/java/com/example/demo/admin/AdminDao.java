package com.example.demo.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.contents.ContentsDo;
import com.example.demo.trainer.TrainerDo;

@Component
public class AdminDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	TrainerDo trainerDo;



	//	-------------------------------------------트레이너 리스트/권한 부여(시작)-----------------------------------------
	//로그인 권한 부여
	public List<TrainerDo> selectTr() {
		System.out.println("AdminDao : selectTr");

		String sql = "SELECT * FROM ez_tr_user";

		List<TrainerDo> trainerDos = new ArrayList<TrainerDo>();

		try {
			trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

				@Override
				public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException{
					TrainerDo trainerDo = new TrainerDo();
					System.out.println(rowNum);
					trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
					trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
					trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
					trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
					trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
					trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
					trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
					trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
					trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
					trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
					trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
					trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
					trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
					trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
					trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));

					return trainerDo;

				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return trainerDos;
	}


	//권한 업데이트
	public void updateAdminAccount(String ez_tr_user_id, int num) {
		System.out.println("AdminDao : updateAdminAccount");

		String sql = "UPDATE ez_tr_user SET ez_tr_user_approval = 1 WHERE ez_tr_user_id = ? ";
		if(num == 1) sql = "UPDATE ez_tr_user SET ez_tr_user_approval = 0 WHERE ez_tr_user_id = ? "; 

		try {
			jdbcTemplate.update(sql, ez_tr_user_id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//		-------------------------------------------트레이너 리스트/권한 부여(끝)-----------------------------------------

	//		-------------------------------------------영상 리스트조회(시작)--------------------------------------

	//영상 리스트 조회
	public List<ContentsDo> selectContents() {
		System.out.println("AdminDao : selectContents");

		String sql = "SELECT * FROM ez_con";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException{
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));

					String ez_tr_user_id = rs.getString("ez_tr_user_id");
					TrainerDo trainerDo = new TrainerDo();
					trainerDo.setEz_tr_user_id(ez_tr_user_id); // TrainerDo 객체의 id 필드 설정
					contentsDo.setTrainerDo(trainerDo); //객체 관계 설정

					return contentsDo;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return contentsDos;
	}
	//		-------------------------------------------영상 리스트조회(끝)-----------------------------------------		


	//관리자 페이지에서 영상삭제를 위한 의존 컨텐츠 삭제
	public int deleteFavCon(int ez_con_no){
		String sql = "DELETE FROM ez_fav_con WHERE ez_con_no = ?";

		int result=-1;

		try {
			result=jdbcTemplate.update(sql,ez_con_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//	관리자 페이지에서 영상삭제
	public int deleteCon(int ez_con_no) {

		String sql = "DELETE FROM ez_con WHERE ez_con_no = ?";

		int result =-1;

		try {
			result =jdbcTemplate.update(sql,ez_con_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	//영상 신고 리스트 조회
	public List<ContentsDo> reportContents() {
		System.out.println("AdminDao : selectContents");

		String sql = "SELECT * FROM ez_con WHERE ez_con_report = 1";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException{
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));

					String ez_tr_user_id = rs.getString("ez_tr_user_id");
					TrainerDo trainerDo = new TrainerDo();
					trainerDo.setEz_tr_user_id(ez_tr_user_id); // TrainerDo 객체의 id 필드 설정
					contentsDo.setTrainerDo(trainerDo); //객체 관계 설정

					return contentsDo;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return contentsDos;
	}

	//	공지사항 등록 확인
	public int insert_notice_conFirm(NoticeDo noticeDo) {
		System.out.println("어드민 다오 : 공지사항 등록 확인" );
		String sql = "INSERT INTO ez_notice(ez_notice_title,ez_notice_content,ez_notice_reg_date,ez_notice_mod_date)"
				+ " VALUES(?,?,now(),now())";

		int result =-1;

		try {
			result =jdbcTemplate.update(sql,noticeDo.getEz_notice_title(),noticeDo.getEz_notice_content());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	//공지사항 리스트 호출
	public List<NoticeDo> select_notice(){
		System.out.println("[어드민 다오]공지사항 리스트 조회");

		String sql = "SELECT * FROM ez_notice";

		List<NoticeDo> noticeDos = new ArrayList<NoticeDo>();

		try {
			noticeDos = jdbcTemplate.query(sql, new RowMapper<NoticeDo>() {

				@Override
				public NoticeDo mapRow(ResultSet rs, int rowNum) throws SQLException{
					NoticeDo noticeDo = new NoticeDo();
					noticeDo.setEz_notice_no(rs.getInt("ez_notice_no"));
					noticeDo.setEz_notice_title(rs.getString("ez_notice_title"));
					noticeDo.setEz_notice_reg_date(rs.getString("ez_notice_reg_date"));
					noticeDo.setEz_notice_mod_date(rs.getString("ez_notice_mod_date"));
					noticeDo.setEz_notice_views(rs.getInt("ez_notice_views"));
					return noticeDo;
				}
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return noticeDos;
	}

	//공지사항 상세 조회"
	public NoticeDo select_notice_list(int Nno){
		System.out.println("[어드민 다오]공지사항 상세 조회");

		String sql = "SELECT * FROM ez_notice WHERE ez_notice_no = ?";

		List<NoticeDo> noticeDos = new ArrayList<NoticeDo>();

		//조회수용 업데이트 작업
		String sql1 = "UPDATE ez_notice SET ez_notice_views = ez_notice_views + 1 WHERE ez_notice_no = ?";
		try {
			jdbcTemplate.update(sql1,Nno);
		}catch (Exception e) {
			e.printStackTrace();
		}


		try {
			noticeDos = jdbcTemplate.query(sql, new RowMapper<NoticeDo>() {

				@Override
				public NoticeDo mapRow(ResultSet rs, int rowNum) throws SQLException{
					NoticeDo noticeDo = new NoticeDo();
					noticeDo.setEz_notice_no(rs.getInt("ez_notice_no"));
					noticeDo.setEz_notice_title(rs.getString("ez_notice_title"));
					noticeDo.setEz_notice_content(rs.getString("ez_notice_content"));
					noticeDo.setEz_notice_reg_date(rs.getString("ez_notice_reg_date"));
					noticeDo.setEz_notice_mod_date(rs.getString("ez_notice_mod_date"));
					noticeDo.setEz_notice_views(rs.getInt("ez_notice_views"));
					System.out.println(noticeDo.getEz_notice_views());
					return noticeDo;
				}
			},Nno);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return noticeDos.size() > 0 ? noticeDos.get(0) : null;
	}


	//공지사항 수정"
	public int upadte_notice_list(NoticeDo noticeDo){
		System.out.println("[어드민 다오]공지사항 수정확인");

		String sql = "UPDATE ez_notice SET ez_notice_title = ?, ez_notice_content = ?, ez_notice_mod_date = NOW() WHERE ez_notice_no = ?";

		String title = noticeDo.getEz_notice_title();
		String content = noticeDo.getEz_notice_content();
		int result = -1;

		try {
			result = jdbcTemplate.update(sql,title,content,noticeDo.getEz_notice_no());

		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	//공지사항 삭제
	public int delete_notice(int no){
		System.out.println("[어드민 다오]공지사항 삭제");

		String sql = "DELETE FROM ez_notice WHERE ez_notice_no = ?";

		int result = -1;

		try {
			result = jdbcTemplate.update(sql,no);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
