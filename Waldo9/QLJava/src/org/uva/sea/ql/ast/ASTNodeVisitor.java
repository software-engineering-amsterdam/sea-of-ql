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
import org.uva.sea.ql.ast.types.ErrorType;

public interface ASTNodeVisitor<T> {

	public T visit(Form form);

	public T visit(StringLiteral stringLiteral);

	public T visit(BoolType boolType);

	public T visit(IntType intType);

	public T visit(StringType stringType);

	public T visit(Block block);

	public T visit(IfThenElse ifThenElse);

	public T visit(Question question);

	public T visit(Add add);

	public T visit(And and);

	public T visit(Div div);

	public T visit(Eq eq);

	public T visit(GEq gEq);

	public T visit(GT gt);

	public T visit(Ident ident);

	public T visit(Int int1);

	public T visit(LEq lEq);

	public T visit(LT lt);

	public T visit(Mul mul);

	public T visit(Neg neg);

	public T visit(NEq nEq);

	public T visit(Not not);

	public T visit(Or or);

	public T visit(Pos pos);

	public T visit(Sub sub);

	public T visit(Expr expr);

	public T visit(BooleanLiteral booleanLiteral);

	public T visit(ErrorType error);

}
