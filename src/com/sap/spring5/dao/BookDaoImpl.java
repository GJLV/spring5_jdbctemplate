package com.sap.spring5.dao;

import com.sap.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //添加
    @Override
    public void add(Book book) {

        String sql = "INSERT INTO t_book VALUES(?,?,?)";

        Object [] args = {book.getUserId(),book.getUserName(),book.getUstatus()};
        int result = jdbcTemplate.update(sql,args);
        System.out.println(result);
    }

    @Override
    public void update(Book book) {

        Object [] args = {book.getUserName(),book.getUstatus(),book.getUserId()};
        String sql = "update t_book set username=?,ustatus=? where user_id =?";
        System.out.println(jdbcTemplate.update(sql,args));
    }

    @Override
    public void delete(String id) {
        String sql = "delete from t_book where user_id =?";
        System.out.println(jdbcTemplate.update(sql,id));
    }

    @Override
    public Book select(String id) {
        String sql = "select * from t_book where user_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    @Override
    public int selectCount() {
        String sql  = "select count(*) from t_book";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<Book> findAll() {
        String sql  = "select * from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public void batchUpdate(List<Object[]> books) {

        String sql  = "insert into t_book values (?,?,?)";
        int result[] =  jdbcTemplate.batchUpdate(sql,books);
        System.out.println(Arrays.toString(result));
    }
}
