package org.uva.sea.ql.parser.test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.antlr.runtime.RecognitionException;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.gui.State;
import org.uva.sea.ql.ast.values.Ident;
import org.uva.sea.ql.ast.visitor.Renderer;
import org.uva.sea.ql.ast.visitor.StatementVisitor;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class RenderingChecking {

	private final static String value = "hasSoldHouse";
	private final static Ident ident = new Ident(value);
	private final static String simpleQuestion1 = ident.getValue()
			+ ": \"Did you sell a house in 2010?\" boolean ";
	private final static String simpleQuestion2 = "hasBoughtHouse: \"Did you buy a house in 2010?\" boolean ";
	private final static String simpleQuestion3 = "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean ";
	private final static String simpleQuestion4 = "sellingPrice: \"Price the house was sold for:\" money ";
	private final static String simpleQuestion5 = "privateDebt: \"Private debts for the sold house:\" money ";
	private final static String comQuestion = "valueResidue: \"Value residue:\" integer (sellingPrice - privateDebt) ";
	private final static String ifBlock = "if (" + ident.getValue() + ") {"
			+ simpleQuestion4 + simpleQuestion5 + comQuestion + "}";
	private final static String elseBlock = "else {" + simpleQuestion4
			+ simpleQuestion5 + "}";
	private final static String form = "form Box1HouseOwning {"
			+ simpleQuestion1 + simpleQuestion2 + simpleQuestion3 + ifBlock
			+ "}";

	public static void main(String[] args) throws ParseError,
			RecognitionException {
		State state = new State();
		HashMap<String, Type> typeEnv = new HashMap<String, Type>();
		ArrayList<String> errormessages = new ArrayList<String>();
		Renderer render = new Renderer(state);
		StatementVisitor visitor = new StatementVisitor(typeEnv, errormessages);
		ANTLRParser parsethat = new ANTLRParser();
		parsethat.parseForm(form).accept(visitor);
		if (errormessages.isEmpty())
			parsethat.parseForm(form).accept(render);
		else {
			createErrorMessage(errormessages);
		}
		System.out.println("ok dog");
	}

	static void createErrorMessage(ArrayList<String> errormessages) {
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.PAGE_AXIS));
		errorPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		JFrame frame = new JFrame("Error message");
		JLabel label = null;
		for (String error : errormessages) {
			label = new JLabel(error);
			errorPanel.add(label);
		}
		frame.setContentPane(errorPanel);
		frame.pack();
		frame.setVisible(true);
	}
}