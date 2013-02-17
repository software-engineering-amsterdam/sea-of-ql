package org.uva.sea.ql.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.output.CSVWriter;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.ui.components.BaseComponent;


public class FormRenderer {
	
	private static Form currentForm; 
	
	public static void main(String[] args){
		currentForm = getFormFromChooser();
		renderForm();
		
	}
	
	public static void renderForm() {
		List<Message> errors = currentForm.checkType(new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>()));
		if(errors.size() > 0){
			showFormErrors(errors); 
		}
		showForm();
	}
	

	private static void showForm() {
	
		final Env environment = new Env(new HashMap<Ident,org.uva.sea.ql.ast.type.Type>(), new HashMap<Ident,Value>());
		JPanel panel = new JPanel(new MigLayout("hidemode 3"));
		
		JFrame frame = new JFrame();		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		
		for(BaseComponent comp : currentForm.getUIComponents(environment, currentForm)){
			panel.add(comp.getComponent(), comp.getArgs());
		}
		
		JButton pickSaveLocation = new JButton();
		pickSaveLocation.setText("Save form");
		pickSaveLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFormToCSV(environment);
			}
		});
		
		panel.add(pickSaveLocation);
		frame.pack();
		currentForm.initTypes(environment);	
		currentForm.eval(environment);
		frame.setVisible(true);				
	}
	
	private static void saveFormToCSV(Env env) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
			File saveLocation = chooser.getSelectedFile();
			CSVWriter.writeForm(currentForm.getName(), env, saveLocation);
		}
		else {
			new ErrorScreen("No directory selected, file not saved.");
		}
	}

	private static void showFormErrors(List<Message> errors) {
		JFrame errorsFrame = new JFrame();
		JButton pickForm = new JButton();
		pickForm.setText("Open new form");
		pickForm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentForm = getFormFromChooser();
			}
		});
	}
	
	public static Form getFormFromChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);				
		if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) { 
			String fileLocation = chooser.getSelectedFile().toString() ;
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(fileLocation));
				String currentLine;
				String qlForm = "" ; 
				while ((currentLine = fileReader.readLine()) != null) {
					qlForm += currentLine;
				}
				
				Form form = new ANTLRParser().parseForm(qlForm);
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
