package com.example.vote.service;

import java.util.List;

import com.example.vote.model.dto.VoteItemsDTO;

public interface VoteItemsService {

	// 查詢所有投票項目
	public List<VoteItemsDTO> getAllVoteItems();
	
	// 新增投票項目
	public VoteItemsDTO addVoteItem(VoteItemsDTO voteItemsDTO);
	
	// 更新投票項目
	public VoteItemsDTO updateVoteItem(VoteItemsDTO voteItemsDTO);
	
	// 刪除投票項目
	public void deleteVoteItem(Long itemId);
}
