package org.uva.sea.ql.check.expressions;

import org.uva.sea.ql.ast.expressions.BinaryExpression;
import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.UnaryExpression;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.check.TypeEnvironment;
import org.uva.sea.ql.parser.errors.ErrorMessages;
import org.uva.sea.ql.parser.errors.Message;

public class ExpressionChecker {
	
	private final TypeEnvironment _typeEnvironment;
	private final ErrorMessages _errorMessages;
	
	public ExpressionChecker(TypeEnvironment typeEnvironment, ErrorMessages messages) {
		_typeEnvironment = typeEnvironment;
		_errorMessages = messages;
	}
	
	public Boolean checkUnaryArithmeticExpression(UnaryExpression expression, String binarySymbol) {
		return isCompatibleToNumeric(expression, binarySymbol);
	}
	
	public Boolean checkUnaryLogicalExpression(UnaryExpression expression, String binarySymbol) {
		return isCompatibleToBool(expression, binarySymbol);
	}
	
	public Boolean checkLiteralExpression(Expression expression, String className) {
		return isCompatibleTo(expression, className);
	}
	
	public Expression getLeftHandSide(BinaryExpression expression)   { return expression.getLeftHandSide();  }
	public Expression getRightHandSide(BinaryExpression expression)  { return expression.getRightHandSide(); }
	
	private Type getTypeFor(Expression expression)                   { return expression.typeOf(_typeEnvironment); }
	private Type getLeftHandSideType(BinaryExpression expression)    { return getLeftHandSide(expression).typeOf(_typeEnvironment);  }
	private Type getRightHandSideType(BinaryExpression expression)   { return getRightHandSide(expression).typeOf(_typeEnvironment); }
	
	public boolean isCompatibleToNumeric(BinaryExpression expression, String binarySymbol) {
		boolean isCompatible = getLeftHandSideType(expression).isCompatibleToNumeric() && getRightHandSideType(expression).isCompatibleToNumeric();
		return checkTypes(expression, getErrorMessage(expression, binarySymbol), isCompatible);
	}
	
	public boolean isCompatibleToNumeric(UnaryExpression expression, String binarySymbol) {
		boolean isCompatible = getTypeFor(expression).isCompatibleToNumeric();
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	public boolean isCompatibleToBool(BinaryExpression expression, String binarySymbol) {
		boolean isCompatible = getLeftHandSideType(expression).isCompatibleToBool() && getRightHandSideType(expression).isCompatibleToBool();
		return checkTypes(expression, getErrorMessage(expression, binarySymbol), isCompatible);
	}
	
	public boolean isCompatibleToBool(UnaryExpression expression, String binarySymbol) {
		boolean isCompatible = getTypeFor(expression).isCompatibleToBool();
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	public boolean isCompatibleTo(BinaryExpression expression, String binarySymbol) {
		boolean isCompatible = getLeftHandSideType(expression).isCompatibleTo(getRightHandSideType(expression));
		return checkTypes(expression, getErrorMessage(expression, binarySymbol), isCompatible);
	}
	
	public boolean isCompatibleTo(Expression expression, String binarySymbol) {
		boolean isCompatible = getTypeFor(expression).isCompatibleTo(getTypeFor(expression));
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean checkTypes(Expression expression, String binarySymbol, boolean isCompatible) {
		if (!isCompatible) {
			addError("Invalid " + binarySymbol);
		}
		return isCompatible;
	}
	
	private void addError(String errorMessage) {
		_errorMessages.add(new Message(errorMessage));
	}
	
	private String getErrorMessage(BinaryExpression expression, String binarySymbol) {
		return "type for computing " + expression.getLeftHandSide().typeOf(_typeEnvironment).toString() + " " + binarySymbol + " " + 
		expression.getRightHandSide().typeOf(_typeEnvironment).toString();
	}
	
	public ErrorMessages getErrorMessages() {
		return _errorMessages;
	}
}