package com.example.vote.service;

import java.util.List;

import com.example.vote.model.dto.VoteRecordsDTO;

public interface VoteRecordsService {

	// 查詢所有投票紀錄
	public List<VoteRecordsDTO> getAllVoteRecords();
	
	// 新增投票紀錄
	public List<VoteRecordsDTO> saveVoteRecords(List<VoteRecordsDTO> voteRecordsDTOs);
}
