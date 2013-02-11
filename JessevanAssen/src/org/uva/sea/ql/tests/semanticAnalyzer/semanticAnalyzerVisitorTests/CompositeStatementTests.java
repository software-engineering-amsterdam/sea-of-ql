package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeStatement;
import org.uva.sea.ql.ast.Statement;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CompositeStatementTests extends SemanticAnalyzerVisitorTests {

    @Test
    public void acceptIsCalled_acceptIsCalledOnAllSubStatements() {
        Iterable<Statement> mockStatements = Arrays.asList(
                mock(Statement.class),
                mock(Statement.class),
                mock(Statement.class)
        );
        CompositeStatement compositeStatement = new CompositeStatement(mockStatements);

        compositeStatement.accept(visitor, context);

        for(Statement statement : mockStatements)
            verify(statement).accept(visitor, context);
    }
}
