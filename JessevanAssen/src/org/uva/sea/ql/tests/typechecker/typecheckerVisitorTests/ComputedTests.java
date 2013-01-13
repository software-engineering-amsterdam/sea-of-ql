package org.uva.sea.ql.tests.typechecker.typecheckerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.expr.Expr;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ComputedTests extends TypecheckerVisitorTests {

    @Test
    public void acceptIsCalled_callsAcceptOnExpression() {
        Expr mockExpression = mock(Expr.class);
        Computed computed = new Computed("a", mockExpression);
        computed.accept(visitor, symbolTable);
        verify(mockExpression).accept(visitor, symbolTable);
    }

}