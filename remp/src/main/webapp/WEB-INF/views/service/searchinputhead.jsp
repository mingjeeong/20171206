<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- 입고조회 헤드 -->

<!-- 결과값 리스트 -->
<div style="width: 100%; height: 80%; overflow: scroll;">
	<table id="inputRequest"
		class="table table-striped table-hover table-bordered table-sm">
		<thead class="thead-dark">
			<tr>
				<th>No</th>
				<th>자산상태</th>
			</tr>
		<thead>
		<tbody>
			<tr data-fn-name="getInput" data-key="wa_check" onclick="setHeadSeqRequest(this)">
				<td>1</td>
				<td>점검대기</td>
			</tr>
			<tr data-fn-name="getInput" data-key="wa_policy" onclick="setHeadSeqRequest(this)">
				<td>2</td>
				<td>정책대기</td>
			</tr>
			<tr data-fn-name="getInput" data-key="wa_ninput" onclick="setHeadSeqRequest(this)">
				<td>3</td>
				<td>등록대기</td>
			</tr>
		</tbody>
	</table>
</div>