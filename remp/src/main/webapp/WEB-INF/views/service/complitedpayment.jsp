<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<div align="center" style="margin-left: 20%; margin-right: 20%">
	<span style="font-size: 20px; ">구매내역</span>
	<table class="table frame" >
		<tr>
			<td>렌탈 제품</td>
			<td>${map.get("itemCode")}<span class="space"></span>${map.get("itemName")}</td>
		</tr>
		<tr>
			<td>렌탈 기간</td>
			<td>${map.get("start")}<span class="space">~</span>${map.get("end")}</td>
		</tr>
		<tr>
			<td>배송지</td>
			<td>${map.get("tb_post")}${map.get("tb_addr")}${map.get("tb_addD")}</td>
		</tr>
		<tr>
			<td>결제내역</td>
			<td>${map.get("sb_card")}<span class="space">${map.get("sb_bank")}</span><span class="space">${price}원</span><span class="space">결제완료</span></td>
		</tr>
	</table>
	<input type="button" class="btn btn-primary btn-sm" value="확인" onclick="location='rentalmain.do'">
</div>

