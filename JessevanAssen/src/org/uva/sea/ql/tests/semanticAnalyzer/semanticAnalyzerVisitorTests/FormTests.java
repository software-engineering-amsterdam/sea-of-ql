package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Identifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FormTests extends SemanticAnalyzerVisitorTests {
	
	@Test
	public void visitCalledOnForm_visitCalledOnStatement() {
		Statement mockStatement = mock(Statement.class);
		Form form = new Form(new Identifier("form1"), mockStatement);
		form.accept(visitor, context);
		verify(mockStatement).accept(visitor, context);
	}
	
}
