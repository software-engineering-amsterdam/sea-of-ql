package org.uva.sea.ql.tests.interpreter.valueParserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Unknown;
import org.uva.sea.ql.interpreter.valueParser.BoolValueParser;
import org.uva.sea.ql.interpreter.valueParser.IntValueParser;
import org.uva.sea.ql.interpreter.valueParser.StrValueParser;
import org.uva.sea.ql.interpreter.valueParser.ValueParserFactory;

import static junit.framework.Assert.assertEquals;

public class ValueParserFactoryTests {


    @Test
    public void boolTypeIsPassed_returnsBoolValueParser() {
        assertEquals(
                BoolValueParser.class,
                ValueParserFactory.createValueParser(new Bool()).getClass()
        );
    }

    @Test
    public void intTypeIsPassed_returnsIntValueParser() {
        assertEquals(
                IntValueParser.class,
                ValueParserFactory.createValueParser(new Int()).getClass()
        );
    }

    @Test
    public void strTypeIsPassed_returnsStrValueParser() {
        assertEquals(
                StrValueParser.class,
                ValueParserFactory.createValueParser(new Str()).getClass()
        );
    }

    @Test(expected = RuntimeException.class)
    public void voidTypeIsPassed_throwsException() {
        ValueParserFactory.createValueParser(new org.uva.sea.ql.ast.type.Void());
    }

    @Test(expected = RuntimeException.class)
    public void unknownTypeIsPassed_throwsException() {
        ValueParserFactory.createValueParser(new Unknown());
    }

}
