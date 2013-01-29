package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.visitor.typechecking.errors.IdentifierRedeclarationError;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IdentifierTypeCheckingVisitorTest {

    @Mock
    private SymbolTable mockedSymbolTable;
    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() throws IllegalAccessException {
        typeCheckingVisitor = new TypeCheckingVisitor(mockedSymbolTable);
    }

    @Test
    public void shouldNotThrowIdentifierRedeclarationError() {
        Ident ident = new Ident("age");

        boolean identCorrect = typeCheckingVisitor.visitIdent(ident);
        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
        assertTrue(identCorrect);
    }

    @Test
    public void shouldThrowIdentifierRedeclarationError() {
        String computationName = "grossIncome";
        Ident ident = new Ident(computationName);
        Question question = new Question(ident, new Str(""), new BooleanType());
        when(mockedSymbolTable.containsReductionFor(ident)).thenReturn(true);

        boolean questionCorrect = typeCheckingVisitor.visitQuestion(question);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof IdentifierRedeclarationError);
        assertFalse(questionCorrect);
    }
}
