package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.primary.Bool;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.general.symboltable.SymbolTableImpl;
import org.uva.sea.ql.semanticanalysis.error.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class UnaryOperationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalysisVisitor semanticAnalysisVisitor;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        semanticAnalysisVisitor = new SemanticAnalysisVisitor(new SymbolTableImpl());
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);

        boolean notCorrect = semanticAnalysisVisitor.visitNot(unaryOperation);
        assertEquals(0, semanticAnalysisVisitor.getErrors().size());
        assertTrue(notCorrect);
    }

    @Test
    public void shouldNotReduceProperlyForUnknownIdentifier() {
        Ident unknownIdent = new Ident("identifier", sourceCodeInformation);
        Not unaryOperation = new Not(unknownIdent, sourceCodeInformation);

        boolean notCorrect = semanticAnalysisVisitor.visitNot(unaryOperation);
        assertEquals(1, semanticAnalysisVisitor.getErrors().size());
        assertTrue(semanticAnalysisVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);

        boolean notCorrect = semanticAnalysisVisitor.visitNot(unaryOperation);
        assertEquals(1, semanticAnalysisVisitor.getErrors().size());
        assertTrue(semanticAnalysisVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldNotCascadeErrorForNestedOperation() {
        Int expression = new Int(0, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);
        Not unaryOperation2 = new Not(unaryOperation, sourceCodeInformation);

        boolean notCorrect = semanticAnalysisVisitor.visitNot(unaryOperation2);
        assertEquals(1, semanticAnalysisVisitor.getErrors().size());
        assertTrue(semanticAnalysisVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }
}
