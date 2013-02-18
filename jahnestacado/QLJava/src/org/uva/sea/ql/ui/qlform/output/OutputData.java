package org.uva.sea.ql.ui.qlform.output;

import java.awt.Component;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import org.uva.sea.ql.ui.qlform.ComputedQuestionPanel;
import org.uva.sea.ql.ui.qlform.QLCheckBox;
import org.uva.sea.ql.ui.qlform.QLComputedField;
import org.uva.sea.ql.ui.qlform.QLElsePanel;
import org.uva.sea.ql.ui.qlform.QLIfThenPanel;
import org.uva.sea.ql.ui.qlform.QLInputVerifier;
import org.uva.sea.ql.ui.qlform.QLNumField;
import org.uva.sea.ql.ui.qlform.QLSpinner;
import org.uva.sea.ql.ui.qlform.QLTextField;
import org.uva.sea.ql.ui.qlform.QuestionPanel;

public class OutputData {
	private final List<JPanel> questionPanelList;
	private final QLOutputState outputState;
	private final JFrame frame;
	



	public OutputData(List<JPanel> questionPanelList, JFrame frame) {
		this.questionPanelList = questionPanelList;
		this.frame = frame;
		outputState = new QLOutputState();

	}

	public QLOutputState getOutputData() {
		traverseFormSubComponents();
		return outputState;
	}

	private void gatherDataFromSubComponents(Component[] components) {
		for (int i = 0; i < components.length; i++) {
			String id = components[i].getName();
			if (hasWarnings(id)) {
				getWarning(components[i]);
			} else if (isQuestionsLabel(id)) {
				getJLabelValue(components[i]);
			} else if (isSpinner(id)) {
				getJSpinnerValue(components[i]);
			} else if (isTxtField(id)) {
				getJTextFieldValue(components[i]);
			} else if (isCheckBox(id)) {
				getJCheckBoxValue(components[i]);
			}

		}

	}
	
	private void traverseFormSubComponents() {
		for (JPanel questionPanel : questionPanelList) {

			String id = questionPanel.getName();
			if (isConditionalBody(id)) {
				if (!isVisible(questionPanel))
					return;
				Component[] conditionalBodyPanel = questionPanel.getComponents();
				gatherDataFromSubComponents(conditionalBodyPanel);

			} else {
				Component[] components = questionPanel.getComponents();
				gatherDataFromSubComponents(components);
			}

		}
	}
	
	private void getWarning(Component component) {
		JLabel label = (JLabel) component;
		String text = label.getText();
		if (text.isEmpty())
			return;
		outputState.setErrorFlag(true);
		showWarning();

	}

	private void getJLabelValue(Component component) {
		JLabel label = (JLabel) component;
		String text = label.getText();
		outputState.addLabelText(text);
	}

	private void getJSpinnerValue(Component component) {
		JSpinner spinner = (JSpinner) component;
		String value = spinner.getValue().toString();
		outputState.addValue(value);
	}

	private void getJTextFieldValue(Component component) {
		JTextField txtField = (JTextField) component;
		String value = txtField.getText();
		outputState.addValue(value);
	}

	private void getJCheckBoxValue(Component component) {
		JCheckBox chBox = (JCheckBox) component;
		Boolean state = chBox.isSelected();
		outputState.addValue(state.toString());
	}

	private void showWarning() {
		JOptionPane.showMessageDialog(frame,"Wrong input.Check input warnings!");

	}
	
	
	private boolean hasWarnings(String id){
		if(id.equals(QLInputVerifier.WARNING_LABEL_ID))  return true;
		return false;
		
	}
	
	private boolean isQuestionsLabel(String id){
		if(id.equals(ComputedQuestionPanel.COM_QUESTION_PANEL)|| id.equals(QuestionPanel.QL_QUESTION_LABEL_ID)) return true;
		return false;
	}
	
	private boolean isSpinner(String id){
		if(id.equals(QLSpinner.QL_SPINNER_ID)) return true;
		return false;
	}
	
	private boolean isTxtField(String id) {
		if (id.equals(QLTextField.QL_TXT_FIELD_ID)
				|| id.equals(QLNumField.NUM_FIELD_ID)
				|| id.equals(QLComputedField.QL_COMPUTED_FIELD_ID))
			return true;
		return false;
	}
	
	private boolean isCheckBox(String id){
		if(id.equals(QLCheckBox.QL_CHECKBOX_ID)) return true;
		return false;
	}
	
	
	private boolean isConditionalBody(String id){
		if(id.equals(QLIfThenPanel.IF_THEN_BODY_ID) || id.equals(QLElsePanel.ELSE_BODY_ID)) return true;
		return false;
	}
	
	private boolean isVisible(Component component){
		return ((JPanel) component).isVisible();
	}
}
