package org.uva.sea.ql.typechecker;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.ExpressionVisitor;

public class CheckExpression implements ExpressionVisitor<Boolean> {

	private final Map<Identifier, Type> typeEnv;
	private final List<Message> messages;
	
	private CheckExpression(Map<Identifier, Type> typeEnv, List<Message> messages) {
		this.typeEnv = typeEnv;
		this.messages = messages;
	}
	
	public static boolean check(Expression expr, Map<Identifier, Type> typeEnv, List<Message> errs) {
		CheckExpression check = new CheckExpression(typeEnv, errs);
		return expr.accept(check);
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
		
		Type operatorType = ast.typeOf(typeEnv);
		
		for(Expression e : ast.getOperands()) {
			Type operandType = e.typeOf(typeEnv);
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
		
		Type lhsType = ast.getLeftOperand().typeOf(typeEnv);
		Type rhsType = ast.getLeftOperand().typeOf(typeEnv);
		
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
