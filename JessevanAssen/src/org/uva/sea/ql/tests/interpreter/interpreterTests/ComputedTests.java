package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.expression.value.Bool;

import static junit.framework.Assert.assertNull;

public class ComputedTests extends InterpreterVisitorTests {

    @Test
    public void acceptCalled_returnsNull() {
        assertNull(
                new Computed("", new Bool(true))
                    .accept(visitor, context)
        );
    }

}
