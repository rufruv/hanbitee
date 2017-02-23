<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<img src="${img}/common/loading.gif" alt="" />

<a onclick="goMain()" href="#">메인페이지로 이동</a>
<script>
function goMain(){
	alert("a태그 클릭했음!!");
	location.href="${context}/home.do?action=move&page=main"; 
}
</script>