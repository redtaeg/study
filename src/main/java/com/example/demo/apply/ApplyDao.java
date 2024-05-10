package com.example.demo.apply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.trainer.TrainerDo;
import com.example.demo.user.UserDo;

@Component
public class ApplyDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//(유저기준)상담신청 리스트 조회
	public List<ApplyDo> selectAllApply(UserDo userDo, ApplyDo applyDo) {
		System.out.println("[다오] [사용자] 상담신청 내역 조회");
		
			String sql = "SELECT * FROM ez_apply WHERE ez_user_id = ?";  //유저꺼로 조회
			 String id = null;
			if(userDo != null) id =userDo.getEz_user_id();
		
		List<ApplyDo> applyDos = new ArrayList<ApplyDo>();
			
		try {
		
			applyDos = jdbcTemplate.query(sql, new RowMapper<ApplyDo>() {
			
			@Override
			public ApplyDo mapRow(ResultSet rs, int rowNum) throws SQLException {
				ApplyDo applyDo = new ApplyDo();
				applyDo.setEz_apply_tr_name(rs.getString("ez_apply_tr_name"));
				applyDo.setEz_apply_user_name(rs.getString("ez_apply_user_name"));
				applyDo.setEz_apply_comment(rs.getString("ez_apply_comment"));
				applyDo.setEz_apply_reg_date(rs.getString("ez_apply_reg_date"));
				applyDo.setEz_apply_mod_date(rs.getString("ez_apply_mod_date"));
				applyDo.setEz_apply_no(rs.getInt("ez_apply_no"));
				applyDo.setEz_apply_result(rs.getInt("ez_apply_result"));
				
				
				String ez_tr_user_id = rs.getString("ez_tr_user_id");
				TrainerDo trainerDo = new TrainerDo();
			    trainerDo.setEz_tr_user_id(ez_tr_user_id); // TrainerDo 객체의 id 필드 설정
			    applyDo.setTrainerDo(trainerDo); //객체 관계 설정

				
			return applyDo;
			
		}
		
	},id);	
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return applyDos;
	}

	
	//(사용자)상담취소 
	public void updateApply(UserDo userDo, int Ano) {
		System.out.println("[다오] 상담취소updateApply");
		
		String sql = "UPDATE ez_apply SET ez_apply_result = -1, ez_apply_mod_date = now()  WHERE ez_user_id = ? AND ez_apply_no = ? ";
		System.out.println(Ano + userDo.getEz_user_id());
		jdbcTemplate.update(sql,userDo.getEz_user_id(),Ano);
	}
	
	
	
	
	//(트레이너)상담신청 리스트 조회
	public List<ApplyDo> selectAllApplyTr(TrainerDo trainerDo, ApplyDo applyDo) {
		System.out.println("[다오] [트레이너]상담신청 내역 조회");
		
		String sql = "SELECT * FROM ez_apply WHERE ez_tr_user_id = ?";
		

		String id = trainerDo.getEz_tr_user_id();  //테스트용 객체이름임 나중에 변경필요
		

		List<ApplyDo> applyDos = new ArrayList<ApplyDo>();
			
		try {
		
			applyDos = jdbcTemplate.query(sql, new RowMapper<ApplyDo>() {
			
			@Override
			public ApplyDo mapRow(ResultSet rs, int rowNum) throws SQLException {
				ApplyDo applyDo = new ApplyDo();
				applyDo.setEz_apply_tr_name(rs.getString("ez_apply_tr_name"));
				applyDo.setEz_apply_user_name(rs.getString("ez_apply_user_name"));
				applyDo.setEz_apply_comment(rs.getString("ez_apply_comment"));
				applyDo.setEz_apply_phone(rs.getString("ez_apply_phone"));
				applyDo.setEz_apply_reg_date(rs.getString("ez_apply_reg_date"));
				applyDo.setEz_apply_mod_date(rs.getString("ez_apply_mod_date"));
				applyDo.setEz_apply_no(rs.getInt("ez_apply_no"));
				applyDo.setEz_apply_result(rs.getInt("ez_apply_result"));
				String ez_tr_user_id = rs.getString("ez_tr_user_id");
				TrainerDo trainerDo = new TrainerDo();
			    trainerDo.setEz_tr_user_id(ez_tr_user_id); // TrainerDo 객체의 id 필드 설정
			    applyDo.setTrainerDo(trainerDo); //객체 관계 설정

			return applyDo;
		}
	},id);	
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return applyDos;
	}
	
	//(트레이너)상담취소 
	public void updateApplyTr(TrainerDo trainerDo, int Ano) {
		System.out.println("[다오] [트레이너]상담취소 updateApply");
		

		String id = trainerDo.getEz_tr_user_id();  //테스트용 객체이름임 나중에 변경필요
		
		String sql = "UPDATE ez_apply SET ez_apply_result = -1, ez_apply_mod_date = now()  WHERE ez_tr_user_id = ? AND ez_apply_no = ? ";
		jdbcTemplate.update(sql,id,Ano);
	}
	
	//(트레이너)상담승인
	public void updateApplyTrapproval(TrainerDo trainerDo, int Ano) {
		System.out.println("[다오] [트레이너] 상담승인 updateApply");
		

		String id = trainerDo.getEz_tr_user_id();  //테스트용 객체이름임 나중에 변경필요
		
		String sql = "UPDATE ez_apply SET ez_apply_result = 1, ez_apply_mod_date = now()  WHERE ez_tr_user_id = ? AND ez_apply_no = ? ";
		jdbcTemplate.update(sql,id,Ano);
	}
	
	
}
