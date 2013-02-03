package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.NullFormElement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IfTests extends TypecheckerVisitorTests {

    @Test
    public void expressionIsBoolean_noErrorsAreAdded() {
        If i = new If(new Bool(true), new NullFormElement());
        i.accept(visitor, context);
        assertTrue(context.getErrors().isEmpty());
    }

    @Test
    public void expressionIsNotBoolean_errorsAreAdded() {
        final Value[] notBooleanValues = {
                new Int(10),
                new Str("Hello")
        };

        for(Value value : notBooleanValues) {
            int errors = context.getErrors().size();
            new If(value, new NullFormElement()).accept(visitor, context);
            assertTrue(errors + 1 == context.getErrors().size());
        }
    }

    @Test
    public void acceptIsCalled_conditionAcceptIsCalled() {
        Expr mockExpression = mock(Expr.class);
        when(mockExpression.accept(visitor, context)).thenReturn(new org.uva.sea.ql.ast.type.Bool());

        If i = new If(mockExpression, new NullFormElement());
        i.accept(visitor, context);
        verify(mockExpression).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_ifBodyAcceptIsCalled() {
        FormElement mockFormElement = mock(FormElement.class);
        If i = new If(new Bool(true), mockFormElement);
        i.accept(visitor, context);
        verify(mockFormElement).accept(visitor, context);
    }
}
