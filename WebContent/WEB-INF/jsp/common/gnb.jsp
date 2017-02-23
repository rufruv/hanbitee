<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="height: 70px;"></div> 
<ul class="gnb width_full_size text_center" style="font-size: 15px; height: 7%">
		<li><a href="${context}/patient.do?action=move&page=registerForm" class="text_no_underline">회원가입</a></li>
		<li><a href="${context}/patient.do?action=move&page=loginForm" class="text_no_underline">고객:로그인</a></li>
		<li><a href="${context}/patient.do?action=move&page=loginForm" class="text_no_underline">스탭:로그인</a></li>
		<li><a href="${context}/patient.do?action=move&page=loginForm" class="text_no_underline">관리자:로그인</a></li>
		<li><a href="${context}/board.do?action=move&page=main.do">자유게시판</a></li>
		<li class="tooltip">
			<a href="#" class="text_no_underline">병원소개</a>
			<span class="tooltiptext">구현되지 않은 기능입니다.</span>
		</li>	
</ul>