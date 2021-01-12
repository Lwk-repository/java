package com.gg.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 全参构造
@NoArgsConstructor  // 无参构造
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;

    public CommonResult(Integer code, String msg){
        this(code,msg,null);
    }
}
