package org.uva.sea.ql.ast.traversal.typechecking;

import java.util.List;

import org.uva.sea.ql.ast.base.Expression;
import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.base.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.traversal.base.*;
import org.uva.sea.ql.ast.traversal.logging.*;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.literals.*;

/**
 * Visitor that type checks (semantics) of the abstract syntax tree. The tree it
 * checks has been parsed by ANTLR.
 * 
 * @author J. Dijkstra
 */
public class TypeChecker implements IVisitor<Boolean> {
	/**
	 * Error log.
	 */
	private final TypeErrorLog errorLog = new TypeErrorLog();

	/**
	 * Event log.
	 */
	private final TypeEventLog eventLog = new TypeEventLog();

	/**
	 * Stores result types for defined labels.
	 */
	private final SymbolTable symbolTable = new SymbolTable();

	@Override
	public Boolean visit(final Computation computation) {
		// Check for errors in the expression of the computation
		final Expression expression = computation.getExpression();
		final boolean expressionErrors = expression.accept(this);
		if (expressionErrors) {
			return true;
		}

		// Check if the identifier has been declared before in the symbol table
		final Ident identifier = computation.getIdent();
		if (symbolTable.get(identifier) != null) {
			errorLog.addLabelRedeclaration(computation, identifier);
			return true;
		}

		// Add the identifier of this computation to the symbol table
		symbolTable.add(identifier, computation.getExpectedType());

		return false;
	}

	@Override
	public Boolean visit(final Form form) {
		// Check for errors in the form elements and return whether errors are found or not
		final boolean elementErrors = checkElements(form.getElements());
		if (!elementErrors) {
			eventLog.addCorrectSemantics(form);
		}
		return elementErrors;
	}

	@Override
	public Boolean visit(final Question question) {
		// Check if the identifier has been declared before in the symbol table
		final Ident identifier = question.getIdent();
		if (symbolTable.get(identifier) != null) {
			errorLog.addLabelRedeclaration(question, identifier);
			return true;
		}

		// Add the identifier to the symbol table
		symbolTable.add(identifier, question.getExpectedType());
		return false;
	}

	@Override
	public Boolean visit(final IfThen ifThen) {
		return checkIfStatement(ifThen);
	}

	@Override
	public Boolean visit(final IfThenElse ifThenElse) {
		final boolean errors = checkIfStatement(ifThenElse);
		final boolean elseElementErrors = checkElements(ifThenElse
				.getElseElements());

		// Errors are present deeper in the AST or in the success elements
		return (errors || elseElementErrors);
	}

	@Override
	public Boolean visit(final BoolLiteral bool) {
		return false;
	}

	@Override
	public Boolean visit(final IntLiteral i) {
		return false;
	}

	@Override
	public Boolean visit(final MoneyLiteral money) {
		return false;
	}

	@Override
	public Boolean visit(final StringLiteral literal) {
		return false;
	}

	@Override
	public Boolean visit(final Ident ident) {
		return false;
	}

	@Override
	public Boolean visit(final And and) {
		return checkBooleanBinaryExpression(and);
	}

	@Override
	public Boolean visit(final Eq eq) {
		final Expression leftHandSide = eq.getLeftHandSide();
		final Expression rightHandSide = eq.getRightHandSide();
		final boolean leftHandSideErrors = leftHandSide.accept(this);
		final boolean rightHandSideErrors = rightHandSide.accept(this);

		// Errors are present deeper in the AST
		if (leftHandSideErrors || rightHandSideErrors) {
			return true;
		}

		final DataType leftType = leftHandSide.typeOf(symbolTable);
		final DataType rightType = rightHandSide.typeOf(symbolTable);
		// Invalid reference
		if (leftType == null || rightType == null) {
			return true;
		}

		// Equals requires both left and the right handside to be of the same type
		if (!leftType.isSameTypeAs(rightType)) {
			errorLog.addBothSidesAreDifferentTypes(eq);
			return true;
		}

		return false;
	}

	@Override
	public Boolean visit(final GEq geq) {
		return checkNumericBinaryExpression(geq);
	}

	@Override
	public Boolean visit(final GT gt) {
		return checkNumericBinaryExpression(gt);
	}

	@Override
	public Boolean visit(final LEq leq) {
		return checkNumericBinaryExpression(leq);
	}

	@Override
	public Boolean visit(final LT lt) {
		return checkNumericBinaryExpression(lt);
	}

	@Override
	public Boolean visit(final NEq neq) {
		return checkNumericBinaryExpression(neq);
	}

	@Override
	public Boolean visit(final Or or) {
		return checkBooleanBinaryExpression(or);
	}

	@Override
	public Boolean visit(final Div div) {
		return checkNumericBinaryExpression(div);
	}

	@Override
	public Boolean visit(final Mul mul) {
		return checkNumericBinaryExpression(mul);
	}

	@Override
	public Boolean visit(final Add add) {
		return checkNumericBinaryExpression(add);
	}

	@Override
	public Boolean visit(final Sub sub) {
		return checkNumericBinaryExpression(sub);
	}

	@Override
	public Boolean visit(final Neg neg) {
		return checkNumericUnaryExpression(neg);
	}

	@Override
	public Boolean visit(final Not not) {
		final Expression expression = not.getExpression();
		final boolean expressionErrors = expression.accept(this);

		// Errors are present deeper in the AST
		if (expressionErrors) {
			return true;
		}

		// Invalid reference
		final DataType expressionType = checkTypeOf(expression);
		if (expressionType == null) {
			return true;
		}

		// The expression should be compatible to bool
		if (!expressionType.isCompatibleToBool()) {
			errorLog.addTypeIsNotBoolean(HandSide.RIGHT, not);
			return true;
		}

		return false;
	}

	@Override
	public Boolean visit(final Pos pos) {
		return checkNumericUnaryExpression(pos);
	}

	public TypeEventLog getEventLog() {
		return eventLog;
	}

	public TypeErrorLog getErrorLog() {
		return errorLog;
	}

	/**
	 * Check numeric binary expressions for errors and log them.
	 * 
	 * @param operation the operation to check.
	 * @return whether errors are present or not.
	 */
	private boolean checkNumericBinaryExpression(final BinaryOperator operation) {
		final Expression leftHandSide = operation.getLeftHandSide();
		final Expression rightHandSide = operation.getRightHandSide();
		final boolean leftHandSideErrors = leftHandSide.accept(this);
		final boolean rightHandSideErrors = rightHandSide.accept(this);

		// Errors are present deeper in the AST
		if (leftHandSideErrors || rightHandSideErrors) {
			return true;
		}

		final DataType leftHandSideType = checkTypeOf(leftHandSide);
		final DataType rightHandSideType = checkTypeOf(rightHandSide);
		if (leftHandSideType == null || rightHandSideType == null) {
			return true;
		}

		// Both hand sides should be compatible to numeric
		boolean error = false;
		if (!leftHandSideType.isCompatibleToNumeric()) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.LEFT, operation);
			error = true;
		}
		if (!rightHandSideType.isCompatibleToNumeric()) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.RIGHT, operation);
			error = true;
		}

		return error;
	}

	/**
	 * Check boolean binary expressions for errors and log them.
	 * 
	 * @param operation the operation to check.
	 * @return whether errors are present or not.
	 */	
	private Boolean checkBooleanBinaryExpression(final BinaryOperator operation) {
		final Expression leftHandSide = operation.getLeftHandSide();
		final Expression rightHandSide = operation.getRightHandSide();
		final boolean leftHandSideErrors = leftHandSide.accept(this);
		final boolean rightHandSideErrors = rightHandSide.accept(this);

		// Errors are present deeper in the AST
		if (leftHandSideErrors || rightHandSideErrors) {
			return true;
		}

		final DataType leftHandSideType = checkTypeOf(leftHandSide);
		final DataType rightHandSideType = checkTypeOf(rightHandSide);
		if (leftHandSideType == null || rightHandSideType == null)
		{
			return true;
		}

		// Both hand sides should be compatible to bool
		boolean error = false;
		if (!leftHandSideType.isCompatibleToBool()) {
			errorLog.addTypeIsNotBoolean(HandSide.LEFT, operation);
			error = true;
		}
		if (!rightHandSideType.isCompatibleToBool()) {
			errorLog.addTypeIsNotBoolean(HandSide.RIGHT, operation);
			error = true;
		}

		return error;
	}

	/**
	 * Check unary numeric expressions for errors and log them.
	 * 
	 * @param operation the operation to check.
	 * @return whether errors are present or not.
	 */
	private Boolean checkNumericUnaryExpression(final UnaryOperator operation) {
		final Expression expression = operation.getExpression();
		final boolean expressionErrors = expression.accept(this);

		// Errors are present deeper in the AST
		if (expressionErrors) {
			return true;
		}

		// Invalid reference
		final DataType expressionType = checkTypeOf(expression);
		if (expressionType == null) {
			return true;
		}

		// The expression should be compatible to numeric
		if (!expressionType.isCompatibleToNumeric()) {
			errorLog.addTypeIsNotIntegerOrMoney(HandSide.RIGHT, operation);
			return true;
		}

		return false;
	}

	/**
	 * Check for errors in an if statement.
	 * 
	 * @param statement if statement to check
	 * @return whether errors were found or not
	 */
	private boolean checkIfStatement(final IfStatement statement) {
		final boolean conditionErrors = statement.getCondition().accept(this);
		final boolean successElementsErrors = checkElements(statement
				.getSuccessElements());

		// Errors are present deeper in the AST
		return (conditionErrors || successElementsErrors);
	}

	/**
	 * Check for errors in form elements.
	 * 
	 * @param elements elements to check
	 * @return whether there are errors found or not
	 */
	private boolean checkElements(final List<Element> elements) {
		boolean errors = false;
		for (final Element element : elements) {
			// Errors deeper in the tree. As we still want to check errors on
			// the same nesting level, we will continue the loop
			if (element.accept(this))
			{
				errors = true;
			}
		}

		return errors;
	}

	private DataType checkTypeOf(final Expression expression) {
		final DataType type = expression.typeOf(symbolTable);
		if (type == null) {
			// Only idents should be able to get here
			// TODO add line numbers
			errorLog.addInvalidReference(expression, null);
		}
		return type;
	}
}