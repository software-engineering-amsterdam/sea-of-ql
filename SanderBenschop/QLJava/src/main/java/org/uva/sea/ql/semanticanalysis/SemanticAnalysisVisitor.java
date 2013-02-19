package org.uva.sea.ql.semanticanalysis;

import org.uva.sea.ql.ast.ASTNodeVisitor;
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
import org.uva.sea.ql.ast.sourcecodeinformation.SourceCodeInformation;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.unary.Negative;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.ast.unary.Positive;
import org.uva.sea.ql.ast.unary.UnaryOperation;
import org.uva.sea.ql.general.symboltable.SymbolTable;
import org.uva.sea.ql.general.symboltable.SymbolTableImpl;
import org.uva.sea.ql.semanticanalysis.error.IdentifierRedeclarationError;
import org.uva.sea.ql.semanticanalysis.error.SemanticQLError;
import org.uva.sea.ql.semanticanalysis.error.UnequalTypesError;
import org.uva.sea.ql.semanticanalysis.error.UnsupportedTypeError;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor that's responsible for semantical analysis. This includes type checking as well as a check if an identifier
 * is declared and it is only declared once.
 */
public class SemanticAnalysisVisitor implements SemanticalAnalyser, ASTNodeVisitor<Boolean> {

    private SymbolTable symbolTable;
    private List<SemanticQLError> semanticValidationErrors;

    public SemanticAnalysisVisitor() {
        this(new SymbolTableImpl());
    }

    public SemanticAnalysisVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        this.semanticValidationErrors = new ArrayList<SemanticQLError>();
    }

    @Override
    public List<SemanticQLError> semanticallyValidateForm(Form form) {
        symbolTable.clear();
        semanticValidationErrors.clear();

        visitForm(form);
        return semanticValidationErrors;
    }

    public List<SemanticQLError> getErrors() {
        return semanticValidationErrors;
    }

    @Override
    public Boolean visitForm(Form form) {
        boolean correctForm = true;
        for (QLStatement formStatement : form.getStatements()) {
            boolean correctStatement = formStatement.accept(this);
            if (!correctStatement && correctForm) correctForm = false;
        }
        return correctForm;
    }

    @Override
    public Boolean visitComputation(Computation computation) {
        QLExpression expression = computation.getExpression();

        boolean identifierPreviouslyUndeclared = (!symbolTable.containsIdentifier(computation.getIdentifier()));
        boolean expressionCorrect = expression.accept(this);

        boolean computationCorrect = identifierPreviouslyUndeclared && expressionCorrect;

        if (computationCorrect) {
            symbolTable.addIdentifier(computation.getIdentifier(), expression.getType(symbolTable));
        }

        return computationCorrect;
    }

    @Override
    public Boolean visitIfStatement(IfStatement ifStatement) {
        boolean correctStatementBody = true;
        for (QLStatement successBlockStatement : ifStatement.getSuccessBlock()) {
            boolean correctStatement = successBlockStatement.accept(this);
            if (!correctStatement && correctStatementBody) correctStatementBody = false;
        }

        return typeCheckConditional(ifStatement) && correctStatementBody;
    }

    @Override
    public Boolean visitIfElseStatement(IfElseStatement ifElseStatement) {
        boolean correctStatementBodies = true;
        for (QLStatement successBlockStatement : ifElseStatement.getSuccessBlock()) {
            boolean correctStatement = successBlockStatement.accept(this);
            if (!correctStatement && correctStatementBodies) correctStatementBodies = false;
        }

        for (QLStatement failureBlockStatement : ifElseStatement.getFailureBlock()) {
            boolean correctStatement = failureBlockStatement.accept(this);
            if (!correctStatement && correctStatementBodies) correctStatementBodies = false;
        }

        return typeCheckConditional(ifElseStatement) && correctStatementBodies;
    }

    private boolean typeCheckConditional(Conditional conditional) {
        Type expectedType = new BooleanType();
        QLExpression condition = conditional.getCondition();
        boolean conditionValid = condition.accept(this);
        if (!conditionValid) {
            return false;
        }

        Type conditionType = condition.getType(symbolTable);
        if (!conditionType.isCompatibleTo(expectedType)) {
            addErrorForUnsupportedType(condition.getSourceCodeInformation(), expectedType, conditionType);
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitQuestion(Question question) {
        Ident ident = question.getIdentifier();
        if (!symbolTable.containsIdentifier(ident)) {
            symbolTable.addIdentifier(ident, question.getDatatype());
            return true;
        } else {
            addErrorForIdentifierRedeclaration(ident);
        }
        return false;
    }

    @Override
    public Boolean visitPositive(Positive positive) {
        return typeCheckUnaryOperation(positive, new IntegerType());
    }

    @Override
    public Boolean visitNegative(Negative negative) {
        return typeCheckUnaryOperation(negative, new IntegerType());
    }

    @Override
    public Boolean visitNot(Not not) {
        return typeCheckUnaryOperation(not, new BooleanType());
    }

    private boolean typeCheckUnaryOperation(UnaryOperation unaryOperation, Type expectedType) {
        boolean innerExpressionCorrect = unaryOperation.getExpression().accept(this);
        if (!innerExpressionCorrect) {
            return false;
        }

        Type innerExpressionType = unaryOperation.getExpression().getType(symbolTable);
        if (!innerExpressionType.isCompatibleTo(expectedType)) {
            addErrorForUnsupportedType(unaryOperation.getSourceCodeInformation(), expectedType, innerExpressionType);
            return false;
        }

        return true;
    }

    @Override
    public Boolean visitMultiply(Multiply multiply) {
        return typeCheckBinaryOperation(multiply, new IntegerType());
    }

    @Override
    public Boolean visitDivide(Divide divide) {
        return typeCheckBinaryOperation(divide, new IntegerType());
    }

    @Override
    public Boolean visitSubtract(Subtract subtract) {
        return typeCheckBinaryOperation(subtract, new IntegerType());
    }

    @Override
    public Boolean visitAdd(Add add) {
        return typeCheckBinaryOperation(add, new IntegerType());
    }

    @Override
    public Boolean visitAnd(And and) {
        return typeCheckBinaryOperation(and, new BooleanType());
    }

    @Override
    public Boolean visitOr(Or or) {
        return typeCheckBinaryOperation(or, new BooleanType());
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
        return typeCheckBinaryOperation(greaterThan, new IntegerType());
    }

    @Override
    public Boolean visitGreaterThanOrEqualTo(GreaterThanOrEqualTo greaterThanOrEqualTo) {
        return typeCheckBinaryOperation(greaterThanOrEqualTo, new IntegerType());
    }

    @Override
    public Boolean visitLessThan(LessThan lessThan) {
        return typeCheckBinaryOperation(lessThan, new IntegerType());
    }

    @Override
    public Boolean visitLessThanOrEqualTo(LessThanOrEqualTo lessThanOrEqualTo) {
        return typeCheckBinaryOperation(lessThanOrEqualTo, new IntegerType());
    }

    private boolean typeCheckBinaryOperation(BinaryOperation binaryOperation, Type expectedType) {
        QLExpression leftHandSide = binaryOperation.getLeftHandSide(), rightHandSide = binaryOperation.getRightHandSide();

        boolean leftHandSideCorrect = leftHandSide.accept(this), rightHandSideCorrect = rightHandSide.accept(this);
        if (!(leftHandSideCorrect && rightHandSideCorrect)) {
            return false;
        }

        Type leftHandSideType = leftHandSide.getType(symbolTable), rightHandSideType = rightHandSide.getType(symbolTable);

        boolean leftHandSideCompatible = leftHandSideType.isCompatibleTo(expectedType), rightHandSideCompatible = rightHandSideType.isCompatibleTo(expectedType);

        if (!leftHandSideCompatible) {
            addErrorForUnsupportedType(binaryOperation.getSourceCodeInformation(), expectedType, leftHandSideType);
        }

        if (!rightHandSideCompatible) {
            addErrorForUnsupportedType(binaryOperation.getSourceCodeInformation(), expectedType, rightHandSideType);
        }

        return leftHandSideCompatible && rightHandSideCompatible;
    }

    private boolean equalityCheckBinaryOperation(BinaryOperation binaryOperation) {
        QLExpression leftHandSide = binaryOperation.getLeftHandSide(), rightHandSide = binaryOperation.getRightHandSide();

        boolean leftHandSideCorrect = leftHandSide.accept(this), rightHandSideCorrect = rightHandSide.accept(this);
        if (!(leftHandSideCorrect && rightHandSideCorrect)) {
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

    private void addErrorForUnsupportedType(SourceCodeInformation sourceCodeInformation, Type expectedType, Type actualType) {
        SemanticQLError unsupportedTypeError = new UnsupportedTypeError(sourceCodeInformation, expectedType, actualType);
        semanticValidationErrors.add(unsupportedTypeError);
    }

    private void addErrorForUnequalTypes(BinaryOperation binaryOperation) {
        Type leftHandType = binaryOperation.getLeftHandSide().getType(symbolTable), rightHandType = binaryOperation.getRightHandSide().getType(symbolTable);
        SemanticQLError unequalTypesError = new UnequalTypesError(binaryOperation.getSourceCodeInformation(), leftHandType, rightHandType);
        semanticValidationErrors.add(unequalTypesError);
    }

    private void addErrorForIdentifierRedeclaration(Ident ident) {
        SemanticQLError identifierRedeclarationError = new IdentifierRedeclarationError(ident.getSourceCodeInformation(), ident.getName());
        semanticValidationErrors.add(identifierRedeclarationError);
    }
}
