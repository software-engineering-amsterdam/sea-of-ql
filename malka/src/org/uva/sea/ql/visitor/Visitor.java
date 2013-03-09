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

	void visit(Form form) throws VisitingException;

	void visit(Question question) throws VisitingException;

	void visit(FormText form_text) throws VisitingException;
	
	void visit(IfStatement ifStatement) throws VisitingException;

	void visit(Identifier identifier) throws VisitingException;

	void visit(BooleanPrimitive booleanPrimitive) throws VisitingException;

	void visit(BooleanVariable booleanVariable) throws VisitingException;

	void visit(And and) throws VisitingException;

	void visit(Not not) throws VisitingException;

	void visit(Or or) throws VisitingException;

	void visit(Eq eq) throws VisitingException;

	void visit(GT gt) throws VisitingException;

	void visit(IntegerPrimitive integerPrimitive) throws VisitingException;
	
	void visit(IntegerVariable integerVariable) throws VisitingException;

	void visit(GEq gEq) throws VisitingException;

	void visit(LEq lEq) throws VisitingException;

	void visit(NEq nEq) throws VisitingException;

	void visit(LT lt) throws VisitingException;

	void visit(Sub sub) throws VisitingException;

	void visit(Neg neg) throws VisitingException;

	void visit(Mul mul) throws VisitingException;

	void visit(Div div) throws VisitingException;

	void visit(Add add) throws VisitingException;

	void visit(Pos pos) throws VisitingException;

	void visit(StringVariable stringVariable) throws VisitingException;

	void visit(StringPrimitive stringPrimitive) throws VisitingException;
	
}
