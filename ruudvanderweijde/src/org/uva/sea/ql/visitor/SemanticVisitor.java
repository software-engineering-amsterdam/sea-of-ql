package org.uva.sea.ql.visitor;

import java.util.HashMap;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Binary;
import org.uva.sea.ql.ast.expr.primary.Bool;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.expr.primary.StringLiteral;
import org.uva.sea.ql.ast.expr.unary.Unary;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Statement;

class SemanticVisitor implements Visitor {
	private HashMap<String, Statement> symbolTable = new HashMap<String, Statement>();
	
	public SemanticVisitor() {
		
	}

	@Override
	public void visit(Form form) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Binary binary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Unary unary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Question question) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void visit(Statement statement) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void visit(Ident ident) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Bool bool) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Int integer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StringLiteral stringLiteral) {
		// TODO Auto-generated method stub
		
	}
}
