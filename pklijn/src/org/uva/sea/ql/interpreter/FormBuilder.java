package org.uva.sea.ql.interpreter;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.form.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

import com.apple.eawt.Application;

public class FormBuilder implements ActionListener {
	
	private final String NEWLINECHAR = "\n";
	private IParse parser;
	private JFrame mainWindow;
	private JButton selectFormButton;
	private JButton backToMainButton;
	
	public FormBuilder() {
		mainWindow = new JFrame();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);
		Application application = Application.getApplication();
		Image dockImage = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/lib/logo.png");
		application.setDockIconImage(dockImage);
		selectFormButton = new JButton("Select an existing form");
		backToMainButton = new JButton("Back");
		selectFormButton.addActionListener(this);
		backToMainButton.addActionListener(this);
	}
	
	public void displayMain() {
		JPanel panel = new JPanel(new MigLayout());
		panel.add(new JLabel("Press the button below to select your form:"), "span, growx");
		panel.add(selectFormButton, "span, growx");
		showPanelInMainWindow(panel,"Questionare form");
	}
	
	public void displayForm(String formText) {
		parser = new ANTLRParser();
		try {
			Form form = parser.parseForm(formText);
			if (form.isFormValid()) {
				JPanel panel = form.buildForm();
				panel.add(backToMainButton, "span, growx");
				showPanelInMainWindow(panel, form.getName());
			}
			else {
				showPanelInMainWindow(getDisplayFormErrorPanel(form), "Errors found!");
			}
		}
		catch (ParseError e) {
			JOptionPane.showMessageDialog(null, "The form has an invalid syntax");
		}
		catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "The form has an invalid syntax:\n" + e.getMessage());
		}
	}
	
	private void showPanelInMainWindow(JPanel formPanel, String formTitle) {
		mainWindow.setContentPane(formPanel);
		mainWindow.setTitle(formTitle);
		mainWindow.pack(); //Automatically resize
		mainWindow.setVisible(true);
	}
	
	private String getFileText(String url) {
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
	
	private void selectQLFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Questionairs (*.ql)", "ql"));
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (fileChooser.getSelectedFile().getPath().toLowerCase().endsWith(".ql")) {
				displayForm(getFileText(fileChooser.getSelectedFile().getPath()));
			}
			else {
				JOptionPane.showMessageDialog(null, "The selected file is not of the right type!");
			}
		}
	}
	
	private JPanel getDisplayFormErrorPanel(Form form) {
		JPanel panel = new JPanel(new MigLayout());
		panel.add(new JLabel("Errors found in form:"), "span, growx");
		panel.add(new JTextArea(form.getPrintableText()), "span, growx");
		panel.add(backToMainButton, "span, growx");
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectFormButton) {
			selectQLFile();
		}
		if (e.getSource() == backToMainButton) {
			displayMain();
		}
	}
}
