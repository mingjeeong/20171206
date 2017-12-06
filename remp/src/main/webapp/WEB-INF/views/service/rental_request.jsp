<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- 렌탈 요청조회 헤드 -->
<!-- 검색어 폼 -->
<div class="item_wrapper">

	<div class="left-w80">
		<input id="keyword" type="text" class="form-control" onkeyup>
	</div>
	<div class="left-w20">
		<button class="btn btn-primary" onclick="getRentalRequest(this)">조회</button>
	</div>
</div>

<!-- 결과값 리스트 -->
<div style="width: 100%; height: 80%; overflow: scroll;">
	<table id="rentalRequestResult" class="table table-striped table-hover table-bordered table-sm">
		<thead class="thead-dark">
			<tr><th>요청번호</th><th>인도일</th></tr>
		<thead>
		<tbody></tbody>
	</table>
</div>