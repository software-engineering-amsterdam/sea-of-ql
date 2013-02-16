package org.uva.sea.ql.ui.qlform.interpreter;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.BodyElement;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfThen;
import org.uva.sea.ql.ast.form.IfThenElse;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.SingleLineElement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.launcher.QLInputReader;
import org.uva.sea.ql.ui.qlform.ComputedQuestionPanel;
import org.uva.sea.ql.ui.qlform.QuestionPanel;
import org.uva.sea.ql.ui.qlform.renderer.Renderer;
import org.uva.sea.ql.visitor.IElementVisitor;
import org.uva.sea.ql.visitor.evaluator.ExprEvaluator;

public class SwingGenerator implements IElementVisitor{
	private final List<JPanel> questionPanelList;
	private final Map<String,Value> declaredVar;
	
	
	
	
	public SwingGenerator(List<JPanel> questionPanelList,Map<String,Value> declaredVar){
		this.questionPanelList=questionPanelList;
		this.declaredVar=declaredVar;
		
	}
	
	
	public void generate(Form form, JFrame frame) {
		String formName=form.getId().getName();
		frame.setTitle(formName);
		form.accept(this);
		new Renderer(questionPanelList, frame).addQuestionsToPanel();

	}

	
	public void regenerate(JFrame frame) {
		Form form=QLInputReader.getParsedForm();
		form.accept(this);
		new Renderer(questionPanelList, frame).refresh();

	}

	
	@Override
	public void visit(Form qlElement) {
		qlElement.getBody().accept(this);
	}

	@Override
	public void visit(Body qlElement) {
		List<BodyElement> bodyList = qlElement.getBodyElement();
		for (BodyElement element : bodyList) {
			element.accept(this);
		}

	}

	@Override
	public void visit(Question qlElement) {
		initVar(qlElement);
		addQuestion(qlElement, declaredVar);
	}

	
	@Override
	public void visit(ComputedQuestion qlElement) {
		initVar(qlElement);   
		Value value = ExprEvaluator.eval(qlElement.getExpr(),declaredVar);
		declaredVar.put(qlElement.getId().getName(),value);

		addComputedQuestion(qlElement,declaredVar);

	}
	
	
	@Override
	public void visit(IfThenElse qlElement) {
		Body body = qlElement.getIfBody();
		Body body2 = qlElement.getElseBody();

		Expr condition = qlElement.getCondition();
		Value expr = ExprEvaluator.eval(condition, declaredVar);

		if (!((BoolLit) expr).getValue())
			body2.accept(this);
		else
			body.accept(this);
	}

	@Override
	public void visit(IfThen qlElement) {
		Body body = qlElement.getIfBody();
		Expr condition = qlElement.getCondition();
		Value expr = ExprEvaluator.eval(condition, declaredVar);

		if (!((BoolLit) expr).getValue())
			return;

		body.accept(this);

	}
	
	
	
	private void addQuestion(Question qlElement,Map<String,Value> declaredVar){
		QuestionPanel panel=new QuestionPanel(qlElement,declaredVar);
		questionPanelList.add(panel.getPanel());
		
	}
	
	private void addComputedQuestion(ComputedQuestion qlElement,Map<String,Value> declaredVar){
		ComputedQuestionPanel panel=new ComputedQuestionPanel(qlElement, declaredVar);
		questionPanelList.add(panel.getPanel());
		
		
	}
	
	
	private void initVar(SingleLineElement qlElement){
		String varName=qlElement.getId().getName();
		if(declaredVar.containsKey(varName)){
			Value value=declaredVar.get(varName);
			declaredVar.put(varName, value);
		}
		else declaredVar.put(varName,initValue(qlElement));
		
	}
	
	
	private Value initValue(SingleLineElement qlElement) {
		Type type = qlElement.getType();

		if (type.isCompatibleToBoolType()) {
			return new BoolLit(false);
		} else if (type.isCompatibleToIntType()) {
			return new IntegerLit(0);
		} else if (type.isCompatibleToMoneyType()) {
			return new DecimalLit(0.0f);
		} else {
			return new StringLit("");
		}

	}
	
	
	
}
