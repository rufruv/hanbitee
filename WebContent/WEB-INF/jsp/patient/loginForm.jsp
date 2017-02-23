<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.PatientServiceImpl" %>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<div id="container" class="width_full_size" style="height:700px;">
<div class="width_full_size" style="margin-top:200px;">
<form action="${context}/patient.do" method="get" style="width:20%;" class="margin_center" >
<table class="table_default">
<tr>
	<td>
	<input type="text" placeholder="아이디" name="id">
	</td>
	<td rowspan="2">
	<input class="width_full_size height_full_size" type="submit" value="LOGIN"  />
	<!-- <a href="admin.html">로그인</a> -->
	</td>
</tr>
<tr>
	<td>
	<input type="password" placeholder="비밀번호" name="password">
	</td>
</tr>
</table>
<input type="hidden" name="action" value="login"/>
<input type="hidden" name="page" value="main"/>
</form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
