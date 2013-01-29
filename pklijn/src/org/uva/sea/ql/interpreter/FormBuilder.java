package org.uva.sea.ql.interpreter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.form.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class FormBuilder {
	
	private final String NEWLINECHAR = "\n";
	private IParse parser;
	
	public FormBuilder() {
	}
	
	public void displayForm() {
		parser = new ANTLRParser();
		try {
			Form form1 = parser.parseForm(getQLFormText("form1.ql"));
			if (form1.checkFormValidity()) {
				displayForm(form1.buildForm(), form1.getName());
			}
			else {
				System.out.println("ERRORS FOUND!!!");
				form1.print();
			}
		}
		catch (ParseError e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void displayForm(JPanel formPanel, String formTitle) {
		JFrame mainWindow = new JFrame(formTitle);

		mainWindow.setContentPane(formPanel);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null); // Put in center of the screen
		mainWindow.pack(); //Automatically resize
		
		mainWindow.setVisible(true);
	}
	
	private String getQLFormText(String formFile) {
		String url = this.getClass().getResource(formFile).getPath();
		url = url.replace("%20", " ");
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			String line, fileText = "";
			while ((line = br.readLine()) != null) {
				fileText += (line + NEWLINECHAR);
			}
			return fileText;
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
}
