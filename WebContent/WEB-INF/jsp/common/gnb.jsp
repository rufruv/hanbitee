<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 70px;"></div> 
<ul id="ulGnb" style="font-size: 15px; height: 7%">
		<li><a id="aJoin" class="text_no_underline">회원가입</a></li>
		<li><a id="aPatLogin" class="text_no_underline">고객:로그인</a></li>
		<li><a id="aStaffLogin" class="text_no_underline">스탭:로그인</a></li>
		<li><a id="aAdminLogin" class="text_no_underline">관리자:로그인</a></li>
		<li><a id="aBoard" class="text_no_underline">자유게시판</a></li>
		<li class="tooltip">
			<a href="#" class="text_no_underline">병원소개</a>
			<span class="tooltiptext">구현되지 않은 기능입니다.</span>
		</li>	
</ul>
<script>
$(function() {
	$('#ulGnb').addClass('gnb').addClass('width_full_size').addClass('text_center');
	$('#aJoin').click(function(){
		alert('JQuery Test!');
		location.href="${context}/patient.do?action=move&page=registerForm";
	});
	document.getElementById('aPatLogin').onclick=function(){
		alert('aPatLogin.onclick');
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
	document.getElementById('aStaffLogin').onclick=function(){
		alert('aStaffLogin.onclick');
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
	document.getElementById('aAdminLogin').onclick=function(){
		alert('aAdminLogin.onclick');
		location.href="${context}/patient.do?action=move&page=loginForm";
	}
	document.getElementById('aBoard').addEventListener('click', function(){
		location.href="${context}/board.do?action=move&page=main";
	});
});
</script>


