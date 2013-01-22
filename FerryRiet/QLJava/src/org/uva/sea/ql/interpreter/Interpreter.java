package org.uva.sea.ql.interpreter;

import java.util.HashMap;

import org.uva.sea.ql.ast.BinExpr;
import org.uva.sea.ql.ast.BooleanLiteral;
import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.ConditionalStatement;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.QLProgram;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.StringLiteral;
import org.uva.sea.ql.ast.UnExpr;
import org.uva.sea.ql.ast.operators.Add;
import org.uva.sea.ql.ast.operators.And;
import org.uva.sea.ql.ast.operators.Div;
import org.uva.sea.ql.ast.operators.Eq;
import org.uva.sea.ql.ast.operators.GEq;
import org.uva.sea.ql.ast.operators.GT;
import org.uva.sea.ql.ast.operators.LEq;
import org.uva.sea.ql.ast.operators.LT;
import org.uva.sea.ql.ast.operators.Mul;
import org.uva.sea.ql.ast.operators.NEq;
import org.uva.sea.ql.ast.operators.Neg;
import org.uva.sea.ql.ast.operators.Not;
import org.uva.sea.ql.ast.operators.Or;
import org.uva.sea.ql.ast.operators.Pos;
import org.uva.sea.ql.ast.operators.Sub;
import org.uva.sea.ql.ast.types.TypeDescription;
import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public class Interpreter implements Visitor {
	
	private HashMap<String, Statement> symbolMap = new HashMap<String, Statement>();

	@Override
	public VisitorResult visit(Expr expr) {

		return null;
	}

	@Override
	public VisitorResult visit(BinExpr expr) {

		return null;
	}

	@Override
	public VisitorResult visit(Ident expr) {

		return null;
	}

	@Override
	public VisitorResult visit(IntLiteral expr) {

		return null;
	}

	@Override
	public VisitorResult visit(StringLiteral expr) {
		return null;
	}

	@Override
	public VisitorResult visit(BooleanLiteral expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Add expr) {

		return null;
	}

	@Override
	public VisitorResult visit(Mul expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Div expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Sub expr) {
		return null;
	}

	@Override
	public VisitorResult visit(And expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Or expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Eq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(GT expr) {

		return null;
	}

	@Override
	public VisitorResult visit(LT expr) {
		return null;
	}

	@Override
	public VisitorResult visit(LEq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(NEq expr) {
		return null;
	}

	@Override
	public VisitorResult visit(GEq expr) {

		return null;
	}

	@Override
	public VisitorResult visit(UnExpr expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Not expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Neg expr) {
		return null;
	}

	@Override
	public VisitorResult visit(Pos expr) {
		return null;
	}

	@Override
	public VisitorResult visit(QLProgram qlProgram) {
		symbolMap.clear();
		qlProgram.getCompound().accept(this);
		return null;
	}

	@Override
	public VisitorResult visit(CompoundStatement compoundBlock) {
		return null;
	}

	@Override
	public VisitorResult visit(LineStatement lineStatement) {
		return null;
	}

	@Override
	public VisitorResult visit(ConditionalStatement conditionalStatement) {
		return null;
	}

	@Override
	public VisitorResult visit(TypeDescription typeDescription) {
		return null;
	}
}
