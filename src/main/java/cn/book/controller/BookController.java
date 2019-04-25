package cn.book.controller;

import cn.book.pojo.Book;
import cn.book.pojo.Page;
import cn.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Book")
public class BookController {
    @Resource
    private BookService bookService;
    @RequestMapping("/booklist")
    public String entrylist(@RequestParam(value="selected", required = false)Integer selected, Model model, @RequestParam(value="currPageNo", required = false) Integer currPageNo){
        Integer pageNo = currPageNo == null ? 1 : currPageNo;  //当前页码
        Integer count=bookService.queryCount(selected);
        Page page=new Page();
        Integer pagesize=3;
        page.setPageSize(pagesize);
        page.setTotalCount(count);
        page.setCurrPageNo(pageNo);
        page.setSelected(selected);
        Integer startPos = (page.getCurrPageNo() - 1) * page.getPageSize();
        List<Book> books=bookService.booksList(selected,startPos,pagesize);
        if(books.get(0)!=null){
            model.addAttribute("bookslist",books);
            model.addAttribute("page",page);
            return "/Edoc";
        }
        return "fail";
    }
  /*  @RequestMapping("/toAdd")
    public String toadd(Model model){
        List<bugproject> projects=bugService.projectList();
        model.addAttribute("projects",projects);
        return "/bugadd";
    }
    @RequestMapping("/saveAdd")
    public String saveAdd(bugdetail detail){
        int result = bugService.savedetail(detail);
        if (result > 0) {
            return "redirect:/bug/buglists";  //新增成功刷新bug列表页面
        } else {
            return "redirect:/bug/toAdd";  //新增失败又跳回新增页面。
        }*/
}
