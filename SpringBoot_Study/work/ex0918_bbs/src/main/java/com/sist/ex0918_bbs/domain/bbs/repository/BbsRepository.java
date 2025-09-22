package com.sist.ex0918_bbs.domain.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.ex0918_bbs.domain.bbs.entity.Bbs;

public interface BbsRepository extends JpaRepository<Bbs, Long> {
    
}
