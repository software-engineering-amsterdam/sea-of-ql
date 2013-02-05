package org.uva.sea.ql.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.interpreter.FormElement;
import org.uva.sea.ql.opencsv.CSVWriter;

public class Form implements ActionListener {

	private Ident id;
	private List<FormItem> body;
	private Env environment;
	private JButton finishButton;
	
	public Form(Ident id, List<FormItem> formItems) {
		this.id = id;
		this.body = formItems;
	}

	public Ident getIdentity() {
		return id;
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
	
	public boolean checkFormValidity() {
		boolean valid = true;
		environment = new Env();
		for (FormItem f : body) {
			if (!f.validate(environment))
				valid = false;
		}
		return valid;
	}
	
	public void eval() {
		for (FormItem f : body) {
			f.eval(environment, this);
		}
	}
	
	public JPanel buildForm() {
		MigLayout ml = new MigLayout("ins 20", "[para]0[][100lp, fill][60lp][95lp, fill]", "");
		JPanel formPanel = new JPanel(ml);
		
		for (FormItem f : body) {
			List<FormElement> components = f.getFormComponents();
			for (FormElement fe : components) {
				formPanel.add(fe.getFormComponent(), fe.getProperties());
			}
		}
		finishButton = new JButton("Finish form");
		finishButton.addActionListener(this);
		formPanel.add(finishButton, "span, growx");
		eval();
		return formPanel;
	}
	
	public Map<Ident, Value> getAllValues() {
		Map<Ident, Value> values = environment.getAllValues();
		for (FormItem f : body) {
			values.putAll(f.getAllValues());
		}
		return values;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == finishButton) {
			Map<Ident, Value> values = getAllValues();
			File writeDirectory = getDirectory();
			if (writeDirectory != null) {
				try {
					Date date = new Date();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
					CSVWriter writer = new CSVWriter(new FileWriter(writeDirectory.getPath() + File.separator + id.getName() + "-" + dateFormat.format(date) +".csv"));
					for (Ident key : values.keySet()) {
						writer.writeNext(new String[]{key.getName(), values.get(key).toString()});
					}
					writer.close();
				}
				catch (IOException ex) {
					System.out.println(ex.getMessage());
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
