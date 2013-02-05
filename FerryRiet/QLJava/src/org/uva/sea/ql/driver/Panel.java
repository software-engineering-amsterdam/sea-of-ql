package org.uva.sea.ql.driver;

import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.LineStatement;
import org.uva.sea.ql.ast.types.BooleanType;

public class Panel {
	private String panelName;
	private JPanel jPanel;
    private JTextField jTextField;
	private JCheckBox jCheckBox ;
    private JLabel jLabel;

	public Panel(LineStatement statement) {
		BooleanType booleanType = new BooleanType();

		panelName = statement.getLineName();

		jPanel = new JPanel();
		jLabel = new JLabel(statement.getDisplayText());

		jPanel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][]", "[]"));

		jPanel.add(jLabel, "cell 0 0,alignx left,aligny top");

		if (booleanType.isCompatibleTo(statement.getTypeDescription())) {
			jCheckBox  = new JCheckBox("");
			jPanel.add(jCheckBox, "cell 12 0");

		} else {
			jTextField = new JTextField();
			jTextField.setColumns(10);
			jPanel.add(jTextField, "cell 12 0,growx");;
		}
	}

	public boolean equals(String name) {
		return panelName.equals(name);
	}
	public void registerAt(JPanel panel,int location) {
		StringBuilder stringBuilder = new StringBuilder("cell 0 ") ;
		
		stringBuilder.append(location) ;
		stringBuilder.append(" ,growx") ;
		
		
		panel.add(jPanel,stringBuilder.toString()) ;
	}
	
	public void registerActionListener(ActionListener actionHandler){
		if ( jCheckBox != null ) jCheckBox.addActionListener(actionHandler) ;
		else {
			jTextField.addActionListener(actionHandler) ;
		}
	}

}
