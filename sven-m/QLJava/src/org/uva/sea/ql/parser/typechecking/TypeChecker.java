package org.uva.sea.ql.parser.typechecking;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Int;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Str;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.ElseIfStatement;
import org.uva.sea.ql.ast.form.ElseStatement;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.visitor.ExpressionVisitor;
import org.uva.sea.ql.ast.visitor.FormVisitor;

public class TypeChecker implements FormVisitor<Boolean>,
	ExpressionVisitor<Boolean>
{

	@Override
	public Boolean visit(Add ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Mul ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Div ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Sub ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(And ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Or ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(LEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Eq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(NEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GEq ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(GT ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Pos ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Neg ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Not ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Ident ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Int ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Str ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Form ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Body ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(IfStatement ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ElseIfStatement ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(ElseStatement ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Question ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(Computed ast) {
		// TODO Auto-generated method stub
		return null;
	}

}
