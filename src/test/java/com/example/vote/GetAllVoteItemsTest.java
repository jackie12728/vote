package com.example.vote;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vote.model.dto.VoteItemsDTO;
import com.example.vote.service.VoteItemsService;

@SpringBootTest
public class GetAllVoteItemsTest {

	@Autowired
	private VoteItemsService voteItemsService;
	
	@Test
	public void test() {
		List<VoteItemsDTO> voteItemsDTOs = voteItemsService.getAllVoteItems();
		System.out.println(voteItemsDTOs);
	}
}
