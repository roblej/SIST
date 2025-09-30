package com.sist.ex0930_compose.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BbsVO {
    private String b_idx, subject, writer, content, file_name, ori_name, pwd, write_date, ip, hit, bname, status;

    private List<CommVO> c_List;
    private MultipartFile s_file;
}
