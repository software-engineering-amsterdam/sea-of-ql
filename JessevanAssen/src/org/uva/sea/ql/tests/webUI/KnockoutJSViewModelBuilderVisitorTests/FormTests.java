package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.NullFormElement;
import org.uva.sea.ql.ast.expr.Ident;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FormTests extends KnockoutJSViewModelBuilderVisitorTests {
	
	@Test
    public void visitCalled_createsRootBlock() {
        new Form(new Ident("a"), new NullFormElement()).accept(visitor, context);
        assertEquals(String.format("new Block(function(){return true;},[])"), context.getObjectHierarchy().toString());
    }
	
}
