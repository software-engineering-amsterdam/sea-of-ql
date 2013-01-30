package org.uva.sea.ql.interpreter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.Body;
import org.uva.sea.ql.ast.form.BodyElement;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IfThen;
import org.uva.sea.ql.ast.form.IfThenElse;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.visitor.IElementVisitor;

public class SwingVisitor implements IElementVisitor{
	private static  List<JPanel> questionList;
	
	public SwingVisitor(List<JPanel> questionList){
		this.questionList=questionList;
	}
	
	
	public static void generate(Form form){
		List<JPanel> questionList=new ArrayList<JPanel>();
		SwingVisitor visitor=new SwingVisitor(questionList);
		form.accept(visitor);
		
	}

	@Override
	public void visit(Form qlElement) {
       String formName=qlElement.getId().getName();
       qlElement.getBody().accept(this);
	}

	@Override
	public void visit(Body qlElement) {
		List<BodyElement> bodyList=qlElement.getBodyElement();
		for(BodyElement element:bodyList){
			element.accept(this);
		}

	}

	@Override
	public void visit(Question qlElement) {
        String label=qlElement.getLabel().getValue();
        Type type=qlElement.getType();
        addQuestion(label, type);
	}

	@Override
	public void visit(ComputedQuestion qlElement) {
		 String label=qlElement.getLabel().getValue();
	     Type type=qlElement.getType();
	     Value expr=ExprEvaluator.eval(qlElement.getExpr());
	     addComputedQuestion(label, type,expr);

	}

	@Override
	public void visit(IfThenElse qlElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(IfThen qlElement) {

	}

	private void addQuestion(String question,Type type){
		JPanel panel=new JPanel();
		panel.setLayout(new MigLayout("","[right][]","[]"));
		JLabel label=new JLabel(question);
		JTextField input=new JTextField(10);
		panel.add(label,"align right");
		panel.add(input,"wrap");
		questionList.add(panel);
		
	}
	
	private void addComputedQuestion(String question,Type type,Value expr){
		JPanel panel=new JPanel();
		panel.setLayout(new MigLayout("","[right][][]","[]"));
		JLabel label=new JLabel(question);
		JTextField input=new JTextField(10);
		JTextField input2=new JTextField(expr.getValue().toString());
		panel.add(label,"align right");
		panel.add(input);
		panel.add(input2,"wrap");
		questionList.add(panel);
		
	}
	
	public static List<JPanel> getQL(){
		return questionList;
	}
}
