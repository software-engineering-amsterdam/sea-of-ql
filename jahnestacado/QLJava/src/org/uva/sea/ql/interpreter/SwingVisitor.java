package org.uva.sea.ql.interpreter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import org.uva.sea.ql.swing.Renderer;
import org.uva.sea.ql.visitor.IElementVisitor;
@SuppressWarnings("rawtypes")
public class SwingVisitor implements IElementVisitor{
	private static List<JPanel> questionList;
	private final Map<String,Value> declaredVar;
	private static Form form;
	
	public SwingVisitor(Form form,List<JPanel> questionList,Map<String,Value> declaredVar){
		this.questionList=questionList;
		this.declaredVar=declaredVar;
		this.form=form;
	}
	
	
	public static List<JPanel> generate(Form form){
		List<JPanel> questionList=new ArrayList<JPanel>();
		Map<String,Value> declaredVar=new LinkedHashMap<String,Value>();
		SwingVisitor visitor=new SwingVisitor(form,questionList,declaredVar);
		form.accept(visitor);
		return getQLPanels();

	}
	
	public static List<JPanel> regenerate(Map<String,Value> declaredVar){
		List<JPanel> questionList=new ArrayList<JPanel>();
		SwingVisitor visitor=new SwingVisitor(form,questionList,declaredVar);
		form.accept(visitor);
		return getQLPanels();
		
	}

	@Override
	public void visit(Form qlElement) {
       String formName=qlElement.getId().getName();
       Renderer.setName(formName);
       qlElement.getBody().accept(this);
	}

	@Override
	public void visit(Body qlElement) {
		List<BodyElement> bodyList=qlElement.getBodyElement();
		for(BodyElement element:bodyList){
			element.accept(this);
		}

	}

	@Override
	public void visit(Question qlElement) {
		initVar(qlElement);
		addQuestion(qlElement,declaredVar);
	}

	@Override
	public void visit(ComputedQuestion qlElement) {
		initVar(qlElement);   //na ginei method
		Value value = ExprEvaluator.eval(qlElement.getExpr(),declaredVar);
		declaredVar.put(qlElement.getId().getName(),value);

		addComputedQuestion(qlElement,declaredVar);

	}
	
	
	@Override
	public void visit(IfThenElse qlElement) {
		Body body = qlElement.getIfBody();
		Body body2 = qlElement.getElseBody();

		Expr condition = qlElement.getCondition();
		Value<Boolean> expr = ExprEvaluator.eval(condition, declaredVar);

		if (!expr.getValue())
			body2.accept(this);
		else
			body.accept(this);
	}

	@Override
	public void visit(IfThen qlElement) {
		Body body=qlElement.getIfBody();
		Expr condition=qlElement.getCondition();
		Value<Boolean> expr=ExprEvaluator.eval(condition,declaredVar);
		
		if(!expr.getValue()) return;
		
		body.accept(this);
		
		
		
		
		
		

	}
	
	
	
	private void addQuestion(Question qlElement,Map<String,Value> declaredVar){
		QuestionPanel panel=new QuestionPanel(qlElement,declaredVar);
		questionList.add(panel.getPanel());
		
	}
	
	private void addComputedQuestion(ComputedQuestion qlElement,Map<String,Value> declaredVar){
		ComputedQuestionPanel panel=new ComputedQuestionPanel(qlElement, declaredVar);
		questionList.add(panel.getPanel());
		
		
	}
	
	private static List<JPanel> getQLPanels(){
		return questionList;
	}
	
	private void initVar(SingleLineElement qlElement){
		String varName=qlElement.getId().getName();
		if(declaredVar.containsKey(varName)){
			Value value=declaredVar.get(varName);
			declaredVar.put(varName, value);
		}
		else declaredVar.put(varName, getValue(qlElement));
		
	}
	
	
	private Value getValue(SingleLineElement qlElement) {
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
