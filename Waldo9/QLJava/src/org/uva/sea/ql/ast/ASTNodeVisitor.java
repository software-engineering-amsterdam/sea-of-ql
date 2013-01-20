package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.And;
import org.uva.sea.ql.ast.expressions.Div;
import org.uva.sea.ql.ast.expressions.Eq;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.GEq;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.ast.expressions.NEq;
import org.uva.sea.ql.ast.expressions.Neg;
import org.uva.sea.ql.ast.expressions.Not;
import org.uva.sea.ql.ast.expressions.Or;
import org.uva.sea.ql.ast.expressions.Pos;
import org.uva.sea.ql.ast.expressions.Sub;
import org.uva.sea.ql.ast.literals.BooleanLiteral;
import org.uva.sea.ql.ast.literals.StringLiteral;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.Question;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;

public interface ASTNodeVisitor {

	public void visit(Form form);

	public void visit(StringLiteral stringLiteral);

	public void visit(BoolType boolType);

	public void visit(IntType intType);

	public void visit(StringType stringType);

	public void visit(Block block);

	public void visit(IfThenElse ifThenElse);

	public void visit(Question question);

	public void visit(Add add);

	public void visit(And and);

	public void visit(Div div);

	public void visit(Eq eq);

	public void visit(GEq gEq);

	public void visit(GT gt);

	public void visit(Ident ident);

	public void visit(Int int1);

	public void visit(LEq lEq);

	public void visit(LT lt);

	public void visit(Mul mul);

	public void visit(Neg neg);

	public void visit(NEq nEq);

	public void visit(Not not);

	public void visit(Or or);

	public void visit(Pos pos);

	public void visit(Sub sub);

	public void visit(Expr expr);

	public void visit(BooleanLiteral booleanLiteral);

}
