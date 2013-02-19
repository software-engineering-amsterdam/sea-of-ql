package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.ast.nodes.types.*;
import org.uva.sea.ql.ast.nodes.types.Float;
import org.uva.sea.ql.ast.expressions.*;

public interface Visitor {
	// Statements
	public void visit(Question question);
	public void visit(Block block);
	public void visit(Condition condition);
	public void visit(ConditionalStatement conditionalStatement);
	public void visit(Form form);
	public void visit(QuestionBody questionBody);
	public void visit(Statement statement);
	// Expressions
	/*
	public void visit(Add add);
	public void visit(And and);
	public void visit(Div div);
	public void visit(Eq eq);
	public void visit(GEq geq);
	public void visit(GT gt);
	public void visit(LEq leq);
	public void visit(LT lt);
	public void visit(Mul mul);
	public void visit(Neg neg);
	public void visit(NEq neq);
	public void visit(Not not);
	public void visit(Or or);
	public void visit(Pos pos);
	public void visit(Sub sub);
	*/
	public void visit(Expr expr);
	public void visit(Bool bool);
	public void visit(Int bool);
	public void visit(Str bool);
	public void visit(Float bool);
	public void visit(Money bool);
	
}
