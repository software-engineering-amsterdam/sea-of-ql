package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Value;
import org.uva.sea.ql.ast.expression.Visitor;
import org.uva.sea.ql.ast.expression.binary.arithmetic.*;
import org.uva.sea.ql.ast.expression.binary.comparison.*;
import org.uva.sea.ql.ast.expression.binary.logic.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.expression.value.*;
import org.uva.sea.ql.evaluator.Environment;


public class ExpressionEvaluator implements Visitor<Value> {

	private final Environment environment;

	public ExpressionEvaluator(Environment environment) {
		this.environment = environment;
	}
	
	public Int intError(String error){
		environment.addError(error);
		return new Int(0);
	}
	
	public Bool boolError(String error){
		environment.addError(error);
		return new Bool(false);
	}

	@Override
	public Int visit(Add ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Int(lhs.getValue() + rhs.getValue());
	}

	@Override
	public Bool visit(And ast) {
		Bool lhs = (Bool) ast.getLhs().accept(this);
		Bool rhs = (Bool) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() && rhs.getValue());
	}

	public Int visit(Div ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Int(lhs.getValue() / rhs.getValue());
	}

	@Override
	public Bool visit(Eq ast) {
		Bool lhs = (Bool) ast.getLhs().accept(this);
		Bool rhs = (Bool) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() == rhs.getValue());
	}

	@Override
	public Bool visit(GEq ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() >= rhs.getValue());
	}

	@Override
	public Bool visit(GT ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() > rhs.getValue());
	}

	@Override
	public Bool visit(LEq ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() <= rhs.getValue());
	}

	@Override
	public Bool visit(LT ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() < rhs.getValue());
	}

	@Override
	public Int visit(Mul ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Int(lhs.getValue() * rhs.getValue());
	}

	@Override
	public Int visit(Neg ast) {
		Int expression = (Int) ast.getExpression().accept(this);
		return expression;
	}

	@Override
	public Bool visit(NEq ast) {
		Bool lhs = (Bool) ast.getLhs().accept(this);
		Bool rhs = (Bool) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() != rhs.getValue());
	}

	@Override
	public Bool visit(Not ast) {
		Bool expression = (Bool) ast.getExpression().accept(this);
		return new Bool(!expression.getValue());
	}

	@Override
	public Bool visit(Or ast) {
		Bool lhs = (Bool) ast.getLhs().accept(this);
		Bool rhs = (Bool) ast.getRhs().accept(this);
		return new Bool(lhs.getValue() || rhs.getValue());
	}

	@Override
	public Int visit(Pos ast) {
		Int expression = (Int) ast.getExpression().accept(this);
		return expression;
	}

	@Override
	public Int visit(Sub ast) {
		Int lhs = (Int) ast.getLhs().accept(this);
		Int rhs = (Int) ast.getRhs().accept(this);
		return new Int(lhs.getValue() - rhs.getValue());
	}

	@Override
	public Bool visit(Bool ast) {
		return new Bool(ast.getValue());
	}

	@Override
	public Str visit(Str ast) {
		return ast;
	}

	@Override
	public Int visit(Int ast) {
		return ast;
	}

	@Override
	public Value visit(Ident ast) {
		return environment.getIdent(ast).getValue().accept(this);
	}

}
