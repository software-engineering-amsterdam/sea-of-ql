package org.uva.sea.ql.ast.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.ExpressionVisitor;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.conditional.And;
import org.uva.sea.ql.ast.operators.conditional.Or;
import org.uva.sea.ql.ast.operators.relational.Eq;
import org.uva.sea.ql.ast.operators.relational.GEq;
import org.uva.sea.ql.ast.operators.relational.GT;
import org.uva.sea.ql.ast.operators.relational.LEq;
import org.uva.sea.ql.ast.operators.relational.LT;
import org.uva.sea.ql.ast.operators.relational.NEq;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.types.literals.BooleanLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.QLValue;
import org.uva.sea.ql.ast.types.literals.StringLiteral;
import org.uva.sea.ql.parsers.exceptions.IdentifierNotDefinedException;
import org.uva.sea.ql.parsers.exceptions.QLException;

public class ExpressionEvaluatingVisitor implements ExpressionVisitor<QLValue> {

	private Map<Identifier, QLValue> identifierValueMap;
	private List<QLException> exceptions;

	public ExpressionEvaluatingVisitor(
			Map<Identifier, QLValue> identifierValueMap) {
		this.identifierValueMap = identifierValueMap;
		this.exceptions = new ArrayList<QLException>();
	}

	public List<QLException> getExceptions() {
		return this.exceptions;
	}

	@Override
	public QLValue visit(BooleanLiteral booleanLiteral) {
		return booleanLiteral;
	}

	@Override
	public QLValue visit(Identifier identifier) {
		String nameOfSearchedIdentifier = identifier.getName();
		for (Identifier ident : identifierValueMap.keySet()) {
			String nameOfFoundIdentifier = ident.getName();
			if (nameOfFoundIdentifier.equals(nameOfSearchedIdentifier)) {
				return identifierValueMap.get(ident);
			}
		}

		this.exceptions.add(new IdentifierNotDefinedException(identifier));
		return null;
	}

	@Override
	public QLValue visit(IntLiteral integerLiteral) {
		return integerLiteral;
	}

	@Override
	public QLValue visit(StringLiteral stringLiteral) {
		return stringLiteral;
	}

	@Override
	public QLValue visit(Add add) {
		QLValue lhs = add.getLhs().accept(this);
		QLValue rhs = add.getRhs().accept(this);
		return lhs.add(rhs);
	}

	@Override
	public QLValue visit(Div div) {
		QLValue lhs = div.getLhs().accept(this);
		QLValue rhs = div.getRhs().accept(this);
		return lhs.div(rhs);
	}

	@Override
	public QLValue visit(Sub sub) {
		QLValue lhs = sub.getLhs().accept(this);
		QLValue rhs = sub.getRhs().accept(this);
		return lhs.sub(rhs);
	}

	@Override
	public QLValue visit(Mul mul) {
		QLValue lhs = mul.getLhs().accept(this);
		QLValue rhs = mul.getRhs().accept(this);
		return lhs.mul(rhs);
	}

	@Override
	public QLValue visit(And and) {
		QLValue lhs = and.getLhs().accept(this);
		QLValue rhs = and.getRhs().accept(this);
		return lhs.and(rhs);
	}

	@Override
	public QLValue visit(Or or) {
		QLValue lhs = or.getLhs().accept(this);
		QLValue rhs = or.getRhs().accept(this);
		return lhs.or(rhs);
	}

	@Override
	public QLValue visit(Eq eq) {
		QLValue lhs = eq.getLhs().accept(this);
		QLValue rhs = eq.getRhs().accept(this);
		return lhs.eql(rhs);
	}

	@Override
	public QLValue visit(GEq gEq) {
		QLValue lhs = gEq.getLhs().accept(this);
		QLValue rhs = gEq.getRhs().accept(this);
		return lhs.gEq(rhs);
	}

	@Override
	public QLValue visit(GT gT) {
		QLValue lhs = gT.getLhs().accept(this);
		QLValue rhs = gT.getRhs().accept(this);
		return lhs.gT(rhs);
	}

	@Override
	public QLValue visit(LEq lEq) {
		QLValue lhs = lEq.getLhs().accept(this);
		QLValue rhs = lEq.getRhs().accept(this);
		return lhs.lEq(rhs);
	}

	@Override
	public QLValue visit(LT lT) {
		QLValue lhs = lT.getLhs().accept(this);
		QLValue rhs = lT.getRhs().accept(this);
		return lhs.lT(rhs);
	}

	@Override
	public QLValue visit(NEq nEq) {
		QLValue lhs = nEq.getLhs().accept(this);
		QLValue rhs = nEq.getRhs().accept(this);
		return lhs.nEq(rhs);
	}

	@Override
	public QLValue visit(Neg neg) {
		QLValue exp = neg.getExpression().accept(this);
		return exp.neg();
	}

	@Override
	public QLValue visit(Not not) {
		QLValue value = not.getExpression().accept(this);
		return value.not();
	}

	@Override
	public QLValue visit(Pos pos) {
		QLValue exp = pos.getExpression().accept(this);
		return exp.pos();
	}
}
