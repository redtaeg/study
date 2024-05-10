package com.example.demo.user;

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

import com.example.demo.apply.ApplyDo;
import com.example.demo.contents.ContentsDo;
import com.example.demo.favcon.FavconDo;
import com.example.demo.favtr.FavTrDo;
import com.example.demo.trainer.TrainerDo;
@Component
public class UserDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	// 중복 아이디 체크
	public boolean isUserMember(String ez_user_id) {
		System.out.println("[UserDao] isUserMember()");
		
		String sql = "SELECT COUNT(*) FROM ez_user " + "WHERE ez_user_id = ?";
	
		int result = jdbcTemplate.queryForObject(sql,  Integer.class, ez_user_id);
		
		return result > 0 ? true : false;
	}
	
	// 신규 사용자 추가
	public int insertUserAccount(UserDo userDo) {
		System.out.println("[UserDao] insertUserAccount()");
		
		String sql = "INSERT INTO ez_user(ez_user_id, "
										+ "ez_user_pw, "
										+ "ez_user_name, "
										+ "ez_user_age, "
										+ "ez_user_phone, "
										+ "ez_user_mail, "
										+ "ez_user_gender, "
										+ "ez_user_weight, "
										+ "ez_user_keyword, "
										+ "ez_user_reg_date, "
										+ "ez_user_mod_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		
		int result = -1;
		
		try {
			result = jdbcTemplate.update(sql,
										userDo.getEz_user_id(),
										passwordEncoder.encode(userDo.getEz_user_pw()),
										userDo.getEz_user_name(),
										userDo.getEz_user_age(),
										userDo.getEz_user_phone(),
										userDo.getEz_user_mail(),
										userDo.getEz_user_gender(),
										userDo.getEz_user_weight(),
										userDo.getEz_user_keyword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 입력한 정보를 테이블에서 조회
	public UserDo selectUser(UserDo userDo) {
		System.out.println("[UserDao] selectUser()");
		
		String sql = "SELECT * FROM ez_user " + "WHERE ez_user_id = ?";
		
		List<UserDo> userDos = new ArrayList<UserDo>();
		
		try {
			userDos = jdbcTemplate.query(sql, new RowMapper<UserDo>() {
				
				@Override
				public UserDo mapRow(ResultSet rs, int RowNum) throws SQLException {
					UserDo userDo = new UserDo();
					userDo.setEz_user_id(rs.getString("ez_user_id"));
					userDo.setEz_user_pw(rs.getString("ez_user_pw"));
					userDo.setEz_user_name(rs.getString("ez_user_name"));
					userDo.setEz_user_age(rs.getString("ez_user_age"));
					userDo.setEz_user_phone(rs.getString("ez_user_phone"));
					userDo.setEz_user_mail(rs.getString("ez_user_mail"));
					userDo.setEz_user_gender(rs.getString("ez_user_gender"));
					userDo.setEz_user_weight(rs.getString("ez_user_weight"));
					userDo.setEz_user_keyword(rs.getString("ez_user_keyword"));
					userDo.setEz_user_reg_date(rs.getString("ez_user_reg_date"));
					userDo.setEz_user_mod_date(rs.getString("ez_user_mod_date"));
					return userDo;
				}
			}, userDo.getEz_user_id());

			if (userDos.isEmpty() || !passwordEncoder.matches(userDo.getEz_user_pw(), userDos.get(0).getEz_user_pw())) {
			    return null; // 비밀번호 불일치 또는 결과가 없는 경우
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDos.size() > 0 ? userDos.get(0) : null;
	}
	
	 // 개인정보수정 작업하던 것 240412 
	  public int updateUserAccount(UserDo userDo) {
	  System.out.println("[UserDao] updateUserAccount()"); 
	  
	  String sql = "UPDATE ez_user SET " 
			  + "ez_user_name = ?, " 
			  + "ez_user_age = ?, "
			  + "ez_user_gender = ?, " 
			  + "ez_user_weight = ?, " 
			  + "ez_user_phone = ?, " 
			  + "ez_user_mail = ?, " 
			  + "ez_user_keyword = ?, " 
			  + "ez_user_mod_date = NOW() " 
			  + "WHERE ez_user_id = ?"; 
	  int result = -1; 
	  
	  try {
		  result = jdbcTemplate.update(sql, 
				  userDo.getEz_user_name(), 
				  userDo.getEz_user_age(), 
				  userDo.getEz_user_gender(), 
				  userDo.getEz_user_weight(), 
				  userDo.getEz_user_phone(),
				  userDo.getEz_user_mail(), 
				  userDo.getEz_user_keyword(),
				  userDo.getEz_user_id());
	  } catch (Exception e) {
		  e.printStackTrace(); } return result; } 
	  
	  
	  
	  public UserDo selectUser(String ez_user_id) { 
		  System.out.println("[UserDao] selectUser()");
		  
		  String sql = "SELECT * FROM ez_user " + "WHERE ez_user_id = ?";
		  
		  List<UserDo> userDos = new ArrayList<UserDo>();
		  
		  try {
			  userDos = jdbcTemplate.query(sql, new RowMapper<UserDo>() {
				  
				  @Override
				  public UserDo mapRow(ResultSet rs, int RowNum) throws SQLException {
				  
				  UserDo userDo = new UserDo();
				  userDo.setEz_user_id(rs.getString("ez_user_id"));
				  userDo.setEz_user_pw(rs.getString("ez_user_pw"));
				  userDo.setEz_user_name(rs.getString("ez_user_id"));
				  userDo.setEz_user_age(rs.getString("ez_user_id"));
				  userDo.setEz_user_gender(rs.getString("ez_user_id"));
				  userDo.setEz_user_weight(rs.getString("ez_user_id"));
				  userDo.setEz_user_phone(rs.getString("ez_user_id"));
				  userDo.setEz_user_mail(rs.getString("ez_user_id"));
				  userDo.setEz_user_keyword(rs.getString("ez_user_id"));
				  userDo.setEz_user_reg_date(rs.getString("ez_user_reg_date"));
				  userDo.setEz_user_mod_date(rs.getString("ez_user_mod_date"));
				  System.out.println("다오 셀렉트유저" + userDo);
				  return userDo;
			  	}  
			  }, ez_user_id);
		  } catch (Exception e) {
			  e.printStackTrace();
		  
	  } 
		  return userDos.size() > 0 ? userDos.get(0) : null;
	  }
	
	  
	  //새 비밀번호
	  public UserDo selectUser(String ez_user_id, String ez_user_name, String ez_user_mail) {
		  System.out.println("[UserDao] selectUser()");
		  String sql = "SELECT * FROM ez_user " + "WHERE ez_user_id = ? AND ez_user_name = ? AND ez_user_mail = ?";
		  List<UserDo> userDos = new ArrayList<UserDo>();
		  try {
			  userDos = jdbcTemplate.query(sql,  new RowMapper<UserDo>() {
				  @Override
				  public UserDo mapRow(ResultSet rs, int RowNum) throws SQLException {
					  UserDo userDo = new UserDo();
					  userDo.setEz_user_id(rs.getString("ez_user_id"));
					  userDo.setEz_user_pw(rs.getString("ez_user_pw"));
					  userDo.setEz_user_mail(rs.getString("ez_user_mail"));
					  userDo.setEz_user_reg_date(rs.getString("ez_user_reg_date"));
					  userDo.setEz_user_mod_date(rs.getString("ez_user_mod_date"));
					  return userDo;
				  }
			  }, ez_user_id, ez_user_name, ez_user_mail);
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return userDos.size() > 0 ? userDos.get(0) : null;
	  }
	  
	  public int updatePassword(String ez_user_id, String newPassword) {
		  System.out.println("[UserDao] updatePassword()");
		  String sql = "UPDATE ez_user SET "
				  		+ "ez_user_pw = ?, ez_user_mod_date = NOW() "
				  		+ "WHERE ez_user_id = ?";
		  int result = -1;
		  try {
			  result = jdbcTemplate.update(sql, passwordEncoder.encode(newPassword), ez_user_id);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  return result;
	  }
	  
	  
	  // 상담신청 확인
	  public int insertApply(ApplyDo applyDo, UserDo userDo, String ez_tr_user_ida, String trname) {
		  System.out.println("[UserDao] insertApply()");
		  String sql = "INSERT INTO ez_apply(ez_apply_user_name, "
				  					+ "ez_tr_user_id, "
				  					+ "ez_user_id, "
				  					+ "ez_apply_comment, "
				  					+ "ez_apply_phone, "
				  					+ "ez_apply_tr_name, "
				  					+ "ez_apply_reg_date, "
				  					+ "ez_apply_mod_date) VALUES (?, ?, ?, ?, ? ,?, NOW(), NOW())";
//		  + "ez_apply_mod_date) VALUES (?, ?, ?, ?, (SELECT ez_tr_user_name FROM ez_tr_user WHERE ez_tr_user_id = ?), NOW(), NOW())";
		  int result = -1;
		  
		  try {
			  String ez_user_id = userDo.getEz_user_id(); // 외래 키
//			  String ez_tr_user_id = applyDo.getTrainerDo().getEz_tr_user_id(); // 외래 키
			  String ez_tr_user_id = ez_tr_user_ida; // 외래 키
			  String ez_apply_tr_name = trname;
			  
			  result = jdbcTemplate.update(sql, applyDo.getEz_apply_user_name(), ez_tr_user_id, ez_user_id, applyDo.getEz_apply_comment(),userDo.getEz_user_phone() , ez_apply_tr_name);
			  
		  } catch(Exception e) {
			  e.printStackTrace();
		  } return result;
				  
	  }
	
	//유저 상세조회(트레이너 즐겨찾기용)
	public UserDo selectTrUsers(String userId) {
	System.out.println("[UserDao] selectTrUsers()");
		
		String sql = "SELECT * FROM ez_user " + "WHERE ez_user_id = ?";
		
		List<UserDo> userDos = null;
		
		try {
			userDos = jdbcTemplate.query(sql, new RowMapper<UserDo>() {
				
				@Override
				public UserDo mapRow(ResultSet rs, int RowNum) throws SQLException {
					UserDo userDo = new UserDo();
					userDo.setEz_user_id(rs.getString("ez_user_id"));
					userDo.setEz_user_pw(rs.getString("ez_user_pw"));
					userDo.setEz_user_name(rs.getString("ez_user_name"));
					userDo.setEz_user_age(rs.getString("ez_user_age"));
					userDo.setEz_user_phone(rs.getString("ez_user_phone"));
					userDo.setEz_user_mail(rs.getString("ez_user_mail"));
					userDo.setEz_user_gender(rs.getString("ez_user_gender"));
					userDo.setEz_user_weight(rs.getString("ez_user_weight"));
					userDo.setEz_user_keyword(rs.getString("ez_user_keyword"));
					userDo.setEz_user_reg_date(rs.getString("ez_user_reg_date"));
					userDo.setEz_user_mod_date(rs.getString("ez_user_mod_date"));
					return userDo;
				}
			}, userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDos.size() > 0 ? userDos.get(0) : null;
	}
	
	
	//트레이너 즐겨찾기 추가
//	public void addFavTr(UserDo userDo, TrainerDo trainerDo) {
//		System.out.println("유저다오 : updateUserAccount" );
//		
//		String sql = "INSERT INTO ez_fav_tr(ez_tr_user_id,ez_user_id)"
//				+ " VALUES(userDo, trainerDo)";
//		jdbcTemplate.update(sql);
//		
//	}
	
	
	
//	//즐겨찾기 영상 찾기 
//	public ContentsDo findCon(int no) {
//		System.out.println("유저다오 : findCon");
//		
//		String sql = "SELECT * FROM ez_con WHERE ez_con_no = ? ";
//		
//		List<ContentsDo> contentsDos = null;
//		
//		try {
//			contentsDos = jdbcTemplate.query(sql, new RowMapper<ContentsDo>() {
//				
//				@Override
//				public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException{
//					
//					ContentsDo contentsDo = new ContentsDo();
//					contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
//					contentsDo.setEz_con_title(rs.getString("ez_con_title"));
//					contentsDo.setEz_con_info(rs.getString("ez_con_info"));
//					contentsDo.setEz_con_level(rs.getString("ez_con_level"));
//					contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
//					contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
//					contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
//					contentsDo.setEz_con_tr_name("ez_con_tr_name");
//					contentsDo.setEz_con_video(rs.getString("ez_con_video"));
//				
//					String ez_tr_user_id = rs.getString("ez_tr_user_id");
//					TrainerDo trainerDo = new TrainerDo();
//					
//				    trainerDo.setEz_tr_user_id(ez_tr_user_id); // TrainerDo 객체의 id 필드 설정
//				    contentsDo.setTrainerDo(trainerDo); //객체 관계 설정
//					System.out.println("즐겨찾기 아이디찾기 아이디 : " + contentsDo.getTrainerDo().getEz_tr_user_id());
//					return contentsDo;
//				}	
//			},no);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return contentsDos.size() > 0 ? contentsDos.get(0) : null;
//	}
	
	
	//영상 즐겨찾기 추가 및 제거
//		public void addFavTr(UserDo userDo, int contentsNo, String contentsTrId) {
			public void addFavTr(UserDo userDo, ContentsDo contentsDo) {
			System.out.println("유저다오 : addFavTr");

		    TrainerDo trainerDo = contentsDo.getTrainerDo();
		    
		    
		    // TrainerDo 객체가 null이 아닌 경우에만 작업을 수행합니다.
		    if (trainerDo != null) {
		        System.out.println(trainerDo.getEz_tr_user_id());
		        System.out.println(contentsDo.getEz_con_no());
		        String sql = "INSERT INTO ez_fav_con(ez_tr_id, ez_user_id, ez_con_no) VALUES(?,?,?)";
		       
		        try {
		            jdbcTemplate.update(sql,
		                trainerDo.getEz_tr_user_id(), 
		                userDo.getEz_user_id(),
		                contentsDo.getEz_con_no());
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("TrainerDo 객체가 null입니다.");
		    }
		    

		}
			
	         public int toggleFavtr(UserDo loginedUserDo, String ez_tr_id , FavTrDo favTrDo) {

	             String sqlCheck = "SELECT COUNT(*) FROM ez_fav_tr WHERE ez_user_id = ? AND ez_tr_id = ?";
	             String sqlInsert = "INSERT INTO ez_fav_tr (ez_user_id, ez_tr_id) VALUES (?, ?)";
	             String sqlDelete = "DELETE FROM ez_fav_tr WHERE ez_user_id = ? AND ez_tr_id = ?";

	               int result = -1;

	               try {
	                   int count = jdbcTemplate.queryForObject(sqlCheck, Integer.class, loginedUserDo.getEz_user_id(), ez_tr_id);

	                   if (count == 0) {
	                       // 해당 트레이너가 즐겨찾기되어 있지 않은 경우 추가
	                       result = jdbcTemplate.update(sqlInsert, loginedUserDo.getEz_user_id(), ez_tr_id);
	                   } else {
	                       // 이미 즐겨찾기된 상태인 경우 삭제
	                       result = jdbcTemplate.update(sqlDelete, loginedUserDo.getEz_user_id(), ez_tr_id);
	                   }
	               } catch (Exception e) {
	                   e.printStackTrace();
	               }

	               return result;
	            }

				
				
//		사용자별 즐겨찾기한 트레이너 조회
		public List<TrainerDo> selectAllFavTr(FavTrDo favTrDo ,TrainerDo trainerDo ,UserDo userDo) {
			
			String sql = "SELECT * FROM ez_tr_user WHERE ez_tr_user_id= ANY (SELECT ez_tr_id FROM ez_fav_tr WHERE ez_user_id = ?)";
			
			List<TrainerDo> favTrDos =new ArrayList<TrainerDo>();
			
			try {
				favTrDos=jdbcTemplate.query(sql,new RowMapper<TrainerDo>() {

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
						System.out.println(trainerDo.getEz_tr_user_id());
						return trainerDo;
					}
					
				},userDo.getEz_user_id());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(favTrDos.size());
			
			return favTrDos.size() > 0 ? favTrDos : null;
			
		}
		
		
//		사용자별 영상즐겨찾기 리스트 출력
		
		public List<ContentsDo> selectAllFavCon(FavconDo favconDo , TrainerDo trainerDo ,UserDo loginedUserDo) {
			
//			String sql = "SELECT * FROM ez_tr_user WHERE ez_tr_user_id= ANY (SELECT ez_tr_id FROM ez_fav_con WHERE ez_user_id = ? ) ";
			String sql = "SELECT * FROM ez_con WHERE ez_con_no = ANY (SELECT ez_con_no FROM ez_fav_con WHERE ez_user_id = ?)";
			
			List<ContentsDo> contentsDos = new ArrayList<ContentsDo>();
			
			try {
				contentsDos=jdbcTemplate.query(sql,new RowMapper<ContentsDo>() {
					@Override
					public ContentsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
						ContentsDo contentsDo = new ContentsDo();

						contentsDo.setEz_con_title(rs.getString("ez_con_title"));
						contentsDo.setEz_con_info(rs.getString("ez_con_info"));
						contentsDo.setEz_con_keyword(rs.getString("ez_con_keyword"));
						contentsDo.setEz_con_level(rs.getString("ez_con_level"));
						contentsDo.setEz_con_mod_date(rs.getString("ez_con_mod_date"));
						contentsDo.setEz_con_reg_date(rs.getString("ez_con_reg_date"));
						contentsDo.setEz_con_tr_name(rs.getString("ez_con_tr_name"));
						contentsDo.setEz_con_video(rs.getString("ez_con_video"));
						contentsDo.setEz_con_no(rs.getInt("ez_con_no"));
						
						return contentsDo;
					}

				},loginedUserDo.getEz_user_id());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return contentsDos.size() > 0 ? contentsDos :null;
			
		}
		
		
		
//		사용자 영상즐겨찾기 추가/제거
		public int insterFavCon(UserDo loginedUserDo,String ez_con_no,FavconDo favconDo,ContentsDo contentsDo) {
			
			String sqlCheck = "SELECT COUNT(*) FROM ez_fav_con WHERE ez_user_id = ? AND ez_con_no = ?";
			String sqlInsert = "INSERT INTO ez_fav_con (ez_tr_id , ez_user_id , ez_con_no) VALUES ((SELECT ez_tr_user_id FROM ez_con WHERE ez_con_no = ?),?,?)";
			String sqlDelete = "DELETE FROM ez_fav_con WHERE ez_user_id = ? AND ez_con_no = ?";
			int result=-1;
			
			try {
                int count = jdbcTemplate.queryForObject(sqlCheck, Integer.class, loginedUserDo.getEz_user_id(), ez_con_no);

                if (count == 0) {
                    // 해당 영상이 즐겨찾기되어 있지 않은 경우 추가
                	result=jdbcTemplate.update(sqlInsert,ez_con_no,loginedUserDo.getEz_user_id(),ez_con_no);
                } else {
                    // 이미 즐겨찾기된 상태인 경우 삭제
                    result = jdbcTemplate.update(sqlDelete, loginedUserDo.getEz_user_id(), ez_con_no);
                }
                
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
			
		}
}
