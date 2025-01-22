package com.example.vote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vote.model.dto.VoteItemsDTO;
import com.example.vote.service.VoteItemsService;

@SpringBootTest
public class UpdateVoteItemTest {

	@Autowired
	private VoteItemsService voteItemsService;
	
	@Test
	public void test() {
		VoteItemsDTO voteItemsDTO = new VoteItemsDTO(1L, "好耶");
		voteItemsDTO = voteItemsService.updateVoteItem(voteItemsDTO);
		System.out.println(voteItemsDTO);
	}
}
