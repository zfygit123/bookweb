package cn.book.service;

import cn.book.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> booksList(Integer selected,Integer startPos,Integer pageSize);
    int AddBooks(Book book);
    int queryCount(Integer selected);
}
