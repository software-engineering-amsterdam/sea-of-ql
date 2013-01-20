package org.uva.sea.ql.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpr;

public class SemanticVisitor implements ASTVisitor {
	
	private final List<Ident> identityList = new ArrayList<Ident>();

	@Override
	public void visit(Form form) throws SemanticException {
		form.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement statement) throws SemanticException {
		Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
	}

	@Override
	public void visit(Question question) throws SemanticException {
		identityList.add(question.getIdent());
	}

	@Override
	public void visit(IfStatement statement) throws SemanticException {
		statement.getExpr().accept(this);
		statement.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(BinaryExpr expression) throws SemanticException {
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
	}

	@Override
	public void visit(UnaryExpr expression) throws SemanticException {
		expression.getExpr().accept(this);
	}

	@Override
	public void visit(Ident ident) throws SemanticException {
		if(!this.identityList.contains(ident)){
			throw new SemanticException("Undefined identity '" + ident.getName() + "'");
		}
	}

	@Override
	public void visit(Literal literal) throws SemanticException {
		
	}
	
}