package org.uva.sea.ql.parser.visitor.typechecking;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.nodetypes.binary.BinaryOperation;
import org.uva.sea.ql.ast.nodetypes.binary.EqualTo;
import org.uva.sea.ql.ast.nodetypes.binary.MultipleTypeBinaryOperation;
import org.uva.sea.ql.ast.nodetypes.binary.SingleTypeBinaryOperation;
import org.uva.sea.ql.ast.nodetypes.formelement.Computation;
import org.uva.sea.ql.ast.nodetypes.formelement.Conditional;
import org.uva.sea.ql.ast.nodetypes.formelement.Question;
import org.uva.sea.ql.ast.nodetypes.primary.Primary;
import org.uva.sea.ql.ast.nodetypes.unary.UnaryOperationExpression;
import org.uva.sea.ql.parser.visitor.ASTNodeVisitor;
import org.uva.sea.ql.parser.visitor.QLValidator;

/**
 * Visitor that's responsible for checking if the variables that are used in the QL program are of the proper types.
 */
public class TypeCheckingVisitor implements ASTNodeVisitor, QLValidator<TypeCheckingError> {

    private ReductionTable reductionTable;
    private List<TypeCheckingError> typeCheckingErrors;

    public TypeCheckingVisitor() {
        this.reductionTable = new ReductionTable();
        this.typeCheckingErrors = new ArrayList<TypeCheckingError>();
    }

    @Override
    public void visitComputation(Computation computation) {

    }

    @Override
    public void visitConditional(Conditional conditional) {
        //Check if condition evaluates to true or false and check identifier is not redefined.
    }

    @Override
    public void visitQuestion(Question question) {
        //Check if identifier is not redefined.
    }


    @Override
    public void visitUnaryOperation(UnaryOperationExpression unaryOperation) {
    }

    @Override
    public void visitBinaryOperation(MultipleTypeBinaryOperation multipleTypeBinaryOperation) {

    }

    @Override
    public void visitBinaryOperation(SingleTypeBinaryOperation binaryOperation) {
        Class<?> expectedType = binaryOperation.getSupportedType();
        QLExpression leftHandSide = binaryOperation.getLeftHandSide(), rightHandSide = binaryOperation.getRightHandSide();

        boolean leftHandSideReducable = reductionTable.isReducableToType(leftHandSide, expectedType), rightHandSideReducable = reductionTable.isReducableToType(rightHandSide, expectedType);

        //Success case
        if(leftHandSideReducable && rightHandSideReducable) {
            //Reduce this expression to the neededClass in the map.
            reductionTable.setReducableToType(binaryOperation, expectedType);
            return;
        }

        if (!leftHandSideReducable) {
            addErrorForVariable(leftHandSide, expectedType);
        }

        if (!rightHandSideReducable) {
            addErrorForVariable(leftHandSide, expectedType);
        }
    }

    @Override
    public void visitPrimary(Primary primary) {
        reductionTable.setReducableToType(primary, primary.getClass());
    }

    @Override
    public List<TypeCheckingError> getErrors() {
        return typeCheckingErrors;
    }

    private void addErrorForVariable(ASTNode astNode, Class<?> expectedType) {
        TypeCheckingError typeCheckingError = new TypeCheckingError(0, astNode.getClass().getSimpleName(), expectedType.getSimpleName());
        typeCheckingErrors.add(typeCheckingError);
    }
}
