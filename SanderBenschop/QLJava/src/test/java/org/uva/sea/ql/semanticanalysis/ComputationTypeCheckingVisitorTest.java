package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.Multiply;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.statement.Computation;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ComputationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalyser semanticAnalyser;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        semanticAnalyser = new SemanticAnalyser();
    }

    @Test
    public void shouldReduceProperly() {
        Ident ident = new Ident("test", sourceCodeInformation);
        Str str = new Str("\"Label\"", sourceCodeInformation);
        Int number = new Int(0, sourceCodeInformation);
        Computation computation = new Computation(ident, str, number);

        boolean computationCorrect = semanticAnalyser.visitComputation(computation);
        assertTrue(semanticAnalyser.getErrors().isEmpty());
        assertTrue(computationCorrect);
    }

    @Test
    public void shouldNotReduceProperly() {
        Ident ident = new Ident("test", sourceCodeInformation);
        Str str = new Str("\"Label\"", sourceCodeInformation);
        Multiply multiply = new Multiply(new Int(1, sourceCodeInformation), new Ident("test2", sourceCodeInformation), sourceCodeInformation);
        Computation computation = new Computation(ident, str, multiply);

        boolean computationCorrect = semanticAnalyser.visitComputation(computation);
        assertFalse(computationCorrect);
        assertEquals(1, semanticAnalyser.getErrors().size());
    }

    @Test
    public void shouldMakeIdentifierReduceableIfExpressionIsReduceable() {
        Int leftHandSide = new Int(1, sourceCodeInformation);
        Int rightHandSide = new Int(3, sourceCodeInformation);
        Int rightHandSide2 = new Int(5, sourceCodeInformation);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide, sourceCodeInformation);
        //
        Ident ident = new Ident("test", sourceCodeInformation);
        Str str = new Str("\"Label\"", sourceCodeInformation);
        Computation computation = new Computation(ident, str, multiply);
        Multiply multiply2 = new Multiply(ident, rightHandSide2, sourceCodeInformation);

        boolean computationCorrect = semanticAnalyser.visitComputation(computation);
        boolean multiplyCorrect = semanticAnalyser.visitMultiply(multiply2);

        assertTrue(semanticAnalyser.getErrors().isEmpty());
        assertTrue(computationCorrect);
        assertTrue(multiplyCorrect);
    }
}
