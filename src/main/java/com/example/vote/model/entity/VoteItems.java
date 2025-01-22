package com.example.vote.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 實體類與資料表對應(會自動建立資料表)
@Table(name = "vote_items")
public class VoteItems {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId; // 投票項目編號
	
	@Column(nullable = false)
    private String itemName; // 投票項目名稱
	
	@OneToMany(mappedBy = "voteItems", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<VoteRecords> voteRecords;
}
