package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.binary.Multiply;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class ComputationTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Int number = new Int(0);
        Computation computation = new Computation(new Ident("test"), new Str("\"Label\""), number);

        boolean computationCorrect = typeCheckingVisitor.visitComputation(computation);
        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
        assertTrue(computationCorrect);
    }

    @Test
    public void shouldNotAcceptOtherExpressionThanInt() {
        Bool bool = new Bool(true);
        Computation computation = new Computation(new Ident("test"), new Str("\"Label\""), bool);

        boolean computationCorrect = typeCheckingVisitor.visitComputation(computation);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(computationCorrect);
    }

    @Test
    public void shouldMakeIdentifierReduceableIfExpressionIsReduceable() {
        Int leftHandSide = new Int(1);
        Int rightHandSide = new Int(3);
        Int rightHandSide2 = new Int(5);
        Multiply multiply = new Multiply(leftHandSide, rightHandSide);
        Computation computation = new Computation(new Ident("test"), new Str("\"Label\""), multiply);
        Multiply multiply2 = new Multiply(new Ident("test"), rightHandSide2);

        boolean computationCorrect = typeCheckingVisitor.visitComputation(computation);
        boolean multiplyCorrect = typeCheckingVisitor.visitMultiply(multiply2);

        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
        assertTrue(computationCorrect);
        assertTrue(multiplyCorrect);
    }
}
