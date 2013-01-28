package org.uva.sea.ql.generation.html;

import java.util.List;

import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.generation.GeneratorException;
import org.uva.sea.ql.visitor.QLDocument;
import org.uva.sea.ql.visitor.Registry;

public class HTMLDocument implements QLDocument {
	private Registry registry;
	private String heading;
	private StringBuilder body;
	private StringBuilder script;

	private Templates templates;

	public HTMLDocument() throws GeneratorException {
		this.body = new StringBuilder();
		this.script = new StringBuilder();
		this.templates = new Templates("templates/");
		this.registry = new Registry();
	}

	private void appendToBody(String s) {
		body.append(s);
	}

	private void appendToScript(String s) {
		script.append(s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.uva.sea.ql.generation.IDocumentBuilder#getOutput()
	 */
	@Override
	public String getOutput() {
		return templates.document(heading, body.toString(), script.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.uva.sea.ql.generation.IDocumentBuilder#setHeading(java.lang.String)
	 */
	@Override
	public void setHeading(String content) {
		heading = content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.uva.sea.ql.generation.IDocumentBuilder#appendQuestion(org.uva.sea
	 * .ql.ast.elements.Question)
	 */
	@Override
	public void appendQuestion(Question question) {
		registry.addQuestion(question);
		Type type = question.getType();
		String name = question.getIdentName();
		String input = new String();
		if (type instanceof BooleanType) {
			input = templates.input(name, InputTypes.BOOLEAN);
		}
		if (type instanceof Money) {
			input = templates.input(name, InputTypes.MONEY);
		}
		if (type instanceof StrType) {
			input = templates.input(name, InputTypes.STRING);
		}
		appendToBody(templates
				.question(question.getContent().toString(), input));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.uva.sea.ql.generation.IDocumentBuilder#beginIf(org.uva.sea.ql.ast
	 * .elements.IfStatement)
	 */
	@Override
	public void beginIf(IfStatement ifStatement) {
		registry.addIfStatement(ifStatement);
		appendToBody(templates.hiddenStart(String.valueOf(ifStatement
				.hashCode())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.uva.sea.ql.generation.IDocumentBuilder#endIf()
	 */
	@Override
	public void endIf() {
		appendToBody(templates.hiddenEnd());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.uva.sea.ql.generation.IDocumentBuilder#create(java.util.List,
	 * java.util.List)
	 */
	@Override
	public void create() {
		for (Question q : registry.getQuestions()) {
			this.addGetter(q);
		}
		for (IfStatement i : registry.getIfStatements()) {
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
		String getter = new String();
		if (q.getType().getClass().equals(BooleanType.class)) {
			getter = templates.getterBool(q.getIdentName());
		}
		if (q.getType().getClass().equals(Money.class)) {
			getter = templates.getterMoney(q.getIdentName());
		}
		if (q.getType().getClass().equals(StrType.class)) {
			getter = templates.getterString(q.getIdentName());
		}
		this.appendToScript(getter);
	}

	/**
	 * Returns a string representing the given Expression, eg. "((1 + 5) > 1)".
	 * Accepts any BinaryExpr using toString() as tree nodes (recursive).
	 * Supports Ident, IntLiteral and StringLiteral as leaves. Ident will be
	 * represented by a function call, eg.
	 * "(hasBoughtHouse() && valueResidue() < 4000)"
	 * 
	 * @param expression
	 * @return a string representing the expression
	 */
	private static String getConditionString(Expr expression) {
		StringBuilder ret = new StringBuilder();

		if (expression.getClass().equals(Ident.class)) {
			ret.append(((Ident) expression).getName());
			ret.append("()");
		}
		if (expression instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) expression;
			ret.append("(");
			ret.append(getConditionString(b.getLeft()));
			ret.append(" ");
			ret.append(b.toString());
			ret.append(" ");
			ret.append(getConditionString(b.getRight()));
			ret.append(")");
		}
		if (expression instanceof IntLiteral) {
			ret.append(((IntLiteral) expression).getValue());
		}
		if (expression instanceof StringLiteral) {
			ret.append(((StringLiteral) expression).getValue());
		}
		return ret.toString();
	}
}
