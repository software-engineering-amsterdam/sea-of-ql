package org.uva.sea.ql.ast.traversal.base;

import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.*;

/**
 * Interface for the visitor that traverses all nodes in the abstract syntax tree
 */
public interface IVisitor {
	// Binary operators
	void visit(Add add);
	void visit(And and);
	void visit(Div div);
	void visit(Eq eq);
	void visit(GEq geq);
	void visit(GT gt);
	void visit(LEq leq);
	void visit(LT lt);
	void visit(Mul mul);
	void visit(NEq neq);
	void visit(Or or);
	void visit(Sub sub);
	
	// Unary operators
	void visit(Neg neg);
	void visit(Not not);
	void visit(Pos pos);
	
	// Form
	void visit(Computation computation);
	void visit(Form form);
	void visit(Question question);
	void visit(Label label);
	
	// Conditionals
	void visit(IfThen ifThen);
	void visit(IfThenElse ifThenElse);

	// Types
	void visit(Bool bool);
	void visit(Int i);
	void visit(Money money);
	void visit(StringLiteral literal);
	void visit(Ident ident);
}
