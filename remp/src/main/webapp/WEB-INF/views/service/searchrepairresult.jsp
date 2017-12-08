<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- 내부수리기사 점검결과 조회 -->
<div class="item_wrapper">
	<span class="btn btn-secondary">점검결과 조회</span>
</div>
<!-- 통계 영역 -->
<!--
<div>이민정님</div>
<table>
	<tr>
		<td>월평균수리량</td>
		<td>000</td>
	</tr>
	<tr>
		<td>일평균수리량</td>
		<td>00</td>
	</tr>
</table>
-->
<!-- 검색영역 -->
<div>
<table border="1"  class="table table-striped table-hover table-bordered table-sm">
	<tr>
		<td class="form-control">기간선택</td>
		<td><div class="left-w20" ><input type="date" id="start" class=" form-control " tabindex="1" onchange="dateLock(this)"></div><div class="left space">~</div><div class="left-w20"><input type="date" class="form-control" id="end" tabindex="2" ></div>
		</td>
		<td rowspan="2" ><input type="button" class="btn btn-primary" value="검색" onclick="getRepairResultList()" tabindex="4"></td>
	</tr>
	<tr>
		<td class="form-control">점검 분류</td>
		<td><select id="repairResultSort" class="form-control" tabindex="3">
				<option value="전체">전체</option>
				<option value="수리대기">수리대기</option>
				<option value="수리완료">수리완료</option>
				<option value="외부수리">외부수리</option>
				<option value="수리불가능">수리불가능</option>
			</select>
		</td>
	</tr>
</table>

<!-- 조회영역 -->
<table class="table table-striped table-hover table-bordered table-sm" border="1">
	<thead class="thead-dark">
		<tr>
			<th>점검id</th>
			<th>제품명</th>
			<th>자산id</th>
			<th>점검내역</th>
			<th>수리일자</th>
			<th>상태</th>
		</tr>
	</thead>
	<tbody id="repairResultList">
	</tbody>
</table>
</div>

<!-- onload -->
<script>
$('body').on('load',getAllRepairResultList());
</script>

