<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<%@ page import="com.remp.work.util.RempUtility" %>


<!-- customer rental detail -->
<div align="center">
<table style="width: 800px; height:400px" class="table frame">
	<tr>
		<td align="center">
			<img src="resources/images/${dto.getImage()}" width="400px">
		</td>
		<td>
			<%
			RempUtility ru = new RempUtility();
			%>
			<div style="padding: 20px;">
				<div>${dto.getCode()}</div>
				<div>${dto.getName()}<hr></div>
				<div>제조사 : ${dto.getManufacturer()}<hr></div>
				<div>렌탈가격 <span style="color: darkred;">월${price}원</span><hr></div>
				<div>*${dto.getPeriod()}개월 약정</div>
				<div align="right" style="margin: 50px;" >
					<input type="button" data-code="${dto.getId()}" id="bt_buy" value="구매하기" class="btn btn-primary" onclick="getId(this)">
					<input type="button" id="bt_golist"value="목록으로" class="btn btn-secondary" onclick="location='rentalmain.do'">
				</div>
			</div>
		</td>
	</tr>
</table>
</div>
