package org.uva.sea.ql.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.Registry;
import org.uva.sea.ql.visitor.VisitorException;

public class HTMLVisitor implements ASTVisitor {
	private Registry registry;
	private HTML html;

	public HTMLVisitor() {
		this.registry = new Registry();
		this.html = new HTML();
	}

	@Override
	public void visit(Form form) throws VisitorException {
		html.startDocument();
		html.addH1(form.getName());
		form.getBlock().accept(this);
		this.visit(registry);
		html.endDocument();
	}

	@Override
	public void visit(Block block) throws VisitorException {
		for (Expr e : block.getContent()) {
			if (e.getClass().equals(IfStatement.class)) {
				IfStatement i = (IfStatement) e;
				html.startDiv();
				i.accept(this);
				html.endDiv();
			}
			if (e.getClass().equals(Question.class)) {
				Question q = (Question) e;
				html.startDiv();
				q.accept(this);
				html.endDiv();
			}
		}
	}

	@Override
	public void visit(Question question) {
		registry.addQuestion(question);
		html.addQuestion(question);
	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		registry.addIfStatement(ifStatement);
		html.startDiv("question", String.valueOf(ifStatement.hashCode()), false);
		ifStatement.getContent().accept(this);
		html.endDiv();
	}

	public String getOutput() {
		return html.getOutput();
	}

	private void visit(Registry reg) {
		html.startScript("text/javascript");
		html.addToggleFunction();
		html.addJsComment("getters");
		for (Question q : reg.getQuestions()) {
			html.addGetter(q);
		}

		html.addJsComment("listeners");
		for (IfStatement i : reg.getIfStatements()) {
			List<Ident> idents = getIdents(i.getCondition());
			for (Ident ident : idents) {
				html.addListener(ident.getName(), String.valueOf(i.hashCode()));
			}
		}
		html.addJsComment("evaluators");
		for (IfStatement i : reg.getIfStatements()) {
			html.addEvaluator(i, reg);
		}
		
		html.endScript();
	}	

	private List<Ident> getIdents(Expr e) {
		List<Ident> idents = new ArrayList<>();
		if (e.getClass().equals(Ident.class)) {
			idents.add((Ident) e);
		}
		if (e instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) e;
			idents.addAll(getIdents(b.getLeft()));
			idents.addAll(getIdents(b.getRight()));
		}
		return idents;
	}
}
