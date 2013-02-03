package org.uva.sea.ql.ast.traversal.codegen;

import java.util.ArrayList;
import java.util.List;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.binary.Add;
import org.uva.sea.ql.ast.operators.binary.And;
import org.uva.sea.ql.ast.operators.binary.Div;
import org.uva.sea.ql.ast.operators.binary.Eq;
import org.uva.sea.ql.ast.operators.binary.GEq;
import org.uva.sea.ql.ast.operators.binary.GT;
import org.uva.sea.ql.ast.operators.binary.LEq;
import org.uva.sea.ql.ast.operators.binary.LT;
import org.uva.sea.ql.ast.operators.binary.Mul;
import org.uva.sea.ql.ast.operators.binary.NEq;
import org.uva.sea.ql.ast.operators.binary.Or;
import org.uva.sea.ql.ast.operators.binary.Sub;
import org.uva.sea.ql.ast.operators.unary.Neg;
import org.uva.sea.ql.ast.operators.unary.Not;
import org.uva.sea.ql.ast.operators.unary.Pos;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.BoolType;
import org.uva.sea.ql.ast.types.datatypes.DataType;
import org.uva.sea.ql.ast.types.datatypes.MoneyType;
import org.uva.sea.ql.ast.types.literals.BoolLiteral;
import org.uva.sea.ql.ast.types.literals.IntLiteral;
import org.uva.sea.ql.ast.types.literals.MoneyLiteral;
import org.uva.sea.ql.ast.types.literals.StringLiteral;

public class BootstrapGenerator implements IVisitor<ST> {
	private final STGroupFile templateGroup = new STGroupFile("codegeneration/bootstrap.stg", '$', '$');
	
	public String generateFrontend(final Form form) {
		final ST formTemplate = form.accept(this);
		final STGroupFile index = new STGroupFile("codegeneration/index.stg", '$',  '$');
		final ST pageTemplate = index.getInstanceOf("page");
		pageTemplate.add("title", form.getName());
		pageTemplate.add("fields", formTemplate);
		return pageTemplate.render();
	}
	
	@Override
	public ST visit(final Add add) {
		final ST st = templateGroup.getInstanceOf("add");
		st.add("lhs", add.getLeftHandSide().accept(this));
		st.add("rhs", add.getRightHandSide().accept(this));
		return st;
	}

	@Override
	public ST visit(final And and) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Div div) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Eq eq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final GEq geq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final GT gt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final LEq leq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final LT lt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Mul mul) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final NEq neq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Or or) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Sub sub) {
		final ST st = templateGroup.getInstanceOf("sub");
		st.add("lhs", sub.getLeftHandSide().accept(this));
		st.add("rhs", sub.getRightHandSide().accept(this));
		return st;
	}

	@Override
	public ST visit(final Neg neg) {
		final ST st = templateGroup.getInstanceOf("neg");
		st.add("expression", neg.getExpression().accept(this));
		return st;
	}

	@Override
	public ST visit(final Not not) {
		final ST st = templateGroup.getInstanceOf("not");
		st.add("expression", not.getExpression().accept(this));
		return st;
	}

	@Override
	public ST visit(final Pos pos) {
		final ST st = templateGroup.getInstanceOf("pos");
		st.add("expression", pos.getExpression().accept(this));
		return st;
	}

	@Override
	public ST visit(final Computation computation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Form form) {
		final ST st = templateGroup.getInstanceOf("form");
		st.add("fields", getFilledFormTemplates(form.getElements()));
		return st;
	}
	
	private List<ST> getFilledFormTemplates(final List<Element> elements) {
		final List<ST> templates = new ArrayList<ST>();
		for (final Element element : elements) {
			if (element instanceof Question) { templates.add(element.accept(this)); }
		}
		
		return templates;
	}

	@Override
	public ST visit(final Question question) {
		final Class<? extends DataType> type = question.getExpectedType().getClass();
		ST questionTemplate;
		if (type.equals(MoneyType.class)){
			questionTemplate = templateGroup.getInstanceOf("question_money");
		}
		else if (type.equals(BoolType.class)) {
			questionTemplate = templateGroup.getInstanceOf("question_bool");
		}
		else {
			questionTemplate = templateGroup.getInstanceOf("question_string_or_int");
		}
		
		questionTemplate.add("id", question.getIdent().getName());
		questionTemplate.add("text", question.getText());

		return questionTemplate;
	}

	@Override
	public ST visit(final IfThen ifThen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final IfThenElse ifThenElse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final BoolLiteral bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final IntLiteral i) {

		return null;
	}

	@Override
	public ST visit(final MoneyLiteral money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final StringLiteral literal) {
		final ST st = templateGroup.getInstanceOf("stringliteral");
		st.add("literal", literal.getValue());
		return st;
	}

	@Override
	public ST visit(final Ident ident) {
		// TODO Auto-generated method stub
		return null;
	}

}
