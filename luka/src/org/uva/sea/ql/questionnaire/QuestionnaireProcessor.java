package org.uva.sea.ql.questionnaire;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.visitor.CheckStat;
import org.uva.sea.ql.questionnaire.state.State;
import org.uva.sea.ql.questionnaire.ui.swing.QuestionnaireGui;
import org.uva.sea.ql.questionnaire.ui.swing.SwingRenderer;
import org.uva.sea.ql.questionnaire.ui.swing.control.SaveButtonActionListener;

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
		
		//Main Panel
		JPanel mainPanel = new JPanel();
		Box box = Box.createVerticalBox();
		//Add Quesions
		box.add(SwingRenderer.renderStatement(this.quesionnaireBlock,
				this.state));
		box.add(Box.createRigidArea(new Dimension(0, 10)));
		
		//Save Button
		JButton saveButton = new JButton("Save");
		String fileLocation = "/Users/luc0/Desktop/test.xml";
		saveButton.addActionListener(new SaveButtonActionListener(state,fileLocation));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		box.add(saveButton);
		
		//Show GUI
		QuestionnaireGui.showGui(quesionnaireName, box);
	}

	private void printErrorList(List<ErrorMessage> errorList) {
		System.err.println(errorList.isEmpty() ? "No errors!"
				: "-----Errors occured-----");
		for (ErrorMessage error : errorList) {
			System.err.println(error.getErrorMeesage());
		}
	}
}
