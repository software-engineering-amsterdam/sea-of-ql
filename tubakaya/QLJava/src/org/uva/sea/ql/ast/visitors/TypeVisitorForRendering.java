package org.uva.sea.ql.ast.visitors;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StringType;
import org.uva.sea.ql.gui.filters.IntFilter;

public class TypeVisitorForRendering implements TypeVisitor{

	private JPanel parentPanel;
	
	public TypeVisitorForRendering(JPanel parentPanel){
		this.parentPanel=parentPanel;
	}
	
	@Override
	public void visit(BooleanType booleanDeclaration) {
		parentPanel.add(new JCheckBox());
	}

	@Override
	public void visit(IntType intDeclaration) {
		
		JTextField textField = new JTextField();
		textField.setSize(100,20);
		parentPanel.add(textField);

		PlainDocument doc = (PlainDocument) textField.getDocument();
	    doc.setDocumentFilter(new IntFilter());
	}

	@Override
	public void visit(StringType stringDeclaration) {
		JTextField textField = new JTextField();
		textField.setSize(100,20);
		parentPanel.add(textField);
	}

}
