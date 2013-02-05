package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeStatement;
import org.uva.sea.ql.ast.Statement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CompositeStatementTests extends InterpreterVisitorTests {

    @Test
    public void acceptCalled_returnsNull() {
        assertNull(new CompositeStatement(new ArrayList<Statement>()).accept(visitor, context));
    }

    @Test
    public void acceptCalled_acceptIsCalledOnAllChildren() {
        final List<Statement> mockStatements = new ArrayList<Statement>(3);
        for(int i = 0; i < 3; ++i)
            mockStatements.add(mock(Statement.class));

        CompositeStatement compositeStatement = new CompositeStatement(mockStatements);
        compositeStatement.accept(visitor, context);

        for(Statement mockStatement : mockStatements)
            verify(mockStatement).accept(visitor, context);
    }

}
