package org.uva.sea.ql.check.expressions;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.LiteralExpr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.expressions.binary.BinaryArithmeticExpr;
import org.uva.sea.ql.ast.expressions.binary.BinaryLogicalExpr;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.ast.expressions.binary.logical.And;
import org.uva.sea.ql.ast.expressions.binary.logical.Or;
import org.uva.sea.ql.ast.expressions.binary.relational.BinaryRelationalExpr;
import org.uva.sea.ql.ast.expressions.binary.relational.Eq;
import org.uva.sea.ql.ast.expressions.binary.relational.GEq;
import org.uva.sea.ql.ast.expressions.binary.relational.GT;
import org.uva.sea.ql.ast.expressions.binary.relational.LEq;
import org.uva.sea.ql.ast.expressions.binary.relational.LT;
import org.uva.sea.ql.ast.expressions.binary.relational.NEq;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
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
	
	public static boolean check(Expr expr, TypeEnvironment supportedTypes, ErrorMessages errors) {
		TypeChecker exprChecker = new TypeChecker(supportedTypes, errors);
		return expr.accept(exprChecker);
	}
	
	@Override
	public Boolean visit(Add ast) { return checkArithmeticExpr(ast, "+"); }
	@Override
	public Boolean visit(Div ast) { return checkArithmeticExpr(ast, "/"); }
	@Override
	public Boolean visit(Sub ast) { return checkArithmeticExpr(ast, "-"); }
	@Override
	public Boolean visit(Mul ast) { return checkArithmeticExpr(ast, "*"); }

	@Override
	public Boolean visit(Eq ast)  { return checkRelationalExpr(ast, "=="); }
	@Override
	public Boolean visit(GEq ast) { return checkRelationalExpr(ast, ">="); }
	@Override
	public Boolean visit(GT ast)  { return checkRelationalExpr(ast, ">");  }
	@Override
	public Boolean visit(LEq ast) { return checkRelationalExpr(ast, "<="); }
	@Override
	public Boolean visit(LT ast)  { return checkRelationalExpr(ast, "<");  }
	@Override
	public Boolean visit(NEq ast) { return checkRelationalExpr(ast, "!="); }
	
	@Override
	public Boolean visit(And ast) { return checkLogicalExpr(ast, "&&"); }
	@Override
	public Boolean visit(Or ast)  { return checkLogicalExpr(ast, "||"); }

	@Override
	public Boolean visit(Neg ast) { return checkUnaryArithmeticExpr(ast, "--"); }
	@Override
	public Boolean visit(Pos ast) { return checkUnaryArithmeticExpr(ast, "++"); }
	@Override
	public Boolean visit(Not ast) { return checkUnaryLogicalExpr(ast, "!");  }

	@Override
	public Boolean visit(Bool ast)  { return checkLiteralExpr(ast, Bool.class.toString());  }
	@Override
	public Boolean visit(Ident ast) { return checkLiteralExpr(ast, Ident.class.toString()); }
	@Override
	public Boolean visit(Int ast)   { return checkLiteralExpr(ast, Int.class.toString());   }
	@Override
	public Boolean visit(Money ast) { return checkLiteralExpr(ast, Money.class.toString()); }
	@Override
	public Boolean visit(Str ast)   { return checkLiteralExpr(ast, Str.class.toString());   }
	
	private Boolean checkArithmeticExpr(BinaryArithmeticExpr expr, String binarySymbol) {
		boolean checkLhs = expr.getLhs().accept(this);
		boolean checkRhs = expr.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expr.getLhs().typeOf(_typeEnvironment);
		Type rhsType = expr.getRhs().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with BinaryNumericExpr
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			addError(expr, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkRelationalExpr(BinaryRelationalExpr expr, String binarySymbol) {
		boolean checkLhs = expr.getLhs().accept(this);
		boolean checkRhs = expr.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expr.getLhs().typeOf(_typeEnvironment);
		Type rhsType = expr.getRhs().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with each other
		if (!lhsType.isCompatibleTo(rhsType)) {
			addError(expr, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkLogicalExpr(BinaryLogicalExpr expr, String binarySymbol) {
		boolean checkLhs = expr.getLhs().accept(this);
		boolean checkRhs = expr.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expr.getLhs().typeOf(_typeEnvironment);
		Type rhsType = expr.getRhs().typeOf(_typeEnvironment);
		
		// Check if Types are compatible with BinaryBoolExpr
		if (!(lhsType.isCompatibleToBool() && rhsType.isCompatibleToBool())) {
			addError(expr, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
	
	private Boolean checkUnaryArithmeticExpr(UnaryExpr expr, String binarySymbol) {
		Type exprType = expr.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with UnaryExpr
		if (!exprType.isCompatibleToNumeric()) {
			addError(expr, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type error
		return true;
	}
	
	private Boolean checkUnaryLogicalExpr(UnaryExpr expr, String binarySymbol) {
		Type exprType = expr.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with UnaryExpr
		if (!exprType.isCompatibleToBool()) {
			addError(expr, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type error
		return true;
	}
	
	private Boolean checkLiteralExpr(LiteralExpr expr, String className) {
		Type exprType = expr.typeOf(_typeEnvironment);
		
		// Check if Type is compatible with LiteralExpr
		if (!exprType.isCompatibleTo(exprType)) {
			addError(expr, "invalid type for literal " + className);
			return false;
		}
		
		// No Type error
		return true; 
	}
	
	private void addError(Expr expr, String errorMessage) {
		_errorMessages.add("Type error for expr " + expr.toString() + ": " + errorMessage);
	}
}