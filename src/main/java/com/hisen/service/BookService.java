package com.hisen.service;

import com.hisen.entity.Book;

import java.util.List;

/**
 * @author zlb
 * @description:
 * @date 2019/3/1 22:59
 */
public interface BookService {
    Book getById(long bookId);
    List<Book> getList(int start, int pageNum);
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBookById(long id);
}