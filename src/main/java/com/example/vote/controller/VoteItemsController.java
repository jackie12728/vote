package com.example.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.response.ApiResponse;
import com.example.vote.model.dto.VoteItemsDTO;
import com.example.vote.service.VoteItemsService;

/*
 * WEB REST API
 * ----------------------------------
 * Servlet-Path: /voteItems
 * ----------------------------------
 * GET    /getAll 查詢所有投票項目
 * POST   /add    新增投票項目
 * POST   /update 更新投票項目
 * DELETE /{itemId} 刪除投票項目
 * */
@RestController
@RequestMapping("/voteItems")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class VoteItemsController {

	@Autowired
	private VoteItemsService voteItemsService;
	
	// 查詢所有投票項目
	@GetMapping("/getAll")
	public ResponseEntity<ApiResponse<List<VoteItemsDTO>>> getAllVoteItems() {
		List<VoteItemsDTO> voteItemsDTOs = voteItemsService.getAllVoteItems();
		
		if(voteItemsDTOs.isEmpty()) {
			return ResponseEntity.status(404).body(ApiResponse.error(404, "查詢失敗"));
		}
		
		return ResponseEntity.ok(ApiResponse.success("查詢成功", voteItemsDTOs));
	}
	
	// 新增投票項目
	@PostMapping("/add")
	public ResponseEntity<ApiResponse<String>> addVoteItem(@RequestBody VoteItemsDTO voteItemsDTO) {
		VoteItemsDTO vItemsDTO = voteItemsService.addVoteItem(voteItemsDTO);
		
		if(vItemsDTO == null) {
			return ResponseEntity.status(404).body(ApiResponse.error(404, "新增失敗"));
		}
		
		return ResponseEntity.ok(ApiResponse.success("新增成功", "新增成功"));
	}
	
	// 更新投票項目
	@PostMapping("/update")
	public ResponseEntity<ApiResponse<String>> updateVoteItem(@RequestBody VoteItemsDTO voteItemsDTO) {
		VoteItemsDTO vItemsDTO = voteItemsService.updateVoteItem(voteItemsDTO);
		
		if(vItemsDTO == null) {
			return ResponseEntity.status(404).body(ApiResponse.error(404, "更新失敗"));
		}
		
		return ResponseEntity.ok(ApiResponse.success("更新成功", "更新成功"));
	}
	
	// 刪除投票項目
	@DeleteMapping("/{itemId}")
	public ResponseEntity<ApiResponse<String>> deleteVoteItem(@PathVariable Long itemId) {
		voteItemsService.deleteVoteItem(itemId);
		return ResponseEntity.ok(ApiResponse.success("刪除成功", "刪除成功"));
	}
}
