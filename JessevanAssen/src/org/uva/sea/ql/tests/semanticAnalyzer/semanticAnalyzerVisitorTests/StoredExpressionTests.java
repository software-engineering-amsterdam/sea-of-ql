package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.StoredExpression;
import org.uva.sea.ql.ast.expr.Ident;

import static junit.framework.Assert.*;

public class StoredExpressionTests extends SemanticAnalyzerVisitorTests {

    private final Ident identifier = new Ident("identifier");
    private final StoredExpression storedExpression = new StoredExpression(
            identifier,
            new org.uva.sea.ql.ast.expr.value.Bool(false)
    );

    @Test
    public void storedExpressionIsVisited_identifierWithTypeIsAddedToSymbolTable() {
        storedExpression.accept(visitor, context);

        assertTrue(context.getSymbolTable().containsKey(identifier));
        assertEquals(org.uva.sea.ql.ast.type.Bool.class, context.getSymbolTable().get(identifier).getClass());
    }

    @Test
    public void identIsAlreadyInSymbolTable_errorIsAdded() {
        context.getSymbolTable().put(identifier, new org.uva.sea.ql.ast.type.Str());

        storedExpression.accept(visitor, context);

        assertFalse(context.getErrors().isEmpty());
    }

}
