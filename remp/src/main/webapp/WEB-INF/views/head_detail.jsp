<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/core.css">
<script src="resources/js/jquery-3.2.1.js"></script>
<script src="resources/js/popper.js"></script>
<script src="resources/js/bootstrap.bundle.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/core.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<!-- navi -->
	<jsp:include page="/WEB-INF/views/structure/navi.jsp" />
	
	<!-- content -->
	<div id="content" class="content_wrapper bd">
		<div class="head bd-right">
			<jsp:include page="${head}" />
		</div>
		<div class="detail">
			<jsp:include page="${detail}" />
		</div>
	</div>
	
	<!-- footer -->
	<div class="content_wrapper">
		<jsp:include page="/WEB-INF/views/structure/footer.jsp" />
	</div>
</body>
</html>
