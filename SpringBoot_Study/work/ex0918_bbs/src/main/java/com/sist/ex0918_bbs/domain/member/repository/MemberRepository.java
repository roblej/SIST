package com.sist.ex0918_bbs.domain.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.ex0918_bbs.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //아이디로 검색
    Optional<Member> findByMid(String mid);
    //refreshToken으로 검색
    
}
