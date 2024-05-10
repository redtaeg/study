package com.example.demo.trainer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.contents.ContentsDo;

@Component
public class TrDao {


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PasswordEncoder passwordEncoder;

	//	--------------------------------
	//	트레이너 회원가입 중복 아이디 확인
	public boolean istrMember(String getEz_tr_user_id) {
		System.out.println("[TrDao] istrMember");
		String sql ="SELECT COUNT(*) FROM ez_tr_user WHERE ez_tr_user_id = ?";

		int result = jdbcTemplate.queryForObject(sql, Integer.class,getEz_tr_user_id);
		return result > 0 ? true:false;	
	}


	//트레이너 회원가입 정보 확인
	public int inserttrAccount(TrainerDo trainerDo) {
		System.out.println("[다오] 회원가입 정보확인");
		String sql = "INSERT INTO ez_tr_user (ez_tr_user_id "
				+ ", ez_tr_user_approval "
				+ ", ez_tr_user_pw "
				+ ", ez_tr_user_name"
				+ ", ez_tr_user_age"
				+ ", ez_tr_user_region"
				+ ", ez_tr_user_mail"
				+ ", ez_tr_user_phone"
				+ ", ez_tr_user_gender"
				+ ", ez_tr_user_keyword"
				+ ", ez_tr_user_career"
				+ ", ez_tr_user_profile"
				+ ", ez_tr_user_photo"
				+ ", ez_tr_user_image"
				+ ", ez_tr_user_reg_date"
				+ ", ez_tr_user_mod_date ) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW())";
		
		int app = 0;
		if(trainerDo.getEz_tr_user_id().equals("super admin")) app = 1; //아이디가 슈퍼어드민이면 권한 부여
		
		int result = -1;
	
		try {
			result = jdbcTemplate.update(sql
					,trainerDo.getEz_tr_user_id()
					,app
					,passwordEncoder.encode(trainerDo.getEz_tr_user_pw())
					,trainerDo.getEz_tr_user_name(),trainerDo.getEz_tr_user_age()
					,trainerDo.getEz_tr_user_region(),trainerDo.getEz_tr_user_mail(),
					trainerDo.getEz_tr_user_phone(),trainerDo.getEz_tr_user_gender(),
					trainerDo.getEz_tr_user_keyword(),trainerDo.getEz_tr_user_career(),
					trainerDo.getEz_tr_user_profile(),trainerDo.getEz_tr_user_photo(),
					trainerDo.getEz_tr_user_image());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}




	//	--------------------------
	//	트레이너 로그인
	public TrainerDo selectTrUser(TrainerDo trainerDo) {

		String sql = "SELECT * FROM ez_tr_user "
				+ "WHERE ez_tr_user_id = ? "
				+ "AND ez_tr_user_approval > 0";

		List<TrainerDo> trainerDos = new ArrayList<TrainerDo>();

		try {
			trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

				@Override
				public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					TrainerDo trainerDo = new TrainerDo();
					trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
					trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
					trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
					trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
					trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
					trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
					trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
					trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
					trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
					trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
					trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
					trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
					trainerDo.setEz_tr_user_pw(rs.getString("ez_tr_user_pw"));
					trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));
					trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
					trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
					return trainerDo;
				}

			},trainerDo.getEz_tr_user_id());
			System.out.println("입력한 비밀번호 : " + trainerDo.getEz_tr_user_pw());
			System.out.println("저장(암호화)된 비밀번호 : " + trainerDos.get(0).getEz_tr_user_pw());



			if (!passwordEncoder.matches(trainerDo.getEz_tr_user_pw(), trainerDos.get(0).getEz_tr_user_pw())) {
				trainerDos.clear();   
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainerDos.size() > 0 ? trainerDos.get(0) :null;	
	}


	// 트레이너 개인정보 수정
	public int updateTrainerAccount(TrainerDo trainerDo) {
		System.out.println("[TrDao] updateTrainerAccount()");
		System.out.println(trainerDo);

		String sql = "UPDATE ez_tr_user SET "
				+ "ez_tr_user_name = ?, "
				+ "ez_tr_user_age = ?, "
				+ "ez_tr_user_gender = ?, "
				+ "ez_tr_user_phone = ?, "
				+ "ez_tr_user_mail = ?, "
				+ "ez_tr_user_region = ?, "
				+ "ez_tr_user_keyword = ?, "
				+ "ez_tr_user_profile = ?, "
				+ "ez_tr_user_career = ?, "
				+ "ez_tr_user_photo = ?, "
				+ "ez_tr_user_image = ?, "
				+ "ez_tr_user_mod_date = NOW() "
				+ "WHERE ez_tr_user_id = ?";
		int result = -1;

		try {
			result = jdbcTemplate.update(sql,
					trainerDo.getEz_tr_user_name(), 
					trainerDo.getEz_tr_user_age(),
					trainerDo.getEz_tr_user_gender(),
					trainerDo.getEz_tr_user_phone(),
					trainerDo.getEz_tr_user_mail(),
					trainerDo.getEz_tr_user_region(),
					trainerDo.getEz_tr_user_keyword(),
					trainerDo.getEz_tr_user_profile(),
					trainerDo.getEz_tr_user_career(),
					trainerDo.getEz_tr_user_photo(),
					trainerDo.getEz_tr_user_image(),
					trainerDo.getEz_tr_user_id());
		} catch (Exception e) {
			e.printStackTrace();
		} return result;
	}

	public TrainerDo selectTrainer(String ez_tr_user_id) {
		System.out.println("[TrDao] selectTrainer()");

		String sql = "SELECT * FROM ez_tr_user " + "WHERE ez_tr_user_id = ?";
		List<TrainerDo> trainerDos = new ArrayList<TrainerDo>();

		try {
			trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

				@Override
				public TrainerDo mapRow(ResultSet rs, int RowNum) throws SQLException {
					TrainerDo trainerDo = new TrainerDo();
					trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
					trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
					trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
					trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
					trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
					trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
					trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
					trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
					trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
					trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
					trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
					trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
					trainerDo.setEz_tr_user_pw(rs.getString("ez_tr_user_pw"));
					trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));
					trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
					trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
					return trainerDo;
				}
			}, ez_tr_user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainerDos.size() > 0 ? trainerDos.get(0) : null;
	}


	//트레이상세조회
	public TrainerDo selectTrUsers(String trId) {
		String sql = "SELECT * FROM ez_tr_user "
				+ "WHERE ez_tr_user_id = ? "
				+ "AND ez_tr_user_approval > 0";

		List<TrainerDo> trainerDos = null;

		try {
			trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

				@Override
				public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					TrainerDo trainerDo = new TrainerDo();

					trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
					trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
					trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
					trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
					trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
					trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
					trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
					trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
					trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
					trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
					trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
					trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
					trainerDo.setEz_tr_user_pw(rs.getString("ez_tr_user_pw"));
					trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));
					trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
					trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
					return trainerDo;
				}

			},trId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return trainerDos.size() > 0 ? trainerDos.get(0) : null;
	}

	
	//트레이상세조회 관리자용
	public TrainerDo selectTrUsers2(String trId, TrainerDo loginedAdminDo) {
		
		String sql = "SELECT * FROM ez_tr_user "
				+ "WHERE ez_tr_user_id = ? "
				+ "AND ez_tr_user_approval > 0";
		
		if(loginedAdminDo.getEz_tr_user_id().equals("super admin")) {
			sql = "SELECT * FROM ez_tr_user "
					+ "WHERE ez_tr_user_id = ? ";
		}
		System.out.println(sql);
		List<TrainerDo> trainerDos = null;

		try {
			trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

				@Override
				public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					TrainerDo trainerDo = new TrainerDo();

					trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
					trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
					trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
					trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
					trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
					trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
					trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
					trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
					trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
					trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
					trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
					trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
					trainerDo.setEz_tr_user_pw(rs.getString("ez_tr_user_pw"));
					trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));
					trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
					trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
					return trainerDo;
				}

			},trId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return trainerDos.size() > 0 ? trainerDos.get(0) : null;
	}
	//tr 리스트 조회
	public List<TrainerDo> selectAlltr(TrainerDo trainerDo) {

	      String sql = "SELECT * FROM ez_tr_user WHERE ez_tr_user_approval > 0 AND ez_tr_user_id != 'super admin'";

		List<TrainerDo> trainerDos = new ArrayList<TrainerDo>();

		try {

			trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

				@Override
				public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					TrainerDo trainerDo = new TrainerDo();

					trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
					trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
					trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
					trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
					trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
					trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
					trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
					trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
					trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
					trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
					trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
					trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
					trainerDo.setEz_tr_user_pw(rs.getString("ez_tr_user_pw"));
					trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));
					trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
					trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
					return trainerDo;

				}

			});	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainerDos.size() > 0 ? trainerDos : null;
	}

	//본인이 올린영상 조회
	public List<ContentsDo> tr_selfcon(TrainerDo loginedTrDo) {

		String sql = "SELECT * FROM ez_con WHERE ez_tr_user_id = ? ";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos=jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {

					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			},loginedTrDo.getEz_tr_user_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() > 0 ? contentsDos : null;
	}

	//영상 수정폼 불러오기
	public ContentsDo tr_con_modify(TrainerDo loginedTrDo, int cNo) {

		String sql = "SELECT * FROM ez_con WHERE ez_tr_user_id = ? and ez_con_no = ? ";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos =jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {

					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			},loginedTrDo.getEz_tr_user_id(),cNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() > 0 ? contentsDos.get(0) : null;
	}

	//영상 수정폼 확인
	public int tr_con_modifyConfirm(ContentsDo contentsDo) {

		String sql = "UPDATE ez_con SET ez_con_title = ?, ez_con_info = ?, ez_con_keyword = ?, ez_con_level = ?, ez_con_mod_date = NOW()"
				+ " WHERE ez_con_no = ?";
		int result = 0;

		try {
			result = jdbcTemplate.update(sql,
					contentsDo.getEz_con_title(), 
					contentsDo.getEz_con_info(),
					contentsDo.getEz_con_keyword(),
					contentsDo.getEz_con_level(),
					contentsDo.getEz_con_no());


		} catch (Exception e) {
			e.printStackTrace();
		} return result;
	}

//  유저 메인페이지 상위6명 트레이너
  public List<TrainerDo> selectToptr(TrainerDo trainerDo) {

     String sql = "SELECT * FROM ez_tr_user WHERE ez_tr_user_approval > 0 AND ez_tr_user_id != 'super admin' order by ez_tr_user_reg_date LIMIT 6";

     List<TrainerDo> trainerDos = new ArrayList<TrainerDo>();

     try {

        trainerDos = jdbcTemplate.query(sql, new RowMapper<TrainerDo>() {

           @Override
           public TrainerDo mapRow(ResultSet rs, int rowNum) throws SQLException {
              TrainerDo trainerDo = new TrainerDo();

              trainerDo.setEz_tr_user_id(rs.getString("ez_tr_user_id"));
              trainerDo.setEz_tr_user_approval(rs.getInt("ez_tr_user_approval"));
              trainerDo.setEz_tr_user_age(rs.getString("ez_tr_user_age"));
              trainerDo.setEz_tr_user_career(rs.getString("ez_tr_user_career"));
              trainerDo.setEz_tr_user_gender(rs.getString("ez_tr_user_gender"));
              trainerDo.setEz_tr_user_image(rs.getString("ez_tr_user_image"));
              trainerDo.setEz_tr_user_keyword(rs.getString("ez_tr_user_keyword"));
              trainerDo.setEz_tr_user_mail(rs.getString("ez_tr_user_mail"));
              trainerDo.setEz_tr_user_name(rs.getString("ez_tr_user_name"));
              trainerDo.setEz_tr_user_phone(rs.getString("ez_tr_user_phone"));
              trainerDo.setEz_tr_user_profile(rs.getString("ez_tr_user_profile"));
              trainerDo.setEz_tr_user_photo(rs.getString("ez_tr_user_photo"));
              trainerDo.setEz_tr_user_pw(rs.getString("ez_tr_user_pw"));
              trainerDo.setEz_tr_user_region(rs.getString("ez_tr_user_region"));
              trainerDo.setEz_tr_user_mod_date(rs.getString("ez_tr_user_mod_date"));
              trainerDo.setEz_tr_user_reg_date(rs.getString("ez_tr_user_reg_date"));
              return trainerDo;

           }

        });   
     } catch (Exception e) {
        e.printStackTrace();
     }
     return trainerDos.size() > 0 ? trainerDos : null;
  }

}
