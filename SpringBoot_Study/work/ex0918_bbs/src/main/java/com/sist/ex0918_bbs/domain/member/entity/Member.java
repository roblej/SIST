package com.sist.ex0918_bbs.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sist.ex0918_bbs.global.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Member extends BaseEntity{

    private String mid, mname;

    //비밀번호는 외부로 가는 것이 보안 좋지 않기 때문에
    // JSON으로 변환하지 못하게 설정
    @JsonIgnore
    private String mpw;
    private String accessToken;

    @Column(name = "refresh_token",length = 1024)
    private String refreshToken;
}
