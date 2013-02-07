package org.uva.sea.ql;

import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmnt.Body;
import org.uva.sea.ql.ast.stmnt.ComputedQuestion;
import org.uva.sea.ql.ast.stmnt.IfStatement;
import org.uva.sea.ql.ast.stmnt.Question;
import org.uva.sea.ql.ast.stmnt.Statement;

public class Interpreter extends ASTVisitor {

	@Override
	public boolean visit(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(ComputedQuestion computedQuestion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Body body) {
		
		List<Statement> statements = body.getStatements();
		
		for (Statement statement : statements) {
			statement.accept(this);
		}
		
		return true;
	}

	@Override
	public boolean visit(Form form) {
		form.getBody().accept(this);
		return true;
	}

}
