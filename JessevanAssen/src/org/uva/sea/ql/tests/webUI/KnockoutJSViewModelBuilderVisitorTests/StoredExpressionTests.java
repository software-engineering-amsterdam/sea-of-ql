package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.StoredExpression;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Bool;

import static org.junit.Assert.assertEquals;

public class StoredExpressionTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final String IDENTIFIER_NAME = "abcde";

    @Test
    public void storedExpressionVisited_addVariableToIdentifierMap() {
        new StoredExpression(new Ident(IDENTIFIER_NAME), new Bool(false)).accept(visitor, context);
        assertEquals(
                String.format(
                        "%s:ko.computed(function(){return false;})",
                        IDENTIFIER_NAME),
                context.getIdentifiers().get(0)
        );
    }
}
