package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.arithmetic.Add;
import org.uva.sea.ql.ast.operators.arithmetic.Div;
import org.uva.sea.ql.ast.operators.arithmetic.Mul;
import org.uva.sea.ql.ast.operators.arithmetic.Sub;
import org.uva.sea.ql.ast.operators.conditional.And;
import org.uva.sea.ql.ast.operators.conditional.Or;
import org.uva.sea.ql.ast.operators.relational.Eq;
import org.uva.sea.ql.ast.operators.relational.GEq;
import org.uva.sea.ql.ast.operators.relational.GT;
import org.uva.sea.ql.ast.operators.relational.LEq;
import org.uva.sea.ql.ast.operators.relational.LT;
import org.uva.sea.ql.ast.operators.relational.NEq;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.literals.BooleanLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

public interface ExpressionTypeVisitor {

	Type visit(BooleanLiteral booleanLiteral);
	Type visit(IntLiteral integerLiteral);
	Type visit(StringLiteral stringLiteral);

	Type visit(Identifier identifier);
	
	Type visit(Add add);
	Type visit(Div div);
	Type visit(Sub sub);
	Type visit(Mul mul);
	
	Type visit(And and);
	Type visit(Or or);
	
	Type visit(Eq eq);
	Type visit(GEq gEq);
	Type visit(GT gT);
	Type visit(LEq lEq);
	Type visit(LT lT);
	Type visit(NEq nEq);
	
	Type visit(Neg neg);
	Type visit(Not not);
	Type visit(Pos pos);
}
