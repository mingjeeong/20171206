<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.remp.work.model.dto.Product" %>

<!-- 내부수리기사 검검내용 작성 헤드 -->
<!-- 검색어 폼 -->
<div class="item_wrapper">
	<div class="left-w25">
		<select id="type" class="form-control">
			<option value="자산ID">자산ID</option>
			<option value="품목명">품목명</option>
		</select>
	</div>
	<div class="left-w60">
		<input id="keyword" class="form-control" type="text" size="30" autofocus>
	</div>
	<div class="left-w10">
		<button class="btn btn-primary" onclick="getRepairList()">조회</button>
	</div>
</div>

<!-- 결과값 리스트 -->
<div style="width: 100%; height: 80%; overflow: scroll;">
	<table id="repairList" class="table table-striped table-hover table-bordered table-sm">
		<thead class="thead-dark">
			<tr><th>자산ID</th><th>품목명</th><th>상태</th><th>신청일자</th></tr>
		<thead>
		<tbody>
		 <% 
   			ArrayList<Product> list = (ArrayList)request.getAttribute("list");
		 	if(list != null){
		 	for(int i=0 ; i<list.size() ; i++){
		 %>
		 <tr data-fn-name='getrepairform(headElement)' data-key='<%=list.get(i).getId()%>' data-itid='<%=list.get(i).getItId()%>' data-productstate='<%=list.get(i).getState()%>' data-itname='<%=list.get(i).getItName()%>'  onclick='setHeadSeqRequest(this); getPartsList(this); resetForm()'>
		 	<td><%=list.get(i).getId()%></td>
		 	<td><%=list.get(i).getItName()%></td>
		 	<td><%=list.get(i).getState()%></td>
		 	<td><%=list.get(i).getInDay()%></td>
		 </tr>
		 <%
		 	}}
		 %>
		</tbody>
	</table>
</div>