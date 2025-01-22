package com.example.vote.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vote.model.dto.VoteRecordsDTO;
import com.example.vote.model.entity.VoteItems;
import com.example.vote.model.entity.VoteRecords;
import com.example.vote.repository.VoteRecordsRepository;
import com.example.vote.service.VoteRecordsService;

import jakarta.transaction.Transactional;

@Service
public class VoteRecordsServiceImpl implements VoteRecordsService {

	@Autowired
	private VoteRecordsRepository voteRecordsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// 查詢所有投票紀錄
	@Override
	@Transactional
	public List<VoteRecordsDTO> getAllVoteRecords() {
		return voteRecordsRepository.findAll().stream()
				.map(record -> new VoteRecordsDTO(
						record.getId(),
		                record.getVoter(),
		                record.getVoteItems() != null ? record.getVoteItems().getItemId() : null))
				.collect(Collectors.toList());
	}

	// 新增投票紀錄
	@Override
	@Transactional
	public List<VoteRecordsDTO> saveVoteRecords(List<VoteRecordsDTO> voteRecordsDTOs) {
	    // 將 DTO 轉換為實體
	    List<VoteRecords> voteRecords = voteRecordsDTOs.stream().map(dto -> {
	        VoteRecords record = modelMapper.map(dto, VoteRecords.class);

	        // 手動設置關聯的 VoteItems（由 itemId 尋找）
	        if (dto.getItemId() != null) {
	            VoteItems voteItems = new VoteItems();
	            voteItems.setItemId(dto.getItemId());
	            record.setVoteItems(voteItems); // 設置關聯
	        }

	        return record;
	    }).collect(Collectors.toList());

	    // 保存到資料庫
	    List<VoteRecords> savedRecords = voteRecordsRepository.saveAll(voteRecords);

	    // 將保存後的實體轉回 DTO 並返回
	    return savedRecords.stream()
	            .map(record -> new VoteRecordsDTO(
						record.getId(),
		                record.getVoter(),
		                record.getVoteItems() != null ? record.getVoteItems().getItemId() : null))
	            .collect(Collectors.toList());
	}

}
