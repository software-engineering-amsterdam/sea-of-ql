package org.uva.sea.ql.main;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.checker.Error;
import org.uva.sea.ql.checker.VisitorStatementChecker;

public class QLFormChecker extends QLProgramBase {

	public QLFormChecker(){
		super();
	}
		
	
	private void checkForm(Statement form) {
		
		VisitorStatementChecker visitor = new VisitorStatementChecker();
		boolean succeeded = form.accept(visitor);
		
		if(succeeded){
			out.printf("Form validation succeeded!\n");
		}
		else{
			out.printf("Validation failed due to the following reasons:\n");
			
			for(Error e: visitor.getErrors())
				out.printf("%s", e.getMessage());
		}
		
	}
	
	@Override
	protected void execute(Statement ast) {
		checkForm(ast);
	}
	
	
	public static void main(String [ ] args){
		new QLFormChecker().start(args);	
	}


	
}
