package com.example.demo.favcon;

import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.contents.ContentsDo;
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

@Entity(name = "ez_fav_con")
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavconDo {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ez_fav_con_no" , length = 11)
	    private int ez_fav_con_no;
	   
	    @ManyToOne
	    @JoinColumn(name = "ez_tr_id", nullable = true)
	    private TrainerDo trainerDo; // TrainerDo와의 매핑

	    @ManyToOne
	    @JoinColumn(name = "ez_user_id", nullable = true)
	    private UserDo userDo;
	    
	    @ManyToOne
	    @JoinColumn(name = "ez_con_no", nullable = true)
	    private ContentsDo contentsDo;  
	    
}
