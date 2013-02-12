package org.uva.sea.ql.visitor.renderer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.ast.stmt.question.Question;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.visitor.IFormVisitor;
import org.uva.sea.ql.visitor.valueCheck.ValueMapper;

public class FormRenderer implements IFormVisitor {
	private STGroup formTemplate = new STGroupFile(System.getProperty("user.dir") + "/files/templates/page.stg", '$', '$');
	private String formContent = "";
	private ValueMapper valueMapper;
	private List<Message> errors;

	public FormRenderer(ValueMapper valueMapper, List<Message> errors) {
		this.valueMapper = valueMapper;
		this.errors = new ArrayList<Message>();
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) {
		addQuestionToFormContent(computedQuestion, true);
	}

	@Override
	public void visit(NormalQuestion question) {
		addQuestionToFormContent(question, false);
	}

	@Override
	public void visit(IfThen ifThen) {
		addExpressionToFormContent(ifThen.getCondition());
		
		openBlock("if_" + ifThen.hashCode());
		for (Statement stmt : ifThen.getIfBlock()) {
			stmt.accept(this);
		}
		closeBlock();
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		addExpressionToFormContent(ifThenElse.getCondition());
		
		openBlock("if_" + ifThenElse.hashCode());
		for (Statement stmt : ifThenElse.getIfBlock()) {
			stmt.accept(this);
		}
		closeBlock();
		openBlock("else_" + ifThenElse.hashCode());
		for (Statement stmt : ifThenElse.getElseBlock()) {
			stmt.accept(this);
		}
		closeBlock();
	}

	@Override
	public void visit(Form form) {
		// dummy/test code
		ST qlPage = formTemplate.getInstanceOf("page");
				
//		TODO add script
//		qlPage.add("script", "");
			
		for (Statement stmt : form.getStatements()) {
			stmt.accept(this);
		}
		
		qlPage.add("formContent", getFormContent());
		
		// render form
		System.out.print(qlPage.render());
		// TODO REMOVE THIS DEBUG FILE ABOVE
		writeOutputToFile(qlPage.render(), "form.html");
	}
	
	private void addQuestionToFormContent(Question question, Boolean isReadOnly) {
		ST qlQuestion = formTemplate.getInstanceOf(question.getType().toString());
		qlQuestion.add("id", question.getId().getName());
		qlQuestion.add("label", question.getLabel());
		qlQuestion.add("readOnly", isReadOnly);
		
		setFormContent(getFormContent() + qlQuestion.render());
	}
	
	private void writeOutputToFile(String output, String fileName) {
		try {
			String file_name = System.getProperty("user.dir")
					+ "/files/output/" + fileName;
			FileWriter file = new FileWriter(file_name);
			BufferedWriter out = new BufferedWriter(file);
			out.write(output);
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void openBlock(String id) {
		ST qlOpenBlock = formTemplate.getInstanceOf("OpenBlock");
		qlOpenBlock.add("id", id);
		addFormContent(qlOpenBlock.render());	
	}
	
	private void closeBlock() {
		addFormContent(formTemplate.getInstanceOf("CloseBlock").render());
	}

	private void addExpressionToFormContent(Expr expr) {
//		expr.accept(this);
		
		System.out.println(formTemplate.getInstanceOf("Expression").render());
		addFormContent(formTemplate.getInstanceOf("Expression").render());
		
	}
	
	private void addFormContent(String html) {
		setFormContent(getFormContent() + html);
	}
	
	public String getFormContent() {
		return formContent;
	}

	public void setFormContent(String formContent) {
		this.formContent = formContent;
	}
}
