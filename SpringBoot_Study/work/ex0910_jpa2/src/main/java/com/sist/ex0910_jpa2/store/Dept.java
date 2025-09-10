package com.sist.ex0910_jpa2.store;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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


@Entity(name = "dept")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // 어노테이션을 사용하여 Hiberdate관련 필드를 직렬화에서 제외하는것이다.
//또한, 양방향관 관계에서 순환참조 문제를 해결한다
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptno;
    private String dname, locCode;

    @OneToMany(mappedBy = "dept",cascade = CascadeType.ALL,fetch = FetchType.LAZY) // dept테이블의 deptno와 emp테이블의 deptno가 매핑이 된다.
    @JsonIgnoreProperties({"dept"}) // 양방향관계에서 순환참조 문제를 해결한다.
    private List<Emp> elist;

    /*
     * 양방향 관계 설정 : mppaedBy는 관계의 주체가 되는 Dept에서 참조되는 객체가 Emp이며 그 안에 있는 속성(멤버변수)이다.
     * 주 객체가 Dept이며 외래키가 자식객체(Entity)에 존재한다고 알고,자식 객체의 외래키를 기준으로 관계를 매핑한다.
     * 즉, Dept엔티티는 부모로서 Emp엔티티의 dept필드를 기준으로 관계를 정의하게 된다.
     * CascadeType.ALL : 모든 작업(저장,병합,삭제,수정 등)을 자식 객체에도 적용)
     * FetchType.LAZY : 필요할 ㄸ때 연관된 엔티티를 로딩하도록 지정하는 방식
     *  즉, Dept엔티티가 로딩될 때 Emp엔티티는 실제로 필요할떄까지 로딩되지 않는다.
     * 이를 통해 성능을 최적화 할 수 있다.
     */
}
