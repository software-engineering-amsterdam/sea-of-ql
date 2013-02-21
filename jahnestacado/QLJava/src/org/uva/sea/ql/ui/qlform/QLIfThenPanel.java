package org.uva.sea.ql.ui.qlform;

import java.util.List;
import java.util.Map;
import java.util.Observer;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QLIfThenPanel extends QLConditionalBody implements Observer {
	
	public final static String IF_THEN_BODY_ID="IF_THEN_BODY_ID";
	
	public QLIfThenPanel(List<JPanel> questionPanelList,Expr condition,VariableUpdater varUpdater,Map<String,Value> runTimeValues){
		super(questionPanelList,condition,varUpdater,runTimeValues);
		setSettings(IF_THEN_BODY_ID);
	}

	
}
