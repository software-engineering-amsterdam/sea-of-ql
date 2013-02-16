<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<stripes:useActionBean beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean"
                       var="displayActionBean"/>
                       
<html>
<head><title>Questionnaire</title></head>
<body>
<div>
<stripes:form beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean" id="questionsForm">
	<c:forEach items="${displayActionBean.questions}" var="aQuestion">
		${aQuestion.question.id.name}
        ${aQuestion.question.label}
        ${aQuestion.answer.value}
	</c:forEach>
</stripes:form>
</div>
</body>
</html>