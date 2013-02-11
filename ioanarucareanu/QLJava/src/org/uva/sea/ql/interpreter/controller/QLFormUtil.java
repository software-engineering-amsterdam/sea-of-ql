package org.uva.sea.ql.interpreter.controller;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.ql.ComputedQuestion;
import org.uva.sea.ql.ast.ql.ConditionalQuestion;
import org.uva.sea.ql.ast.ql.QLForm;
import org.uva.sea.ql.ast.ql.QLItem;
import org.uva.sea.ql.ast.ql.Question;

public class QLFormUtil {
	
	private QLFormUtil() {
		
	}
	
	public static List<Question> getSimpleOuterQuestions(QLForm form) {
		
		List<Question> result = new ArrayList<Question>();
		List<QLItem> items = form.getBlockOfItems().getBlockElements();
		for(QLItem qlItem : items) {
			if(qlItem instanceof ConditionalQuestion || qlItem instanceof ComputedQuestion) {
				continue;
			}
			result.add((Question)qlItem);
		}
		return result;
	}

}
