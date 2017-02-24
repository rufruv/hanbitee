<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.PatientServiceImpl" %>
<jsp:include page="../common/top.jsp"/>
<jsp:include page="../common/header.jsp"/>
<div id="container">
<div id="loginInputBox">
<form id="loginForm" action="${context}/patient.do" method="get" >
<table class="table_default">
<tr>
	<td>
	<input type="text" placeholder="아이디" name="id">
	</td>
	<td rowspan="2">
	<input id="inputLogin" type="submit" value="LOGIN"  />
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
<script>
$(function() {
	$('#container').addClass('width_full_size').css('height','700px');
	$('#loginInputBox').addClass('width_full_size').css('margin-top','170px');
	$('#loginForm').addClass('margin_center').css('width','20%');
	$('#inputLogin').addClass('width_full_size').addClass('height_full_size');
});
</script>



