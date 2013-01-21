package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.TypeDeclaration;

public interface SyntaxTreeVisitor {
	//base type
	void visit(Node element);
	//base expressions
	void visit(Expression element);
	void visit(Binary element);
	void visit(Simple element);
	void visit(Unary element);
	
	//expressions - binary - arithmetic
	void visit(Arithmetic element);
	void visit(Addition element);
	void visit(Division element);
	void visit(Multiplication element);
	void visit(Subtraction element);
	
	//expressions - binary - comparisons
	void visit(Comparison element);
	void visit(Equals element);
	void visit(GreaterThan element);
	void visit(GreaterThanOrEquals element);
	void visit(LessThan element);
	void visit(LessThanOrEquals element);
	void visit(NotEquals element);
	
	//expressions - binary - logical
	void visit(Logical element);
	void visit(And element);
	void visit(Or element);
	void visit(Xor element);
	
	//expressions - simple
	void visit(Literal element);
	void visit(NumberLiteral element);
	void visit(BooleanLiteral element);
	void visit(IntegerLiteral element);
	void visit(MoneyLiteral element);
	void visit(StringLiteral element);
	
	//expressions - unary
	void visit(UnaryNumeric element);
	void visit(UnaryNot element);
	void visit(UnaryMinus element);
	void visit(UnaryPlus element);
	
	//type declaration	
	void visit(TypeDeclaration element);
	
	//statements
	void visit(Statement element);
	void visit(Form element);
	void visit(If element);
	void visit(Question element);
	void visit(Statements element);
	
}
