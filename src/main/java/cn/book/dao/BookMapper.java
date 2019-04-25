package cn.book.dao;

import cn.book.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
       List<Book>  booksList(Integer selected,Integer startPos,Integer pageSize);
       int AddBooks(Book book);
       int queryCount(Integer selected);
}
