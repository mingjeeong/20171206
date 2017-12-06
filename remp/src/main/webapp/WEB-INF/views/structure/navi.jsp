<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">ReMP</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor02" aria-controls="navbarColor02"
		aria-expanded="false" aria-label="Toggle navigation" style="">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor02">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="#">Home
					<span class="sr-only">(current)</span>
				</a>
			</li>
			<li class="nav-item"><a class="nav-link" data-module="member" href="javascript:void(0)" onclick="getNavSubMenu(this)">회원관리</a></li>
			<li class="nav-item"><a class="nav-link" data-module="rental" href="javascript:void(0)" onclick="getNavSubMenu(this)">렌탈관리</a></li>
			<li class="nav-item"><a class="nav-link" data-module="asset" href="javascript:void(0)" onclick="getNavSubMenu(this)">자산괸리</a></li>
			<li class="nav-item"><a class="nav-link" data-module="EIS" href="javascript:void(0)" onclick="getNavSubMenu(this)">EIS</a></li>
		</ul>
	</div>
</nav>
<!-- 회원관리 -->
<div id="member" class="navbar navbar-expand-lg navbar-dark bg-dark" style="display: none;">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item"><a class="nav-link" href="gochangepw.do">비밀번호변경</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item2</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item3</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item4</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item5</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item6</a></li>
	</ul>
</div>

<!-- 렌탈관리 -->
<div id="rental" class="navbar navbar-expand-lg navbar-dark bg-dark" style="display: none;">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item"><a class="nav-link" href="rentalmain.do">렌탈검색</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item2</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item3</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item4</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item5</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item6</a></li>
	</ul>
</div>

<!-- 자산관리 -->
<div id="asset" class="navbar navbar-expand-lg navbar-dark bg-dark" style="display: none;">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item"><a class="nav-link" href="goinputrequest.do">입고요청조회</a></li>
		<li class="nav-item"><a class="nav-link" href="goinput.do">입고조회</a></li>
		<li class="nav-item"><a class="nav-link" href="gorepairlist.do">점검내역등록</a></li>
		<li class="nav-item"><a class="nav-link" href="gosearchparts.do">수리부속조회</a></li>
		<li class="nav-item"><a class="nav-link" href="gorepairresult.do">점검결과조회</a></li>
	</ul>
</div>

<!-- EIS -->
<div id="EIS" class="navbar navbar-expand-lg navbar-dark bg-dark" style="display: none;">
		<ul class="navbar-nav mr-auto">
		<li class="nav-item"><a class="nav-link" href="#">item1</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item2</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item3</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item4</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item5</a></li>
		<li class="nav-item"><a class="nav-link" href="#">item6</a></li>
	</ul>
</div>