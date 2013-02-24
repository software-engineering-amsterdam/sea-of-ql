package org.uva.sea.ql.parser.typechecker;

import org.uva.sea.ql.ast.visitor.FormVisitor;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.ElseIfStatement;
import org.uva.sea.ql.ast.form.ElseStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.Computed;
import org.uva.sea.ql.parser.typechecker.error.VariableRedefinitionError;

public class FormTypeChecker implements FormVisitor<Boolean> {
	
	private Environment environment;
	private ExpressionTypeChecker exprTypeChecker;
	private ExpressionTypeEvaluator exprTypeEval;
	
	public FormTypeChecker(Environment environment) {
		this.environment = environment;
		this.exprTypeChecker = new ExpressionTypeChecker(environment);
		this.exprTypeEval = new ExpressionTypeEvaluator(
				environment.getTypeEnvironment());
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
		
		if (ast.getElse() != null) {
			typeCorrect &= ast.getElse().accept(this);
		}
		
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
		boolean typeCorrect = environment.getType(ast.getIdent()) == null;
		Ident ident = ast.getIdent();
		
		if (typeCorrect) {
			environment.setType(ident, ast.getType());
		} else {
			environment.reportError(
					new VariableRedefinitionError(ident.getName(), ident));
		}
		
		return typeCorrect;
	}

	@Override
	public Boolean visit(Computed ast) {
		boolean typeCorrect = ast.getExpression().accept(exprTypeChecker);
		Ident ident = ast.getIdent();
		
		typeCorrect &=
				ast.getExpression().accept(exprTypeEval).equals(ast.getType());
		
		
		if (environment.getType(ident) == null) {
			environment.setType(ident, ast.getType());
		} else {
			typeCorrect = false;
			environment.reportError(
					new VariableRedefinitionError(ident.getName(), ident));
		}
		
		return typeCorrect;
	}

}
