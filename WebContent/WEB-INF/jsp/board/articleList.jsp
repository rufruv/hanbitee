<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<div style="height: 120px;"></div>

<table id="articleList">
	<tr><th>총게시글수 : ${count} 건</th></tr>
	<tr>
		<th>No</th>
		<th>ID</th>
		<th>제목</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>

<c:forEach var="article" items="${requestScope.list}" > <!-- 확장 for문과 동일  -->
	<tr>
		<td>${article.seq}</td>
		<td>${article.id}</td>
		<td><a href="${context}/board.do?action=detail&page=articleDetail&seq=${article.seq}">${article.title}</a></td>
		<td>${article.regdate}</td>
		<td>${article.readCount}</td>
	</tr>
</c:forEach>
	
</table>
<nav style="width: 500px; margin:0 auto;">
<ul class="gnb">
<c:if test="${requestScope.preBlock gt 0}">
	<a href="${context}/board.do?action=list&page=articleList&pageNO=${requestScope.prevBlock} ">◀PREV</a>
</c:if>
<c:forEach varStatus="pageNO"  begin="${requestScope.blockStart}" end="${requestScope.blockEnd}" step="1" > <!-- 일반 for문과 동일 (step은 i++과 동일한 의미)-->
	<li style="width:20px; ">
		<a class="text_center" style="color: black" href="${context}/board.do?action=list&page=articleList&pageNO=${pageNO.index}">${pageNO.index}</a>
	</li>	
</c:forEach>
<c:if test="${requestScope.nextBlock le count}">
	<a href="${context}/board.do?action=list&page=articleList&pageNO=${requestScope.nextBlock} ">NEXT▶</a>
</c:if>
</ul>
</nav>
<script>
$(function() {
	var $articleList = $('#articleList');
	$articleList.addClass('table_default').addClass('margin_center').css('width','500px').css('margin-top','100px');
	$articleList.find('tr:nth-child(1)>th:nth-child(1)').attr("colspan", "5").css('text-align','right');
	$articleList.find('tr:nth-child(2)>th:nth-child(1)').addClass('text_center');
	$articleList.find('tr:nth-child(2)>th:nth-child(2)').addClass('text_center');
	$articleList.find('tr:nth-child(2)>th:nth-child(3)').addClass('text_center');
	$articleList.find('tr:nth-child(2)>th:nth-child(4)').addClass('text_center');
	$articleList.find('tr:nth-child(2)>th:nth-child(5)').addClass('text_center');

});
</script>
<jsp:include page="../common/footer.jsp"></jsp:include>