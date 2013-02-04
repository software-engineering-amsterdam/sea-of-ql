package org.uva.sea.ql.ast;

public class ConsistencyChecker {
	protected Form formToCheck;
	
	public ConsistencyChecker(Form f){
		formToCheck = f;
	}
	
	public boolean isFormCorrect(){
		
		return !(foundCyclicDependency() || 
				foundBadType() ||
				foundDuplicateLabel() ||
				foundDuplicateQuestion() ||
				foundDuplicateVariable() ||
				foundUndefinedVariable());
	}

	private boolean foundDuplicateLabel() {
		
		return false;
	}

	private boolean foundUndefinedVariable() {
		return false;
	}

	private boolean foundDuplicateVariable() {
		return false;
	}

	private boolean foundDuplicateQuestion() {
		return false;
	}

	private boolean foundCyclicDependency() {
		return false;
	}

	private boolean foundBadType() {
		return false;		
	}
}
