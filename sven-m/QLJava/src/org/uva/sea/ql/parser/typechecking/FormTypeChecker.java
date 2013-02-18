package org.uva.sea.ql.parser.typechecking;

import org.uva.sea.ql.ast.visitor.FormVisitor;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.ElseIfStatement;
import org.uva.sea.ql.ast.form.ElseStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Computed;

public class FormTypeChecker implements FormVisitor<Boolean> {
	
	private Environment environment;
	private ExpressionTypeChecker exprTypeChecker;
	
	public FormTypeChecker(Environment environment) {
		this.environment = environment;
		this.exprTypeChecker = new ExpressionTypeChecker(environment);
	}

	@Override
	public Boolean visit(Form ast) {
		return ast.getBody().accept(this);
	}

	@Override
	public Boolean visit(Body ast) {
		boolean typeCorrect = true;
		
		for (FormElement formElement : ast.getElements()) {
			typeCorrect &= formElement.accept(this);
		}
		
		return typeCorrect;
	}

	@Override
	public Boolean visit(IfStatement ast) {
		boolean typeCorrect =
				ast.getCondition().accept(exprTypeChecker);
		
		for (ElseIfStatement elseIf : ast.getElseIfs()) {
			typeCorrect &= elseIf.accept(this);
		}
		
		typeCorrect &= ast.getElse().accept(this);
		
		return typeCorrect;
	}

	@Override
	public Boolean visit(ElseIfStatement ast) {
		boolean typeCorrect =
				ast.getCondition().accept(exprTypeChecker);
		
		typeCorrect &= ast.getBody().accept(this);
		
		return typeCorrect;
	}

	@Override
	public Boolean visit(ElseStatement ast) {
		return ast.getBody().accept(this);
	}

	@Override
	public Boolean visit(Question ast) {
		return environment.getType(ast.getName()) != null;
	}

	@Override
	public Boolean visit(Computed ast) {
		return environment.getType(ast.getName()) == ast.getType();
	}

}
