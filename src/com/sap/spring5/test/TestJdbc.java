package com.sap.spring5.test;

import com.sap.spring5.entity.Book;
import com.sap.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestJdbc {

    @Test
    public void testAdd(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("2");
        book.setUserName("aaaaa");
        book.setUstatus("bvvvvvvv");
        bookService.add(book);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("2");
        book.setUserName("aaaaaaaa");
        book.setUstatus("bdddddd");
        bookService.update(book);
    }

    @Test
    public void testDelete(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.delete("1");
    }

    //查询一个
    @Test
    public void testQuery(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        System.out.println(bookService.findCount());
    }

    @Test
    public void testGetObject(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        System.out.println(bookService.select("2"));
    }

    @Test
    public void testFindAll(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        List<Book> all = bookService.findAll();
        System.out.println(all);
    }

    @Test
    public void testBatchUpdate(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        List<Object[]> aa = new ArrayList<>();
        Object[] o1  = {"3","c++","c"};
        Object[] o2 = {"4","6dasd++","c"};
        Object[] o3 = {"5","c++dasda","cd"};
        aa.add(o1);
        aa.add(o2);
        aa.add(o3);
        bookService.batchUpdate(aa);
    }


}
