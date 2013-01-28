package org.uva.sea.ql.visitor.typechecking;

import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.binary.BinaryOperation;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Datatype;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.statement.Computation;
import org.uva.sea.ql.ast.statement.Conditional;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.unary.UnaryOperation;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.QLError;
import org.uva.sea.ql.visitor.typechecking.errors.IdentifierRedeclarationError;
import org.uva.sea.ql.visitor.typechecking.errors.UnequalTypesError;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Visitor that's responsible for checking if the variables that are used in the QL program are of the proper types.
 */
public class TypeCheckingVisitor implements ASTNodeVisitor {

    private final ReductionTable reductionTable;
    private final List<QLError> semanticValidationErrors;

    public TypeCheckingVisitor() {
        this(new ReductionTable());
    }

    protected TypeCheckingVisitor(ReductionTable reductionTable) {
        this.reductionTable = reductionTable;
        this.semanticValidationErrors = new ArrayList<QLError>();
    }

    @Override
    public void visitComputation(Computation computation) {
        Class<?> expressionReduction = reductionTable.getReduceableType(computation.getExpression());

        Ident identifier = computation.getIdentifier();
        if (expressionReduction != null && !reductionTable.containsReductionFor(identifier)) {
            reductionTable.setReducableToType(identifier, expressionReduction);
        }

        Class<?> supportedExpressionType = Int.class;
        QLExpression expression = computation.getExpression();

        if (reductionTable.getReduceableType(expression) != supportedExpressionType) {
            addErrorForUnsupportedType(expression, supportedExpressionType);
        }
    }

    @Override
    public void visitConditional(Conditional conditional) {
        Class<?> supportedType = Bool.class;
        if (reductionTable.getReduceableType(conditional.getCondition()) != supportedType) {
            addErrorForUnsupportedType(conditional.getCondition(), supportedType);
        }
    }

    @Override
    public void visitQuestion(Question question) {
        Ident identifier = question.getIdentifier();
        if (!reductionTable.containsReductionFor(identifier)) {
            reductionTable.setReducableToType(identifier, question.getDatatype());
        }
    }

    @Override
    public void visitUnaryOperation(UnaryOperation unaryOperation) {
        Class<?> supportedType = unaryOperation.getSupportedType(), reduction = reductionTable.getReduceableType(unaryOperation.getExpression());

        if (reduction == supportedType) {
            reductionTable.setReducableToType(unaryOperation, reduction);
        } else {
            addErrorForUnsupportedType(unaryOperation.getExpression(), supportedType);
        }
    }

    @Override
    public void visitBinaryOperation(BinaryOperation binaryOperation) {
        List<Class<?>> supportedTypes = binaryOperation.getSupportedTypes();
        QLExpression leftHandSide = binaryOperation.getLeftHandSide(), rightHandSide = binaryOperation.getRightHandSide();

        Class<?> leftHandSideReduction = reductionTable.getReduceableType(leftHandSide), rightHandSideReduction = reductionTable
                .getReduceableType(rightHandSide);
        boolean leftHandSideReduceable = supportedTypes.contains(leftHandSideReduction), rightHandSideReduceable = supportedTypes
                .contains(rightHandSideReduction);

        if (leftHandSideReduction == rightHandSideReduction) {
            if (leftHandSideReduceable) {
                //Reduce this expression to the neededClass in the map.
                reductionTable.setReducableToType(binaryOperation, leftHandSideReduction);
                return;
            }
        } else if (supportedTypes.size() > 1) {
            addErrorForUnequalTypes(binaryOperation);
        }

        if (!leftHandSideReduceable) {
            addErrorForUnsupportedType(leftHandSide, supportedTypes);
        }

        if (!rightHandSideReduceable) {
            addErrorForUnsupportedType(leftHandSide, supportedTypes);
        }
    }

    @Override
    public void visitIdent(Ident ident) {
        if (reductionTable.containsReductionFor(ident)) {
            addErrorForIdentifierRedeclaration(ident);
        }
    }

    @Override
    public void visitDatatype(Datatype<?> datatype) {
        reductionTable.setReducableToType(datatype, datatype.getClass());
    }

    public List<QLError> getErrors() {
        return semanticValidationErrors;
    }

    private void addErrorForUnsupportedType(QLExpression expression, Class<?> allowedType) {
        List<Class<?>> allowedTypeList = Arrays.asList(new Class<?>[] { allowedType });
        addErrorForUnsupportedType(expression, allowedTypeList);
    }

    private void addErrorForUnsupportedType(QLExpression expression, List<Class<?>> allowedTypes) {
        QLError unsupportedTypeError = new UnsupportedTypeError(0, expression.getClass().getSimpleName(), allowedTypes);
        semanticValidationErrors.add(unsupportedTypeError);
    }

    private void addErrorForUnequalTypes(BinaryOperation binaryOperation) {
        QLError unequalTypesError = new UnequalTypesError(0, binaryOperation);
        semanticValidationErrors.add(unequalTypesError);
    }

    private void addErrorForIdentifierRedeclaration(Ident ident) {
        QLError identifierRedeclarationError = new IdentifierRedeclarationError(0, ident.getName());
        semanticValidationErrors.add(identifierRedeclarationError);
    }
}
