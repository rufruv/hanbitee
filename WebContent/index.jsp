<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<img src="${img}/common/loading.gif" alt="" />
<script>
$(function() {
	location.href="${context}/home.do?action=move&page=main"; // location객체는 이동할때 쓰이는 refrence
});
</script>