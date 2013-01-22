package org.uva.sea.ql.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;

class Document {

	private final String CHECKBOX = "checkbox";
	private final String TEXT = "text";
	private String heading;
	private StringBuilder body;
	private StringBuilder script;
	private Templates templates;

	public Document() throws InterpreterException {
		this.body = new StringBuilder();
		this.script = new StringBuilder();
		this.templates = new Templates("templates/");
	}

	private void appendToBody(String s) {
		body.append(s);
	}

	private void appendToScript(String s) {
		script.append(s);
	}

	public String getOutput() {
		return templates.getDocument(heading, body.toString(),
				script.toString());
	}

	public void setHeading(String content) {
		this.heading = content;
	}

	public void appendQuestion(Question question) {
		Type type = question.getType();
		String name = question.getIdent().getName();
		String input = "";
		if (type instanceof BooleanType) {
			input = templates.getInput(name, CHECKBOX);
		}
		if (type instanceof Money || type instanceof StrType) {
			input = templates.getInput(name, TEXT);
		}
		appendToBody(templates.getQuestion(question.getContent().toString(),
				input));
	}

	public void beginIf(String id) {
		appendToBody(templates.startDiv(id));
	}

	public void endIf() {
		appendToBody(templates.endDiv());
	}

	public void create(List<IfStatement> ifStatements,
			List<Question> questions) {
		for (Question q : questions) {
			this.appendQuestion(q);
			this.addGetter(q);
		}
		for (IfStatement i : ifStatements) {
			
			List<Ident> idents = getIdents(i.getCondition());
			for (Ident ident : idents) {
				this.appendToScript(templates.getListener(ident.getName(), String.valueOf(i.hashCode())));
			}
		}
		for (IfStatement i : ifStatements) {
			appendToScript(templates.getEvaluator(String.valueOf(i.hashCode()),
					getConditionString(i.getCondition())));
		}
	}

	private void addGetter(Question q) {
		String getter = "";
		if (q.getType().getClass().equals(BooleanType.class)) {
			getter = templates.getGetterBool(q.getIdent().getName());
		}
		if (q.getType().getClass().equals(Money.class)) {
			getter = templates.getGetterMoney(q.getIdent().getName());
		}
		if (q.getType().getClass().equals(StrType.class)) {
			getter = templates.getGetterString(q.getIdent().getName());
		}
		this.appendToScript(getter);
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
	
	private String getConditionString(Expr i) {
		String ret = "";

		if (i.getClass().equals(Ident.class)) {
			ret = ((Ident) i).getName() + "()";
		}
		if (i instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) i;
			ret += "(" + getConditionString(b.getLeft()) + " " + b.toString()
					+ " " + getConditionString(b.getRight()) + ")";
		}
		if (i instanceof IntLiteral) {
			ret += ((IntLiteral) i).getValue();
		}
		if (i instanceof StringLiteral) {
			ret += ((StringLiteral) i).getValue();
		}
		return ret;
	}
}
