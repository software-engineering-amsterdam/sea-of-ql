package org.uva.sea.ql.check.expressions;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.BinaryArithmeticExpression;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.ast.expressions.binary.logical.And;
import org.uva.sea.ql.ast.expressions.binary.logical.BinaryLogicalExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.Or;
import org.uva.sea.ql.ast.expressions.binary.relational.BinaryRelationalExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.Eq;
import org.uva.sea.ql.ast.expressions.binary.relational.GEq;
import org.uva.sea.ql.ast.expressions.binary.relational.GT;
import org.uva.sea.ql.ast.expressions.binary.relational.LEq;
import org.uva.sea.ql.ast.expressions.binary.relational.LT;
import org.uva.sea.ql.ast.expressions.binary.relational.NEq;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.LiteralExpression;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
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
	public Boolean visit(Add ast) { return checkArithmeticExpression(ast, "+"); }
	@Override
	public Boolean visit(Div ast) { return checkArithmeticExpression(ast, "/"); }
	@Override
	public Boolean visit(Sub ast) { return checkArithmeticExpression(ast, "-"); }
	@Override
	public Boolean visit(Mul ast) { return checkArithmeticExpression(ast, "*"); }

	@Override
	public Boolean visit(Eq ast)  { return checkRelationalExpression(ast, "=="); }
	@Override
	public Boolean visit(GEq ast) { return checkRelationalExpression(ast, ">="); }
	@Override
	public Boolean visit(GT ast)  { return checkRelationalExpression(ast, ">");  }
	@Override
	public Boolean visit(LEq ast) { return checkRelationalExpression(ast, "<="); }
	@Override
	public Boolean visit(LT ast)  { return checkRelationalExpression(ast, "<");  }
	@Override
	public Boolean visit(NEq ast) { return checkRelationalExpression(ast, "!="); }
	
	@Override
	public Boolean visit(And ast) { return checkLogicalExpression(ast, "&&"); }
	@Override
	public Boolean visit(Or ast)  { return checkLogicalExpression(ast, "||"); }

	@Override
	public Boolean visit(Neg ast) { return checkUnaryArithmeticExpression(ast, "--"); }
	@Override
	public Boolean visit(Pos ast) { return checkUnaryArithmeticExpression(ast, "++"); }
	@Override
	public Boolean visit(Not ast) { return checkUnaryLogicalExpression(ast, "!");  }

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
		boolean checkLhs = expression.getLhs().accept(this);
		boolean checkRhs = expression.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expression.getLhs().typeOf(_typeEnvironment);
		Type rhsType = expression.getRhs().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with BinaryNumericExpr
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkRelationalExpression(BinaryRelationalExpression expression, String binarySymbol) {
		boolean checkLhs = expression.getLhs().accept(this);
		boolean checkRhs = expression.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expression.getLhs().typeOf(_typeEnvironment);
		Type rhsType = expression.getRhs().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with each other
		if (!lhsType.isCompatibleTo(rhsType)) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkLogicalExpression(BinaryLogicalExpression expression, String binarySymbol) {
		boolean checkLhs = expression.getLhs().accept(this);
		boolean checkRhs = expression.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expression.getLhs().typeOf(_typeEnvironment);
		Type rhsType = expression.getRhs().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with BinaryBoolExpr
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkUnaryArithmeticExpression(UnaryExpression expression, String binarySymbol) {
		Type exprType = expression.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with UnaryExpr
		if (!exprType.isCompatibleToNumeric()) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type error
		return true;
	}
	
	private Boolean checkUnaryLogicalExpression(UnaryExpression expression, String binarySymbol) {
		Type exprType = expression.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with UnaryExpr
		if (!exprType.isCompatibleToBool()) {
			addError(expression, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type error
		return true;
	}
	
	private Boolean checkLiteralExpression(LiteralExpression expression, String className) {
		Type exprType = expression.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with LiteralExpr
		if (!exprType.isCompatibleTo(exprType)) {
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