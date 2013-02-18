package org.uva.sea.ql.typechecker;

import java.util.List;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.operators.*;
import org.uva.sea.ql.ast.expression.operators.logical.*;
import org.uva.sea.ql.ast.expression.operators.numeric.*;
import org.uva.sea.ql.ast.expression.operators.relational.*;
import org.uva.sea.ql.ast.type.Type;

public class CheckExpression implements ExpressionVisitor<Boolean> {

	private final TypeEnvironment typeEnv;
	private final List<Message> messages;
	
	private CheckExpression(TypeEnvironment typeEnv, List<Message> messages) {
		this.typeEnv = typeEnv;
		this.messages = messages;
	}
	
	public static boolean check(Expression expr, TypeEnvironment typeEnv, List<Message> errs) {
		CheckExpression check = new CheckExpression(typeEnv, errs);
		return expr.accept(check);
	}
	
	public Type typeOf(Expression expr) {
		return expr.typeOf(typeEnv);
	}
	
	public boolean checkOperands(Operator ast) {
		
		boolean compatible = true;

		for(Expression e : ast.getOperands()) {
			compatible = compatible && e.accept(this);  
		}
		
		return compatible;
	}
	
	public boolean checkOperator(Operator ast) {
		
		if (!checkOperands(ast)) {
			return false;
		}
		
		Type operatorType = typeOf(ast);
		
		for(Expression expr : ast.getOperands()) {
			Type operandType = typeOf(expr);
			if (!operandType.isCompatibleWith(operatorType)) {
				//addError(ast, "invalid type for " + ast.getRepresentation());
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkRelationalOperator(BinaryOperator ast) {
		
		if (!checkOperands(ast)) {
			return false;
		}
		
		Type lhsType = typeOf(ast.getLeftOperand());
		Type rhsType = typeOf(ast.getLeftOperand());
		
		return lhsType.isCompatibleWith(rhsType);
	}

	public Boolean visit(Add ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Div ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Mul ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Neg ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Pos ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Sub ast) {
		return checkOperator(ast);
	}

	public Boolean visit(And ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Not ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Or ast) {
		return checkOperator(ast);
	}

	public Boolean visit(Eq ast) {
		return checkRelationalOperator(ast);
	}

	public Boolean visit(GEq ast) {
		return checkRelationalOperator(ast);
	}

	public Boolean visit(GT ast) {
		return checkRelationalOperator(ast);
	}

	public Boolean visit(LEq ast) {
		return checkRelationalOperator(ast);
	}

	public Boolean visit(LT ast) {
		return checkRelationalOperator(ast);
	}

	public Boolean visit(NEq ast) {
		return checkRelationalOperator(ast);
	}

	public Boolean visit(Identifier ast) {
		return true;
	}

	public Boolean visit(BooleanLiteral ast) {
		return true;
	}

	public Boolean visit(IntegerLiteral ast) {
		return true;
	}

	public Boolean visit(StringLiteral ast) {
		return true;
	}
	
}
