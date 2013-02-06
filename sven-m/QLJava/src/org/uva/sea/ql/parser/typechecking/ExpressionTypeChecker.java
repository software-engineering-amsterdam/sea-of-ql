package org.uva.sea.ql.parser.typechecking;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Binary;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.Expr;
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
import org.uva.sea.ql.ast.expression.Unary;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;

public class ExpressionTypeChecker implements ExpressionVisitor<Boolean>
{
	private ExpressionTypeEvaluator exprTypeEval;
	private Map<String, Type> typeEnvironment;
	private List<String> messages;
	
	private final IntType intType = new IntType();
	private final BoolType boolType = new BoolType();
	
	public ExpressionTypeChecker(Map<String, Type> typeEnvironment,
			List<String> messages)
	{
		this.typeEnvironment = typeEnvironment;
		this.messages = messages;
		exprTypeEval = new ExpressionTypeEvaluator(typeEnvironment);
	}
	
	private void addTypeMismatch(Expr expr, Type expected, Type actual) {
		messages.add(String.format(
				"In %s expression: unexpected %s, expected %s",
				expr.getClass().getName(),
				expected.getClass().getName(),
				actual.getClass().getName()
		));
	}
	
	private void addVariableUndeclared(Ident ident) {
		messages.add(String.format(
				"Variable \"%s\" not declared",
				ident.getName()
		));
	}
	
	private Boolean assertChildrenType(Binary ast, Type type) {
		boolean typeCorrect = 	ast.getLhs().accept(this)
							&&	ast.getRhs().accept(this);
		
		Type lhsType = ast.getLhs().accept(exprTypeEval);
		Type rhsType = ast.getRhs().accept(exprTypeEval);
		
		if (!lhsType.equals(type)) {
			addTypeMismatch(ast, type, lhsType);
			typeCorrect = false;
		}
		
		if (!(rhsType.equals(type))) {
			addTypeMismatch(ast, type, lhsType);
			typeCorrect = false;
		}
		
		return typeCorrect;
	}
	
	private Boolean assertChildType(Unary ast, Type type) {
		boolean typeCorrect = ast.getOp().accept(this);
		
		Type opType = ast.getOp().accept(exprTypeEval);
		
		if (!opType.equals(type)) {
			addTypeMismatch(ast, type, opType);
			typeCorrect = false;
		}
		
		return typeCorrect;
	}
	
	
	/* Integer binary nodes */

	@Override
	public Boolean visit(Add ast) {
		return assertChildrenType(ast, intType);
	}

	@Override
	public Boolean visit(Mul ast) {
		return assertChildrenType(ast, intType);
	}

	@Override
	public Boolean visit(Div ast) {
		return assertChildrenType(ast, intType);
	}

	@Override
	public Boolean visit(Sub ast) {
		return assertChildrenType(ast, intType);
	}

	
	/* Integer unary nodes */
	
	@Override
	public Boolean visit(Pos ast) {
		return assertChildType(ast, intType);
	}

	@Override
	public Boolean visit(Neg ast) {
		return assertChildType(ast, intType);
	}
	
	
	/* Boolean binary nodes */

	@Override
	public Boolean visit(And ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(Or ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(LT ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(LEq ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(Eq ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(NEq ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(GEq ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(GT ast) {
		return assertChildrenType(ast, boolType);
	}
	

	/* Boolean unary nodes */
	
	@Override
	public Boolean visit(Not ast) {
		return assertChildType(ast, boolType);
	}
	
	
	/* Leaf nodes */

	@Override
	public Boolean visit(Ident ast) {
		boolean typeCorrect = typeEnvironment.get(ast.getName()) != null;
		
		if (!typeCorrect) {
			addVariableUndeclared(ast);
		}
		
		return typeCorrect;
	}

	@Override
	public Boolean visit(Int ast) {
		return true;
	}

	@Override
	public Boolean visit(Str ast) {
		return true;
	}

}