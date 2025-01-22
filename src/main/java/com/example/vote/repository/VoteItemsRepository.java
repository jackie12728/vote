package com.example.vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vote.model.entity.VoteItems;

@Repository
public interface VoteItemsRepository extends JpaRepository<VoteItems, Long> {

	// 使用 JPQL 查詢所有投票項目
    @Query(value = """
    				SELECT *
    				FROM vote_items
    			   """
    		, nativeQuery = true)
    List<VoteItems> findAllVoteItems();
}
