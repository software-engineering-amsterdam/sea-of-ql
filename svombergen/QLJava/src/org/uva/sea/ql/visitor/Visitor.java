package org.uva.sea.ql.visitor;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ast.binaryexpr.BinaryExpr;
import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.PrimaryExpr;
import org.uva.sea.ql.ast.statements.IfStatement;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.unaryexpr.UnaryExpr;

public class Visitor {
	protected Map<Ident,Question> identQuestionMap;
	protected Messages 	errorMsgs, 
						warningMsgs;
	
	public Visitor() {
		identQuestionMap = new HashMap<Ident, Question>();
		errorMsgs = new Messages("Errors"); 
		warningMsgs = new Messages("Warnings");
	}

	public void visit(Question q) {
		
	}
	
	public void visit(IfStatement ifStat) {
		
	}
	
	public void visit(BinaryExpr be) {
		
	}
	
	public void visit(UnaryExpr ue) {
		
	}
	
	public void visit(PrimaryExpr pe) {
		
	}

}
