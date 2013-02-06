package org.uva.sea.ql.visitor.checkers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
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
	private final List<QLError> errorReport;
	 
	
	private ElementChecker(Map<String,Type> declaredVar,List<QLError> errorReport){
			this.declaredVar=declaredVar;
			this.errorReport=errorReport;
	}
	
	public static boolean checkQL(Form form){
		Map<String,Type> declaredVar= new LinkedHashMap<String,Type>();
		List<QLError> errorReport= new ArrayList<QLError>();
		ElementChecker checker=new ElementChecker(declaredVar,errorReport);
		form.accept(checker);
		printErrors(errorReport);
		if(!errorReport.isEmpty()) return false;
		
		return true;
		
	}
	
	private void checkVarName(SingleLineElement qlElement){
		String id=qlElement.getId().getName();
		Type type=qlElement.getType();
		
		if(declaredVar.containsKey(id)){
			addError(new QLError("Invalid variable name. Variable '"+id+"' is already declared"));
			return;
		}
		
		declaredVar.put(id,type);
       

	}
	
	private void checkComputedExpr(ComputedQuestion qlElement){
		Expr computedExpr=qlElement.getExpr();
		Type questionType=qlElement.getType();
		Type exprType=computedExpr.isOfType(declaredVar);
		ExpressionChecker.check(computedExpr,declaredVar, errorReport);

		if(!(questionType.isCompatibleToType(exprType))){
			addError(new QLError("Invalid expression type. Expression must be of '"+classToString(questionType)+"'."));
			return;
		}
		

	}
	
	
	private static String classToString(Type type){
		String typeToString=type.getClass().getSimpleName();
		return typeToString;
	}
	
	
	private void checkCondition(ConditionalElement qlElement){    
		Expr condition=qlElement.getCondition(); 
		Type conditionType=condition.isOfType(declaredVar);
		ExpressionChecker.check(condition,declaredVar, errorReport);
		if(conditionType.isCompatibleToUndefinedType()){
			 Ident conditionID=(Ident) condition;
			 addError(new QLError("Variable '"+conditionID.getName()+"' is undefined."));
		}
		else if(!conditionType.isCompatibleToBoolType()){ 
			addError(new QLError("Invalid conditional expression. Expression can only be of 'Boolean' type."));
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
	
    private static void printErrors(List<QLError> errorReport){
    	for(QLError error:errorReport){
    		System.out.println(error.getError());
    	}
    }
    
    private void addError(QLError message){
    	errorReport.add(message);
    }
	
}
