package org.uva.sea.ql.ui.qlform;

import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.ExprEvaluator;

public abstract class QLConditionalBody implements Observer{

	private final List<JPanel> questionPanelList;
	private  Map<String,Value> runTimeValues;
	private final VariableUpdater varUpdater;
	private final Expr condition;
	private final JPanel panel;

	
	public QLConditionalBody(List<JPanel> questionPanelList,Expr condition,VariableUpdater varUpdater,Map<String,Value> runTimeValues){
		this.questionPanelList=questionPanelList;
		this.runTimeValues=runTimeValues;
		this.varUpdater=varUpdater;
		this.varUpdater.addObserver(this);
		this.condition=condition;
		panel=new JPanel(new MigLayout("fill,insets 0"));	
	}
	
	protected void setSettings(String id){
		panel.setMinimumSize(new Dimension(617, 40));
		panel.setOpaque(false);
		panel.setName(id);
		fillPanel();
		setVisibility(runTimeValues);
	}
	
	
	private void fillPanel(){
		for(JPanel questionPanel:questionPanelList){
			panel.add(questionPanel,"align label,wrap");
		}
	}
	
	
	public JPanel getPanel(){
		return panel;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		setVisibility(varUpdater.getUpdatedValues());
			
	}
	
	private void setVisibility(Map<String,Value> runTimeValues){
		boolean isVisible=((BoolLit) ExprEvaluator.eval(condition, runTimeValues)).getValue();
		if(panel.getName().equals(QLElsePanel.ELSE_BODY_ID)){
		panel.setVisible(!isVisible);
		return;
		}
		panel.setVisible(isVisible);
	}
	
	
	
	
}
