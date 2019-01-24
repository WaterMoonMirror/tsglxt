package com.tkn.tsglxt.repository;

import com.tkn.tsglxt.vo.BookVo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookVo,Long> {

}
