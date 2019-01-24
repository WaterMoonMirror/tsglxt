package com.tkn.tsglxt.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Builder
public class FileModel {
    @Id
    private Long id;
    private String fileName;
    private String filePath;
    private Long pid;

}
