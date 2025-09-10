package com.sist.ex0910_jpa1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0910_jpa1.repository.Category1Repository;
import com.sist.ex0910_jpa1.repository.ProductRepository;
import com.sist.ex0910_jpa1.store.Category1JPO;
import com.sist.ex0910_jpa1.store.ProductJPO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Category1Repository category1Repository;

    @GetMapping("/add")
    public String add() {
        ProductJPO p1 = ProductJPO.builder()
            .pNum(102L)
            .pName("아이폰 17")
            .pCompany("애플")
            .regDate(java.time.LocalDate.now())
            .category1(1)
            .category2(2)
            .category3(3)
            .build();
        productRepository.save(p1);
        return "Product added successfully";
    }
    
    @GetMapping("/cList")
    public String getClist() {
        List<Category1JPO> list = category1Repository.findAll();
        StringBuilder sb = new StringBuilder();
        for (Category1JPO c : list) {
            sb.append(c.getIdx());
            sb.append(" / ");
            sb.append(c.getCName());
            sb.append("<br>");
            List<ProductJPO> pList = c.getPList();
            for (ProductJPO p : pList) {
                sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
                sb.append(p.getPNum());
                sb.append(" / ");
                sb.append(p.getPName());
                sb.append(" / ");
                sb.append(p.getPCompany());
                sb.append("<br>");
            }
        }
        return sb.toString();
    }
}