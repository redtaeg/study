package com.example.demo.admin;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;	

@Entity(name = "ez_notice")
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDo {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ez_notice_no")
	    private int ez_notice_no;

	    @Column(name = "ez_notice_title", nullable = false, length = 100)
	    private String ez_notice_title;

	    @Column(name = "ez_notice_content", nullable = false, length = 800)
	    private String ez_notice_content;
	    
	    @Column(name = "ez_notice_reg_date", nullable = false, length = 30)
	    private String ez_notice_reg_date;

	    @Column(name = "ez_notice_mod_date", nullable = false, length = 30)
	    private String ez_notice_mod_date;
	    
	    @Column(name = "ez_notice_views", nullable = false, columnDefinition = "INT DEFAULT 0", length = 11)
	    private int ez_notice_views;

}
