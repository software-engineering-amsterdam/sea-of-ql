package org.uva.sea.ql.tests.interpreter.valueParserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.type.Boolean;
import org.uva.sea.ql.ast.type.Integer;
import org.uva.sea.ql.ast.type.String;
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
                ValueParserFactory.createValueParser(new Boolean()).getClass()
        );
    }

    @Test
    public void intTypeIsPassed_returnsIntValueParser() {
        assertEquals(
                IntValueParser.class,
                ValueParserFactory.createValueParser(new Integer()).getClass()
        );
    }

    @Test
    public void strTypeIsPassed_returnsStrValueParser() {
        assertEquals(
                StrValueParser.class,
                ValueParserFactory.createValueParser(new String()).getClass()
        );
    }

    @Test(expected = RuntimeException.class)
    public void unknownTypeIsPassed_throwsException() {
        ValueParserFactory.createValueParser(new Unknown());
    }

}
