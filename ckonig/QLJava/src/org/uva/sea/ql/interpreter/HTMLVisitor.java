package org.uva.sea.ql.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.AcceptsBoolOperands;
import org.uva.sea.ql.ast.AcceptsBothOperands;
import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.Registry;
import org.uva.sea.ql.visitor.VisitorException;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HTMLVisitor implements ASTVisitor {
	private Registry registry;
	private static final String head = "<!DOCTYPE html><html><head><style>.question {padding-left:20px; height:30px; width:600px;}.q_text{float:left;} .q_input{float:right;clear: right;} .content_below{clear:both;}</style></head><body>\n";
	private static final String jquery = "<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\" type=\"text/javascript\"></script>\n";

	public HTMLVisitor() {
		this.registry = new Registry();
	}

	@Override
	public void visit(Form form) throws VisitorException {
		registry.appendToOutput(head);
		registry.appendToOutput(jquery);
		registry.appendToOutput("<h1>" + form.getName() + "</h1>");
		form.getBlock().accept(this);
		registry.accept(this);
		registry.appendToOutput("</body></html>");
	}

	@Override
	public void visit(Block block) throws VisitorException {
		for (Expr e : block.getContent()) {
			if (e.getClass().equals(IfStatement.class)) {
				IfStatement i = (IfStatement) e;
				registry.appendToOutput("<div>");
				i.accept(this);
				registry.appendToOutput("</div>\n");
			}
			if (e.getClass().equals(Question.class)) {
				Question q = (Question) e;
				registry.appendToOutput("<div>");
				q.accept(this);
				registry.appendToOutput("</div>\n");
			}
		}
	}

	@Override
	public void visit(Question question) {
		registry.addQuestion(question);
		registry.appendToOutput("<div class=\"question\"><div class=\"q_text\">"
				+ question.getContent() + "</div><div class=\"q_input\">");
		Type type = question.getType();
		String name = question.getIdent().getName();
		if (type instanceof BooleanType) {
			registry.appendToOutput("<input id=\"question_" + name
					+ "\" type=\"checkbox\" class=\"qlinput\" name=\"" + name
					+ "\"/>");
		}
		if (type instanceof Money) {
			registry.appendToOutput("<input type=\"text\" id=\"question_"
					+ name + "\"  class=\"qlinput\" name=\"" + name + "\"/>");
		}
		if (type instanceof StrType) {
			registry.appendToOutput("<input type=\"text\" id=\"question_"
					+ name + "\" name=\"" + name + "\"></input>");
		}
		registry.appendToOutput("</div></div>\n<div class=\"content_below\">&nbsp;</div>\n");
	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		registry.addIfStatement(ifStatement);
		registry.appendToOutput("<div style=\"display:none;\" id=\"if_"
				+ ifStatement.hashCode() + "\" class=\"question\">");
		ifStatement.getContent().accept(this);
		registry.appendToOutput("</div>\n");
	}

	public String getOutput() {
		return registry.getOutput();
	}

	@Override
	public void visit(Registry reg) {
		registry.appendToOutput("<script type=\"text/javascript\">");
		registry.appendToOutput("//helper\n"
				+ "function toggleContent(value, id){\n"
				+ "  if( value == true){\n" + "      $('#if_' + id).show();\n"
				+ "  }else{\n" + "      $('#if_' + id).hide();\n" + "  }\n"
				+ " }\n");
		registry.appendToOutput("//getters for " + reg.getQuestions().size()
				+ " questions\n");
		for (Question q : reg.getQuestions()) {
			if (q.getType().getClass().equals(BooleanType.class)) {
				registry.appendToOutput("function " + q.getIdent().getName()
						+ "(){\n" + " return $('#question_"
						+ q.getIdent().getName()
						+ "').attr('checked') == 'checked';\n" + "}\n");
			}
			if (q.getType().getClass().equals(Money.class)) {
				registry.appendToOutput("function " + q.getIdent().getName()
						+ "(){\n" + " return parseFloat($('#question_"
						+ q.getIdent().getName() + "').val());\n" + "}\n");
			}
			if (q.getType().getClass().equals(StrType.class)) {
				registry.appendToOutput("function " + q.getIdent().getName()
						+ "(){\n" + " return $('#question_"
						+ q.getIdent().getName() + "').val();\n" + "}\n");
			}
		}
		registry.appendToOutput("//listeners\n");
		for (IfStatement i : reg.getIfStatements()) {
			List<Ident> idents = getIdents(i.getCondition());
			for (Ident ident : idents) {
				registry.appendToOutput("$('#question_" + ident.getName()
						+ "').change(function(){\n" + "  eval" + i.hashCode()
						+ "();\n" + "  });\n");
			}
		}
		registry.appendToOutput("//evaluators\n");
		for (IfStatement i : reg.getIfStatements()) {
			String eval = getEvaluator(i, reg);
			registry.appendToOutput(eval);
		}
		registry.appendToOutput("</script>");
	}

	private String getEvaluator(IfStatement i, Registry reg) {
		String ret = "function eval" + i.hashCode() + "(){\n"
				+ "   toggleContent(";
		ret += getConditionString(i.getCondition());
		ret += ", '" + i.hashCode() + "');\n" + " }\n";
		return ret;
	}

	private String getConditionString(Expr i) {
		String ret = "";

		if (i.getClass().equals(Ident.class)) {
			ret = ((Ident) i).getName() + "()";
		}
		if (i instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) i;
			ret += "(" + getConditionString(b.getLeft()) + " " + b.toString() + " "
					+ getConditionString(b.getRight()) + ")";
		}
		if (i instanceof IntLiteral) {
			ret += ((IntLiteral) i).getValue();
		}
		if (i instanceof StringLiteral) {
			ret += ((StringLiteral) i).getValue();
		}
		return ret;
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
