<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- 입고조회영역-->
<div class="item_wrapper">
	<div class="left-w20">
		<span class="btn btn-secondary">입고조회</span>
	</div>
	<div class="left-w70">
		<input type="text" id="searchInput" class="form-control" placeholder="제품명 입력">
	</div>
	<div class="left-w10">
		<input type="button" class="btn btn-primary" value="검색" onclick="searchInput()">
	</div>
</div>

<!-- 조회리스트 -->
<div style="width: 100%; height: 80%; overflow: scroll;">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead class="thead-dark">
			<tr>
				<th>입고번호</th>
				<th>제품명</th>
				<th>수량</th>
				<th>입고일자</th>
				<th>인계자</th>
				<th>QR코드</th>
			</tr>
		</thead>
		<tbody id="inputList">
			<tr>
			</tr>
		</tbody>
	</table>
</div>