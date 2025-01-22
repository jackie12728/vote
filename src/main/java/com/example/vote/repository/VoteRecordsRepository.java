package com.example.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vote.model.entity.VoteRecords;

@Repository
public interface VoteRecordsRepository extends JpaRepository<VoteRecords, Long> {

}
