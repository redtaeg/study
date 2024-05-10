package com.example.demo.favtr;

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

@Entity(name = "ez_fav_tr")
@Table
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavTrDo {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       @Column(name = "ez_fav_tr_no")
       private Long ez_fav_tr_no;

       @ManyToOne
       @JoinColumn(name = "ez_tr_id", nullable = false)
       private TrainerDo trainerDo;

       @ManyToOne
       @JoinColumn(name = "ez_user_id", nullable = false)
       private UserDo userDo;
       
       @Column(nullable = false, columnDefinition = "INT DEFAULT 0" , length = 2)
       private int ez_fav_tr_approval;
       


}