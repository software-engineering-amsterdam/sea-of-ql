package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.semanticanalysis.error.IdentifierRedeclarationError;

import static junit.framework.Assert.*;

public class IdentifierTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalyser semanticAnalyser;

    @Before
    public void init() throws IllegalAccessException {
        semanticAnalyser = new SemanticAnalyser();
        sourceCodeInformation = new SourceCodeInformation(0, 0);
    }

    @Test
    public void shouldNotReturnIdentifierRedeclarationError() {
        Ident ident = new Ident("age", sourceCodeInformation);

        boolean identCorrect = semanticAnalyser.visitIdent(ident);
        assertTrue(semanticAnalyser.getErrors().isEmpty());
        assertTrue(identCorrect);
    }

    @Test
    public void shouldReturnIdentifierRedeclarationError() throws IllegalAccessException {
        String computationName = "grossIncome";
        Ident ident = new Ident(computationName, sourceCodeInformation);
        Str label = new Str("", sourceCodeInformation);
        Question question = new Question(ident, label, new BooleanType());

        semanticAnalyser.visitQuestion(question);
        boolean questionCorrect = semanticAnalyser.visitQuestion(question);

        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof IdentifierRedeclarationError);
        assertFalse(questionCorrect);
    }
}
