package visitor.evaluator;

import visitor.Environment;
import ast.expression.Ident;
import ast.expression.Value;
import ast.expression.Visitor;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.*;

public class ExpressionEvaluator implements Visitor {
	
	private final Environment environment;
	
	public ExpressionEvaluator(Environment environment){
		this.environment = environment;
	}

	@Override
	public Int visit(Add ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);
		return new Int(lhs.getValue() + rhs.getValue());
	}

	@Override
	public Bool visit(And ast) {
		Bool lhs = ast.getLhs().accept(this);
		Bool rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() && rhs.getValue());
	}

	public Int visit(Div ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

		return new Int(lhs.getValue() / rhs.getValue());
	}

	@Override
	public Bool visit(Eq ast) {
		Bool lhs = ast.getLhs().accept(this);
		Bool rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() == rhs.getValue());
	}

	@Override
	public Bool visit(GEq ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() >= rhs.getValue());
	}

	@Override
	public Bool visit(GT ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() > rhs.getValue());
	}

	@Override
	public Bool visit(LEq ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() <= rhs.getValue());
	}

	@Override
	public Bool visit(LT ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() < rhs.getValue());
	}

	@Override
	public Int visit(Mul ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

		return new Int(lhs.getValue() * rhs.getValue());
	}

	@Override
	public Int visit(Neg ast) {
		Int expression = ast.getExpression().accept(this);
		if (expression.getValue() > 0)
			return new Int(expression.getValue() * (-1));
		return expression;
	}

	@Override
	public Bool visit(NEq ast) {
		Bool lhs = ast.getLhs().accept(this);
		Bool rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() != rhs.getValue());
	}

	@Override
	public Bool visit(Not ast) {
		Bool expression = ast.getExpression().accept(this);
		return new Bool(!expression.getValue());
	}

	@Override
	public Bool visit(Or ast) {
		Bool lhs = ast.getLhs().accept(this);
		Bool rhs = ast.getRhs().accept(this);

		return new Bool(lhs.getValue() || rhs.getValue());
	}

	@Override
	public Int visit(Pos ast) {
		Int expression = ast.getExpression().accept(this);
		if (expression.getValue() < 0)
			return new Int(expression.getValue() * (-1));
		return expression;
	}

	@Override
	public Int visit(Sub ast) {
		Int lhs = ast.getLhs().accept(this);
		Int rhs = ast.getRhs().accept(this);

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
