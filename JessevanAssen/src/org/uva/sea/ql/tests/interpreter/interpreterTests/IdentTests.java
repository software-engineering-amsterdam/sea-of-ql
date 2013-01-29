package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.value.Str;

import static junit.framework.Assert.assertSame;

public class IdentTests extends InterpreterVisitorTests {

    @Test
    public void acceptIsCalledOnIdent_returnsValueFromIdentifiers() {
        final Ident identifier = new Ident("abcdefg");
        final Str value = new Str("hijklmnop");
        context.getIdentifiers().put(identifier, value);

        assertSame(
                value,
                identifier.accept(visitor, context)
        );
    }
}
