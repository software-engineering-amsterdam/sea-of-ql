package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.value.Str;

import static junit.framework.Assert.assertSame;

public class IdentTests extends InterpreterVisitorTests {

    @Test
    public void acceptIsCalledOnIdent_returnsValueFromIdentifiers() {
        final Identifier identifier = new Identifier("abcdefg");
        final Str value = new Str("hijklmnop");
        context.getIdentifiers().put(identifier, value);

        assertSame(
                value,
                identifier.accept(visitor, context)
        );
    }
}
