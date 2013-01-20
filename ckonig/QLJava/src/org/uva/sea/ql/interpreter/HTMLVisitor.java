package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.bool.BinaryBoolOperator;
import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.math.BinaryMathOperator;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.Registry;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HTMLVisitor implements ASTVisitor {
	private Registry registry;
	private static final String head = "<!DOCTYPE html><html><head><style>.question {padding-left:20px; height:30px; width:600px;}.q_text{float:left;} .q_input{float:right;clear: right;} .content_below{clear:both;}</style></head><body>";
	private static final String jquery = "<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\" type=\"text/javascript\"></script>";

	public HTMLVisitor() {
		this.registry = new Registry();
	}

	@Override
	public void visit(Form form) {
		registry.appendToOutput(head);
		registry.appendToOutput(jquery);
		registry.appendToOutput("<h1>" + form.getName() + "</h1>");
		form.getBlock().accept(this);
		registry.accept(this);
		registry.appendToOutput("</body></html>");
	}

	@Override
	public void visit(Block block) {
		for (Expr e : block.getContent()) {
			if (e.getClass().equals(IfStatement.class)) {
				IfStatement i = (IfStatement) e;
				registry.appendToOutput("<div>");
				i.accept(this);
				registry.appendToOutput("</div>");
			}
			if (e.getClass().equals(Question.class)) {
				Question q = (Question) e;
				registry.appendToOutput("<div>");
				q.accept(this);
				registry.appendToOutput("</div>");
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
		if (type instanceof Bool) {
			registry.appendToOutput("<input id=\"question_" + name
					+ "\" type=\"checkbox\" class=\"qlinput\" name=\"" + name
					+ "\"/>");
		}
		if (type instanceof Money) {
			registry.appendToOutput("<input type=\"text\" id=\"question_" + name
					+ "\"  class=\"qlinput\" name=\"" + name + "\"/>");
		}
		if (type instanceof StrType) {
			registry.appendToOutput("<input type=\"text\" id=\"question_" + name
					+ "\" name=\"" + name + "\"></input>");
		}
		registry.appendToOutput("</div></div><div id=\"content-below\">&nbsp;</div>");
	}

	@Override
	public void visit(IfStatement ifStatement) {
		registry.addIfStatement(ifStatement);
		registry.appendToOutput("<div style=\"display:none;\" id=\"if_"
				+ ifStatement.hashCode() + "\" class=\"question\">");
		ifStatement.getContent().accept(this);
		registry.appendToOutput("</div>");
	}

	@Override
	public void visit(Ident ident) {
		throw new NotImplementedException();
	}

	@Override
	public void visit(BinaryBoolOperator op) {
		throw new NotImplementedException();
	}

	@Override
	public void visit(BinaryMathOperator op) {
		throw new NotImplementedException();
	}

	public String getOutput() {
		return registry.getOutput();
	}

	@Override
	public void visit(Registry reg) {
		registry.appendToOutput("<script type=\"text/javascript\">");
		for (IfStatement i : reg.getIfStatements()) {
			if (i.getCondition().getClass().equals(Ident.class)) {
				Ident id = (Ident) i.getCondition();
				for (Question q : reg.getQuestions()) {
					if (q.getIdent().getName().equals(id.getName())) {
						if (q.getType() instanceof Bool) {
							registry.appendToOutput("$('#question_"
									+ id.getName()
									+ "').change(function(){if($(this).attr('checked')=='checked'){$('#if_"
									+ i.hashCode() + "').show();}else{$('#if_"
									+ i.hashCode() + "').hide();}});\n");
						}
					}
				}
			}
		}
		registry.appendToOutput("</script>");
	}

}
