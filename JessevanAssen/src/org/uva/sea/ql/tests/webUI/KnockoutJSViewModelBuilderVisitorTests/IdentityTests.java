package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;

import static org.junit.Assert.assertEquals;

public class IdentityTests extends KnockoutJSViewModelBuilderVisitorTests {

    private static final String IDENTITY_NAME = "abc";

    @Test
    public void identityVisited_identityCallAddedToStringBuilder() {
        new Ident(IDENTITY_NAME).accept(visitor, context);
        assertEquals(String.format("_self.identities.%s()", IDENTITY_NAME), context.getObjectHierarchy().toString());
    }

}
