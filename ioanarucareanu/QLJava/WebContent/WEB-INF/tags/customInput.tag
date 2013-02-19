<%@tag description="Custom input" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ attribute name="valueType" type="org.uva.sea.ql.ast.type.Type" fragment="false"
              rtexprvalue="true" required="true" %> 
<%@ attribute name="name" type="java.lang.String" fragment="false"
              rtexprvalue="true" required="true" %>
<%@ attribute name="editable" type="java.lang.Boolean" fragment="false"
              rtexprvalue="true" required="true" %>
<%@ attribute name="value" type="org.uva.sea.ql.ast.expr.value.Val" fragment="false"
              rtexprvalue="true" required="true" %>
   
<c:set var="actionOnClickBool" value="processUserResponse('/ql/protected/question/process/bool', this)" />
<c:set var="actionOnClickInt" value="processUserResponse('/ql/protected/question/process/int', this)" />
<c:if test="${not editable}">
		<c:set var="actionOnClickBool" value="" />
		<c:set var="actionOnClickInt" value="" />
</c:if>
<c:if test="${valueType.class.name == 'org.uva.sea.ql.ast.type.BooleanType'}">
		Yes
		<c:choose>
			<c:when test="${value.class.name ne 'org.uva.sea.ql.ast.expr.value.UndefinedVal' and value.value}">
				<stripes:checkbox name="${name}" onclick="${actionOnClickBool}" disabled="${not editable}" checked="true" />
			</c:when>
			<c:otherwise>
				<stripes:checkbox name="${name}" onclick="${actionOnClickBool}" disabled="${not editable}" />
			</c:otherwise>
		</c:choose> 
        <stripes:errors field="${name}" />
</c:if>
<c:if test="${valueType.class.name == 'org.uva.sea.ql.ast.type.IntegerType'}"> 
        <stripes:text name="${name}" onchange="${actionOnClickInt}" disabled="${not editable}" value="${value}"/>
        <stripes:errors field="${name}" />
</c:if> 
