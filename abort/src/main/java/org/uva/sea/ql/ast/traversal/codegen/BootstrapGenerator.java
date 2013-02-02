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
	
	@Override
	public ST visit(final Add add) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Neg neg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Not not) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Pos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Computation computation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Form form) {
		ST st = templateGroup.getInstanceOf("form");
		// st.add("${form.fields}", form.getElements().get(0).accept(this));
		st.add("fields", getFilledFormTemplates(form.getElements()));
		System.out.println(st.render());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final MoneyLiteral money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final StringLiteral literal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ST visit(final Ident ident) {
		// TODO Auto-generated method stub
		return null;
	}

}
