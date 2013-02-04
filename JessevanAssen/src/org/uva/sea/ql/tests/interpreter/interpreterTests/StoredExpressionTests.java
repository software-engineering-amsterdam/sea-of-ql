package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.StoredExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.value.Bool;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StoredExpressionTests extends InterpreterVisitorTests {

    @Test
    public void acceptIsCalledOnStoredExpression_returnsNull() {
        final StoredExpression storedExpression = new StoredExpression(new Identifier(""), new Bool(true));
        assertNull(storedExpression.accept(visitor, context));
    }

    @Test
    public void acceptIsCalledOnStoredExpression_acceptIsCalledOnExpression() {
        final Identifier identifier = new Identifier("abcd");
        final Expression mockExpression = mock(Expression.class);
        final StoredExpression storedExpression = new StoredExpression(identifier, mockExpression);

        storedExpression.accept(visitor, context);

        verify(mockExpression).accept(visitor, context);
    }

    @Test
    public void acceptIsCalledOnStoredExpression_expressionIsAddedToIdentifiers() {
        final Identifier identifier = new Identifier("abcd");
        final Expression expression = new Bool(true);
        final StoredExpression storedExpression = new StoredExpression(identifier, expression);

        storedExpression.accept(visitor, context);

        assertTrue(context.getIdentifiers().containsKey(identifier));
        assertSame(expression, context.getIdentifiers().get(identifier));
    }

}
