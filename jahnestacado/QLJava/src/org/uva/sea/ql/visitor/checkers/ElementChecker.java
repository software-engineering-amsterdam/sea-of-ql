package org.uva.sea.ql.visitor.checkers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.BodyElement;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.ConditionalElement;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfThen;
import org.uva.sea.ql.ast.form.IfThenElse;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.SingleLineElement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IElementVisitor;

public class ElementChecker implements IElementVisitor {
	
	private final Map<String,Type> declaredVar;
	private final List<String> errorReport;
	
	public ElementChecker(Map<String,Type> declaredVar,List<String> errorReport){
			this.declaredVar=declaredVar;
			this.errorReport=errorReport;
	}
	
	public static void checkQL(Form form){
		Map<String,Type> declaredVar= new HashMap<String,Type>();
		List<String> errorReport= new ArrayList<String>();
		ElementChecker checker=new ElementChecker(declaredVar,errorReport);
		form.accept(checker);
	}
	
	private void checkVarName(SingleLineElement qlElement){
		String id=qlElement.getId().getName();
		Type type=qlElement.getType();
		
		if(declaredVar.containsKey(id)){
			System.out.println("Invalid variable name. Variable '"+id+"' is already declared");
			errorReport.add("Invalid variable name.Variable"+id+" is already declared");
			return;
		}
		
		declaredVar.put(id,type);
	
	}
	
	private void checkComputedExpr(ComputedQuestion qlElement){
		Type questionType=qlElement.getType();
		Type exprType=qlElement.getExpr().isOfType(declaredVar);
        
		ExpressionChecker.check(qlElement.getExpr(),declaredVar, errorReport);

		if(!(questionType.isCompatibleToType(exprType))){
			System.out.println("Invalid expression type. Expression must be of '"+classToString(questionType)+"'.");
			errorReport.add("Invalid expression type. Expression must be of '"+classToString(questionType)+"'.");
			return;
		}
		

	}
	
	
	private String classToString(Type type){
		String typeToString=type.getClass().getSimpleName();
		return typeToString;
	}
	
	
	private void checkCondition(ConditionalElement qlElement){
		Expr condition=qlElement.getCondition();
		if(!condition.isOfType(declaredVar).isCompatibleToBoolType()){
			System.out.println("Invalid conditional expression. Expression can only be of 'Boolean' type.");
			errorReport.add("Invalid conditional expression. Expression can only be of 'Boolean' type.");
		}
	}
	
	private void acceptIfBodyElement(Body body){
			for(BodyElement element:body.getBodyElement()){
				element.accept(this);
			}
	}
	
	

	@Override
	public void visit(Form qlElement) {
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
		checkVarName(qlElement);
		
		
	}

	@Override
	public void visit(ComputedQuestion qlElement) {
		checkVarName(qlElement);
		checkComputedExpr(qlElement);
	}

	@Override
	public void visit(IfThenElse qlElement) {
		checkCondition(qlElement);
		acceptIfBodyElement(qlElement.getIfBody());
		acceptIfBodyElement(qlElement.getElseBody());
		
		
	}

	@Override
	public void visit(IfThen qlElement) {
		checkCondition(qlElement);
		acceptIfBodyElement(qlElement.getIfBody());
			
	}
	
    
	
}
