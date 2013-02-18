package org.uva.sea.ql.parser.typechecking;

import java.util.Map;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Int;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Str;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.form.BoolType;
import org.uva.sea.ql.ast.form.IntType;
import org.uva.sea.ql.ast.form.StrType;
import org.uva.sea.ql.ast.form.Type;


public class ExpressionTypeEvaluator implements ExpressionVisitor<Type> {
	private Map<String, Type> environment;
	
	public ExpressionTypeEvaluator(Map<String, Type> environment) {
		this.environment = environment;
	}
	
	@Override
	public Type visit(Add ast) {
		return ast.getLhs().accept(this);
	}

	@Override
	public Type visit(Mul ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(Div ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(Sub ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(And ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(Or ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(LT ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(LEq ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(Eq ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(NEq ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(GEq ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(GT ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(Pos ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(Neg ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(Not ast) {
		return new BoolType(null);
	}

	@Override
	public Type visit(Ident ast) {
		return environment.get(ast.getName());
	}

	@Override
	public Type visit(Int ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(Str ast) {
		return new StrType(null);
	}
	
}