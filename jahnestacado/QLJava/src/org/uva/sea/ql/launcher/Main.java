package org.uva.sea.ql.launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.interpreter.SwingVisitor;
import org.uva.sea.ql.visitor.checkers.ElementChecker;

public class Main {

	public static void main(String[] args) {

		Form parsedForm = QLInputReader.getParsedForm();
		if (ElementChecker.checkQL(parsedForm)) {
            List<JPanel> questionList = new ArrayList<JPanel>();
			Map<String, Value> declaredVar = new HashMap<String, Value>();
			JFrame frame = new JFrame();
			new SwingVisitor(questionList, declaredVar).generate(parsedForm,frame);

		}

	}

}
