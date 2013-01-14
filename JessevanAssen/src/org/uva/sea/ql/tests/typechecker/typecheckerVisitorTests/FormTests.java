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
	public void visitCalledOnForm_visitCalledOnAllFormElements() {
		List<FormElement> mockFormElements = new ArrayList<FormElement>(3);
		for(int i = 0; i < 3; ++i)
			mockFormElements.add(mock(FormElement.class));
		
		Form form = new Form(new Ident("form1"), mockFormElements);
		
		form.accept(visitor, context);
		
		for(FormElement mockFormElement : mockFormElements)
			verify(mockFormElement).accept(visitor, context);
	}
	
}
