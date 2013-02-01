package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.StoredExpression;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Bool;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StoredExpressionTests extends InterpreterVisitorTests {

    @Test
    public void acceptIsCalledOnStoredExpression_returnsNull() {
        final StoredExpression storedExpression = new StoredExpression(new Ident(""), new Bool(true));
        assertNull(storedExpression.accept(visitor, context));
    }

    @Test
    public void acceptIsCalledOnStoredExpression_acceptIsCalledOnExpression() {
        final Ident identifier = new Ident("abcd");
        final Expr mockExpression = mock(Expr.class);
        final StoredExpression storedExpression = new StoredExpression(identifier, mockExpression);

        storedExpression.accept(visitor, context);

        verify(mockExpression).accept(visitor, context);
    }

    @Test
    public void acceptIsCalledOnStoredExpression_expressionIsAddedToIdentifiers() {
        final Ident identifier = new Ident("abcd");
        final Expr expression = new Bool(true);
        final StoredExpression storedExpression = new StoredExpression(identifier, expression);

        storedExpression.accept(visitor, context);

        assertTrue(context.getIdentifiers().containsKey(identifier));
        assertSame(expression, context.getIdentifiers().get(identifier));
    }

}
