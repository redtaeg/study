package com.example.demo.user;

import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.favcon.FavconDo;
import com.example.demo.favtr.FavTrDo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ez_user")
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDo {
	

//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    @Column(name = "ez_user_no")
//	    private Long ez_user_no;
		@Id
		@Column(name = "ez_user_id", nullable = false, unique = true, length = 50)
		private String ez_user_id;

	    @Column(name = "ez_user_pw", nullable = false , length = 80) //BCryptPasswordEncoder 60바이트
	    private String ez_user_pw;

	    @Column(name = "ez_user_name", nullable = false , length = 20)
	    private String ez_user_name;

	    @Column(name = "ez_user_age", nullable = false , length = 3)
	    private String ez_user_age;

	    @Column(name = "ez_user_phone", nullable = false , length = 20)
	    private String ez_user_phone;

	    @Column(name = "ez_user_mail", nullable = false , length = 50)
	    private String ez_user_mail;

	    @Column(name = "ez_user_gender", nullable = false , length = 20)
	    private String ez_user_gender;

	    @Column(name = "ez_user_weight", nullable = false , length = 3)
	    private String ez_user_weight;

	    @Column(name = "ez_user_keyword", nullable = false , length = 200)
	    private String ez_user_keyword;

	    @Column(name = "ez_user_reg_date", nullable = false, length = 30)
	    private String ez_user_reg_date;

	    @Column(name = "ez_user_mod_date", nullable = false, length = 30)
	    private String ez_user_mod_date;

	    @OneToMany(mappedBy = "userDo")
	    private List<FavTrDo> favoriteTrainers;

	    @OneToMany(mappedBy = "userDo")
	    private List<FavconDo> favoriteContents;


}
