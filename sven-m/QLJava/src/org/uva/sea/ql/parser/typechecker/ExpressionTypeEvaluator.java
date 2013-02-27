package org.uva.sea.ql.parser.typechecker;

import java.util.Map;

import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BoolLiteral;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.IntLiteral;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.StrLiteral;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.form.types.BoolType;
import org.uva.sea.ql.ast.form.types.IntType;
import org.uva.sea.ql.ast.form.types.StrType;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.ast.form.types.UndefinedType;


public class ExpressionTypeEvaluator implements ExpressionVisitor<Type> {
	private Map<Ident, Type> typeState;
	
	public ExpressionTypeEvaluator(Map<Ident, Type> typeState) {
		this.typeState = typeState;
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
		Type type = typeState.get(ast);
				
		if (type == null) {
			type = new UndefinedType(null);
		}
		
		return type;
	}

	@Override
	public Type visit(IntLiteral ast) {
		return new IntType(null);
	}

	@Override
	public Type visit(StrLiteral ast) {
		return new StrType(null);
	}
	
	@Override
	public Type visit(BoolLiteral ast) {
		return new BoolType(null);
	}
	
}
