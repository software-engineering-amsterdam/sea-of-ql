<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Questionnaire</title>
<script type="text/javascript" src="<c:url value="/resources/script/jquery-1.8.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/script/script.js"/>"></script>
</head>
<body>
<div id="content">
	<jsp:include page="/WEB-INF/jsp/questionsFragment.jsp"></jsp:include>
</div>
</body>
</html>