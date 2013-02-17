package org.uva.sea.ql.core.dom;

import org.uva.sea.ql.core.dom.operators.arithmetic.Add;
import org.uva.sea.ql.core.dom.operators.arithmetic.Div;
import org.uva.sea.ql.core.dom.operators.arithmetic.Mul;
import org.uva.sea.ql.core.dom.operators.arithmetic.Sub;
import org.uva.sea.ql.core.dom.operators.conditional.*;
import org.uva.sea.ql.core.dom.operators.relational.Eq;
import org.uva.sea.ql.core.dom.operators.relational.GEq;
import org.uva.sea.ql.core.dom.operators.relational.GT;
import org.uva.sea.ql.core.dom.operators.relational.LEq;
import org.uva.sea.ql.core.dom.operators.relational.LT;
import org.uva.sea.ql.core.dom.operators.relational.NEq;
import org.uva.sea.ql.core.dom.operators.unary.Neg;
import org.uva.sea.ql.core.dom.operators.unary.Not;
import org.uva.sea.ql.core.dom.operators.unary.Pos;
import org.uva.sea.ql.core.dom.types.primitive.BooleanLiteral;
import org.uva.sea.ql.core.dom.types.primitive.IntLiteral;
import org.uva.sea.ql.core.dom.types.primitive.MoneyLiteral;
import org.uva.sea.ql.core.dom.types.primitive.StringLiteral;

public interface ExpressionVisitor {
	
	// Primitive types
	boolean visit(BooleanLiteral ast);
	boolean visit(Identifier identifier);
	boolean visit(IntLiteral integer);
	boolean visit(MoneyLiteral money);
	boolean visit(StringLiteral str);

	// Arithmetic operators
	boolean visit(Add ast);
	boolean visit(Div ast);
	boolean visit(Sub ast);
	boolean visit(Mul ast);
	
	// Conditional operators
	boolean visit(And ast);
	boolean visit(Or ast);
	
	// Relational operators
	boolean visit(Eq ast);
	boolean visit(GEq ast);
	boolean visit(GT ast);
	boolean visit(LEq ast);
	boolean visit(LT ast);
	boolean visit(NEq ast);
	
	// Unary operators
	boolean visit(Neg ast);
	boolean visit(Not ast);
	boolean visit(Pos ast);
}
