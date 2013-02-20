package org.uva.sea.ql.semanticanalysis;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.binary.Divide;
import org.uva.sea.ql.ast.expression.binary.EqualTo;
import org.uva.sea.ql.ast.expression.binary.Multiply;
import org.uva.sea.ql.ast.expression.primary.Bool;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.semanticanalysis.error.UnequalTypesError;
import org.uva.sea.ql.semanticanalysis.error.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class BinaryOperationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private SemanticAnalyser semanticAnalyser;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0, 0);
        semanticAnalyser = new SemanticAnalyser();
    }

    @Test
    public void shouldReduceProperlyForSingleType() {
        Int leftHandSide = new Int(1, sourceCodeInformation);
        Int leftHandSide2 = new Int(2, sourceCodeInformation);
        Int rightHandSide = new Int(3, sourceCodeInformation);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide, sourceCodeInformation);
        Divide divide = new Divide(leftHandSide2, multiply, sourceCodeInformation);

        boolean divideCorrect = semanticAnalyser.visitDivide(divide);
        assertEquals(0, semanticAnalyser.getErrors().size());
        assertTrue(divideCorrect);
    }

    @Test
    public void shouldDetectTypeErrorForSingleType() {
        Int leftHandSide = new Int(1, sourceCodeInformation);
        Bool rightHandSide = new Bool(false, sourceCodeInformation);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide, sourceCodeInformation);

        boolean multiplyCorrect = semanticAnalyser.visitMultiply(multiply);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(multiplyCorrect);
    }

    @Test
    public void shouldNotCascadeErrorForNestedSingleType() {
        Bool leftHandSide = new Bool(true, sourceCodeInformation);
        Int leftHandSide2 = new Int(2, sourceCodeInformation);
        Int rightHandSide = new Int(3, sourceCodeInformation);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide, sourceCodeInformation);
        Divide divide = new Divide(leftHandSide2, multiply, sourceCodeInformation);

        boolean divideCorrect = semanticAnalyser.visitDivide(divide);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(divideCorrect);
    }

    @Test
    public void shouldThrowErrorIfTypesAreUnequalInMultipleType() {
        Int leftHandSide = new Int(1, sourceCodeInformation);
        Bool rightHandSide = new Bool(false, sourceCodeInformation);
        EqualTo equalTo = new EqualTo(leftHandSide, rightHandSide, sourceCodeInformation);

        boolean equalToCorrect = semanticAnalyser.visitEqualTo(equalTo);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnequalTypesError);
        assertFalse(equalToCorrect);
    }

    @Test
    public void shouldThrowErrorsIfTypesAreUnequalAndDisallowedInMultipleType() {
        Int leftHandSide = new Int(1, sourceCodeInformation);
        Str rightHandSide = new Str("", sourceCodeInformation);
        EqualTo equalTo = new EqualTo(leftHandSide, rightHandSide, sourceCodeInformation);

        boolean equalToValid = semanticAnalyser.visitEqualTo(equalTo);
        assertEquals(1, semanticAnalyser.getErrors().size());
        assertTrue(semanticAnalyser.getErrors().get(0) instanceof UnequalTypesError);
        assertFalse(equalToValid);
    }
}
