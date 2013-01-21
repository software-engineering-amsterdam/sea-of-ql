package org.uva.sea.ql.visitor.checker;

import java.util.List;
import java.util.Map;

import org.antlr.tool.Message;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class ExpressionChecker implements ExpressionVisitor<Boolean> {
	private final Map<Ident, Type> typeEnv;
	private final List<Message> messages;

	public ExpressionChecker(Map<Ident, Type> tenv, List<Message> messages) {
		this.typeEnv = tenv;
		this.messages = messages;
	}

	public static boolean check(Expr expr, Map<Ident, Type> typeEnv,
			List<Message> errs) {
		ExpressionChecker check = new ExpressionChecker(typeEnv, errs);
		return expr.accept(check);
	}

	@Override
	public Boolean visit(Add ast) {
		boolean checkLhs = ast.getLhs().accept(this);
		boolean checkRhs = ast.getRhs().accept(this);

		if (!(checkLhs && checkRhs)) {
			return false;
		}

		Type lhsType = ast.getLhs().typeOf(typeEnv);
		Type rhsType = ast.getRhs().typeOf(typeEnv);

		if (!(lhsType.isCompatibleToNumericType() && rhsType
				.isCompatibleToNumericType())) {

			System.out.println("invalid type for + ");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(And and) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Div div) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Eq eq) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(GEq geq) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(GT gt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(LEq leq) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(LT lt) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Mul mul) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(NEq neq) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Or or) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Sub sub) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Neg neg) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Not not) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Pos pos) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Bool bool) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Ident ident) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(Int integer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		return true;
	}

	public List<Message> getMessages() {
		return messages;
	}
}
