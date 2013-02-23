package org.uva.sea.ql.check.expressions;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.BinaryArithmeticExpression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Subtraction;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.BinaryLogicalExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyNotEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.BinaryRelationalExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.NotEqualToExpression;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.LiteralExpression;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.ast.expressions.unary.NegativeExpression;
import org.uva.sea.ql.ast.expressions.unary.NegationalExpression;
import org.uva.sea.ql.ast.expressions.unary.PositiveExpression;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpression;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.ErrorMessages;
import org.uva.sea.ql.parser.TypeEnvironment;

public class TypeChecker implements Visitor<Boolean> {
	
	private final TypeEnvironment _typeEnvironment;
	private final ErrorMessages _errorMessages;
	
	private TypeChecker(TypeEnvironment supportedTypes, ErrorMessages messages) {
		_typeEnvironment = supportedTypes;
		_errorMessages = messages;
	}
	
	public static boolean check(Expression expression, TypeEnvironment supportedTypes, ErrorMessages errors) {
		TypeChecker expressionChecker = new TypeChecker(supportedTypes, errors);
		return expression.accept(expressionChecker);
	}
	
	@Override
	public Boolean visit(Addition ast) { return checkArithmeticExpression(ast, "+"); }
	@Override
	public Boolean visit(Division ast) { return checkArithmeticExpression(ast, "/"); }
	@Override
	public Boolean visit(Subtraction ast) { return checkArithmeticExpression(ast, "-"); }
	@Override
	public Boolean visit(Multiplication ast) { return checkArithmeticExpression(ast, "*"); }

	@Override
	public Boolean visit(EqualToExpression ast)  { return checkRelationalExpression(ast, "=="); }
	@Override
	public Boolean visit(GreaterThanOrEqualToExpression ast) { return checkRelationalExpression(ast, ">="); }
	@Override
	public Boolean visit(GreaterThanExpression ast)  { return checkRelationalExpression(ast, ">");  }
	@Override
	public Boolean visit(LessThanOrEqualToExpression ast) { return checkRelationalExpression(ast, "<="); }
	@Override
	public Boolean visit(LessThanExpression ast)  { return checkRelationalExpression(ast, "<");  }
	@Override
	public Boolean visit(NotEqualToExpression ast) { return checkRelationalExpression(ast, "!="); }
	
	@Override
	public Boolean visit(LogicallyEquivalentExpression ast) { return checkLogicalExpression(ast, "&&"); }
	@Override
	public Boolean visit(LogicallyNotEquivalentExpression ast)  { return checkLogicalExpression(ast, "||"); }

	@Override
	public Boolean visit(NegativeExpression ast) { return checkUnaryArithmeticExpression(ast, "--"); }
	@Override
	public Boolean visit(PositiveExpression ast) { return checkUnaryArithmeticExpression(ast, "++"); }
	@Override
	public Boolean visit(NegationalExpression ast) { return checkUnaryLogicalExpression(ast, "!");  }

	@Override
	public Boolean visit(Bool ast)  { return checkLiteralExpression(ast, Bool.class.toString());  }
	@Override
	public Boolean visit(Ident ast) { return checkLiteralExpression(ast, Ident.class.toString()); }
	@Override
	public Boolean visit(Int ast)   { return checkLiteralExpression(ast, Int.class.toString());   }
	@Override
	public Boolean visit(Money ast) { return checkLiteralExpression(ast, Money.class.toString()); }
	@Override
	public Boolean visit(Str ast)   { return checkLiteralExpression(ast, Str.class.toString());   }
	
	private Boolean checkArithmeticExpression(BinaryArithmeticExpression expression, String binarySymbol) {
		boolean checkLeftHandSide  = expression.getLeftHandSide().accept(this);
		boolean checkRightHandSide = expression.getRightHandSide().accept(this);
		
		if (!(checkLeftHandSide && checkRightHandSide)) {
			// Type errors occurred
			return false;
		}
		
		Type leftHandSideType  = expression.getLeftHandSide().typeOf(_typeEnvironment);
		Type rightHandSideType = expression.getRightHandSide().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with BinaryNumericExpr
		if (!(leftHandSideType.isCompatibleToNumeric() && rightHandSideType.isCompatibleToNumeric())) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkRelationalExpression(BinaryRelationalExpression expression, String binarySymbol) {
		boolean checkLeftHandSide  = expression.getLeftHandSide().accept(this);
		boolean checkRightHandSide = expression.getRightHandSide().accept(this);
		
		if (!(checkLeftHandSide && checkRightHandSide)) {
			// Type errors occurred
			return false;
		}
		
		Type leftHandSideType  = expression.getLeftHandSide().typeOf(_typeEnvironment);
		Type rightHandSideType = expression.getRightHandSide().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with each other
		if (!leftHandSideType.isCompatibleTo(rightHandSideType)) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkLogicalExpression(BinaryLogicalExpression expression, String binarySymbol) {
		boolean checkLeftHandSide  = expression.getLeftHandSide().accept(this);
		boolean checkRightHandSide = expression.getRightHandSide().accept(this);
		
		if (!(checkLeftHandSide && checkRightHandSide)) {
			// Type errors occurred
			return false;
		}
		
		Type leftHandSideType  = expression.getLeftHandSide().typeOf(_typeEnvironment);
		Type rightHandSideType = expression.getRightHandSide().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with BinaryBoolExpr
		if (!(leftHandSideType.isCompatibleToBool() && rightHandSideType.isCompatibleToBool())) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkUnaryArithmeticExpression(UnaryExpression expression, String binarySymbol) {
		Type expressionType = expression.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with UnaryExpr
		if (!expressionType.isCompatibleToNumeric()) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type error
		return true;
	}
	
	private Boolean checkUnaryLogicalExpression(UnaryExpression expression, String binarySymbol) {
		Type expressionType = expression.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with UnaryExpr
		if (!expressionType.isCompatibleToBool()) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type error
		return true;
	}
	
	private Boolean checkLiteralExpression(LiteralExpression expression, String className) {
		Type expressionType = expression.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with LiteralExpr
		if (!expressionType.isCompatibleTo(expressionType)) {
			addError(expression, "invalid type for literal " + className);
			return false;
		}
		
		// No Type error
		return true; 
	}
	
	private void addError(Expression expression, String errorMessage) {
		_errorMessages.add("Type error for expr " + expression.toString() + ": " + errorMessage);
	}
}