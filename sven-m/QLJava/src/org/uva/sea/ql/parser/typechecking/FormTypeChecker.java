package org.uva.sea.ql.parser.typechecking;


import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.visitor.FormVisitor;
import org.uva.sea.ql.ast.form.BoolType;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.ElseIfStatement;
import org.uva.sea.ql.ast.form.ElseStatement;
import org.uva.sea.ql.ast.form.IntType;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.ast.form.StrType;

public class FormTypeChecker implements FormVisitor<Boolean> {
	
	private Environment environment;
	
	public FormTypeChecker(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Boolean visit(Form ast) {
		return ast.getBody().accept(this);
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

	@Override
	public Boolean visit(IntType ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(BoolType ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean visit(StrType ast) {
		// TODO Auto-generated method stub
		return null;
	}

}
