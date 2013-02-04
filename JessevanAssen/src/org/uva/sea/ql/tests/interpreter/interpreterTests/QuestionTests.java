package org.uva.sea.ql.tests.interpreter.interpreterTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.interpreter.valueParser.BoolValueParser;

import static junit.framework.Assert.*;

public class QuestionTests extends InterpreterVisitorTests {

    private static final Identifier IDENTIFIER = new Identifier("abcd");
    private final Question QUESTION = new Question("label", IDENTIFIER, new Bool());

    @Test
    public void acceptIsCalled_returnsNull() {
        assertNull(QUESTION.accept(visitor, context));
    }

    @Test
    public void valueIsntInValues_errorIsAdded() {
        assertErrorIsAddedAfterAccept();
    }

    @Test
    public void valueIsntInValues_defaultValueIsAddedToIdentifiers() {
        QUESTION.accept(visitor, context);
        assertTrue(defaultIsAdded());
    }

    @Test
    public void valueCantBeParsed_errorIsAdded() {
        context.getValues().put(IDENTIFIER.getName(), "abcd");
        assertErrorIsAddedAfterAccept();
    }

    @Test
    public void valueCantBeParsed_defaultValueIsAddedToIdentifiers() {
        context.getValues().put(IDENTIFIER.getName(), "abcd");
        QUESTION.accept(visitor, context);
        assertTrue(defaultIsAdded());
    }

    @Test
    public void valueIsParsed_valueIsAddedToIdentifiers() {
        final org.uva.sea.ql.ast.expression.value.Bool expectedResult = new org.uva.sea.ql.ast.expression.value.Bool(true);

        context.getValues().put(IDENTIFIER.getName(), expectedResult.toString());
        QUESTION.accept(visitor, context);

        assertTrue(context.getIdentifiers().containsKey(IDENTIFIER));
        assertEquals(
                expectedResult,
                context.getIdentifiers().get(IDENTIFIER)
        );
    }

    private void assertErrorIsAddedAfterAccept() {
        assertTrue(context.getErrors().isEmpty());
        QUESTION.accept(visitor, context);
        assertFalse(context.getErrors().isEmpty());
    }

    private boolean defaultIsAdded() {
        return context.getIdentifiers().containsKey(IDENTIFIER) &&
                context.getIdentifiers().get(IDENTIFIER).equals(
                        new BoolValueParser().getDefault()
                );
    }

}
