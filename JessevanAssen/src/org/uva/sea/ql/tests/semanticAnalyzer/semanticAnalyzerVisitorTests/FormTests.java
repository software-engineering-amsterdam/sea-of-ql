package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.expr.Ident;

import static org.mockito.Mockito.*;

public class FormTests extends SemanticAnalyzerVisitorTests {
	
	@Test
	public void visitCalledOnForm_visitCalledOnFormElement() {
		FormElement mockFormElement = mock(FormElement.class);
		Form form = new Form(new Ident("form1"), mockFormElement);
		form.accept(visitor, context);
		verify(mockFormElement).accept(visitor, context);
	}
	
}
