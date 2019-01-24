package com.tkn.tsglxt.service;

import com.tkn.tsglxt.repository.BookRepository;
import com.tkn.tsglxt.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public void add(BookVo bookVo){
        repository.save(bookVo);
    }

    public List<BookVo> list(){
         return  repository.findAll();
    }
}
