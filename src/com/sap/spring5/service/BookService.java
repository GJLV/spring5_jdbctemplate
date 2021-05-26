package com.sap.spring5.service;


import com.sap.spring5.dao.BookDao;
import com.sap.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //注入dao
    @Autowired
    private BookDao bookDao;


    //添加
    public void add(Book book){
        bookDao.add(book);
    }
    //修改
    public void update(Book book){
        bookDao.update(book);
    }
    //删除
    public void delete(String id){
        bookDao.delete(id);
    }

    //查询出来的值包装成对象
    public Book select(String id){
        return bookDao.select(id);
    }

    //查询一条记录
    public int findCount(){
        return bookDao.selectCount();
    }
    //返回集合
    public List<Book> findAll(){
        return bookDao.findAll();
    }


    //批量操作
    public void batchUpdate(List<Object[]> books){
        bookDao.batchUpdate(books);
    }

}
