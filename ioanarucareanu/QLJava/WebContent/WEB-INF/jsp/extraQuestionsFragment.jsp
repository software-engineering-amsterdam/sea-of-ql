<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="stripes"
	uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<stripes:useActionBean
	beanclass="${param['actionBeanPath']}"
	var="displayActionBean" />
<stripes:form partial="true" beanclass="org.uva.sea.ql.interpreter.controller.DisplayQLActionBean">
	<c:forEach items="${displayActionBean.questions}" var="aQuestion"
		varStatus="step">
		<div>
			${aQuestion.question.id.name} ${aQuestion.question.label}
			<%-- questions[${step.index}].answer.value --%>
			<t:customInput valueType="${aQuestion.question.type}" name="value" />
			<br />
		</div>
	</c:forEach>
</stripes:form>