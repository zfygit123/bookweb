<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Title</title>
<html>
<head>
    <style>
        .bugdiv{width:680px;
            border:1px solid black;
            margin: 0px auto;
        }
        .project{
            padding-left: 363px;
            margin: 0px auto;
        }
        h1{
            text-align: center;
            margin-top: 3px;
            margin-bottom: 3px;
        }
        .btn{margin-left: 100px;}
    </style>
</head>
<body>
<form  class="project" action="${pageContext.request.contextPath}/Book/booklist" method="post">
    <select name="selected">
        <option value="1">书名</option>
        <option value="2">作者</option>
        <option value="3">出版社</option>
    </select>
    <input type="submit" value="查询">
    <%--    <a class="add" href="${pageContext.request.contextPath}/bug/toAdd">新增BUG</a>--%>
</form>
<div class="bugdiv">
    <h1>BUG列表</h1>
    <a href="${pageContext.request.contextPath}/edoc/addedc">添加</a>
    <table border="1" width="100%">
        <tr>
            <th>文档编号</th>
            <th>文档名称</th>
            <th>文档摘要</th>
            <th>上传人</th>
            <th>上传日期</th>
            <th>操作</th>
        </tr>
        <c:forEach var="books" items="${bookslist}">
            <tr role="row">
                <td>${books.bookName}</td>
                <td>${books.title}</td>
                <td>${books.bookAuthor}</td>
                <td>${books.bookPublish}</td>
                <td>${books.bookPage}</td>
                <td>${books.bookPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <div><!--${pageContext.request.contextPath}/goodsdetail/findAll?pageNo=1-->
        <a href="${pageContext.request.contextPath}/Book/booklist?currPageNo=1">首页</a>
        <a href="${pageContext.request.contextPath}/Book/booklist?currPageNo=${page.currPageNo-1}"> 上一页</a>
        <a href="${pageContext.request.contextPath}/Book/booklist?currPageNo=${page.currPageNo+1}"> 下一页</a>
        <a href="${pageContext.request.contextPath}/Book/booklist?currPageNo=${page.totalPageCount}"> 末页</a>
        第${page.currPageNo}页/共${page.totalPageCount}页
    </div>
</div>


<%-- $(function(){
      $("tr:even").css("background-color","yellow");
  })--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/jquery.min.js"></script>
<script >
    function del(id)
    {
        if(confirm("确定要删除吗？"))
        {
            $.ajax({
                /* "url" : "/edoc/deletebyId/"+id,*/
                "url" : "${pageContext.request.contextPath}/edoc/deletebyId",
                "type" : "post",
                "data" : "id="+id,
                "dataType" : "text",
                "success" :function callBack(data){
                    if(data=="success")
                    {
                        alert("删除成功");
                        location.href="${pageContext.request.contextPath}/edoc/entrylist";
                    }
                    else
                    {
                        alert("删除失败");
                    }
                }
            });

        }
    }
</script>
</body>
</html>