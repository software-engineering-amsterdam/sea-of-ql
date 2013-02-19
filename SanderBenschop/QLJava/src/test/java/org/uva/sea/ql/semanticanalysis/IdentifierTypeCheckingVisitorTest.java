package org.uva.sea.ql.semanticanalysis;

import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.parsing.TestParser;
import org.uva.sea.ql.semanticanalysis.error.IdentifierRedeclarationError;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.when;

public class IdentifierTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() throws IllegalAccessException {
        semanticAnalysisVisitor = new SemanticAnalysisVisitor();
        sourceCodeInformation = new SourceCodeInformation(0, 0);
    }

    @Test
    public void shouldNotReturnIdentifierRedeclarationError() {
        Ident ident = new Ident("age", sourceCodeInformation);

        boolean identCorrect = semanticAnalysisVisitor.visitIdent(ident);
        assertTrue(semanticAnalysisVisitor.getErrors().isEmpty());
        assertTrue(identCorrect);
    }

    @Test
    public void shouldReturnIdentifierRedeclarationError() throws IllegalAccessException {
        String computationName = "grossIncome";
        Ident ident = new Ident(computationName, sourceCodeInformation);
        Str label = new Str("", sourceCodeInformation);
        Question question = new Question(ident, label, new BooleanType());

        semanticAnalysisVisitor.visitQuestion(question);
        boolean questionCorrect = semanticAnalysisVisitor.visitQuestion(question);

        assertEquals(1, semanticAnalysisVisitor.getErrors().size());
        assertTrue(semanticAnalysisVisitor.getErrors().get(0) instanceof IdentifierRedeclarationError);
        assertFalse(questionCorrect);
    }
}
