package org.uva.sea.ql.visitor.typechecking;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.QLExpression;
import org.uva.sea.ql.ast.QLStatement;
import org.uva.sea.ql.ast.binary.*;
import org.uva.sea.ql.ast.primary.Bool;
import org.uva.sea.ql.ast.primary.Ident;
import org.uva.sea.ql.ast.primary.Int;
import org.uva.sea.ql.ast.primary.Str;
import org.uva.sea.ql.ast.primary.typeClasses.BooleanType;
import org.uva.sea.ql.ast.primary.typeClasses.IntegerType;
import org.uva.sea.ql.ast.primary.typeClasses.Type;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.unary.Negative;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.ast.unary.Positive;
import org.uva.sea.ql.ast.unary.UnaryOperation;
import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.QLError;
import org.uva.sea.ql.visitor.typechecking.errors.IdentifierRedeclarationError;
import org.uva.sea.ql.visitor.typechecking.errors.UnequalTypesError;
import org.uva.sea.ql.visitor.typechecking.errors.UnsupportedTypeError;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor that's responsible for checking if the variables that are used in the QL program are of the proper types.
 */
public class TypeCheckingVisitor implements ASTNodeVisitor<Boolean> {

    private final SymbolTable symbolTable;
    private final List<QLError> semanticValidationErrors;

    public TypeCheckingVisitor() {
        this(new SymbolTable());
    }

    protected TypeCheckingVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.semanticValidationErrors = new ArrayList<QLError>();
    }

    @Override
    public Boolean visitForm(Form form) {
        for (QLStatement formStatement : form.getStatements()) {
            formStatement.accept(this);
        }
        return true;
    }

    @Override
    public Boolean visitComputation(Computation computation) {
        Type expectedType = new IntegerType();

        boolean identifierPreviouslyUndeclared = (!symbolTable.containsReductionFor(computation.getIdentifier()));
        boolean expressionCorrect = computation.getExpression().accept(this);

        if (!(identifierPreviouslyUndeclared && expressionCorrect)) {
            return false;
        }

        Type expressionType = computation.getExpression().getType(symbolTable);
        if (expressionType.isCompatibleTo(expectedType)){
            symbolTable.setReducableToType(computation.getIdentifier(), expectedType);
            return true;
        } else {
            addErrorForUnsupportedType(expectedType, expressionType);
        }

        return false;
    }

    @Override
    public Boolean visitIfStatement(IfStatement ifStatement) {
        for (QLStatement successBlockStatement : ifStatement.getSuccessBlock()) {
            successBlockStatement.accept(this);
        }

        return typeCheckConditional(ifStatement);
    }

    @Override
    public Boolean visitIfElseStatement(IfElseStatement ifElseStatement) {
        for (QLStatement successBlockStatement : ifElseStatement.getSuccessBlock()) {
            successBlockStatement.accept(this);
        }

        for (QLStatement failureBlockStatement : ifElseStatement.getFailureBlock()) {
            failureBlockStatement.accept(this);
        }

        return typeCheckConditional(ifElseStatement);
    }

    private boolean typeCheckConditional(Conditional conditional) {
        Type expectedType = new BooleanType();
        boolean condition = conditional.getCondition().accept(this);
        if (!condition) {
            return false;
        }

        Type conditionType = conditional.getCondition().getType(symbolTable);
        if (!conditionType.isCompatibleTo(expectedType)) {
            addErrorForUnsupportedType(expectedType, conditionType);
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitQuestion(Question question) {
        Ident ident = question.getIdentifier();
        if (!symbolTable.containsReductionFor(ident)) {
            symbolTable.setReducableToType(ident, question.getDatatype());
            return true;
        } else {
            addErrorForIdentifierRedeclaration(ident);
        }
        return false;
    }

    @Override
    public Boolean visitPositive(Positive positive) {
        return typeCheckUnaryOperation(positive);
    }

    @Override
    public Boolean visitNegative(Negative negative) {
        return typeCheckUnaryOperation(negative);
    }

    @Override
    public Boolean visitNot(Not not) {
        return typeCheckUnaryOperation(not);
    }

    private boolean typeCheckUnaryOperation(UnaryOperation unaryOperation) {
        Type expectedType = unaryOperation.getType(symbolTable);

        boolean innerExpressionCorrect = unaryOperation.getExpression().accept(this);
        if (!innerExpressionCorrect) {
            return false;
        }

        Type innerExpressionType = unaryOperation.getExpression().getType(symbolTable);
        if (!innerExpressionType.isCompatibleTo(expectedType)) {
            addErrorForUnsupportedType(expectedType, innerExpressionType);
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitMultiply(Multiply multiply) {
        return typeCheckBinaryOperation(multiply);
    }

    @Override
    public Boolean visitDivide(Divide divide) {
        return typeCheckBinaryOperation(divide);
    }

    @Override
    public Boolean visitSubtract(Subtract subtract) {
        return typeCheckBinaryOperation(subtract);
    }

    @Override
    public Boolean visitAdd(Add add) {
        return typeCheckBinaryOperation(add);
    }

    @Override
    public Boolean visitAnd(And and) {
        return typeCheckBinaryOperation(and);
    }

    @Override
    public Boolean visitOr(Or or) {
        return typeCheckBinaryOperation(or);
    }

    @Override
    public Boolean visitEqualTo(EqualTo equalTo) {
        return equalityCheckBinaryOperation(equalTo);
    }

    @Override
    public Boolean visitNotEqualTo(NotEqualTo notEqualTo) {
        return equalityCheckBinaryOperation(notEqualTo);
    }

    @Override
    public Boolean visitGreaterThan(GreaterThan greaterThan) {
        return typeCheckBinaryOperation(greaterThan);
    }

    @Override
    public Boolean visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        return typeCheckBinaryOperation(greaterThanOrEqualTo);
    }

    @Override
    public Boolean visitLessThan(LessThan lessThan) {
        return typeCheckBinaryOperation(lessThan);
    }

    @Override
    public Boolean visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        return typeCheckBinaryOperation(lessThanOrEqualTo);
    }

    private boolean typeCheckBinaryOperation(BinaryOperation binaryOperation) {
        Type expectedType = binaryOperation.getType(symbolTable);

        QLExpression leftHandSide = binaryOperation.getLeftHandSide(), rightHandSide = binaryOperation.getRightHandSide();

        boolean leftHandSideCorrect = leftHandSide.accept(this), rightHandSideCorrect = rightHandSide.accept(this);
        if (! (leftHandSideCorrect && rightHandSideCorrect) ) {
            return false;
        }

        Type leftHandSideType = leftHandSide.getType(symbolTable), rightHandSideType = rightHandSide.getType(symbolTable);

        boolean leftHandSideCompatible = leftHandSideType.isCompatibleTo(expectedType), rightHandSideCompatible = rightHandSideType.isCompatibleTo(expectedType);

        if(!leftHandSideCompatible) {
            addErrorForUnsupportedType(expectedType, leftHandSideType);
        }

        if(!rightHandSideCompatible) {
            addErrorForUnsupportedType(expectedType, rightHandSideType);
        }

        return leftHandSideCompatible && rightHandSideCompatible;
    }

    private boolean equalityCheckBinaryOperation(BinaryOperation binaryOperation) {
        QLExpression leftHandSide = binaryOperation.getLeftHandSide(), rightHandSide = binaryOperation.getRightHandSide();

        boolean leftHandSideCorrect = leftHandSide.accept(this), rightHandSideCorrect = rightHandSide.accept(this);
        if (! (leftHandSideCorrect && rightHandSideCorrect) ) {
            return false;
        }

        Type leftHandSideType = leftHandSide.getType(symbolTable), rightHandSideType = rightHandSide.getType(symbolTable);

        if (leftHandSideType.getClass() != rightHandSideType.getClass()) {
            addErrorForUnequalTypes(binaryOperation);
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitIdent(Ident ident) {
        return true;
    }

    @Override
    public Boolean visitBool(Bool boolLiteral) {
        return true;
    }

    @Override
    public Boolean visitInt(Int intLiteral) {
        return true;
    }

    @Override
    public Boolean visitStr(Str str) {
        return true;
    }

    public List<QLError> getErrors() {
        return semanticValidationErrors;
    }

    private void addErrorForUnsupportedType(Type expectedType, Type actualType) {
        QLError unsupportedTypeError = new UnsupportedTypeError(0, expectedType, actualType);
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
