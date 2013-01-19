package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.expr.Ident;

import static org.mockito.Mockito.*;

public class FormTests extends TypecheckerVisitorTests {
	
	@Test
	public void visitCalledOnForm_visitCalledOnFormElement() {
		FormElement mockFormElement = mock(FormElement.class);
		Form form = new Form(new Ident("form1"), mockFormElement);
		form.accept(visitor, context);
		verify(mockFormElement).accept(visitor, context);
	}
	
}