package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.NullFormElement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.expr.value.Bool;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IfTests extends TypecheckerVisitorTests {

    @Test
    public void acceptIsCalled_conditionAcceptIsCalled() {
        Expr mockExpression = mock(Expr.class);
        If i = new If(mockExpression, new NullFormElement(), new NullFormElement());
        i.accept(visitor, context);
        verify(mockExpression).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_ifBodyAcceptIsCalled() {
        FormElement mockFormElement = mock(FormElement.class);
        If i = new If(new Bool(true), mockFormElement, new NullFormElement());
        i.accept(visitor, context);
        verify(mockFormElement).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_elseBodyAcceptIsCalled() {
        FormElement mockFormElement = mock(FormElement.class);
        If i = new If(new Bool(true), new NullFormElement(), mockFormElement);
        i.accept(visitor, context);
        verify(mockFormElement).accept(visitor, context);
    }

}
