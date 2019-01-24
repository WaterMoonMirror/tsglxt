package com.tkn.tsglxt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class FileVo {
    private String fileName;
    private String filePath;
    private int level;// 级别：用户呈现树的形状
    private List<FileVo> fileVos;// 子集

    // 序号自增
    public int inclevel(){
        return ++level;
    }

    @Override
    public String toString() {
        return "FileVo{" +
                String.join("",Collections.nCopies(level,"*"))+
                "fileName='" + fileName + '\'' +
                ", level=" + level +
                '}';
    }
}
