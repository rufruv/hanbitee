<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="service.BoardService" %>
<%@ page import="serviceImpl.BoardServiceImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page import="domain.ArticleBean"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="../../css/hanbit.css" />
</head>
<body>
<% 
	BoardService service = BoardServiceImpl.getInstance();
	List<ArticleBean> list = service.list();
	
	int rowCount = 5;
	int card = service.count();
%>
<div style="width: 90%">
<table class="table_default margin_center" style="width: 500px; margin-top: 100px;">
	<tr><th colspan="5" style="text-align: right">총게시글수: <%= card %>건</th></tr>
	<tr>
		<th class="text_center">No</th>
		<th class="text_center">ID</th>
		<th class="text_center">제목</th>
		<th class="text_center">등록일</th>
		<th class="text_center">조회수</th>
	</tr>
<% 
 	for(int i=0;i<rowCount;i++){
%>
	<tr>
		<td><%=list.get(i).getSeq() %></td>
		<td><%=list.get(i).getId() %></td>
		<td><a href=""><%=list.get(i).getTitle() %></a></td>
		<td><%=list.get(i).getRegdate() %></td>
		<td><%=list.get(i).getReadCount() %></td>
	</tr>
<% 
 	}
%>
</table>
<nav style="width: 500px; margin:0 auto;">
<ul class="gnb">
<% 
	int pageCount = (card%rowCount==0)?card/rowCount:card/rowCount+1;
	for(int i=0;i<pageCount;i++){	
%>
	<li style="width:20px; ">
	<a class="text_center" style="color: black" href=""><%= i+1 %></a>
	
	</li>	
<% } %>
</ul>
</nav>
</div>
</body>
</html>