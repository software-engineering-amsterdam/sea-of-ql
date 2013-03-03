package visitor.evaluator;

import visitor.Environment;
import ast.expression.Ident;
import ast.expression.Value;
import ast.expression.Visitor;
import ast.expression.binary.*;
import ast.expression.unary.*;
import ast.expression.value.*;

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
		Int lhs;
		Int rhs;
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		return new Int(lhs.getValue() + rhs.getValue());
	}

	@Override
	public Bool visit(And ast) {
		Bool lhs;
		Bool rhs;
		try {
			lhs = (Bool) ast.getLhs().accept(this);
			rhs = (Bool) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("And incompatible types (Required: Bool; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() && rhs.getValue());
	}

	public Int visit(Div ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return intError("Div incompatible types (Required: Int; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Int(lhs.getValue() / rhs.getValue());
	}

	@Override
	public Bool visit(Eq ast) {
		Bool lhs;
		Bool rhs;
		try {
			lhs = (Bool) ast.getLhs().accept(this);
			rhs = (Bool) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("Eq incompatible types (Required: Bool; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() == rhs.getValue());
	}

	@Override
	public Bool visit(GEq ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("GEq incompatible types (Required: Bool; Int: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() >= rhs.getValue());
	}

	@Override
	public Bool visit(GT ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("Add incompatible types (Required: Int; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() > rhs.getValue());
	}

	@Override
	public Bool visit(LEq ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("LEq incompatible types (Required: Int; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() <= rhs.getValue());
	}

	@Override
	public Bool visit(LT ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("LT incompatible types (Required: Int; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() < rhs.getValue());
	}

	@Override
	public Int visit(Mul ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return intError("Mul incompatible types (Required: Int; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Int(lhs.getValue() * rhs.getValue());
	}

	@Override
	public Int visit(Neg ast) {
		Int expression;
		try {
			expression = (Int) ast.getExpression().accept(this);
		}catch(Exception e){
			return intError("Neg incompatible types (Required: Int; Got: " +ast.getExpression().typeOf(environment.getTypeEnv())+")");
		}
		if (expression.getValue() > 0)
			return new Int(expression.getValue() * (-1));
		return expression;
	}

	@Override
	public Bool visit(NEq ast) {
		Bool lhs;
		Bool rhs;
		try {
			lhs = (Bool) ast.getLhs().accept(this);
			rhs = (Bool) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("NEq incompatible types (Required: Bool; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() != rhs.getValue());
	}

	@Override
	public Bool visit(Not ast) {
		Bool expression;
		try {
			expression = (Bool) ast.getExpression().accept(this);
		}catch(Exception e){
			return boolError("Not incompatible types (Required: Bool; Got: " +ast.getExpression().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(!expression.getValue());
	}

	@Override
	public Bool visit(Or ast) {
		Bool lhs;
		Bool rhs;
		try {
			lhs = (Bool) ast.getLhs().accept(this);
			rhs = (Bool) ast.getRhs().accept(this);
		} catch (Exception e) {
			return boolError("Or incompatible types (Required: Bool; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
		return new Bool(lhs.getValue() || rhs.getValue());
	}

	@Override
	public Int visit(Pos ast) {
		Int expression;
		try {
			expression = (Int) ast.getExpression().accept(this);
		}catch(Exception e){
			return intError("Pos incompatible types (Required: Int; Got: " +ast.getExpression().typeOf(environment.getTypeEnv())+")");
		}
		if (expression.getValue() < 0)
			return new Int(expression.getValue() * (-1));
		return expression;
	}

	@Override
	public Int visit(Sub ast) {
		Int lhs;
		Int rhs;
		try {
			lhs = (Int) ast.getLhs().accept(this);
			rhs = (Int) ast.getRhs().accept(this);
		} catch (Exception e) {
			return intError("Sub incompatible types (Required: Int; Got: " +ast.getLhs().typeOf(environment.getTypeEnv())+" and "+ast.getRhs().typeOf(environment.getTypeEnv())+")");
		}
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
