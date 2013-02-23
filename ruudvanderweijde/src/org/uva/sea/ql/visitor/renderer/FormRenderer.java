package org.uva.sea.ql.visitor.renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.primary.Ident;
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
	private STGroup formTemplate;
	private String formContent = "";
	private String scriptFunctions = "";
	private String scriptCommands = "";
	private String output = "";
	private ValueMapper valueMapper;
	private List<Message> errors;

	public FormRenderer(ValueMapper valueMapper, List<Message> errors, String stgFilePath) {
		this.valueMapper = valueMapper;
		this.errors = new ArrayList<Message>();
		this.formTemplate = new STGroupFile(stgFilePath + "/page.stg", '$', '$');
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) {
		addQuestionToFormContent(computedQuestion, true);
		addComputationToFormContent(computedQuestion.getExpr(), computedQuestion.getId(),
				getUniqueString());
	}

	@Override
	public void visit(NormalQuestion question) {
		addQuestionToFormContent(question, false);
	}

	@Override
	public void visit(IfThen ifThen) {
		final String id = getUniqueString();

		Expr expr = ifThen.getCondition();
		addConditionToFormContent(expr, id);

		openBlock("if_" + id);
		for (Statement stmt : ifThen.getIfBlock()) {
			stmt.accept(this);
		}
		closeBlock();
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		final String id = getUniqueString();

		Expr expr = ifThenElse.getCondition();
		addConditionToFormContent(expr, id);

		openBlock("if_" + id);
		for (Statement stmt : ifThenElse.getIfBlock()) {
			stmt.accept(this);
		}
		closeBlock();
		openBlock("else_" + id);
		for (Statement stmt : ifThenElse.getElseBlock()) {
			stmt.accept(this);
		}
		closeBlock();
	}

	@Override
	public void visit(Form form) {

		ST qlPage = formTemplate.getInstanceOf("page");

		for (Statement stmt : form.getStatements()) {
			stmt.accept(this);
		}

		qlPage.add("scriptFunctions", getScriptFunctions());
		qlPage.add("scriptCommands", getScriptCommands());
		qlPage.add("formContent", getFormContent());
		qlPage.add("formName", form.getId().getName());

		setOutput(qlPage.render());
	}

	private void addQuestionToFormContent(Question question, Boolean isReadOnly) {
		ST qlQuestion = formTemplate.getInstanceOf(question.getType().toString());
		qlQuestion.add("id", question.getId().getName());
		qlQuestion.add("label", question.getLabel());
		qlQuestion.add("readOnly", isReadOnly);

		setFormContent(getFormContent() + qlQuestion.render());
	}


	private void openBlock(String id) {
		ST qlOpenBlock = formTemplate.getInstanceOf("OpenBlock");
		qlOpenBlock.add("id", id);
		addFormContent(qlOpenBlock.render());
	}

	private void closeBlock() {
		addFormContent(formTemplate.getInstanceOf("CloseBlock").render());
	}

	private void addComputationToFormContent(Expr expr, Ident questionId, String uniqueId) {
		String strCondition = getExpressionStringByExpression(expr, uniqueId);

		ST qlCondition = formTemplate.getInstanceOf("Computation");
		qlCondition.add("id", questionId.getName());
		qlCondition.add("uuid", uniqueId);
		qlCondition.add("condition", strCondition);

		addScriptFunction(qlCondition.render());
	}

	private void addConditionToFormContent(Expr expr, String uniqueId) {
		String strCondition = getExpressionStringByExpression(expr, uniqueId);

		ST qlCondition = formTemplate.getInstanceOf("Condition");
		qlCondition.add("id", uniqueId);
		qlCondition.add("condition", strCondition);

		addScriptFunction(qlCondition.render());
	}

	private String getExpressionStringByExpression(Expr expr, String uniqueId) {
		ExpressionRenderer exprRenderer = new ExpressionRenderer();
		String strCondition = expr.accept(exprRenderer);
		for (Ident ident : exprRenderer.getIdents()) {
			ST qlBindIdToFunction = formTemplate.getInstanceOf("BindIdToFunction");
			qlBindIdToFunction.add("id", ident.getName());
			qlBindIdToFunction.add("function", uniqueId);
			addScriptCommand(qlBindIdToFunction.render());
		}
		return strCondition;
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

	public List<Message> getErrors() {
		return errors;
	}

	public ValueMapper getValueMapper() {
		return valueMapper;
	}

	private void addScriptCommand(String html) {
		setScriptCommands(getScriptCommands() + "\n" + html);
	}

	public String getScriptCommands() {
		return scriptCommands;
	}

	public void setScriptCommands(String scriptCommands) {
		this.scriptCommands = scriptCommands;
	}

	private void addScriptFunction(String html) {
		setScriptFunctions(getScriptFunctions() + "\n" + html);
	}

	public String getScriptFunctions() {
		return scriptFunctions;
	}

	public void setScriptFunctions(String scriptFunction) {
		this.scriptFunctions = scriptFunction;
	}

	private String getUniqueString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
}