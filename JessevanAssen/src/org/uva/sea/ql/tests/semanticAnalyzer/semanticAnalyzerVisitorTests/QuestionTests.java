package org.uva.sea.ql.tests.semanticAnalyzer.semanticAnalyzerVisitorTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Type;

import static org.junit.Assert.*;

public class QuestionTests extends SemanticAnalyzerVisitorTests {

    @Test
    public void acceptIsCalledOnQuestion_IdentifierIsAddedToSymbolTable() {
        final Identifier identifier = new Identifier("a");
        final Type type = new Bool();
        final Question question = new Question("a", identifier, type);

        question.accept(visitor, context);

        assertTrue(context.getErrors().isEmpty());
        assertTrue(context.getSymbolTable().containsKey(identifier));
        assertEquals(type, context.getSymbolTable().get(identifier));
    }

    @Test
    public void variableIsDeclaredTwice_addsError() {
        final Question question = new Question("a", new Identifier("a"), new Bool());

        question.accept(visitor, context);
        question.accept(visitor, context);

        assertFalse(context.getErrors().isEmpty());
    }

    @Test
    public void variableNameIsDeclaredTwice_addsError() {
        new Question("a", new Identifier("a"), new Bool()).accept(visitor, context);
        new Question("a", new Identifier("a"), new Int()).accept(visitor, context);

        assertFalse(context.getErrors().isEmpty());
    }
}
