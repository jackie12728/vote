package com.example.vote.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vote.model.dto.VoteItemsDTO;
import com.example.vote.model.entity.VoteItems;
import com.example.vote.repository.VoteItemsRepository;
import com.example.vote.service.VoteItemsService;

import jakarta.transaction.Transactional;

@Service
public class VoteItemsServiceImpl implements VoteItemsService {

	@Autowired
	private VoteItemsRepository voteItemsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// 查詢所有投票項目
	@Override
	public List<VoteItemsDTO> getAllVoteItems() {
		return voteItemsRepository.findAllVoteItems().stream()
				.map(voteItem -> modelMapper.map(voteItem, VoteItemsDTO.class))
				.collect(Collectors.toList());
	}

	// 新增投票項目
	@Override
	public VoteItemsDTO addVoteItem(VoteItemsDTO voteItemsDTO) {
		VoteItems voteItems = modelMapper.map(voteItemsDTO, VoteItems.class);
		voteItems = voteItemsRepository.save(voteItems);
		return modelMapper.map(voteItems, VoteItemsDTO.class);
	}

	// 更新投票項目
	@Override
	public VoteItemsDTO updateVoteItem(VoteItemsDTO voteItemsDTO) {
		Optional<VoteItems> optionalVoteItem = voteItemsRepository.findById(voteItemsDTO.getItemId());
		if (optionalVoteItem.isPresent()) {
            VoteItems voteItem = optionalVoteItem.get();
            voteItem.setItemName(voteItemsDTO.getItemName());  // 更新名稱
            voteItem = voteItemsRepository.save(voteItem);  // 儲存更新後的投票項目
            return modelMapper.map(voteItem, VoteItemsDTO.class);
        } else {
            throw new RuntimeException("投票項目不存在，無法更新！");
        }
	}

	// 刪除投票項目
	@Override
	@Transactional
	public void deleteVoteItem(Long itemId) {
		if (voteItemsRepository.existsById(itemId)) {
            voteItemsRepository.deleteById(itemId);  // 刪除投票項目
        } else {
            throw new RuntimeException("投票項目不存在，無法刪除！");
        }
	}

}
