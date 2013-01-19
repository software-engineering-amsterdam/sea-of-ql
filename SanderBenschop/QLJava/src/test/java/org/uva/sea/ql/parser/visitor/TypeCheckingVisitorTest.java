package org.uva.sea.ql.parser.visitor;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.BinaryOperation;
import org.uva.sea.ql.ast.nodetypes.binary.Divide;
import org.uva.sea.ql.ast.nodetypes.binary.Multiply;
import org.uva.sea.ql.ast.nodetypes.binary.SingleTypeBinaryOperation;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.primary.Primary;
import org.uva.sea.ql.parser.visitor.typechecking.TypeCheckingVisitor;

import static junit.framework.Assert.assertEquals;

public class TypeCheckingVisitorTest {

    @Test
    public void shouldDetectTypeErrorForSingleTypeBinaryExpression() {
        Primary leftHandSide = new Int(1);
        Primary rightHandSide = new Bool(false);
        SingleTypeBinaryOperation multiply = new Multiply(leftHandSide, rightHandSide);

        TypeCheckingVisitor nodeVisitor = new TypeCheckingVisitor();
        nodeVisitor.visitPrimary(leftHandSide);
        nodeVisitor.visitPrimary(rightHandSide);
        nodeVisitor.visitBinaryOperation(multiply);

        assertEquals(1, nodeVisitor.getErrors().size());
    }

    @Test
    public void shouldReduceProperlyForSingleTypeBinaryExpression() {
        Primary leftHandSide = new Int(1);
        Primary leftHandSide2 = new Int(2);
        Primary rightHandSide = new Int(3);
        SingleTypeBinaryOperation multiply = new Multiply(leftHandSide, rightHandSide);
        SingleTypeBinaryOperation divide = new Divide(leftHandSide2, multiply);

        TypeCheckingVisitor nodeVisitor = new TypeCheckingVisitor();
        nodeVisitor.visitPrimary(leftHandSide);
        nodeVisitor.visitPrimary(leftHandSide2);
        nodeVisitor.visitPrimary(rightHandSide);
        nodeVisitor.visitBinaryOperation(multiply);
        nodeVisitor.visitBinaryOperation(divide);

        assertEquals(0, nodeVisitor.getErrors().size());
    }

    @Test
    public void shouldCascadeErrorForNestedSingleTypeBinaryExpression() {
        Primary leftHandSide = new Bool(true);
        Primary leftHandSide2 = new Int(2);
        Primary rightHandSide = new Int(3);
        SingleTypeBinaryOperation multiply = new Multiply(leftHandSide, rightHandSide);
        SingleTypeBinaryOperation divide = new Divide(leftHandSide2, multiply);

        TypeCheckingVisitor nodeVisitor = new TypeCheckingVisitor();
        nodeVisitor.visitPrimary(leftHandSide);
        nodeVisitor.visitPrimary(leftHandSide2);
        nodeVisitor.visitPrimary(rightHandSide);
        nodeVisitor.visitBinaryOperation(multiply);
        nodeVisitor.visitBinaryOperation(divide);

        assertEquals(2, nodeVisitor.getErrors().size());
    }
}
