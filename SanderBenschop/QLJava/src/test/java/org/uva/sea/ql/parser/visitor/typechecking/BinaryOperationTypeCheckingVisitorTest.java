package org.uva.sea.ql.parser.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.*;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.primary.Datatype;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.parser.visitor.typechecking.TypeCheckingVisitor;
import org.uva.sea.ql.parser.visitor.typechecking.UnequalTypesError;
import org.uva.sea.ql.parser.visitor.typechecking.UnsupportedTypeError;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class BinaryOperationTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperlyForSingleType() {
        Datatype leftHandSide = new Int(1);
        Datatype leftHandSide2 = new Int(2);
        Datatype rightHandSide = new Int(3);
        BinaryOperation multiply = new Multiply(leftHandSide, rightHandSide);
        BinaryOperation divide = new Divide(leftHandSide2, multiply);

        typeCheckingVisitor.visitPrimary(leftHandSide);
        typeCheckingVisitor.visitPrimary(leftHandSide2);
        typeCheckingVisitor.visitPrimary(rightHandSide);
        typeCheckingVisitor.visitBinaryOperation(multiply);
        typeCheckingVisitor.visitBinaryOperation(divide);

        assertEquals(0, typeCheckingVisitor.getErrors().size());
    }

    @Test
    public void shouldDetectTypeErrorForSingleType() {
        Datatype leftHandSide = new Int(1);
        Datatype rightHandSide = new Bool(false);
        BinaryOperation multiply = new Multiply(leftHandSide, rightHandSide);

        typeCheckingVisitor.visitPrimary(leftHandSide);
        typeCheckingVisitor.visitPrimary(rightHandSide);
        typeCheckingVisitor.visitBinaryOperation(multiply);

        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
    }

    @Test
    public void shouldCascadeErrorForNestedSingleType() {
        Datatype leftHandSide = new Bool(true);
        Datatype leftHandSide2 = new Int(2);
        Datatype rightHandSide = new Int(3);
        BinaryOperation multiply = new Multiply(leftHandSide, rightHandSide);
        BinaryOperation divide = new Divide(leftHandSide2, multiply);

        typeCheckingVisitor.visitPrimary(leftHandSide);
        typeCheckingVisitor.visitPrimary(leftHandSide2);
        typeCheckingVisitor.visitPrimary(rightHandSide);
        typeCheckingVisitor.visitBinaryOperation(multiply);
        typeCheckingVisitor.visitBinaryOperation(divide);

        assertEquals(2, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertTrue(typeCheckingVisitor.getErrors().get(1) instanceof UnsupportedTypeError);
    }

    @Test
    public void shouldThrowErrorIfTypesAreUnequalInMultipleType() {
        Datatype leftHandSide = new Int(1);
        Datatype rightHandSide = new Bool(false);
        BinaryOperation equalTo = new EqualTo(leftHandSide, rightHandSide);

        typeCheckingVisitor.visitPrimary(leftHandSide);
        typeCheckingVisitor.visitPrimary(rightHandSide);
        typeCheckingVisitor.visitBinaryOperation(equalTo);

        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnequalTypesError);
    }

    @Test
    public void shouldThrowErrorsIfTypesAreUnequalAndDisallowedInMultipleType() {
        Datatype leftHandSide = new Int(1);
        Datatype rightHandSide = new Str("");
        BinaryOperation equalTo = new EqualTo(leftHandSide, rightHandSide);

        typeCheckingVisitor.visitPrimary(leftHandSide);
        typeCheckingVisitor.visitPrimary(rightHandSide);
        typeCheckingVisitor.visitBinaryOperation(equalTo);

        assertEquals(2, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnequalTypesError);
        assertTrue(typeCheckingVisitor.getErrors().get(1) instanceof UnsupportedTypeError);
    }
}
