package com.example.vote;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vote.model.dto.VoteRecordsDTO;
import com.example.vote.service.VoteRecordsService;

@SpringBootTest
public class GetAllVoteRecordsTest {

	@Autowired
	private VoteRecordsService voteRecordsService;
	
	@Test
	public void test() {
		List<VoteRecordsDTO> voteRecordsDTOs = voteRecordsService.getAllVoteRecords();
		System.out.println(voteRecordsDTOs);
	}
}
