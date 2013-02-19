<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<stripes:useActionBean beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean"
                       var="displayActionBean"/>

<stripes:form beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean" id="questionsForm">
	<c:forEach items="${displayActionBean.questions}" var="aQuestion" varStatus="step">
	<div>
		${aQuestion.question.id.name}
        ${aQuestion.question.label}
		<stripes:hidden name="${aQuestion.question.id.name}" class="identHolder"/>
		<%-- questions[${step.index}].answer.value --%>
        <t:customInput valueType="${aQuestion.question.type}" name="answer" 
        	editable="${aQuestion.editable}" value="${aQuestion.answer}" />
        <br/>
    </div>
	</c:forEach>
</stripes:form>
<stripes:link beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean" event="clear">Start again</stripes:link>