package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class UnaryOperationTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true);
        Not unaryOperation = new Not(expression);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation);
        assertEquals(0, typeCheckingVisitor.getErrors().size());
        assertTrue(notCorrect);
    }

    @Test
    public void shouldNotReduceProperlyForUnknownIdentifier() {
        Ident unknownIdent = new Ident("identifier");
        Not unaryOperation = new Not(unknownIdent);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0);
        Not unaryOperation = new Not(expression);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldNotCascadeErrorForNestedOperation() {
        Int expression = new Int(0);
        Not unaryOperation = new Not(expression);
        Not unaryOperation2 = new Not(unaryOperation);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation2);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }
}
