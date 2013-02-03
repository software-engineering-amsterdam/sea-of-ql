package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.visitor.typechecking.error.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class UnaryOperationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0,0);
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Bool expression = new Bool(true, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation);
        assertEquals(0, typeCheckingVisitor.getErrors().size());
        assertTrue(notCorrect);
    }

    @Test
    public void shouldNotReduceProperlyForUnknownIdentifier() {
        Ident unknownIdent = new Ident("identifier", sourceCodeInformation);
        Not unaryOperation = new Not(unknownIdent, sourceCodeInformation);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldDetectTypeError() {
        Int expression = new Int(0, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }

    @Test
    public void shouldNotCascadeErrorForNestedOperation() {
        Int expression = new Int(0, sourceCodeInformation);
        Not unaryOperation = new Not(expression, sourceCodeInformation);
        Not unaryOperation2 = new Not(unaryOperation, sourceCodeInformation);

        boolean notCorrect = typeCheckingVisitor.visitNot(unaryOperation2);
        assertEquals(1, typeCheckingVisitor.getErrors().size());
        assertTrue(typeCheckingVisitor.getErrors().get(0) instanceof UnsupportedTypeError);
        assertFalse(notCorrect);
    }
}
