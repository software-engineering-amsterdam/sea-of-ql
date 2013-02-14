package org.uva.sea.ql.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.extensions.Tuple;
import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.opencsv.CSVWriter;

// TODO: Clean this class, merge some functions. etc..
public class Form implements ActionListener {

	private final Ident id;
	private final List<FormItem> body;
	private Env environment;
	private JButton finishButton;
	private JFrame mainWindow;
	
	public Form(Ident id, List<FormItem> formItems) {
		this.id = id;
		this.body = formItems;
	}

	public String getName() {
		return id.getName();
	}
	
	public List<FormItem> getBody() {
		return body;
	}

	public String getPrintableText() {
		String formText = "Form: " + id + "\n";
		for (FormItem f : body) {
			formText += f.getPrintableText(0);
		}
		return formText;
	}
	
	public boolean isFormValid() {
		environment = new Env();
		for (FormItem f : body) {
			if (!f.validate(environment))
				return false;
		}
		return true;
	}
	
	public void eval() {
		for (FormItem f : body) {
			f.eval(environment, this);
		}
		mainWindow.pack();
	}
	
	public JPanel buildForm(JFrame mainWindow) {
		assert isFormValid();
		this.mainWindow = mainWindow;
		JPanel formPanel = new JPanel(new MigLayout("hidemode 3"));
		for (FormItem f : body) {
			f.buildForm(formPanel);
		}
		finishButton = new JButton("Finish form");
		finishButton.addActionListener(this);
		formPanel.add(finishButton, "span, growx");
		eval();
		return formPanel;
	}
	
	public boolean isFinished() {
		for (FormItem f : body) {
			if (!f.isFinished(environment)) {
				return false;
			}
		}
		return true;
	}
	
	public List<Tuple<Ident,Value>> getAllValues() {
		List<Tuple<Ident, Value>> values = new ArrayList<Tuple<Ident, Value>>();
		for (FormItem f : body) {
			values.addAll(f.getAllValues(environment));
		}
		return values;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finishButton) {
			if (!isFinished()) {
				JOptionPane.showMessageDialog(null, "Please fill in all fields before finishing your questionaire");
			}
			else {
				List<Tuple<Ident, Value>> values = getAllValues();
				File writeDirectory = getDirectory();
				if (writeDirectory != null) {
					try {
						Date date = new Date();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
						CSVWriter writer = new CSVWriter(new FileWriter(writeDirectory.getPath() + File.separator + id.getName() + "-" + dateFormat.format(date) +".csv"));
						for (Tuple<Ident, Value> v : values) {
							writer.writeNext(new String[]{ v.getLeft().toString(), v.getRight().toString() });
						}
						writer.close();
						JOptionPane.showMessageDialog(null, "The form results are now saved to the selected folder!");
					}
					catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "There was an error while trying to save your form results.\nPlease try again.", "Error saving document", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
	
	private File getDirectory() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}
}
