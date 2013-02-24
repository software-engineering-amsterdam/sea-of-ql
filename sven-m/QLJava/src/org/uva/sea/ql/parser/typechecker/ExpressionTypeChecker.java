package org.uva.sea.ql.parser.typechecker;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Binary;
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
import org.uva.sea.ql.ast.expression.Unary;
import org.uva.sea.ql.ast.form.types.BoolType;
import org.uva.sea.ql.ast.form.types.IntType;
import org.uva.sea.ql.ast.form.types.Type;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;
import org.uva.sea.ql.parser.typechecker.error.OperatorTypeMismatchError;
import org.uva.sea.ql.parser.typechecker.error.VariableUndefinedError;

public class ExpressionTypeChecker implements ExpressionVisitor<Boolean>
{
	private ExpressionTypeEvaluator typeEval;
	private Environment environment;
	
	private final IntType intType = new IntType(null);
	private final BoolType boolType = new BoolType(null);
	
	public ExpressionTypeChecker(Environment environment)
	{
		this.environment = environment;
		typeEval = new ExpressionTypeEvaluator(
				environment.getTypeEnvironment());
	}
	
	
	/*
	 * Error reporting
	 */
	
	private void addTypeMismatch(Binary ast) {
		OperatorTypeMismatchError error =
				new OperatorTypeMismatchError(ast.getClass().getSimpleName(),
						ast.getLhs().getClass().getSimpleName(),
						ast.getRhs().getClass().getSimpleName(),
						ast);
		
		environment.reportError(error);
	}
	
	private void addTypeMismatch(Unary ast) {
		OperatorTypeMismatchError error =
				new OperatorTypeMismatchError(ast.getClass().getSimpleName(),
						ast.getClass().getSimpleName(), ast);
		environment.reportError(error);
	}
	
	private void addVariableUndefined(Ident ident) {
		VariableUndefinedError error =
				new VariableUndefinedError(ident.getName(), ident);
		environment.reportError(error);
	}
	
	
	/*
	 * Traverse child(ren)
	 */ 
	
	private boolean traverse(Binary ast) {
		return ast.getLhs().accept(this) && ast.getRhs().accept(this);
	}
	
	private boolean traverse(Unary ast) {
		return ast.getOp().accept(this);
	}

	
	/*
	 * Actual type checking for binary and unary operators
	 */
	
	private Boolean assertChildrenEqualType(Binary ast) {
		boolean typeCorrect = traverse(ast);
		
		Type lhsType = ast.getLhs().accept(typeEval);
		Type rhsType = ast.getRhs().accept(typeEval);
		
		if (!lhsType.equals(rhsType)) {
			addTypeMismatch(ast);
			typeCorrect = false;
		}
		
		return typeCorrect;
	}
	
	private Boolean assertChildrenType(Binary ast, Type type) {
		boolean typeCorrect = traverse(ast);
		
		Type lhsType = ast.getLhs().accept(typeEval);
		Type rhsType = ast.getRhs().accept(typeEval);
		
		if (!lhsType.equals(type)) {
			addTypeMismatch(ast);
			typeCorrect = false;
		}
		
		if (!(rhsType.equals(type))) {
			addTypeMismatch(ast);
			typeCorrect = false;
		}
		
		return typeCorrect;
	}
	
	private Boolean assertChildType(Unary ast, Type type) {
		boolean typeCorrect = traverse(ast);
		
		Type opType = ast.getOp().accept(typeEval);
		
		if (!opType.equals(type)) {
			addTypeMismatch(ast);
			typeCorrect = false;
		}
		
		return typeCorrect;
	}
	
	
	/*
	 * AST node visiting
	 */
	
	
	/*
	 * Overloaded
	 */
	
	@Override
	public Boolean visit(Add ast) {
		return assertChildrenEqualType(ast);
	}
	
	@Override
	public Boolean visit(Eq ast) {
		return assertChildrenEqualType(ast);
	}
	
	@Override
	public Boolean visit(NEq ast) {
		return assertChildrenEqualType(ast);
	}
	
	
	/*
	 * Integer
	 */
	
	@Override
	public Boolean visit(Sub ast) {
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
	public Boolean visit(Pos ast) {
		return assertChildType(ast, intType);
	}

	@Override
	public Boolean visit(Neg ast) {
		return assertChildType(ast, intType);
	}
	
	@Override
	public Boolean visit(LT ast) {
		return assertChildrenType(ast, intType);
	}

	@Override
	public Boolean visit(LEq ast) {
		return assertChildrenType(ast, intType);
	}
	
	@Override
	public Boolean visit(GEq ast) {
		return assertChildrenType(ast, intType);
	}

	@Override
	public Boolean visit(GT ast) {
		return assertChildrenType(ast, intType);
	}
	
	
	/*
	 * Boolean
	 */
	
	@Override
	public Boolean visit(And ast) {
		return assertChildrenType(ast, boolType);
	}

	@Override
	public Boolean visit(Or ast) {
		return assertChildrenType(ast, boolType);
	}
	
	@Override
	public Boolean visit(Not ast) {
		return assertChildType(ast, boolType);
	}
	
	
	/*
	 * Leaf nodes
	 */

	@Override
	public Boolean visit(Ident ast) {
		boolean typeCorrect = environment.getType(ast) != null;
		
		if (!typeCorrect) {
			addVariableUndefined(ast);
		}
		
		return typeCorrect;
	}

	@Override
	public Boolean visit(IntLiteral ast) {
		return true;
	}

	@Override
	public Boolean visit(StrLiteral ast) {
		return true;
	}


	@Override
	public Boolean visit(BoolLiteral ast) {
		return true;
	}
	
}
