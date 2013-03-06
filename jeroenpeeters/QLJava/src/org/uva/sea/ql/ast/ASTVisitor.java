package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.binary.Add;
import org.uva.sea.ql.ast.expression.binary.And;
import org.uva.sea.ql.ast.expression.binary.Div;
import org.uva.sea.ql.ast.expression.binary.Eq;
import org.uva.sea.ql.ast.expression.binary.GEq;
import org.uva.sea.ql.ast.expression.binary.GT;
import org.uva.sea.ql.ast.expression.binary.LEq;
import org.uva.sea.ql.ast.expression.binary.LT;
import org.uva.sea.ql.ast.expression.binary.Mul;
import org.uva.sea.ql.ast.expression.binary.NEq;
import org.uva.sea.ql.ast.expression.binary.Or;
import org.uva.sea.ql.ast.expression.binary.Sub;
import org.uva.sea.ql.ast.expression.literal.Literal;
import org.uva.sea.ql.ast.expression.unary.Neg;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Pos;

public interface ASTVisitor {
	
	//void visit(ASTNode node);
		
	void visit(Form form);
	
	void visit(CompoundStatement statement);
	
	void visit(Question question);
	
	void visit(IfStatement statement);
	
	void visit(IfElseStatement statement);
	
	void visit(Identifier identifier);

	void visit(Literal literal);

	// Binary expressions

	void visit(Add expression);

	void visit(Div expression);

	void visit(Mul expression);

	void visit(Sub expression);

	void visit(And expression);

	void visit(Eq expression);

	void visit(GEq expression);

	void visit(LEq expression);

	void visit(GT expression);
	
	void visit(LT expression);

	void visit(NEq expression);

	void visit(Or expression);

	// Unary

	void visit(Neg expression);

	void visit(Pos expression);

	void visit(Not expression);
	
}
