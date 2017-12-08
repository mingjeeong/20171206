<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- 내부수리기사 검검내용 작성 detail -->
<div class="item_wrapper">
	<span class="btn btn-secondary">점검 내용 등록</span>
</div>
<!-- 점검자산 등록 -->
<div style="width: 100%; height: 80%; overflow: scroll;">

<form name="repairInputForm">
	<table id="repairForm" class="table table-striped table-hover table-bordered table-sm">
		<tr>
			<th>자산ID</th>
			<td><input type="text" id="productId" name="productId" class="form-control" readonly></td>
		</tr>
		<tr>
			<th>품목명</th>
			<td><input type="text" id="itemName" name="itemName" class="form-control" readonly></td>
		</tr>
		<tr>
			<th>품목ID</th>
			<td><input type="text" id="itemId" name="itemId" class="form-control" readonly></td>
		</tr>
		<tr>
			<th>수리기사ID</th>
			<td><input type="text" id="engineerId" name="engineerId" class="form-control" readonly value="${id}"></td>
		</tr>
		<tr>
			<th>수리기사명</th>
			<td><input type="text" id="engineerName" name="engineerName" class="form-control" value="${name}"readonly></td>
		</tr>
		<tr>
			<th>수리일자</th>
			<td><input type="text" id="repairDate" name="repairDate" class="form-control" readonly></td>
		</tr>
		<tr>
			<th>점검분류</th>
			<td>
				<select id="repairSort" class="form-control" name="repairSort" required>
					<option value="" >==선택하세요==</option>
					<option value="wa_product">내부수리완료</option> 
					<option value="wa_repair">수리대기</option>
					<option value="re_exoutput">외부수리</option>
					<option value="re_disuse">수리불가능</option>
				</select>
			</td>
		</tr>
		<tr>
			<th colspan="2">점검내용</th>
		</tr>
		<tr>
			<td colspan="2"><textarea name="repairContents" id="repairContents" rows="5" style="width:100%" required></textarea></td>
		</tr>
	</table>
</form>
<form name="partsInputForm">
	<table id="parts" class="table table-striped table-hover table-bordered table-sm">
		<thead class="thead-dark">
			<tr>
				<th colspan="4">사용부품</th>
			</tr>
			<tr>
				<th>부품ID</th>
				<th>부품명</th>
				<th>재고수량</th>
				<th>사용수량</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</form>
<input type="button" value="등록" class="btn btn-primary btn-sm" onclick="addRepairResult()">

</div>


