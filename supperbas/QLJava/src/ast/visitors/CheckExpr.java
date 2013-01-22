package ast.visitors;

import java.util.List;
import java.util.Map;

import ast.Expr;
import ast.exprs.binary.Add;
import ast.exprs.binary.And;
import ast.exprs.binary.Div;
import ast.exprs.binary.Mul;
import ast.exprs.binary.Or;
import ast.exprs.binary.Sub;
import ast.exprs.eval.Eq;
import ast.exprs.eval.GEq;
import ast.exprs.eval.GT;
import ast.exprs.eval.LEq;
import ast.exprs.eval.LT;
import ast.exprs.eval.NEq;
import ast.exprs.unary.Neg;
import ast.exprs.unary.Not;
import ast.exprs.unary.Pos;
import ast.exprs.value.Bool;
import ast.exprs.value.Int;
import ast.types.*;

public class CheckExpr implements Visitor<Boolean> {
	@SuppressWarnings("unused")
	private final Map<Ident, Type> typeEnv;
	@SuppressWarnings("unused")
	private final List<Message> messages;

	private CheckExpr(Map<Ident, Type> tenv, List<Message> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<Message> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Div ast) {
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
	public Boolean visit(ast.exprs.value.Ident ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Int ast) {
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
	public Boolean visit(Mul ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Sub ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Bool bool) {
		// TODO Auto-generated method stub
		return null;
	}
}