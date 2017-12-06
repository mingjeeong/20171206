<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.remp.work.model.dto.Item" %>
<%@ page import="com.remp.work.util.RempUtility" %>

<!-- customer rental main -->
<!-- 검색바 -->
<form action="searchitem.do" method="post">
<div class="item_wrapper">
<div class="left-w20">
		<span class="btn btn-secondary">제품검색</span>
	</div> 
<div class="left-w10">
	<select name="sb_search" class="form-control">
		<option value="제품명">제품명</option>
		<option value="제품코드">제품코드</option>
	</select>
</div>
<div class="left-w50">
	<input type="text" id="item" class="form-control" name="item" autofocus>
</div>
<div class="left-w10">
	<input type="submit" class="btn btn-primary" value="검색" >
</div>
</div>
</form>
<div align="center">${message}</div>
<!-- 제품리스트 -->
<div align="center" style="margin: 20px;">
 <table class="table frame" style="width: 900px">
 <% 
 	RempUtility ru = new RempUtility();
    ArrayList<Item> list = (ArrayList)request.getAttribute("list");
	 if(list != null){
	    int size = list.size();
	    int trMax = size / 3; 
	    int tmp = size % 3;
	    if (tmp > 0) { 
	      trMax += 1; 
	     } 
 %>

<% 
   int position = 0;
   for (int i=0; i < trMax;  i++) { 
%> 
   <tr >
<% 
 for (int j=0; j < 3;  j++) {
	 
%> 
      <td>
<%
  if (position < size) { 
%>
  <a href="#" data-code="<%= list.get(position).getId() %>" onclick="getItemId(this)"><img src="resources/images/<%= list.get(position).getImage() %>"></a>
  <div><%= list.get(position).getCode() %></div>
  <div><%= list.get(position).getName() %></div>
  <div>렌탈가격 <%= ru.numMoney(list.get(position).getPrice()) %>원</div>
  <input type="button" class="btn btn-primary" data-code="<%= list.get(position).getId() %>" value="구매하기" onclick="getId(this)">
  
      </td>
<% 
   position++;
  }  
 }
%>
 </tr>
<%
}
}
%> 
 </table> 
</div>