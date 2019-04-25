package cn.book.service.Impl;

import cn.book.dao.BookMapper;
import cn.book.pojo.Book;
import cn.book.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public List<Book> booksList(Integer selected,Integer startPos,Integer pageSize) {
        return bookMapper.booksList(selected,startPos,pageSize);
    }

    @Override
    public int AddBooks(Book book) {
        return bookMapper.AddBooks(book);
    }

    @Override
    public int queryCount(Integer selected) {
        return bookMapper.queryCount(selected);
    }
}
