package com.sist.ex0909_jpa1.store;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product_t")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductJPO {

    @Id
    @GeneratedValue
    private Long pNum;
    private String pName;
    private String pCompany;
    private LocalDate regDate;

    @Column(name = "category1")
    private int category1;

    private int category2;
    private int category3;

    @ManyToOne
    @JoinColumn(name = "category1", insertable = false, updatable = false)
    private Category1JPO cvo1;
    //JPA가 해당 컬럼(category1)을 삽입하거나 저장하거나 수정하지못하도록 설정

}
