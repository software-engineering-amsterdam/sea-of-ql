<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<stripes:useActionBean beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean"
                       var="displayActionBean"/>
<html>
<head>
<title>Questionnaire</title>
<script type="text/javascript" src="<c:url value="/resources/script/jquery-1.8.3.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/script/script.js"/>"></script>
</head>
<body>
<div>
<stripes:form beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean" id="questionsForm">
	<c:forEach items="${displayActionBean.questions}" var="aQuestion" varStatus="step">
	<div>
		${aQuestion.question.id.name}
        ${aQuestion.question.label}
		<stripes:hidden name="identName" value="${aQuestion.question.id.name}" />
		<%-- questions[${step.index}].answer.value --%>
        <t:customInput valueType="${aQuestion.question.type}" name="answer"/>
        <br/>
    </div>
	</c:forEach>
	<div id="extraQuestions">
	</div>
</stripes:form>
</div>
</body>
</html>