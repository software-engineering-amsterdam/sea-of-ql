package org.uva.sea.ql.core.dom.visitors.tests;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.Identifier;
import org.uva.sea.ql.core.dom.Variable;
import org.uva.sea.ql.core.dom.operators.arithmetic.Add;
import org.uva.sea.ql.core.dom.operators.conditional.Or;
import org.uva.sea.ql.core.dom.operators.relational.NEq;
import org.uva.sea.ql.core.dom.operators.unary.Pos;
import org.uva.sea.ql.core.dom.types.declarations.BooleanDeclaration;
import org.uva.sea.ql.core.dom.types.declarations.TypeDeclaration;
import org.uva.sea.ql.core.dom.visitors.ExpressionVisitorToCheckIdentifierDefinitions;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class ExpressionVisitorToCheckIdentifierDefinitionsTests {
	
	private ExpressionVisitorToCheckIdentifierDefinitions target;
	private List<Variable> variableList;
	
	@Before
    public void setUp() {
		variableList=new ArrayList<Variable>();

		String identifierName = "identifier";
		TypeDeclaration type = new BooleanDeclaration();
		
		Variable variable = new Variable (new Identifier(identifierName),type);
		variableList.add(variable);
		
		this.target = new ExpressionVisitorToCheckIdentifierDefinitions(variableList);
    }
	
	@Test
	public void does_addOneErrorInTheList_when_noVariableInTheVariableListHasTheSameNameOfIdentifier() throws ParseException {
		Identifier identifier = new Identifier("newIdentifierName");		
		target.visit(identifier);
		
		assertEquals(1,target.getExceptions().size());
	}
	
	@Test
	public void does_addErrorsInTheList_when_noVariableInTheVariableListHasTheSameNameOfIdentifierWithinArithmeticalOperator() throws ParseException {
		Identifier identifier = new Identifier("newIdentifierName");	
		Identifier identifier2 = new Identifier("newIdentifierName2");
		Add add = new Add(identifier,identifier2);
		target.visit(add);
		
		assertEquals(2,target.getExceptions().size());
	}
	
	@Test
	public void does_addErrorsInTheList_when_noVariableInTheVariableListHasTheSameNameOfIdentifierWithinRelationalOperator() throws ParseException {
		Identifier identifier = new Identifier("newIdentifierName");	
		Identifier identifier2 = new Identifier("newIdentifierName2");
		NEq nEq = new NEq(identifier,identifier2);
		target.visit(nEq);
		
		assertEquals(2,target.getExceptions().size());
	}
	
	@Test
	public void does_addErrorsInTheList_when_noVariableInTheVariableListHasTheSameNameOfIdentifierWithinConditionalOperator() throws ParseException {
		Identifier identifier = new Identifier("newIdentifierName");	
		Identifier identifier2 = new Identifier("newIdentifierName2");
		Or or = new Or(identifier,identifier2);
		target.visit(or);
		
		assertEquals(2,target.getExceptions().size());
	}
	
	@Test
	public void does_addErrorsInTheList_when_noVariableInTheVariableListHasTheSameNameOfIdentifierWithinUnaryOperator() throws ParseException {
		Identifier identifier = new Identifier("newIdentifierName");	
		Pos pos = new Pos(identifier);
		target.visit(pos);
		
		assertEquals(1,target.getExceptions().size());
	}
}
