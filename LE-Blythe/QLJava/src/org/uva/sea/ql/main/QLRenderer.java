package org.uva.sea.ql.main;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.checker.Error;
import org.uva.sea.ql.checker.VisitorStatementChecker;
import org.uva.sea.ql.gui.VisitorRenderForm;
import org.uva.sea.ql.gui.control.Applet;

public class QLRenderer extends QLProgramBase {

	public QLRenderer(){
		super();
	}
	
	@Override
	protected void execute(Form form) {
	
		VisitorStatementChecker checker = new VisitorStatementChecker();
		boolean succeeded = form.accept(checker);
		
		if(succeeded){
			Applet app = VisitorRenderForm.render(form, 500, 500);
			app.run();
		}
		else{
			for(Error e: checker.getErrors()){
				out.printf(e.getMessage());
			}
		}
	}

	
	public static void main(String[] args){
		new QLRenderer().start(args);
	}



}
