<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- 부속품조회 -->
<!-- 검색바 영역 -->
<div class="item_wrapper">
	<div class="left-w10">
		<span class="btn btn-secondary">부속품 조회</span>
	</div> 
	<div class="left-w10">
	<select class="form-control" id="searchType">
		<option value="all">전체</option>
		<option value="partId">부속품ID</option>
		<option value="PartSearchName">부속품명</option>
		<option value="ItemId">품목ID</option>
		<option value="partManufacturer">제조사</option>
	</select>
	</div>
	<div class="left-w60">
		<input type="text" id="searchParts" class="form-control" autofocus>
	</div>
	<div class="left-w10">
		<input type="button" class="btn btn-primary" value="검색" onclick="getSearchPartsList()">
	</div>
</div>

<!-- 조회 리스트 영역 -->
<div align="center">
	<table class="table table-striped table-hover table-bordered table-sm" id="partsTable">
		<thead class="thead-dark">
		<tr>
			<th>부속품ID</th>
			<th>모델명</th>
			<th>부속품명</th>
			<th>품목ID</th>
			<th>제조사</th>
			<th>현재재고량</th>
			<th>안전재고량</th>
			<th>비고</th>
		</tr>
		</thead>
		<tbody id="partsList">
		</tbody>
	</table>
</div>

<!-- onload function -->
<script>
$('body').on('load',getAllPartsList());
</script>