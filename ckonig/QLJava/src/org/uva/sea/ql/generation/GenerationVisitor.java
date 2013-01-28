package org.uva.sea.ql.generation;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.Registry;
import org.uva.sea.ql.visitor.VisitorException;

public class GenerationVisitor implements ASTVisitor {
	private Registry registry;
	private DocumentBuilder document;

	public GenerationVisitor(DocumentBuilder document) throws VisitorException {
		this.registry = new Registry();
		this.document = document;
	}

	@Override
	public void visit(Form form) throws VisitorException {
		document.setHeading(form.getName());
		form.getBlock().accept(this);
		document.create(registry.getIfStatements(), registry.getQuestions());
	}

	@Override
	public void visit(Block block) throws VisitorException {
		for (Expr e : block.getContent()) {
			if (e.getClass().equals(IfStatement.class)) {
				IfStatement i = (IfStatement) e;
				i.accept(this);
			}
			if (e.getClass().equals(Question.class)) {
				Question q = (Question) e;
				q.accept(this);
			}
		}
	}

	@Override
	public void visit(Question question) {
		registry.addQuestion(question);
		document.appendQuestion(question);
	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		registry.addIfStatement(ifStatement);
		document.beginIf(ifStatement);
		ifStatement.getContent().accept(this);
		document.endIf();
	}

	public String getOutput() {
		return document.getOutput();
	}
}
