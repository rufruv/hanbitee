<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="serviceImpl.PatientServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<%=application.getContextPath() %>/css/hanbit.css" />

</head>
<body>
<div id="wrapper" class="width_full_size">
<div id="header" class="width_full_size position_fix;" style="height:120px;">
	<div class="logo_box width_full_size text_center" style="height: 60%">
	<a href="../../index.html"><img src="<%=application.getContextPath() %>/images/common/index_logo.png" style="margin-top:20px;"></a>
	</div>
	<ul class="gnb width_full_size" style="font-size: 15px; height: 38%">
		<li><a href="join.html" class="text_no_underline">회원가입</a></li>
		<li><a href="login.html" class="text_no_underline">로그인</a></li>
		<li><a href="../bbs/bbs_list.html" class="text_no_underline">자유게시판</a></li>
		<li class="dropdown"><a href="../admin/admin.html" class="text_no_underline">관리자</a>
			<div class="dropdown_content text_left" style="color:black">
				<p><a href="" class="text_no_underline">의 사</a></p>
				<p><a href="" class="text_no_underline">간호사</a></p>
				<p><a href="" class="text_no_underline">환 자</a></p>
				<p><a href="" class="text_no_underline">차 트</a></p>
			</div>
		</li>	
	</ul>
	</div>
<div style="height: 120px;"></div>
<div id="container" class="width_full_size" style="height:700px;">
<div class="width_full_size" style="margin-top:200px;">
<form action="patLogin.jsp" class="margin_center" style="width:20%;">
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
</form>
</div>
</div>
<div id="footer" class="width_full_size" style="height:100px; border-top:2px solid #5a5a5a;">
	<dl class="notice">
		<dt><a href="/NOTICE" class="h_notice">공지사항</a></dt>
	</dl>
	<dl class="policy">
		<dd class="f"><a href="http://www.navercorp.com/" target="_blank" id="plc.intronhn">회사소개</a></dd>
		<dd><a href="http://mktg.naver.com/" id="plc.adinfo">광고</a></dd>
		<dd><a href="https://submit.naver.com/" id="plc.search">마이비즈니스</a></dd>
		<dd><a href="https://www.navercorp.com/ko/company/proposalGuide.nhn" target="_blank" id="plc.contact">제휴제안</a></dd>
		<dd><a href="rules/service.html" id="plc.service">이용약관</a></dd>
		<dd><a href="rules/privacy.html" id="plc.privacy"><strong>개인정보처리방침</strong></a></dd>
		<dd><a href="rules/youthpolicy.html" id="plc.youth">청소년보호정책</a></dd>
		<dd><a href="rules/spamcheck.html" id="plc.policy">네이버 정책</a></dd>
		<dd><a href="https://help.naver.com/" id="plc.helpcenter">네이버 고객센터</a></dd>
	</dl>
	<address>&copy; <strong><a href="http://www.navercorp.com/" target="_blank">NAVER Corp.</a></strong></address>
	</div>
</div>
</body>
</html>

