package org.uva.sea.ql.core.dom.visitors;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import org.uva.sea.ql.core.dom.TypeVisitor;
import org.uva.sea.ql.core.dom.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.IntDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.StringDeclaration;
import org.uva.sea.ql.gui.filters.IntFilter;

public class TypeVisitorForRendering implements TypeVisitor{

	private JPanel parentPanel;
	
	public TypeVisitorForRendering(JPanel parentPanel){
		this.parentPanel=parentPanel;
	}
	
	@Override
	public void visit(BooleanDeclaration booleanDeclaration) {
		parentPanel.add(new JCheckBox());
	}

	@Override
	public void visit(IntDeclaration intDeclaration) {
		
		JTextField textField = new JTextField();
		textField.setSize(100,20);
		parentPanel.add(textField);

		PlainDocument doc = (PlainDocument) textField.getDocument();
	    doc.setDocumentFilter(new IntFilter());
	}

	@Override
	public void visit(StringDeclaration stringDeclaration) {
		JTextField textField = new JTextField();
		textField.setSize(100,20);
		parentPanel.add(textField);
	}

}
