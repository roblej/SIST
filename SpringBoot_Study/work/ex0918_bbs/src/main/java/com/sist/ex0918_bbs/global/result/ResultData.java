package com.sist.ex0918_bbs.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultData<T> {
    private int totalcount; // length
    private String msg; //메세지
    private T data; // 데이터

    public static <T> ResultData<T> of(int totalcount, String msg, T data) {
        return new ResultData<>(totalcount, msg, data);
    }

    public static <T> ResultData<T> of(int totalcount, String msg) {
        return of(totalcount, msg, null);
    }
}
