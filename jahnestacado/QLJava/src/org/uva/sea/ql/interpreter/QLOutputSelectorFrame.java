package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.output.generators.json.QLToJSON;
import org.uva.sea.ql.output.generators.pdf.QLToPDF;

public class QLOutputSelectorFrame implements ActionListener{
	private final JFrame dialog;
	private final String [] comboSelection = new String[]{"PDF","JSON"};
	private final List<String> questionLabels;
	private final List<String> questionValues;
	private JComboBox comboBox;

	
	private QLOutputSelectorFrame(JFrame dialog,QLOutputState outputState){
		this.dialog=dialog;
		this.questionLabels=outputState.getQuestionLabels();
		this.questionValues=outputState.getQuestionValues();
		
	}
	
	public static void showFormatSelector(String formName,QLOutputState outputState){
		JFrame frame=QLFrame.createQLFrame();
		frame.setTitle(formName);
		QLOutputSelectorFrame selector=new QLOutputSelectorFrame(frame,outputState);
		selector.setContentPanel();
		selector.showDialog();

	}
	
	private JPanel getComboBoxPanel(){
		JPanel comboBoxPanel=new JPanel(new MigLayout());
		JLabel label=new JLabel("Choose format");
		comboBox=new JComboBox(comboSelection);
		comboBoxPanel.add(label,"align label");
		comboBoxPanel.add(comboBox,"align label,wrap");
		return comboBoxPanel;
	}
	
	
	private JPanel getButtonPanel(){
		JPanel buttonPanel=new JPanel(new MigLayout());
		JButton button=new JButton("Generate");
		button.addActionListener(this);
		buttonPanel.add(button,"align label"); 
		return buttonPanel;

	}
	
	private void setContentPanel(){
		JPanel comboBoxPanel=getComboBoxPanel();
		JPanel buttonPanel=getButtonPanel();

		JPanel contentPanel=new JPanel(new MigLayout());
		contentPanel.add(comboBoxPanel,"align label,wrap");
		contentPanel.add(buttonPanel,"align label");
		dialog.add(contentPanel);
	}
	
	
	private void showDialog() {
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String title=dialog.getTitle();
		switch (comboBox.getSelectedIndex()) {
		case 0:
			
			QLToPDF.createPdf(title, questionLabels, questionValues);
			showConfirmationMessage(title+".pdf file successful created!");
			break;
		case 1:
			QLToJSON.generateJson(dialog.getTitle(), questionLabels,questionValues);
			showConfirmationMessage(title+".json file successful created!");
			break;

		default:
			return;
		}

	}
	
	private void showConfirmationMessage(String message){
		JOptionPane.showMessageDialog(dialog,message);

		
	}

}
