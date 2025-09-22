package com.sist.ex0918_bbs.domain.bbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sist.ex0918_bbs.domain.bbs.entity.Bbs;
import com.sist.ex0918_bbs.domain.bbs.repository.BbsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //초기화 되지 않은 final 필드나 @NonNull 어노테이션이 붙은 필드를 생성자로 초기화
public class BbsService {

    private final BbsRepository bbsRepository;

    public List<Bbs> getList() {
        return bbsRepository.findAll();
    }

    public Bbs getBbs(Long b_idx) {
        Bbs bbs = null;
        Optional<Bbs> result = bbsRepository.findById(b_idx);
        if(result.isPresent()) {
            bbs = result.get();
        }
        return bbs;
    }

     public Bbs create(String title, String content, String writer) {
        Bbs bbs = Bbs.builder()
            .title(title)
            .content(content)
            .writer(writer)
            .build();
            
        return this.bbsRepository.save(bbs);
     }

     public void delete(Long b_idx) {
        bbsRepository.deleteById(b_idx);
     }
     
}
