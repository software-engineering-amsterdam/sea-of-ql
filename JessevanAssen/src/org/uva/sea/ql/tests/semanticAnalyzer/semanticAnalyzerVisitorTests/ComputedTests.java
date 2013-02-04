package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.expression.Expression;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ComputedTests extends SemanticAnalyzerVisitorTests {

    @Test
    public void acceptIsCalled_callsAcceptOnExpression() {
        Expression mockExpression = mock(Expression.class);
        Computed computed = new Computed("a", mockExpression);
        computed.accept(visitor, context);
        verify(mockExpression).accept(visitor, context);
    }

}
