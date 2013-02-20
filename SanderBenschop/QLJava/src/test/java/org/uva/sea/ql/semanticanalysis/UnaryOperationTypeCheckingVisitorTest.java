package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.primary.Bool;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.semanticanalysis.error.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class UnaryOperationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalyser semanticAnalyser;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        semanticAnalyser = new SemanticAnalyser();
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);

        boolean notCorrect = semanticAnalyser.visitNot(unaryOperation);
        assertEquals(0, semanticAnalyser.getErrors().size());
        assertTrue(notCorrect);
    }

    @Test
    public void shouldNotReduceProperlyForUnknownIdentifier() {
        Ident unknownIdent = new Ident("identifier", sourceCodeInformation);
        Not unaryOperation = new Not(unknownIdent, sourceCodeInformation);

        boolean notCorrect = semanticAnalyser.visitNot(unaryOperation);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);

        boolean notCorrect = semanticAnalyser.visitNot(unaryOperation);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldNotCascadeErrorForNestedOperation() {
        Int expression = new Int(0, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);
        Not unaryOperation2 = new Not(unaryOperation, sourceCodeInformation);

        boolean notCorrect = semanticAnalyser.visitNot(unaryOperation2);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }
}
