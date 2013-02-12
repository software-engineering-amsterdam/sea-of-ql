package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.ast.nodes.values.Bool;
import org.uva.sea.ql.ast.nodes.values.Int;
import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Str;
import org.uva.sea.ql.ast.type.Type;

public class CheckExpr implements Visitor<Boolean> {
	
	private Map<Ident, Type> typeEnv;
	private List<ErrorMessage> messages;

	private CheckExpr(Map<Ident, Type> tenv, List<ErrorMessage> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<ErrorMessage> errs) {
		CheckExpr check = new CheckExpr(typeEnv, errs);
		return expr.accept(check);
	}

	private void addError(Expr ex, String message) {
		this.messages.add(new ErrorMessage(ex,message));
	}
	
	public List<ErrorMessage> getErrorMessages(){
		return this.messages;
	}

	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type typeLhs = ast.getLhs().typeOf(typeEnv);
		Type typeRhs = ast.getRhs().typeOf(typeEnv);

		if (!(typeLhs.isCompatibleToNumeric() && typeRhs
				.isCompatibleToNumeric())) {
			addError(ast, "invalid type for addition (+)");
			return false;
		}
		return true;

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

	@Override
	public Boolean visit(Str bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Money bool) {
		// TODO Auto-generated method stub
		return null;
	}

}
