package org.uva.sea.ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.uva.sea.ql.util.Environment;
import org.uva.sea.ql.util.FormValueWriter;
import org.uva.sea.ql.util.IWriter;

public class FormSubmissionHandler implements ActionListener{

	IWriter writer;
	
	public FormSubmissionHandler(String formName, Environment environment){
		this.writer = new FormValueWriter(formName, environment);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		writer.write();
	}

}
