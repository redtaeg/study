package com.example.demo.trainer;

import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.apply.ApplyDo;
import com.example.demo.contents.ContentsDo;
import com.example.demo.favcon.FavconDo;
import com.example.demo.favtr.FavTrDo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "ez_tr_user")
@Table
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TrainerDo {
	


	public String getEz_tr_user_id() {
		return ez_tr_user_id;
	}

	public void setEz_tr_user_id(String ez_tr_user_id) {
		this.ez_tr_user_id = ez_tr_user_id;
	}

	public int getEz_tr_user_approval() {
		return ez_tr_user_approval;
	}

	public void setEz_tr_user_approval(int ez_tr_user_approval) {
		this.ez_tr_user_approval = ez_tr_user_approval;
	}

	public String getEz_tr_user_pw() {
		return ez_tr_user_pw;
	}

	public void setEz_tr_user_pw(String ez_tr_user_pw) {
		this.ez_tr_user_pw = ez_tr_user_pw;
	}

	public String getEz_tr_user_name() {
		return ez_tr_user_name;
	}

	public void setEz_tr_user_name(String ez_tr_user_name) {
		this.ez_tr_user_name = ez_tr_user_name;
	}

	public String getEz_tr_user_age() {
		return ez_tr_user_age;
	}

	public void setEz_tr_user_age(String ez_tr_user_age) {
		this.ez_tr_user_age = ez_tr_user_age;
	}

	public String getEz_tr_user_region() {
		return ez_tr_user_region;
	}

	public void setEz_tr_user_region(String ez_tr_user_region) {
		this.ez_tr_user_region = ez_tr_user_region;
	}

	public String getEz_tr_user_mail() {
		return ez_tr_user_mail;
	}

	public void setEz_tr_user_mail(String ez_tr_user_mail) {
		this.ez_tr_user_mail = ez_tr_user_mail;
	}

	public String getEz_tr_user_phone() {
		return ez_tr_user_phone;
	}

	public void setEz_tr_user_phone(String ez_tr_user_phone) {
		this.ez_tr_user_phone = ez_tr_user_phone;
	}

	public String getEz_tr_user_gender() {
		return ez_tr_user_gender;
	}

	public void setEz_tr_user_gender(String ez_tr_user_gender) {
		this.ez_tr_user_gender = ez_tr_user_gender;
	}

	public String getEz_tr_user_keyword() {
		return ez_tr_user_keyword;
	}

	public void setEz_tr_user_keyword(String ez_tr_user_keyword) {
		this.ez_tr_user_keyword = ez_tr_user_keyword;
	}

	public String getEz_tr_user_career() {
		return ez_tr_user_career;
	}

	public void setEz_tr_user_career(String ez_tr_user_career) {
		this.ez_tr_user_career = ez_tr_user_career;
	}

	public String getEz_tr_user_profile() {
		return ez_tr_user_profile;
	}

	public void setEz_tr_user_profile(String ez_tr_user_profile) {
		this.ez_tr_user_profile = ez_tr_user_profile;
	}

	public String getEz_tr_user_photo() {
		return ez_tr_user_photo;
	}

	public void setEz_tr_user_photo(String ez_tr_user_photo) {
		this.ez_tr_user_photo = ez_tr_user_photo;
	}

	public String getEz_tr_user_image() {
		return ez_tr_user_image;
	}

	public void setEz_tr_user_image(String ez_tr_user_image) {
		this.ez_tr_user_image = ez_tr_user_image;
	}

	public String getEz_tr_user_reg_date() {
		return ez_tr_user_reg_date;
	}

	public void setEz_tr_user_reg_date(String ez_tr_user_reg_date) {
		this.ez_tr_user_reg_date = ez_tr_user_reg_date;
	}

	public String getEz_tr_user_mod_date() {
		return ez_tr_user_mod_date;
	}

	public void setEz_tr_user_mod_date(String ez_tr_user_mod_date) {
		this.ez_tr_user_mod_date = ez_tr_user_mod_date;
	}

	public List<FavTrDo> getFavTrDos() {
		return favTrDos;
	}

	public void setFavTrDos(List<FavTrDo> favTrDos) {
		this.favTrDos = favTrDos;
	}

	public List<ApplyDo> getApplyDos() {
		return applyDos;
	}

	public void setApplyDos(List<ApplyDo> applyDos) {
		this.applyDos = applyDos;
	}

	public List<ContentsDo> getContentsDos() {
		return contentsDos;
	}

	public void setContentsDos(List<ContentsDo> contentsDos) {
		this.contentsDos = contentsDos;
	}

	@Id
	@Column(nullable = false, length = 20)
	private String ez_tr_user_id;
	
	@Column(nullable = false, length = 2)
	private int ez_tr_user_approval;
	
	@Column(nullable = false, length = 80) //BCryptPasswordEncoder 60바이트
	private String ez_tr_user_pw;
	
	@Column(nullable = false, length = 20)
	private String ez_tr_user_name;
	
	@Column(nullable = false, length = 3)
	private String ez_tr_user_age;
	
	@Column(nullable = false, length = 30)
	private String ez_tr_user_region;
	
	@Column(nullable = false, length = 30)
	private String ez_tr_user_mail;
	
	@Column(nullable = false, length = 20)
	private String ez_tr_user_phone;
	
	@Column(nullable = false, length = 10)
	private String ez_tr_user_gender;
	
	@Column(nullable = false, length = 90)
	private String ez_tr_user_keyword;
	
	@Column(nullable = false, length = 150)  //50글자
	private String ez_tr_user_career;
	
	@Column(nullable = false , length = 180)   
	private String ez_tr_user_profile;
	
	@Column(nullable = false , length = 140)
	private String ez_tr_user_photo;
	
	@Column(nullable = false , length = 140)
	private String ez_tr_user_image;
	
	@Column(nullable = false, length = 30)
	private String ez_tr_user_reg_date;
	
	@Column(nullable = false, length = 30)
	private String ez_tr_user_mod_date;
	

	 @OneToMany(mappedBy = "trainerDo", fetch = FetchType.LAZY)
//	 @JoinColumn(name = "ez_tr_id")
	 private List<FavconDo> favconDos;
	 
	 @OneToMany(mappedBy = "trainerDo", fetch = FetchType.LAZY)
////	 @JoinColumn(name = "ez_tr_id")
	 private List<FavTrDo> favTrDos;
	
	 @OneToMany(mappedBy = "trainerDo", fetch = FetchType.LAZY)
//	 @JoinColumn(name = "ez_tr_id")
	 private List<ApplyDo> applyDos;
	 
	 
	 @OneToMany(mappedBy = "trainerDo", fetch = FetchType.LAZY)
//	 @JoinColumn(name = "ez_tr_id")
	 private List<ContentsDo> contentsDos;
	
	
}


