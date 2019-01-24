package com.tkn.tsglxt.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum FileEnum {
    BLANK_URL(0,"文件路径为空"),
    FILE_NO_EXISTS(1,"文件不存在"),
    PATH_NO_DIR(2,"路径不为文件夹");
    private Integer code;
    private String value;

}
