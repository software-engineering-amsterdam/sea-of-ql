package org.uva.sea.ql.interpreter;

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
import org.uva.sea.ql.visitor.Registry;

public class HTML {
	public static final String CHECKBOX = "checkbox";
	public static final String TEXT = "text";
	private StringBuilder sb;

	public HTML() {
		this.sb = new StringBuilder();
	}

	public void startDocument() {
		this.appendToOutput("<!DOCTYPE html><html><head><style>.question {padding-left:20px; height:30px; width:600px;}.q_text{float:left;} .q_input{float:right;clear: right;} .content_below{clear:both;}</style></head><body>\n");
		this.appendToOutput("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\" type=\"text/javascript\"></script>\n");
	}

	public void endDocument() {
		this.appendToOutput("</body></html>");
	}

	public void startDiv() {
		this.startDiv("");
	}

	public void startDiv(String htmlClass) {
		startDiv(htmlClass, true);
	}

	public void startDiv(String htmlClass, boolean visible) {
		this.appendToOutput("<div class=\"" + htmlClass + "\""
				+ (!visible ? " style=\"display:none;\"" : "") + ">");
	}

	public void startDiv(String htmlClass, String id, boolean visible) {
		this.appendToOutput("<div "
				+ (!visible ? " style=\"display:none;\"" : "") + " id=\"if_"
				+ id + "\" class=\"" + htmlClass + "\">");
	}

	public void endDiv() {
		this.appendToOutput("</div>");
	}

	private void appendToOutput(String s) {
		this.sb.append(s);
	}

	public String getOutput() {
		return sb.toString();
	}

	public void addH1(String content) {
		this.appendToOutput("<h1>" + content + "</h1>");
	}

	public void startScript(String type) {
		this.appendToOutput("<script type=\"" + type + "\">");
	}
	
	public void endScript(){
		this.appendToOutput("</script>");
	}

	public void addInput(String name, String type) {
		this.appendToOutput("<input id=\"question_" + name + "\" type=\""
				+ type + "\" class=\"qlinput\" name=\"" + name + "\"/>");
	}

	public void addQuestion(Question question) {
		startDiv("question");
		startDiv("q_text");
		appendToOutput(question.getContent().getValue());
		endDiv();
		startDiv("q_input");
		Type type = question.getType();
		String name = question.getIdent().getName();
		if (type instanceof BooleanType) {
			addInput(name, HTML.CHECKBOX);
		}
		if (type instanceof Money) {
			addInput(name, HTML.TEXT);
		}
		if (type instanceof StrType) {
			addInput(name, HTML.TEXT);
		}
		endDiv();
		endDiv();
		startDiv("content_below");
		endDiv();
	}

	public void addToggleFunction() {
		appendToOutput("//helper\n" + "function toggleContent(value, id){\n"
				+ "  if( value == true){\n" + "      $('#if_' + id).show();\n"
				+ "  }else{\n" + "      $('#if_' + id).hide();\n" + "  }\n"
				+ " }\n");
	}

	public void addJsComment(String comment) {
		appendToOutput("//" + comment + "\n");
	}

	public void addGetter(Question q) {
		if (q.getType().getClass().equals(BooleanType.class)) {
			this.appendToOutput("function " + q.getIdent().getName() + "(){\n"
					+ " return $('#question_" + q.getIdent().getName()
					+ "').attr('checked') == 'checked';\n" + "}\n");
		}
		if (q.getType().getClass().equals(Money.class)) {
			this.appendToOutput("function " + q.getIdent().getName() + "(){\n"
					+ " return parseFloat($('#question_"
					+ q.getIdent().getName() + "').val());\n" + "}\n");
		}
		if (q.getType().getClass().equals(StrType.class)) {
			this.appendToOutput("function " + q.getIdent().getName() + "(){\n"
					+ " return $('#question_" + q.getIdent().getName()
					+ "').val();\n" + "}\n");
		}
	}
	public void addListener(String name, String id){
		appendToOutput("$('#question_" + name
				+ "').change(function(){\n" + "  eval" + id
				+ "();\n" + "  });\n");
	}
	
	public void addEvaluator(IfStatement i, Registry reg){
		appendToOutput(getEvaluator(i, reg));
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
