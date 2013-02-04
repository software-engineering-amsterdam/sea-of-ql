package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.NullStatement;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.expr.value.Bool;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

public class IfTests extends InterpreterVisitorTests {

    @Test
    public void conditionIsTrue_acceptCalledOnIfBody() {
        Statement mockIfBody = mock(Statement.class);
        If i = new If(new Bool(true), mockIfBody);
        i.accept(visitor, context);
        verify(mockIfBody, times(1)).accept(visitor, context);
    }

    @Test
    public void conditionIsFalse_acceptIsNotCalledOnIfBody() {
        Statement mockIfBody = mock(Statement.class);
        If i = new If(new Bool(false), mockIfBody);
        i.accept(visitor, context);
        verify(mockIfBody, never()).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_returnsNull() {
        If i = new If(new Bool(true), new NullStatement());
        assertNull(i.accept(visitor, context));
    }
}
