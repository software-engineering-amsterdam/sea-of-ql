package org.uva.sea.ql.variablebinding;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Primitive;
import org.uva.sea.ql.ast.expression.Variable;
import org.uva.sea.ql.ast.expression.bool.BooleanPrimitive;
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
import org.uva.sea.ql.ast.expression.integer.IntegerPrimitive;
import org.uva.sea.ql.ast.expression.integer.IntegerVariable;
import org.uva.sea.ql.ast.expression.integer.operation.Add;
import org.uva.sea.ql.ast.expression.integer.operation.Div;
import org.uva.sea.ql.ast.expression.integer.operation.Mul;
import org.uva.sea.ql.ast.expression.integer.operation.Neg;
import org.uva.sea.ql.ast.expression.integer.operation.Pos;
import org.uva.sea.ql.ast.expression.integer.operation.Sub;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.expression.string.StringVariable;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.VisitingException;
import org.uva.sea.ql.visitor.Visitor;

public class VariableBinder implements Visitor {
	Map<Identifier, Primitive> variable_boundations;
	
	
	private void addVariableBoundation(Variable variable) {
		if (variable_boundations.containsKey(variable.getID())) {
			variable.bind(variable_boundations.get(variable.getID()));
		}
	}
	
	/*
	private Primitive getBoundVariableFromId(Identifier id) {
		Primitive primitive = null;
		if (variable_boundations.containsKey(id)) {
			primitive = variable_boundations.get(id);
		} else {
			// TODO error?
		}
		return primitive;
	}
	*/
	
	public void bindVariables(Form form, Map<Identifier, Primitive> variable_boundations) throws VisitingException {
		this.variable_boundations = variable_boundations;
		form.accept(this);
	}
	
	@Override
	public void visit(IfStatement statement) throws VisitingException {
		List<FormElement> elements = statement.getIfList();
		List<FormElement> else_elements = statement.getElseList();
		
		if (else_elements != null) {
			elements.addAll(else_elements);
		}
		
		statement.getCondition().accept(this);
		
		for(FormElement element : elements) {
			element.accept(this);
		}
	}
	
	@Override
	public void visit(BooleanVariable booleanVariable) throws VisitingException {
		addVariableBoundation(booleanVariable);
	}
	
	@Override
	public void visit(IntegerVariable integerVariable) throws VisitingException {
		addVariableBoundation(integerVariable);
	}
	
	
	@Override
	public void visit(StringVariable stringVariable) throws VisitingException {
		addVariableBoundation(stringVariable);
	}
	
	/*
	 * Below are only needed for traversal (watch that identifiers of bound variables
	 * are replaced by an instantiation of that variable)
	 */
	
	@Override
	public void visit(Form form) throws VisitingException {
		List<FormElement> elements = form.getElements(); 
		for(FormElement element : elements) {
			element.accept(this);
		}
	}
	
	@Override
	public void visit(FormText form_text) throws VisitingException {
		form_text.getCalculation().accept(this);
	}
	
	@Override
	public void visit(Question question) throws VisitingException {
		Variable variable = null;
		variable = question.getVariable();
		addVariableBoundation(variable);
	}
	
	@Override
	public void visit(And operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Not not) throws VisitingException {
		not.getOperand().accept(this);
	}
	
	@Override
	public void visit(Or operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Eq operator) throws VisitingException {
		/*
		if (operator.getLeftOperand() instanceof Identifier) {
			Primitive primitive;
			primitive = getBoundVariableFromId((Identifier)operator.getLeftOperand());
			operator.setLeftOperand(primitive);
			
		} else {
			operator.getLeftOperand().accept(this);
		}
		operator.getRightOperand().accept(this);
		*/
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
		
	}
	
	@Override
	public void visit(GT operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(GEq operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(LEq operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(NEq operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(LT operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Sub operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Neg neg) throws VisitingException {
		neg.getOperand().accept(this);
	}
	
	@Override
	public void visit(Mul operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Div operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Add operator) throws VisitingException {
		operator.getLeftOperand().accept(this);
		operator.getRightOperand().accept(this);
	}
	
	@Override
	public void visit(Pos pos) throws VisitingException {
		pos.getOperand().accept(this);
	}
	
	
	/*
	 * These should be leaf node
	 */
	
	@Override
	public void visit(Identifier id) throws VisitingException {
		
	}

	@Override
	public void visit(StringPrimitive stringPrimitive) throws VisitingException {
		
	}
	
	@Override
	public void visit(BooleanPrimitive booleanPrimitive)
			throws VisitingException {
		
		
	}
	
	@Override
	public void visit(IntegerPrimitive integerPrimitive)
			throws VisitingException {
		
		
	}
		
}
