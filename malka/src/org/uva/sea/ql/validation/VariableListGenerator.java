package org.uva.sea.ql.validation;

import org.uva.sea.ql.visitor.NodeNotSupportedByVisitorException;
import org.uva.sea.ql.visitor.Visitor;
import org.uva.sea.ql.visitor.VisitingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.Type;
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

public class VariableListGenerator implements Visitor {
	Map<String, Variable> variables;
	
	private void addVariable(Variable variable) throws DuplicateVariableException {
		if (variables.containsKey(variable.getID().getName())) {
			throw new DuplicateVariableException();
		} else {
			variables.put(variable.getID().getName(), variable);
		}
	}
	
	public VariableListGenerator() {
		variables = new HashMap<String, Variable>();
	}
	
	public Map<String, Variable> getVariableList (Form form)
			throws VisitingException {
		
		form.accept(this);
		return variables;
	}
		
	@Override
	public void visit(Form form) throws VisitingException {
		List<FormElement> elements = form.getElements(); 
		for(FormElement element : elements) {
			element.accept(this);
		}
	}
	
	@Override
	public void visit(FormText field) throws DuplicateVariableException {
		Identifier id     = field.getId();
		Type type         = field.getType();
		Variable variable = type.getVariable(id); 
		addVariable(variable);
	}
	
	@Override
	public void visit(Question field) throws DuplicateVariableException {
		Identifier id     = field.getId();
		Type type         = field.getType();
		Variable variable = type.getVariable(id); 
		addVariable(variable);
	}
	
	@Override
	public void visit(IfStatement statement) throws VisitingException {
		List<FormElement> elements = statement.getIfList();
		List<FormElement> else_elements = statement.getElseList();
		
		if (else_elements != null) {
			elements.addAll(else_elements);
		}
		
		for(FormElement element : elements) {
			element.accept(this);
		}
	}

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
		// TODO Auto-generated method stub
		
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