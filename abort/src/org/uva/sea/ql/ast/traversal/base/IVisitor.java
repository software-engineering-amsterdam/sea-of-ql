package org.uva.sea.ql.ast.traversal.base;

import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.types.*;

public interface IVisitor {
	// Binary operators
	void visit(final Add add);
	void visit(final And and);
	void visit(final Div div);
	void visit(final Eq eq);
	void visit(final GEq geq);
	void visit(final GT gt);
	void visit(final LEq leq);
	void visit(final LT lt);
	void visit(final Mul mul);
	void visit(final NEq neq);
	void visit(final Or or);
	void visit(final Sub sub);
	
	// Unary operators
	void visit(final Neg neg);
	void visit(final Not not);
	void visit(final Pos pos);
	
	// Form
	void visit(final Computation computation);
	void visit(final Form form);
	void visit(final Question question);
	void visit(final Label label);
	
	// Conditionals
	void visit(final IfThen ifThen);
	void visit(final IfThenElse ifThenElse);

	// Types
	void visit(final Bool bool);
	void visit(final Int i);
	void visit(final Money money);
	void visit(final StringLiteral literal);
	void visit(final Ident ident);
}
