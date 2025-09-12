package com.sist.ex0911_jwt.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id; // import 추가
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "member_t")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemVO {

    @Id // <-- mIdx 위에 @Id 추가
    private String mIdx;
    
    private String mName;
    private String mId;
private String mPw;
}              