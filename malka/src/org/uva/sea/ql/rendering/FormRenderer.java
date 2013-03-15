package org.uva.sea.ql.rendering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.RuntimeTypeError;
import org.uva.sea.ql.ast.expression.Type;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.bool.BooleanPrimitive;
import org.uva.sea.ql.ast.expression.bool.BooleanType;
import org.uva.sea.ql.ast.expression.bool.BooleanVariable;
import org.uva.sea.ql.ast.expression.bool.operation.logical.And;
import org.uva.sea.ql.ast.expression.bool.operation.logical.Not;
import org.uva.sea.ql.ast.expression.bool.operation.logical.Or;
import org.uva.sea.ql.ast.expression.bool.operation.relational.Eq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.GEq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.GT;
import org.uva.sea.ql.ast.expression.bool.operation.relational.LEq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.LT;
import org.uva.sea.ql.ast.expression.bool.operation.relational.NEq;
import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.ast.expression.integer.IntegerPrimitive;
import org.uva.sea.ql.ast.expression.integer.IntegerType;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.integer.operation.Add;
import org.uva.sea.ql.ast.expression.integer.operation.Div;
import org.uva.sea.ql.ast.expression.integer.operation.Mul;
import org.uva.sea.ql.ast.expression.integer.operation.Neg;
import org.uva.sea.ql.ast.expression.integer.operation.Pos;
import org.uva.sea.ql.ast.expression.integer.operation.Sub;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.expression.string.StringType;
import org.uva.sea.ql.ast.expression.string.StringVariable;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.variablebinding.VariableBinder;
import org.uva.sea.ql.visitor.NodeNotSupportedByVisitorException;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

public class FormRenderer implements Visitor, QuestionnaireRenderer,
        ChangeListener, ActionListener {
	
	JFrame frame;
	JPanel panel;
	Form form;
	Map<Identifier, Primitive> variable_values;
	Map<Identifier, JComponent> variable_fields;
	
	private JComponent getFieldFromType(Type type, Primitive value) {
		JComponent field = null;
		
		if (type instanceof BooleanType && value instanceof BooleanPrimitive) {
			boolean boolean_value = false;
			boolean_value = ((BooleanPrimitive)value).evaluate();
			field = new JCheckBox("Yes");
			((JCheckBox)field).setSelected(boolean_value);
			
			((JCheckBox)field).addActionListener(this);
		} else if(type instanceof IntegerType && value instanceof IntegerPrimitive) {
			int int_value = 0;
			int_value = ((IntegerPrimitive)value).evaluate();
			field = new JSpinner();
			((JSpinner)field).setValue(new Integer((int_value)));
			((JSpinner)field).addChangeListener(this);
		} else if(type instanceof StringType && value instanceof StringPrimitive) {
			String string_value;
			string_value = ((StringPrimitive) value).evaluate();
			field = new JTextField();
			((JTextField) field).setText(string_value);
			((JTextField)field).addActionListener(this);
		} else {
			throw new RuntimeTypeError();
		}
		
		return field;
	}
	
	/*
	 * sets the value of the primitive from the value of the field
	 */
	private Primitive getPrimitiveFromField(JComponent field, Primitive primitive) {
		if (field instanceof JCheckBox) {
			primitive = new BooleanPrimitive(((JCheckBox)field).isSelected());
		} else if(field instanceof JSpinner) {
			Integer integer = (Integer)((JSpinner)field).getValue();
			primitive = new IntegerPrimitive(integer.intValue());
		} else {
			primitive = new StringPrimitive(((JTextField)field).getText());
		}
		return primitive;
	}
	
	/*
	 * fills in the bound values of the variables from the fields
	 */
	private void calculateVariableValuesFromFields() {
		for (Identifier id : variable_fields.keySet()) {
			Primitive value = variable_values.get(id);
			
			value = getPrimitiveFromField(variable_fields.get(id), value);
			
			variable_values.put(id, value);
		}
	}
	
	/*
	 * Calculates the value of the variable (if bound, it is bound and evaluated)
	 * and keeps the member variable up-to-date
	 */
	private Primitive calculateVariableValue(Variable variable, Type type) {
		Primitive value;
		if ( variable_values.containsKey(variable.getID())) {
			value = variable_values.get(variable.getID());
		} else {
			value = type.getPrimitive();
			variable_values.put(variable.getID(), value);
		}
		
		return value;
	}
	
	private String getCalculationString(Expression calculation) {
		// Maybe put this logic inside evaluateToString in expression self?
		String value = null;
		if (calculation instanceof IntegerExpression) {
			IntegerExpression e = ((IntegerExpression) calculation);
			return new Integer(e.evaluate()).toString();
		} else if (calculation instanceof IntegerExpression) {
			IntegerExpression e = ((IntegerExpression) calculation);
			return new Integer(e.evaluate()).toString();
		} else if (calculation instanceof IntegerExpression) {
			IntegerExpression e = ((IntegerExpression) calculation);
			return new Integer(e.evaluate()).toString();
		} else {
			// TODO some error handling here??
		}
		
		return value;
	}
	
	
	public FormRenderer(Form form) {
		panel = new JPanel(new MigLayout("fillx,insets 1"));
		
		variable_values = new HashMap<Identifier, Primitive>();
		variable_fields = new HashMap<Identifier, JComponent>();
		
		this.form = form;
	}
	
	public void render(JFrame frame) throws VisitingException{
		this.frame = frame;
		panel.removeAll();
		
		form.accept(this);
		
		if (frame.getContentPane() != panel) {
			frame.add(panel);
			frame.setContentPane(panel);
		}
		
		panel.validate();
		panel.repaint();
	}
	

	@Override
	public void stateChanged(ChangeEvent event) {
		calculateVariableValuesFromFields();
		
		try {
			VariableBinder binder = new VariableBinder();
			binder.bindVariables(form, variable_values);
			
			render(frame);
		} catch (VisitingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		calculateVariableValuesFromFields();
		
		try {
			VariableBinder binder = new VariableBinder();
			binder.bindVariables(form, variable_values);
			
			render(frame);
		} catch (VisitingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/*
	 * Visiting functions
	 */
	
	@Override
	public void visit(Form form) throws VisitingException {
		List<FormElement> elements = form.getElements(); 
		for(FormElement element : elements) {
			element.accept(this);
		}
	}
	
	@Override
	public void visit(Question question) throws VisitingException {
		JComponent field;
		Variable variable;
		Primitive variable_value;
		
		panel.add(new JLabel(question.getLabel()));
		
		variable = question.getVariable();
		
		variable_value = calculateVariableValue(variable, question.getType());
		
		field = getFieldFromType(question.getType(), variable_value);
		variable_fields.put(variable.getID(), field);
		
		panel.add(field, "width :200:, wrap");
	}
	
	@Override
	public void visit(FormText form_text) throws VisitingException {
		panel.add(new JLabel(form_text.getLabel()));
		
		// TODO real evaluation!
		//form_text.getCalculation()
		
		panel.add(new JLabel(getCalculationString(form_text.getCalculation())), "width :200:, wrap");
	}
	
	@Override
	public void visit(IfStatement if_statement) throws VisitingException {
		List<FormElement> elements = null;
		boolean condition_result = false;
		
		condition_result = if_statement.getCondition().evaluate();
		
		if (condition_result) {
			elements = if_statement.getIfList();
		} else {
			elements = if_statement.getElseList();
		}
		
		if (elements != null) {
			for(FormElement element : elements) {
				element.accept(this);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	/*
	 * Following are not needed. Should be unreachable for visitor!
	 */
	
	
	
	@Override
	public void visit(Identifier identifier) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}
	
	@Override
	public void visit(BooleanPrimitive booleanPrimitive)
			throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(BooleanVariable booleanVariable) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(And and) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Not not) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Or or) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Eq eq) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(GT gt) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(IntegerPrimitive integerPrimitive)
			throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(IntegerVariable integerVariable) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(GEq gEq) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(LEq lEq) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(NEq nEq) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(LT lt) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Sub sub) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Neg neg) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Mul mul) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Div div) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Add add) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(Pos pos) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(StringVariable stringVariable) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

	@Override
	public void visit(StringPrimitive stringPrimitive) throws VisitingException {
		throw new NodeNotSupportedByVisitorException();
	}

}