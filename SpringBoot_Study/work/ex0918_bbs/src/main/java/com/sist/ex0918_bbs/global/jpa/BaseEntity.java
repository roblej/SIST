package com.sist.ex0918_bbs.global.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.experimental.SuperBuilder;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@SuperBuilder //빌더 패턴을 구현하기 위한 코드 간결과
              //생성자에서 상속받은 필드도 빌더에서 사용할 수 있다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//접근제한 protected에 대한 접근력을 두고 생성자를 생성함
@MappedSuperclass //상속받은 클래스에서 사용할 수 있도록 설정
@EntityListeners(AuditingEntityListener.class)
@ToString //toString함수를 생성
//엔티티와 매핑된 테이블의 데이터를 조작 수정과 이벤트에 대한 감지를 처리하기 위한 리스너
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키 생성과 추가 시 생성된 기본키를 받고자함
    private Long b_idx;

    @CreatedDate
    private String write_date;
}
