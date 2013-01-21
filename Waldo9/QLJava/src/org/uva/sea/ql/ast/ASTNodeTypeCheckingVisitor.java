package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.Expr;
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
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.ast.types.Type;

public class ASTNodeTypeCheckingVisitor implements ASTNodeVisitor<Boolean> {
	
	private Map<Ident, Type> typeEnvironment;

	@Override
	public Boolean visit(Form form) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(StringLiteral stringLiteral) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(BoolType boolType) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(IntType intType) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(StringType stringType) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Block block) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(IfThenElse ifThenElse) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Question question) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Add add) {
		return null;
		
		
	}

	@Override
	public Boolean visit(And and) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Div div) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Eq eq) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(GEq gEq) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(GT gt) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Ident ident) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Int int1) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(LEq lEq) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(LT lt) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Mul mul) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Neg neg) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(NEq nEq) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Not not) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Or or) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Pos pos) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Sub sub) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(Expr expr) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean visit(BooleanLiteral booleanLiteral) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
