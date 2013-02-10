package org.uva.sea.ql.visitor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.ast.stmt.question.Question;
import org.uva.sea.ql.value.Value;

public class FormRenderer implements IFormVisitor {
	private STGroup formTemplate = new STGroupFile(System.getProperty("user.dir") + "/files/templates/page.stg", '$', '$');
	private String formContent = "";

	public FormRenderer() {
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) {
		addQuestionFormContent(computedQuestion, true);
	}

	@Override
	public void visit(NormalQuestion question) {
		addQuestionFormContent(question, false);
	}

	@Override
	public void visit(IfThen ifThen) {
//		Value aap = ifThen.getCondition().accept(this);
		ST qlOpenBlock = formTemplate.getInstanceOf("OpenBlock");
		qlOpenBlock.add("id", ifThen.hashCode());
		formContent += qlOpenBlock.render();
		for (Statement stmt : ifThen.getIfBlock()) {
			stmt.accept(this);
		}
		formContent += formTemplate.getInstanceOf("CloseBlock").render();

	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		for (Statement stmt : ifThenElse.getIfBlock()) {
			stmt.accept(this);
		}
		for (Statement stmt : ifThenElse.getElseBlock()) {
			stmt.accept(this);
		}

	}

	@Override
	public void visit(Form form) {
		// dummy/test code
		ST qlPage = formTemplate.getInstanceOf("page");
				
		qlPage.add("script", "");
			
		for (Statement stmt : form.getStatements()) {
			stmt.accept(this);
		}
		
		qlPage.add("formContent", formContent);
		
		// render form
		System.out.print(qlPage.render());
		writeOutputToFile(qlPage.render(), "form.html");
	}
	
	private void addQuestionFormContent(Question question, Boolean isReadOnly) {
		ST qlQuestion = formTemplate.getInstanceOf(question.getType().toString());
		qlQuestion.add("id", question.getId().getName());
		qlQuestion.add("label", question.getLabel());
		qlQuestion.add("readOnly", isReadOnly);
		
		formContent += qlQuestion.render();
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
}
