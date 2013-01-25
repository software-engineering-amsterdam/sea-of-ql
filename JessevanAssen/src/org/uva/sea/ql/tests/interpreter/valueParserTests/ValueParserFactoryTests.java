package org.uva.sea.ql.tests.interpreter.valueParserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.interpreter.valueParser.*;

import static junit.framework.Assert.assertEquals;

public class ValueParserFactoryTests {

    private final ValueParserFactory valueParserFactory = new ValueParserFactory();

    @Test
    public void boolTypeIsPassed_returnsBoolValueParser() {
        assertEquals(
                BoolValueParser.class,
                new Bool().accept(valueParserFactory, null).getClass()
        );
    }

    @Test
    public void intTypeIsPassed_returnsIntValueParser() {
        assertEquals(
                IntValueParser.class,
                new Int().accept(valueParserFactory, null).getClass()
        );
    }

    @Test
    public void strTypeIsPassed_returnsStrValueParser() {
        assertEquals(
                StrValueParser.class,
                new Str().accept(valueParserFactory, null).getClass()
        );
    }

    @Test(expected = RuntimeException.class)
    public void voidTypeIsPassed_throwsException() {
         new org.uva.sea.ql.ast.type.Void().accept(valueParserFactory, null);
    }

    @Test(expected = RuntimeException.class)
    public void unknownTypeIsPassed_throwsException() {
        new Unknown().accept(valueParserFactory, null);
    }

}
