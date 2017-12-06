<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<!-- findId -->
<form action="findid.do" method="post">
	<div>
		<input name="name" type="text" placeholder="성명" class="form-control">
		<input name="phone" type="text" placeholder="핸드폰번호" class="form-control">
		<input type="submit" class="btn btn-primary" value="아이디 찾기">
	</div>
</form>