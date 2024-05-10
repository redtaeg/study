package com.example.demo.contents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.trainer.TrainerDo;

@Component
public class ContentsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//영상 중복 확인
	public boolean isISBN(String ez_con_title) {
		System.out.println("[BookDao] isISBN");

		String sql = "SELECT COUNT(*) FROM ez_con"
				+" WHERE ez_con_title = ? ";

		int result = jdbcTemplate.queryForObject(sql, Integer.class, ez_con_title);

		return result > 0 ? true : false;
	}


	//신규 영상 등록
	public int insertContent(ContentsDo contentsDo, TrainerDo loginedTrDo) {
		System.out.println("[ContentsDao] 영상 등록");

		String sql = "INSERT INTO ez_con(ez_con_info,ez_con_keyword,ez_con_level,"
				+ "ez_con_title,ez_con_tr_name,ez_con_video,ez_tr_user_id,ez_con_report,"
				+ "ez_con_mod_date,ez_con_reg_date)"
				+ " VALUES(?,?,?,?,?,?,?,?,NOW(),NOW())";

		int result = -1;

		try {
			//			TrainerDo trainer = contentsDo.getTrainerDo();  아이디 외래키 사용용

			result = jdbcTemplate.update(sql,
					contentsDo.getEz_con_info(), contentsDo.getEz_con_keyword(),
					contentsDo.getEz_con_level(),contentsDo.getEz_con_title(),
					loginedTrDo.getEz_tr_user_name(), contentsDo.getEz_con_video(),
					loginedTrDo.getEz_tr_user_id(),"0"
					);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	//   영상검색 기능
	public List<ContentsDo> search_con(ContentsDo contentsDo,String search_name) {

		String sql = "SELECT * FROM ez_con WHERE ez_con_level LIKE ? or ez_con_title LIKE ? or ez_con_keyword LIKE ?";
		
		String search = "%" + search_name + "%";
		
		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos=jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			},search,search,search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() >0 ? contentsDos:null;

	}

	//영상 상세 조회
	public ContentsDo selectContents(int ez_con_no) {
		System.out.println("[ContentsDao] 영상 상세조회");

		String sql = "SELECT * FROM ez_con WHERE ez_con_no = ?";
		System.out.println(ez_con_no);

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException{

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
					   String ez_tr_user_id = rs.getString("ez_tr_user_id");
		               TrainerDo trainerDo = new TrainerDo();
		               trainerDo.setEz_tr_user_id(ez_tr_user_id); // TrainerDo 객체의 id 필드 설정
		               contentsDo.setTrainerDo(trainerDo); //객체 관계 설정
					return contentsDo;
				}	
			},ez_con_no);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() > 0 ? contentsDos.get(0) : null;
	}

	
	
	//트레이너-본인영상 삭제1
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

	//	트레이너-본인영상 삭제2
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



	//	모든영상조회
	public List<ContentsDo> selectAllCon(ContentsDo contentsDo) {

		String sql ="SELECT * FROM ez_con WHERE ez_tr_user_id = any (SELECT ez_tr_user_id FROM ez_tr_user WHERE ez_tr_user_approval > 0 ) ORDER BY ez_con_mod_date DESC;";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo =new ContentsDo();

					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));
					return contentsDo;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(contentsDos.size());
		return contentsDos.size() > 0 ? contentsDos :null;

	}


	//	상체 운동영상 조회
	public List<ContentsDo> selectStrengthCon_1(ContentsDo contentsDo) {
		System.out.println("[ContentsDao] selectStrengthCon_1");
		String sql ="SELECT * FROM ez_con WHERE ez_con_keyword LIKE '%상체%'";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo =new ContentsDo();

					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));
					return contentsDo;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(contentsDos.size());
		return contentsDos.size() > 0 ? contentsDos :null;

	}


	//	하체 운동영상 조회
	public List<ContentsDo> selectStrengthCon_2(ContentsDo contentsDo) {
		System.out.println("[ContentsDao] selectStrengthCon_2");
		String sql ="SELECT * FROM ez_con WHERE ez_con_keyword LIKE '%하체%' ORDER BY ez_con_no ASC";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo =new ContentsDo();

					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));
					return contentsDo;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(contentsDos.size());
		return contentsDos.size() > 0 ? contentsDos :null;

	}




	public List<ContentsDo> selectOther1(ContentsDo contentsDo) {
		String sql = "SELECT * FROM ez_con WHERE ez_con_keyword LIKE '%다이어트%'";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos=jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() >0 ? contentsDos:null;
	}


	public List<ContentsDo> selectOther2(ContentsDo contentsDo) {
		String sql = "SELECT * FROM ez_con WHERE ez_con_keyword LIKE '%스트레칭%'";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos=jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() >0 ? contentsDos:null;
	}

	public List<ContentsDo> selectOther3(ContentsDo contentsDo) {
		String sql = "SELECT * FROM ez_con WHERE ez_con_keyword LIKE '%유산소%'";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos=jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() >0 ? contentsDos:null;
	}

	public List<ContentsDo> selectOther4(ContentsDo contentsDo) {
		String sql = "SELECT * FROM ez_con WHERE ez_con_keyword LIKE '%재활%'";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos=jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo = new ContentsDo();
					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));

					return contentsDo;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contentsDos.size() >0 ? contentsDos:null;
	}

	public List<ContentsDo> selectTopCon(ContentsDo contentsDo) {

		String sql ="SELECT * FROM ez_con ORDER BY ez_con_reg_date ASC LIMIT 6";

		List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();

		try {
			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {

				@Override
				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
					ContentsDo contentsDo =new ContentsDo();

					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
					contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
					contentsDo.setEz_con_video(rs.getString("ez_con_video"));
					return contentsDo;
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(contentsDos.size());
		return contentsDos.size() > 0 ? contentsDos :null;

	}
	
//	사용자 영상신고 어드민한테
	
	public int conReport(ContentsDo contentsDo , int ez_con_no) {
		
		String sql = "UPDATE ez_con SET ez_con_report=1 WHERE ez_con_no= ? ";
		
		System.out.println(ez_con_no);
		int result = -1;
		
		try {
			result =jdbcTemplate.update(sql,ez_con_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}
