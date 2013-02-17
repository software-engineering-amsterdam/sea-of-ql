package org.uva.sea.ql.interpreter.controller;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Block;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.Question;

public class QLFormUtil {
	
	private QLFormUtil() {
		
	}
	
	public static List<Question> getSimpleOuterQuestions(Block block) {
		
		List<Question> result = new ArrayList<Question>();
		List<Statement> items = block.getBlockElements();
		for(Statement item : items) {
			if (!item.isDependent()) {
				result.add((Question)item);
			}
		}
		return result;
	}
	
	public static List<Statement> getDependentStatements(QLForm form) {
		
		List<Statement> result = new ArrayList<Statement>();
		List<Statement> items = form.getBlockOfItems().getBlockElements();
		for(Statement item : items) {
			if (item.isDependent()) {
				result.add(item);
			}
		}
		return result;
	}

}
