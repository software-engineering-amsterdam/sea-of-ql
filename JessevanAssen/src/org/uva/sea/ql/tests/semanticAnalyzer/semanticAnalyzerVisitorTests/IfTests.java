package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.If;
import org.uva.sea.ql.ast.NullStatement;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.ast.expr.value.Value;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class IfTests extends SemanticAnalyzerVisitorTests {

    @Test
    public void expressionIsBoolean_noErrorsAreAdded() {
        If i = new If(new Bool(true), new NullStatement());
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
            new If(value, new NullStatement()).accept(visitor, context);
            assertTrue(errors + 1 == context.getErrors().size());
        }
    }

    @Test
    public void acceptIsCalled_conditionAcceptIsCalled() {
        Expr mockExpression = mock(Expr.class);
        when(mockExpression.accept(visitor, context)).thenReturn(new org.uva.sea.ql.ast.type.Bool());

        If i = new If(mockExpression, new NullStatement());
        i.accept(visitor, context);
        verify(mockExpression).accept(visitor, context);
    }

    @Test
    public void acceptIsCalled_ifBodyAcceptIsCalled() {
        Statement mockStatement = mock(Statement.class);
        If i = new If(new Bool(true), mockStatement);
        i.accept(visitor, context);
        verify(mockStatement).accept(visitor, context);
    }
}
