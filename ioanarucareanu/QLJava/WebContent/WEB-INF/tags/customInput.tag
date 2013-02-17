<%@tag description="Custom input" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ attribute name="valueType" type="org.uva.sea.ql.ast.type.Type" fragment="false"
              rtexprvalue="true" required="true" %> 
<%@ attribute name="name" type="java.lang.String" fragment="false"
              rtexprvalue="true" required="true" %>
<c:if test="${valueType.class.name == 'org.uva.sea.ql.ast.type.BooleanType'}">
		Yes
        <stripes:checkbox name="${name}" onclick="processUserResponse('/ql/protected/question/process/bool', this)"/>
        <stripes:errors field="${name}" />
</c:if>
<c:if test="${valueType.class.name == 'org.uva.sea.ql.ast.type.IntegerType'}"> 
        <stripes:text name="${name}" />
        <stripes:errors field="${name}" />
</c:if> 
