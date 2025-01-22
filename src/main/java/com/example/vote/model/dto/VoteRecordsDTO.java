package com.example.vote.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteRecordsDTO {

	private Long id; // 投票編號
	private String voter; // 投票人
	private Long itemId; // 投票項目編號
}
