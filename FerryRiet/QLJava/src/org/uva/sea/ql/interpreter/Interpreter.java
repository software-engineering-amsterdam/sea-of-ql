package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.And;
import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanLiteral;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Div;
import org.uva.sea.ql.ast.Eq;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.GEq;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.NEq;
import org.uva.sea.ql.ast.Neg;
import org.uva.sea.ql.ast.Not;
import org.uva.sea.ql.ast.Or;
import org.uva.sea.ql.ast.Pos;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.Sub;
import org.uva.sea.ql.ast.TypeDescription;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public class Interpreter implements Visitor {

	@Override
	public VisitorResult visit(Expr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Ident expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(IntLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(StringLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(BooleanLiteral expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Add expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Mul expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Div expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Sub expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(And expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Or expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Eq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(GT expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(LT expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(LEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(NEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(GEq expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Not expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Neg expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(Pos expr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(CompoundStatement compoundBlock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(LineStatement lineStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitorResult visit(TypeDescription typeDescription) {
		// TODO Auto-generated method stub
		return null;
	}

}
