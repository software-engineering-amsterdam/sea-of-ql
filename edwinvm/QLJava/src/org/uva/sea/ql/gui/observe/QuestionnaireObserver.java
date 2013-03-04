package org.uva.sea.ql.gui.observe;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expressions.Expression;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.statements.questions.ComputedQuestion;
import org.uva.sea.ql.ast.statements.questions.Question;
import org.uva.sea.ql.gui.render.widgets.Widget;

public class QuestionnaireObserver {

	public static void registerEventHandler(Question question, Widget widget, State state) {
		AnswerableQuestionObservable observable = new AnswerableQuestionObservable(widget, state, question);
		state.putObservable(question.getQuestionVariable().getVariable(), observable);
		widget.addListener(observable);
	}
	
	public static void registerObserver(Expression condition, ArrayList<JPanel> renderedBody, State state) {
		registerObserver(condition, renderedBody, null, state);
	}
	
	public static void registerObserver(Expression condition, ArrayList<JPanel> renderedBody, ArrayList<JPanel> renderedElseBody, State state) {
		ConditionObserver observer = new ConditionObserver(condition, renderedBody, renderedElseBody, state);
		addObserver(observer, state);
	}
	
	public static void registerObserver(ComputedQuestion statement, Widget widget, State state) {
		ComputedQuestionObserver observer = new ComputedQuestionObserver(widget, state, statement);
		addObserver(observer, state);
	}

	private static void addObserver(Observer observer, State state) {
		for (Entry<Identifier, Observable> observable : state.getObservableEnvironment().entrySet()) {
			state.addObserver(observable.getKey(), observer);
		}
	}
	
}