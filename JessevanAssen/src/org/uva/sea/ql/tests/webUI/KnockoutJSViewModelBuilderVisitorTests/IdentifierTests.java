package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;

import static org.junit.Assert.assertEquals;

public class IdentifierTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final String IDENTIFIER_NAME = "abc";

    @Test
    public void identifierVisited_identifierCallAddedToStringBuilder() {
        new Identifier(IDENTIFIER_NAME).accept(visitor, context);
        assertEquals(String.format("_self.identifiers.%s()", IDENTIFIER_NAME), context.getObjectHierarchy().toString());
    }

}
