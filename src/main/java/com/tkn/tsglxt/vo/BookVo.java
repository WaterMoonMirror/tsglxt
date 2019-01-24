package com.tkn.tsglxt.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String chapter;
}
