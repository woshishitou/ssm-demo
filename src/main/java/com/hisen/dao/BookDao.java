package com.hisen.dao;

import com.hisen.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zlb
 * @description:
 * @date 2019/3/1 22:43
 */
public interface BookDao {
    Book queryById(long id);
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBookById(long id);
}
