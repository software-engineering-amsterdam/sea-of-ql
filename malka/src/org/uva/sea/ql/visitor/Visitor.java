package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.expression.Identifier;
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
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.form.IfStatement;
import org.uva.sea.ql.ast.form.Question;

public interface Visitor {

	void visit(Form form) throws VisitorException;

	void visit(Question question) throws VisitorException;

	void visit(FormText form_text) throws VisitorException;
	
	void visit(IfStatement ifStatement) throws VisitorException;

	void visit(Identifier identifier) throws VisitorException;

	void visit(BooleanPrimitive booleanPrimitive) throws VisitorException;

	void visit(BooleanVariable booleanVariable) throws VisitorException;

	void visit(And and) throws VisitorException;

	void visit(Not not) throws VisitorException;

	void visit(Or or) throws VisitorException;

	void visit(Eq eq) throws VisitorException;

	void visit(GT gt) throws VisitorException;

	void visit(IntegerPrimitive integerPrimitive) throws VisitorException;
	
	void visit(IntegerVariable integerVariable) throws VisitorException;

	void visit(GEq gEq) throws VisitorException;

	void visit(LEq lEq) throws VisitorException;

	void visit(NEq nEq) throws VisitorException;

	void visit(LT lt) throws VisitorException;

	void visit(Sub sub) throws VisitorException;

	void visit(Neg neg) throws VisitorException;

	void visit(Mul mul) throws VisitorException;

	void visit(Div div) throws VisitorException;

	void visit(Add add) throws VisitorException;

	void visit(Pos pos) throws VisitorException;

	void visit(StringVariable stringVariable) throws VisitorException;

	void visit(StringPrimitive stringPrimitive) throws VisitorException;
	
}
