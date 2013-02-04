package org.uva.sea.ql.parser.visitors.checkexpr;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.binary.BinaryNumericExpr;
import org.uva.sea.ql.ast.expressions.binary.bool.And;
import org.uva.sea.ql.ast.expressions.binary.bool.Eq;
import org.uva.sea.ql.ast.expressions.binary.bool.GEq;
import org.uva.sea.ql.ast.expressions.binary.bool.GT;
import org.uva.sea.ql.ast.expressions.binary.bool.LEq;
import org.uva.sea.ql.ast.expressions.binary.bool.LT;
import org.uva.sea.ql.ast.expressions.binary.bool.NEq;
import org.uva.sea.ql.ast.expressions.binary.bool.Or;
import org.uva.sea.ql.ast.expressions.binary.numeric.Add;
import org.uva.sea.ql.ast.expressions.binary.numeric.Div;
import org.uva.sea.ql.ast.expressions.binary.numeric.Mul;
import org.uva.sea.ql.ast.expressions.binary.numeric.Sub;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.parser.Message;

public class CheckExpr implements Visitor<Boolean> {
	
	private final Map<Ident, Type> _typeEnv;
	private final List<Message> _messages;
	
	private CheckExpr(Map<Ident, Type> typeEnv, List<Message> messages) {
		_typeEnv = typeEnv;
		_messages = messages;
	}
	
	public static boolean check(Expr expr, Map<Ident, Type> typeEnv, List<Message> errors) {
		CheckExpr exprChecker = new CheckExpr(typeEnv, errors);
		return expr.accept(exprChecker);
	}

	private void addError(Expr expr, String errorMessage) {
		_messages.add(new Message("Type error for expr " + expr.toString() + ": " + errorMessage));
	}
	
	@Override
	public Boolean visit(Add ast) { return visitNumericExpr(ast, "+"); }
	@Override
	public Boolean visit(Div ast) { return visitNumericExpr(ast, "/"); }
	@Override
	public Boolean visit(Sub ast) { return visitNumericExpr(ast, "-"); }
	@Override
	public Boolean visit(Mul ast) { return visitNumericExpr(ast, "*"); }

	@Override
	public Boolean visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Eq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Bool ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Ident ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Money money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Str str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Boolean visitNumericExpr(BinaryNumericExpr expr, String binarySymbol) {
		boolean checkLhs = expr.getLhs().accept(this);
		boolean checkRhs = expr.getRhs().accept(this);
		
		if (!(checkLhs && checkRhs)) {
			// Type errors occurred
			return false;
		}
		
		Type lhsType = expr.getLhs().typeOf(_typeEnv);
		Type rhsType = expr.getRhs().typeOf(_typeEnv);
		
		// Check if Types are compatible with Add
		if (!(lhsType.isCompatibleToNumeric() && rhsType.isCompatibleToNumeric())) {
			addError(expr, "invalid type for " + binarySymbol);
			return false;
		}
		
		// No Type errors
		return true; 
	}
}