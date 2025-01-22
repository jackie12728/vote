package com.example.vote.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 實體類與資料表對應(會自動建立資料表)
@Table(name = "vote_records")
public class VoteRecords {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 投票編號
	
	@Column(nullable = false)
    private String voter; // 投票人
	
	@ManyToOne
    @JoinColumn(name = "item_id")
    private VoteItems voteItems; // 投票項目
}
