package com.example.vote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vote.model.dto.VoteItemsDTO;
import com.example.vote.service.VoteItemsService;

@SpringBootTest
public class AddVoteItemTest {

	@Autowired
	private VoteItemsService voteItemsService;
	
	@Test
	public void test() {
		String itemName = "沒意見";
		VoteItemsDTO voteItemsDTO = new VoteItemsDTO();
		voteItemsDTO.setItemName(itemName);
		voteItemsDTO = voteItemsService.addVoteItem(voteItemsDTO);
		System.out.println(voteItemsDTO);
	}
}
