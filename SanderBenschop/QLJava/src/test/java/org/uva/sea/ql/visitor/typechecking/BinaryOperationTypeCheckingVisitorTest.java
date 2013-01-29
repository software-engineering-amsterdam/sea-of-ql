package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.binary.Divide;
import org.uva.sea.ql.ast.binary.EqualTo;
import org.uva.sea.ql.ast.binary.Multiply;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.visitor.typechecking.errors.UnequalTypesError;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class BinaryOperationTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperlyForSingleType() {
        Int leftHandSide = new Int(1);
        Int leftHandSide2 = new Int(2);
        Int rightHandSide = new Int(3);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide);
        Divide divide = new Divide(leftHandSide2, multiply);

        boolean divideCorrect = typeCheckingVisitor.visitDivide(divide);
        assertEquals(0, typeCheckingVisitor.getErrors().size());
        assertTrue(divideCorrect);
    }

    @Test
    public void shouldDetectTypeErrorForSingleType() {
        Int leftHandSide = new Int(1);
        Bool rightHandSide = new Bool(false);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide);

        boolean multiplyCorrect = typeCheckingVisitor.visitMultiply(multiply);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(multiplyCorrect);
    }

    @Test
    public void shouldNotCascadeErrorForNestedSingleType() {
        Bool leftHandSide = new Bool(true);
        Int leftHandSide2 = new Int(2);
        Int rightHandSide = new Int(3);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide);
        Divide divide = new Divide(leftHandSide2, multiply);

        boolean divideCorrect = typeCheckingVisitor.visitDivide(divide);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(divideCorrect);
    }

    @Test
    public void shouldThrowErrorIfTypesAreUnequalInMultipleType() {
        Int leftHandSide = new Int(1);
        Bool rightHandSide = new Bool(false);
        EqualTo equalTo = new EqualTo(leftHandSide, rightHandSide);

        boolean equalToCorrect = typeCheckingVisitor.visitEqualTo(equalTo);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnequalTypesError);
        assertFalse(equalToCorrect);
    }

    @Test
    public void shouldThrowErrorsIfTypesAreUnequalAndDisallowedInMultipleType() {
        Int leftHandSide = new Int(1);
        Str rightHandSide = new Str("");
        EqualTo equalTo = new EqualTo(leftHandSide, rightHandSide);

        boolean equalToValid = typeCheckingVisitor.visitEqualTo(equalTo);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnequalTypesError);
        assertFalse(equalToValid);
    }
}
