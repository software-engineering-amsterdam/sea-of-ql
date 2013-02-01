package org.uva.sea.ql.interpreter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;

public class QuestionPanel extends JPanel implements MouseListener{

	private final JLabel label;
	private final Question qlElement;
	private final JComponent inputComponent;
	
	
	public QuestionPanel(Question qlElement,Map<String,Value> declaredVar){
	    this.qlElement=qlElement;
		
		label=new JLabel(qlElement.getLabel().getValue());
		inputComponent=setInputComponent(qlElement.getId().getName(),qlElement.getType(),declaredVar);
		addComponents();
	}
	
	private void addComponents(){
		this.setLayout(new MigLayout("","[right][]","[]"));
		inputComponent.addMouseListener(this);
		this.add(label,"align right");
		this.add(inputComponent,"wrap");
		
	}
	
	public JPanel getPanel(){
		return this;
	}
	
	private JComponent setInputComponent(final String varName,Type type,final Map<String,Value> declaredVar){
	
		if (type.isCompatibleToStringType()) {
			JTextField textField = new JTextField(10);
			textField.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println(qlElement.getLabel().getValue());				}
			});
			return textField;
		} else if (type.isCompatibleToBoolType()) {
			final JCheckBox chBox = new JCheckBox("Yes");
			chBox.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(!declaredVar.get(varName).isOfType(null).isCompatibleToUndefinedType()){
						boolean newState=!chBox.isSelected();
						chBox.setSelected(newState);
						System.out.println("kj");	

						VariableEnvironment.refreshForm(varName,declaredVar,new BoolLit(newState));
					}else{
						System.out.println(declaredVar);	

						VariableEnvironment.refreshForm(varName,declaredVar,new BoolLit(true));

					}
					
				
				}
			});
			return chBox;
		}
		if(type.isCompatibleToIntType()){
			return new JSpinner();
		}
		return null;
	}

	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		label.setVisible(false);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
