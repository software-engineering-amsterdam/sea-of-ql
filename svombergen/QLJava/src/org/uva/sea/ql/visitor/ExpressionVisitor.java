package org.uva.sea.ql.visitor;

import java.util.Map;

import org.uva.sea.ql.ast.binaryexpr.*;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.unaryexpr.*;
import org.uva.sea.ql.ast.primaryexpr.*;

public class ExpressionVisitor extends Visitor {
	
	public ExpressionVisitor() {
		super();
	}
	
	public ExpressionVisitor(Map<Ident,Question> map, Messages errMsgs, Messages warnMsgs) {
		identQuestionMap = map;
		errorMsgs = errMsgs;
		warningMsgs = warnMsgs;
	}
	
	public void visit(BinaryExpr be) {
		
		be.getLeft().accept(this);
		be.getRight().accept(this);
		
		System.out.println("BinaryExpr visited: " + be);
	}
	
	public void visit(UnaryExpr ue) {
		ue.getExpr().accept(this);
		
		System.out.println("unary visited: " + ue);
	}
	
	public void visit(PrimaryExpr pe) {
		System.out.println("primary visited: " + pe);
	}
	
	public void visit(Ident id) {
		if ( !identQuestionMap.containsKey(id) )
			errorMsgs.add(String.format("Undefined variable: %s", id));
	}
	
	public boolean visit(Add exp) {
		return exp.isNumeric();
	}
}
