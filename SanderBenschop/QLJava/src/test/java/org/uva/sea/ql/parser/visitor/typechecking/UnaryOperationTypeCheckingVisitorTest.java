package org.uva.sea.ql.parser.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.unary.Not;
import org.uva.sea.ql.ast.nodetypes.unary.UnaryOperation;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class UnaryOperationTypeCheckingVisitorTest {

    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true);
        UnaryOperation unaryOperation = new Not(expression);
        typeCheckingVisitor.visitDatatype(expression);
        typeCheckingVisitor.visitUnaryOperation(unaryOperation);

        assertEquals(0, typeCheckingVisitor.getErrors().size());
    }

    @Test
    public void shouldNotReduceProperlyForUnknownIdentifier() {
        Ident unknownIdent = new Ident("identifier");
        UnaryOperation unaryOperation = new Not(unknownIdent);
        typeCheckingVisitor.visitUnaryOperation(unaryOperation);

        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0);
        UnaryOperation unaryOperation = new Not(expression);
        typeCheckingVisitor.visitDatatype(expression);
        typeCheckingVisitor.visitUnaryOperation(unaryOperation);

        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
    }

    @Test
    public void shouldCascadeErrorForNestedOperation() {
        Int expression = new Int(0);
        UnaryOperation unaryOperation = new Not(expression);
        UnaryOperation unaryOperation2 = new Not(unaryOperation);
        typeCheckingVisitor.visitDatatype(expression);
        typeCheckingVisitor.visitUnaryOperation(unaryOperation);
        typeCheckingVisitor.visitUnaryOperation(unaryOperation2);

        assertEquals(2, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertTrue(typeCheckingVisitor.getErrors().get(1) instanceof UnsupportedTypeError);
    }
}
