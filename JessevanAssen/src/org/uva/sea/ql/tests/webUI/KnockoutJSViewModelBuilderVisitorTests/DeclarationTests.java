package org.uva.sea.ql.tests.webUI.KnockoutJSViewModelBuilderVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Declaration;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Bool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DeclarationTests extends KnockoutJSViewModelBuilderVisitorTests {

    @Test
    public void visitDeclaration_addVariableToIdentityMap() {
        final String IDENTITY_NAME = "abc";
        Declaration declaration = new Declaration(new Ident(IDENTITY_NAME), new Bool());
        declaration.accept(visitor, context);
        assertFalse(context.getIdentities().isEmpty());
        assertEquals(IDENTITY_NAME, context.getIdentities().get(0));
    }

}
