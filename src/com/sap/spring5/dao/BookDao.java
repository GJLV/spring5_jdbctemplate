package com.sap.spring5.dao;

import com.sap.spring5.entity.Book;

import java.util.List;

public interface BookDao {
    //添加
    public void add(Book book);

    void update(Book book);

    void delete(String id);

    Book select(String id);

    int selectCount();

    List<Book> findAll();

    void batchUpdate(List<Object[]> books);
}
