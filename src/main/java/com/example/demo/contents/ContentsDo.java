package com.example.demo.contents;

import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.favcon.FavconDo;
import com.example.demo.trainer.TrainerDo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ez_con")
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentsDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ez_con_no", length = 11)
    private int ez_con_no;

    @ManyToOne
    @JoinColumn(name = "ez_tr_user_id", nullable = false)
    private TrainerDo trainerDo;

    @Column(name = "ez_con_tr_name", nullable = false , length = 20)
    private String ez_con_tr_name;

    @Column(name = "ez_con_title", nullable = false, length = 60)
    private String ez_con_title;

    @Column(name = "ez_con_video", nullable = false, length = 140)
    private String  ez_con_video;

    @Column(name = "ez_con_info", nullable = false , length = 150)
    private String ez_con_info;

    @Column(name = "ez_con_keyword", nullable = false, length = 90) //키워드 합 고려
    private String ez_con_keyword;

    @Column(name = "ez_con_level", nullable = false, length = 10)
    private String ez_con_level;

    @Column(name = "ez_con_report", length = 2)  //평상시 0 / 신고시 1
    private String ez_con_report;
    
    @Column(name = "ez_con_reg_date", nullable = false, length = 30)
    private String ez_con_reg_date;

    @Column(name = "ez_con_mod_date", nullable = false, length = 30)
    private String ez_con_mod_date;

   
    
	 @OneToMany(mappedBy = "contentsDo", fetch = FetchType.LAZY)
	 private List<FavconDo> favconDos;

}
