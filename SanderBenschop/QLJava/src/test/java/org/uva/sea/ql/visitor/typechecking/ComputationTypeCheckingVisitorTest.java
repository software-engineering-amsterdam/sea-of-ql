package org.uva.sea.ql.visitor.typechecking;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.binary.Multiply;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.visitor.typechecking.error.UnsupportedTypeError;

import static junit.framework.Assert.*;

public class ComputationTypeCheckingVisitorTest {

    private SourceCodeInformation sourceCodeInformation;
    private TypeCheckingVisitor typeCheckingVisitor;

    @Before
    public void init() {
        sourceCodeInformation = new SourceCodeInformation(0,0);
        typeCheckingVisitor = new TypeCheckingVisitor();
    }

    @Test
    public void shouldReduceProperly() {
        Ident ident = new Ident("test", sourceCodeInformation);
        Str str = new Str("\"Label\"", sourceCodeInformation);
        Int number = new Int(0, sourceCodeInformation);
        Computation computation = new Computation(ident, str, number);

        boolean computationCorrect = typeCheckingVisitor.visitComputation(computation);
        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
        assertTrue(computationCorrect);
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

        boolean computationCorrect = typeCheckingVisitor.visitComputation(computation);
        boolean multiplyCorrect = typeCheckingVisitor.visitMultiply(multiply2);

        assertTrue(typeCheckingVisitor.getErrors().isEmpty());
        assertTrue(computationCorrect);
        assertTrue(multiplyCorrect);
    }
}
