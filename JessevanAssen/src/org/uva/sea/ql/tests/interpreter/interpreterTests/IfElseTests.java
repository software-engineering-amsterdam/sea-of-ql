package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.FormElement;
import org.uva.sea.ql.ast.IfElse;
import org.uva.sea.ql.ast.NullFormElement;
import org.uva.sea.ql.ast.expr.value.Bool;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

public class IfElseTests extends InterpreterVisitorTests {

    @Test
    public void conditionIsTrue_acceptIsOnlyCalledOnIfBody() {
        FormElement mockIfBody = mock(FormElement.class);
        FormElement mockElseBody = mock(FormElement.class);
        IfElse ifElse = new IfElse(new Bool(true), mockIfBody, mockElseBody);
        ifElse.accept(visitor, context);
        verify(mockIfBody, times(1)).accept(visitor, context);
        verify(mockElseBody, never()).accept(visitor, context);
    }

    @Test
    public void conditionIsFalse_acceptIsOnlyCalledOnElseBody() {
        FormElement mockIfBody = mock(FormElement.class);
        FormElement mockElseBody = mock(FormElement.class);
        IfElse ifElse = new IfElse(new Bool(false), mockIfBody, mockElseBody);
        ifElse.accept(visitor, context);
        verify(mockIfBody, never()).accept(visitor, context);
        verify(mockElseBody, times(1)).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_returnsNull() {
        IfElse ifElse = new IfElse(new Bool(true), new NullFormElement(), new NullFormElement());
        assertNull(ifElse.accept(visitor, context));
    }
}