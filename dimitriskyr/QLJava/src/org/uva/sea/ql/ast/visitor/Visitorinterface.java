package org.uva.sea.ql.ast.visitor;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;

public interface Visitorinterface {
	
	
	
	public void visit (Add add);
	
	public void visit (And and);
	
	public void visit (Div div);
	
	public void visit (Eq eq);
	
	public void visit (GEq geq);
	
	public void visit (GT gt);
	
	public void visit (LEq leq);
	
	public void visit (LT lt);
	
	public void visit (Mul mul);
	
	public void visit (Neg neg);
	
	public void visit (NEq neq);
	
	public void visit (Not not);
	
	public void visit (Or or);
	
	public void visit (Pos pos);
	
	public void visit (Sub sub);
	
	public void visit (Form form);
	
	public void visit (ComQuestions comquestions);
	
	public void visit (Ifthen ifthen);
	
	public void visit (Ifthenelse ifthenelse);
	
	public void visit (Questions questions);
	
	public void visit (Bool bool);
	
	public void visit (Ident ident);
	
	public void visit (Int integer);
	
	public void visit (String_lit string_lit);

	public void visit(Expr expr);

	public void visit(Type type);

	public void visit(Statement statement);
	
	public void visit(Question question);
	
	
	
}
