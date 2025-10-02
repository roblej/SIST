package com.sist.backend.store;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "emp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empno;
    private String ename,job,sal;
    private LocalDate hiredate;

    @Column(name = "deptno",insertable = false,updatable = false)
    private Long deptno;//추가/편집 시 자동으로 값을 지정 또는 수정되지 못하게함

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptno",referencedColumnName = "deptno")
    private Dept dept;
}
