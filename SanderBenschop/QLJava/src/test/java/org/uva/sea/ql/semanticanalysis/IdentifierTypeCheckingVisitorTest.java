package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.general.SymbolTable;
import org.uva.sea.ql.semanticanalysis.error.IdentifierRedeclarationError;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdentifierTypeCheckingVisitorTest {

    @Mock
    private SymbolTable mockedSymbolTable;
    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() throws IllegalAccessException {
        semanticAnalysisVisitor = new SemanticAnalysisVisitor(mockedSymbolTable);
        sourceCodeInformation = new SourceCodeInformation(0, 0);
    }

    @Test
    public void shouldNotThrowIdentifierRedeclarationError() {
        Ident ident = new Ident("age", sourceCodeInformation);

        boolean identCorrect = semanticAnalysisVisitor.visitIdent(ident);
        assertTrue(semanticAnalysisVisitor.getErrors().isEmpty());
        assertTrue(identCorrect);
    }

    @Test
    public void shouldThrowIdentifierRedeclarationError() {
        String computationName = "grossIncome";
        Ident ident = new Ident(computationName, sourceCodeInformation);
        Str label = new Str("", sourceCodeInformation);
        Question question = new Question(ident, label, new BooleanType());
        when(mockedSymbolTable.containsIdentifier(ident)).thenReturn(true);

        boolean questionCorrect = semanticAnalysisVisitor.visitQuestion(question);
        assertEquals(1, semanticAnalysisVisitor.getErrors().size());
        assertTrue(semanticAnalysisVisitor.getErrors().get(0) instanceof IdentifierRedeclarationError);
        assertFalse(questionCorrect);
    }
}
