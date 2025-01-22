package com.example.vote;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.vote.model.dto.VoteRecordsDTO;
import com.example.vote.service.VoteRecordsService;

@SpringBootTest
public class SaveVoteRecordsTest {

	@Autowired
	private VoteRecordsService voteRecordsService;
	
	@Test
	public void test() {
		List<VoteRecordsDTO> recordsToSave = Arrays.asList(
                new VoteRecordsDTO(null, "Alice", 1L),
                new VoteRecordsDTO(null, "Bob", 2L)
        );
		
		List<VoteRecordsDTO> voteRecordsList = voteRecordsService.saveVoteRecords(recordsToSave);
        System.out.println(voteRecordsList);
	}
}
