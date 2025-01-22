package com.example.vote.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteItemsDTO {

	private Long itemId; // 投票項目編號
	private String itemName; // 投票項目名稱
}
