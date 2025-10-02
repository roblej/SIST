package com.sist.backend.store;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "dept")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//어노테이션을 사용할 때 hibernate관련 필드를 직렬화해서 제외시킨다.
//이는 양방향 관계에서 순환참조문제를 해결한다.
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptno;
    private String dname;
    private String loc_code;

    //양방향 관계 설정 - mappedBy는 관계의 주체가 되는 Dept에서
    //참조되는 Emp의 속성(멤버변수)을 의미함
    //주 테이블(부모)의 외래키가 자식엔티티(자식테이블)에 존재한다고 알고,
    //자식테이블의 외래키를 기준으로 관계를 매핑한다
    // 즉, Dept 엔티티는 부모로서 Emp 엔티티의 dept라는 멤버변수를 기준으로 관계를 정의하고있다
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"dept"}) //Dept엔티티 기준으로 참조하는 Emp의 무한참조를 막아준다.
    private List<Emp> elist;
    //CascadeType.ALL : 모든 작업(저장,병합,삭제)를 자식 객체에도 적용
    //FetchType.LAZY : 필요할 때 연관된 엔티티를 로딩하도록 지정
    // ex) Dept엔티티가 로딩될때 Emp엔티티는 실제로 필요할때까지 로딩하지 않음
}   
