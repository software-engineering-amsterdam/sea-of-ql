package org.uva.sea.ql.questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.CheckStat;
import org.uva.sea.ql.questionnaire.state.State;
import org.uva.sea.ql.questionnaire.ui.swing.QuestionnaireGui;
import org.uva.sea.ql.questionnaire.ui.swing.SwingRenderer;

public class QuestionnaireProcessor {
	private Map<Ident, Type> typeEnv;
	private List<ErrorMessage> errorList;
	private Block quesionnaireBlock;
	private String quesionnaireName;
	private State state;

	public QuestionnaireProcessor(Questionnaire questionnaire,
			Map<Ident, Type> typeEnv) {
		this.state = new State();
		this.typeEnv = typeEnv;
		this.errorList = new ArrayList<ErrorMessage>();
		this.quesionnaireBlock = questionnaire.getBlock();
		this.quesionnaireName = questionnaire.getName();
	}

	public void process() {
		System.out.println("Starting processing: " + this.quesionnaireName);
		CheckStat.checkStatBlock(this.quesionnaireBlock, this.typeEnv,
				this.errorList);
		printErrorList(this.errorList);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		mainPanel = SwingRenderer.renderStatement(this.quesionnaireBlock,
				this.state);
		QuestionnaireGui.showGui(quesionnaireName, mainPanel);
	}

	private void printErrorList(List<ErrorMessage> errorList) {
		System.err.println(errorList.isEmpty() ? "No errors!"
				: "-----Errors occured-----");
		for (ErrorMessage error : errorList) {
			System.err.println(error.getErrorMeesage());
		}
	}
}
