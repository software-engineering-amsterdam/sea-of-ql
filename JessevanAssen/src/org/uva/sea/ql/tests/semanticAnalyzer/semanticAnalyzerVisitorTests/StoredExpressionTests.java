package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.StoredExpression;
import org.uva.sea.ql.ast.expression.Identifier;

import static junit.framework.Assert.*;

public class StoredExpressionTests extends SemanticAnalyzerVisitorTests {

    private final Identifier identifier = new Identifier("identifier");
    private final StoredExpression storedExpression = new StoredExpression(
            identifier,
            new org.uva.sea.ql.ast.expression.value.Bool(false)
    );

    @Test
    public void storedExpressionIsVisited_identifierWithTypeIsAddedToSymbolTable() {
        storedExpression.accept(visitor, context);

        assertTrue(context.getSymbolTable().containsKey(identifier));
        assertEquals(org.uva.sea.ql.ast.type.Boolean.class, context.getSymbolTable().get(identifier).getClass());
    }

    @Test
    public void identIsAlreadyInSymbolTable_errorIsAdded() {
        context.getSymbolTable().put(identifier, new org.uva.sea.ql.ast.type.String());

        storedExpression.accept(visitor, context);

        assertFalse(context.getErrors().isEmpty());
    }

}
