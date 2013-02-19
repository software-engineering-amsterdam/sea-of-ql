package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.output.CSVCreator;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.ui.components.BaseComponent;


public class FormRenderer {
	
	public static void main(String[] args){
		Form currentForm = getFormFromChooser();
		renderForm(currentForm);
	}
	
	public static void renderForm(Form currentForm) {
		List<Message> errors = currentForm.checkType(new Env());
		if(errors.size() > 0){
			showFormErrors(currentForm);
			return; 
		}
		showForm(currentForm);
	}

	private static void showForm(final Form currentForm) {
		final Env environment = new Env();
		JPanel panel = new JPanel(new MigLayout("hidemode 3"));
		
		JFrame frame = new JFrame();		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		currentForm.initTypes(environment);	
		for(BaseComponent comp : currentForm.getUIComponents(environment, currentForm)){
			panel.add(comp.getComponent(), comp.getArgs());
		}
		
		JButton pickSaveLocation = new JButton();
		pickSaveLocation.setText("Save form");
		pickSaveLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFormToCSV(environment, currentForm);
			}
		});
		
		panel.add(pickSaveLocation);
		frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		frame.setVisible(true);				
	}
	
	private static void saveFormToCSV(Env env, Form currentForm) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
			File saveLocation = chooser.getSelectedFile();
			CSVCreator.writeForm(currentForm.getName(), env, saveLocation);
		}
		else {
			new ErrorScreen("No directory selected, file not saved.");
		}
	}

	private static void showFormErrors(Form currentForm) {
		Env environment = new Env();
		JFrame errorsFrame = new JFrame();
		errorsFrame.setLayout(new MigLayout());
		
		JTextArea errorText = new JTextArea();
		currentForm.initTypes(environment);	
		errorText.setText(currentForm.genFormFeedBack(environment, 0));
		
		errorsFrame.add(errorText);
		errorsFrame.pack();
		errorsFrame.setVisible(true);
	}
	
	public static Form getFormFromChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);				
		if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
			String fileLocation = chooser.getSelectedFile().toString() ;
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation));
				String currentLine;
				StringBuilder qlForm = new StringBuilder();
				while ((currentLine = fileReader.readLine()) != null) {
					qlForm.append(currentLine);
				}
				fileReader.close();				
				Form form = new ANTLRParser().parseForm(qlForm.toString());				
				return form;
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else {
			new ErrorScreen("No form file selected.");
		}
		return null;
	}

}
