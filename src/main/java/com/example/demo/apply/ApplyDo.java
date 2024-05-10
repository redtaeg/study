package com.example.demo.apply;

import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.trainer.TrainerDo;
import com.example.demo.user.UserDo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ez_apply")
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyDo {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ez_apply_no", length = 11)
		private int ez_apply_no;
		
		@ManyToOne
		@JoinColumn(name = "ez_user_id", nullable = false)
		private UserDo userDo;
		
		@ManyToOne
		@JoinColumn(name = "ez_tr_user_id", nullable = false)
		private TrainerDo trainerDo;
		
		@Column(name = "ez_apply_user_name", length = 20, nullable = false)
		private String ez_apply_user_name;
		
        @Column(name = "ez_apply_tr_name", length = 20, nullable = false)
        private String ez_apply_tr_name;
 
        @Column(name = "ez_apply_comment", length = 500, nullable = false)
        private String ez_apply_comment;
        
        @Column(name = "ez_apply_phone", length = 20, nullable = false)
        private String ez_apply_phone;

        @Column(name = "ez_apply_reg_date", length = 30, nullable = false)
        private String ez_apply_reg_date;

        @Column(name = "ez_apply_mod_date", length = 30, nullable = false)
        private String ez_apply_mod_date;

        @Column(name = "ez_apply_result", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
        private int ez_apply_result;

}
