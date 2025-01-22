package com.example.vote;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vote.service.VoteItemsService;

@SpringBootTest
public class DeleteVoteItemTest {

	@Autowired
	private VoteItemsService voteItemsService;
	
	@Test
	public void test() {
		voteItemsService.deleteVoteItem(4L);
	}
}
