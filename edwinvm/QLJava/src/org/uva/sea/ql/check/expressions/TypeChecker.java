package org.uva.sea.ql.check.expressions;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.binary.BinaryExpression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.BinaryArithmeticExpression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Subtraction;
import org.uva.sea.ql.ast.expressions.binary.logical.BinaryLogicalExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyNotEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.BinaryRelationalExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.NotEqualToExpression;
import org.uva.sea.ql.ast.expressions.unary.NegationalExpression;
import org.uva.sea.ql.ast.expressions.unary.NegativeExpression;
import org.uva.sea.ql.ast.expressions.unary.PositiveExpression;
import org.uva.sea.ql.ast.expressions.unary.UnaryExpression;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.NullValue;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.ast.visitors.typechecker.Visitor;
import org.uva.sea.ql.parser.TypeEnvironment;
import org.uva.sea.ql.parser.errors.ErrorMessages;
import org.uva.sea.ql.parser.errors.Message;

public class TypeChecker implements Visitor<Boolean> {
	
	private final TypeEnvironment _typeEnvironment;
	private final ErrorMessages _errorMessages;
	
	private TypeChecker(TypeEnvironment typeEnvironment, ErrorMessages messages) {
		_typeEnvironment = typeEnvironment;
		_errorMessages = messages;
	}
	
	public static boolean check(Expression expression, TypeEnvironment typeEnvironment, ErrorMessages errors) {
		TypeChecker expressionChecker = new TypeChecker(typeEnvironment, errors);
		return expression.accept(expressionChecker);
	}
	
	@Override
	public Boolean visit(Addition astNode)                         { return checkArithmeticExpression(astNode, "+"); }
	@Override
	public Boolean visit(Division astNode)                         { return checkArithmeticExpression(astNode, "/"); }
	@Override
	public Boolean visit(Subtraction astNode)                      { return checkArithmeticExpression(astNode, "-"); }
	@Override
	public Boolean visit(Multiplication astNode)                   { return checkArithmeticExpression(astNode, "*"); }

	@Override
	public Boolean visit(EqualToExpression astNode)                { return checkRelationalExpression(astNode, "=="); }
	@Override
	public Boolean visit(GreaterThanOrEqualToExpression astNode)   { return checkRelationalExpression(astNode, ">="); }
	@Override
	public Boolean visit(GreaterThanExpression astNode)            { return checkRelationalExpression(astNode, ">");  }
	@Override
	public Boolean visit(LessThanOrEqualToExpression astNode)      { return checkRelationalExpression(astNode, "<="); }
	@Override
	public Boolean visit(LessThanExpression astNode)               { return checkRelationalExpression(astNode, "<");  }
	@Override
	public Boolean visit(NotEqualToExpression astNode)             { return checkRelationalExpression(astNode, "!="); }
	
	@Override
	public Boolean visit(LogicallyEquivalentExpression astNode)    { return checkLogicalExpression(astNode, "&&"); }
	@Override
	public Boolean visit(LogicallyNotEquivalentExpression astNode) { return checkLogicalExpression(astNode, "||"); }

	@Override
	public Boolean visit(NegativeExpression astNode)               { return checkUnaryArithmeticExpression(astNode, "--"); }
	@Override
	public Boolean visit(PositiveExpression astNode)               { return checkUnaryArithmeticExpression(astNode, "++"); }
	@Override
	public Boolean visit(NegationalExpression astNode)             { return checkUnaryLogicalExpression(astNode, "!");  }

	@Override
	public Boolean visit(Bool astNode)                             { return checkLiteralExpression(astNode, Bool.class.toString());  }
	@Override
	public Boolean visit(Identifier astNode)                       { return checkLiteralExpression(astNode, Identifier.class.toString()); }
	@Override
	public Boolean visit(Int astNode)                              { return checkLiteralExpression(astNode, Int.class.toString());   }
	@Override
	public Boolean visit(Money astNode)                            { return checkLiteralExpression(astNode, Money.class.toString()); }
	@Override
	public Boolean visit(Str astNode)                              { return checkLiteralExpression(astNode, Str.class.toString());   }
	@Override
	public Boolean visit(NullValue astNode) 					   { return false; }
	
	private Boolean checkArithmeticExpression(BinaryArithmeticExpression expression, String binarySymbol) {
		return isAValidExpression(expression) && isCompatibleToNumeric(expression, binarySymbol);
	}
	
	private Boolean checkRelationalExpression(BinaryRelationalExpression expression, String binarySymbol) {
		return isAValidExpression(expression) && isCompatibleTo(expression, binarySymbol); 
	}
	
	private Boolean checkLogicalExpression(BinaryLogicalExpression expression, String binarySymbol) {
		return isAValidExpression(expression) && isCompatibleToBool(expression, binarySymbol);
	}
	
	private Boolean checkUnaryArithmeticExpression(UnaryExpression expression, String binarySymbol) {
		return isCompatibleToNumeric(expression, binarySymbol);
	}
	
	private Boolean checkUnaryLogicalExpression(UnaryExpression expression, String binarySymbol) {
		return isCompatibleToBool(expression, binarySymbol);
	}
	
	private Boolean checkLiteralExpression(Expression expression, String className) {
		return isCompatibleTo(expression, className);
	}
	
	private Expression getLeftHandSide(BinaryExpression expression)  { return expression.getLeftHandSide();  }
	private Expression getRightHandSide(BinaryExpression expression) { return expression.getRightHandSide(); }
	
	private Type getTypeFor(Expression expression)                   { return expression.typeOf(_typeEnvironment); }
	private Type getLeftHandSideType(BinaryExpression expression)    { return getLeftHandSide(expression).typeOf(_typeEnvironment);  }
	private Type getRightHandSideType(BinaryExpression expression)   { return getRightHandSide(expression).typeOf(_typeEnvironment); }
	
	private boolean isAValidExpression(BinaryExpression expression) {
		Expression leftHandSide  = getLeftHandSide(expression);
		Expression rightHandSide = getRightHandSide(expression);
		
		boolean checkLeftHandSide  = leftHandSide.accept(this);
		boolean checkRightHandSide = rightHandSide.accept(this);
		
		return checkLeftHandSide && checkRightHandSide;
	}
	
	private boolean isCompatibleToNumeric(BinaryExpression expression, String binarySymbol) {
		boolean isCompatible = getLeftHandSideType(expression).isCompatibleToNumeric() && getRightHandSideType(expression).isCompatibleToNumeric();
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean isCompatibleToNumeric(UnaryExpression expression, String binarySymbol) {
		boolean isCompatible = getTypeFor(expression).isCompatibleToNumeric();
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean isCompatibleToBool(BinaryExpression expression, String binarySymbol) {
		boolean isCompatible = getLeftHandSideType(expression).isCompatibleToBool() && getRightHandSideType(expression).isCompatibleToBool();
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean isCompatibleToBool(UnaryExpression expression, String binarySymbol) {
		boolean isCompatible = getTypeFor(expression).isCompatibleToBool();
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean isCompatibleTo(BinaryExpression expression, String binarySymbol) {
		boolean isCompatible = getLeftHandSideType(expression).isCompatibleTo(getRightHandSideType(expression));
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean isCompatibleTo(Expression expression, String binarySymbol) {
		boolean isCompatible = getTypeFor(expression).isCompatibleTo(getTypeFor(expression));
		return checkTypes(expression, binarySymbol, isCompatible);
	}
	
	private boolean checkTypes(Expression expression, String binarySymbol, boolean isCompatible) {
		if (!isCompatible) {
			addError(expression, "invalid type for " + binarySymbol);
		}
		return isCompatible;
	}
	
	private void addError(Expression expression, String errorMessage) {
		_errorMessages.add(new Message("Type error for expr " + expression + ": " + errorMessage));
	}
	
}