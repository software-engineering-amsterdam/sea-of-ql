package org.uva.sea.ql.interpreter;

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

class DocumentBuilder {

	private final String CHECKBOX = "checkbox";
	private final String TEXT = "text";
	private String heading;
	private StringBuilder body;
	private StringBuilder script;

	private Templates templates;

	public DocumentBuilder() throws InterpreterException {
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
		return templates.document(heading,
				body.toString(), script.toString());
	}

	public void setHeading(String content) {
		heading = content;
	}

	public void appendQuestion(Question question) {
		Type type = question.getType();
		String name = question.getIdent().getName();
		String input = "";
		if (type instanceof BooleanType) {
			input = templates.input(name, CHECKBOX);
		}
		if (type instanceof Money || type instanceof StrType) {
			input = templates.input(name, TEXT);
		}
		appendToBody(templates.question(question.getContent().toString(),
				input));
	}

	public void beginIf(IfStatement ifStatement) {
		appendToBody(templates.hiddenStart(String.valueOf(ifStatement.hashCode())));
	}

	public void endIf() {
		appendToBody(templates.hiddenEnd());
	}

	public void create(List<IfStatement> ifStatements, List<Question> questions) {
		for (Question q : questions) {
			this.addGetter(q);
		}
		for (IfStatement i : ifStatements) {
			appendToScript(templates.evaluator(String.valueOf(i.hashCode()),
					getConditionString(i.getCondition())));
			List<Ident> idents = i.getIdents();
			for (Ident ident : idents) {
				this.appendToScript(templates.listener(ident.getName(),
						String.valueOf(i.hashCode())));
			}
		}
	}

	private void addGetter(Question q) {
		String getter = "";
		if (q.getType().getClass().equals(BooleanType.class)) {
			getter = templates.getterBool(q.getIdent().getName());
		}
		if (q.getType().getClass().equals(Money.class)) {
			getter = templates.getterMoney(q.getIdent().getName());
		}
		if (q.getType().getClass().equals(StrType.class)) {
			getter = templates.getterString(q.getIdent().getName());
		}
		this.appendToScript(getter);
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
