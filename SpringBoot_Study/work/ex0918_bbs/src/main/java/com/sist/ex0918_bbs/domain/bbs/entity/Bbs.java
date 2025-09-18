package com.sist.ex0918_bbs.domain.bbs.entity;

import com.sist.ex0918_bbs.global.jpa.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@SuperBuilder  //현재클래스와 상위클래스의 필드값을 저장하기 위한 메서드들 포함
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true) // 부모가 가지는 함수 사용(필드 포함)
public class Bbs extends BaseEntity{
    
    @Column(columnDefinition = "bigint default 0")
    private Long hit;

    @Column
    private Long state = 0L;

    @NonNull
    private String title, content, writer;

    @PrePersist
    public void initStatus() { //save함수로 데이터가 저장되기 전에 수행하는 함수
        if(state == null) {
            this.state = 0L;
            this.hit = 0L;
        }
    }
}
