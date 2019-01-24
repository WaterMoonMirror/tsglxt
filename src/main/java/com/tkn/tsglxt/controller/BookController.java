package com.tkn.tsglxt.controller;

import com.tkn.tsglxt.service.BookService;
import com.tkn.tsglxt.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;
    @RequestMapping
    public String index(Model model){
        model.addAttribute("books",service.list());
        return "book";
    }
    @RequestMapping("/add")
    public String add( BookVo bookVo){
        service.add(bookVo);
        return "redirect:/book";
    }
    @RequestMapping("/addPage")
    public String addPage(){
        return "addBook";
    }
}
