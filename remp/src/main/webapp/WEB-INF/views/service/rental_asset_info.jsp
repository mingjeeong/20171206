<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<!-- detail -->
<div class="item_wrapper">
	<span class="btn btn-secondary">출고가능 자산목록 조회결과</span>
</div>
<div style="width: 100%; height: 80%; overflow: scroll;">
	<table class="table table-striped table-hover table-bordered table-sm">
		<thead class="thead-dark">
			<tr>
				<th>자산ID</th>
				<th>제품명</th>
				<th>최초입고</th>
				<th>최근출고</th>
				<th>출고횟수</th>
				<th>가격</th>
				<th>출고</th>
			</tr>
		</thead>
		<tbody id="productList">
			<tr data-item-id="P123456789" data-item-name="윈나이 정수기"
				data-item-entrydate="1999-12-01" data-item-recentdate="2017-11-15"
				data-item-unstorecount="27" data-item-price="900000"
				data-item-misc="">
			</tr>
		</tbody>
	</table>
</div>