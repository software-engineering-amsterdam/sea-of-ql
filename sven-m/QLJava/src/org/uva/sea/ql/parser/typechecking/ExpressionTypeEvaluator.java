package org.uva.sea.ql.parser.typechecking;

import java.util.Map;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Bool;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Str;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.form.types.BoolType;
import org.uva.sea.ql.ast.form.types.IntType;
import org.uva.sea.ql.ast.form.types.StrType;
import org.uva.sea.ql.ast.form.types.Type;


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
	
	@Override
	public Type visit(Bool ast) {
		return new BoolType(null);
	}
	
}
