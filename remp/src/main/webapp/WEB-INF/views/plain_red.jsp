<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>

<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="resources/css/simplex/bootstrap.css">
<link rel="stylesheet" type="text/css" href="resources/css/core.css">
<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui.css">
<script src="resources/js/jquery-3.2.1.js"></script>
<script src="resources/js/jquery-ui.js"></script>
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
	<div style="min-width: 800px; max-width: 1920px; min-height: 600px; padding: 10px">
			<jsp:include page="${servicePage}" />
	</div>
	<!-- footer -->
	<div style="min-width: 800px; max-width: 1920px; margin: 0px auto;">
		<jsp:include page="/WEB-INF/views/structure/footer.jsp" />
	</div>
</body>
</html>
