package com.example.vote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.model.dto.VoteRecordsDTO;
import com.example.vote.response.ApiResponse;
import com.example.vote.service.VoteRecordsService;

/*
 * WEB REST API
 * ----------------------------------
 * Servlet-Path: /voteRecords
 * ----------------------------------
 * GET  /getAll 查詢所有投票紀錄
 * POST /save   新增投票紀錄
 * */
@RestController
@RequestMapping("/voteRecords")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class VoteRecordsController {

	@Autowired
	private VoteRecordsService voteRecordsService;
	
	// 查詢所有投票紀錄
	@GetMapping("/getAll")
	public ResponseEntity<ApiResponse<List<VoteRecordsDTO>>> getAllVoteRecords() {
		List<VoteRecordsDTO> voteRecordsDTOs = voteRecordsService.getAllVoteRecords();
		
		if(voteRecordsDTOs.isEmpty()) {
			return ResponseEntity.status(404).body(ApiResponse.error(404, "查詢失敗"));
		}
		
		return ResponseEntity.ok(ApiResponse.success("查詢成功", voteRecordsDTOs));
	}
	
	// 新增投票紀錄
	@PostMapping("/save")
	public ResponseEntity<ApiResponse<String>> saveVoteRecords(@RequestBody List<VoteRecordsDTO> voteRecordsDTOs) {
		List<VoteRecordsDTO> vRecordsDTOs = voteRecordsService.saveVoteRecords(voteRecordsDTOs);
		
		if(vRecordsDTOs.isEmpty()) {
			return ResponseEntity.status(404).body(ApiResponse.error(404, "新增失敗"));
		}
		
		return ResponseEntity.ok(ApiResponse.success("新增成功", "新增成功"));
	}
}
