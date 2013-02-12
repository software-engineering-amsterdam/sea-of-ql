package org.uva.sea.ql.ast.traversal.codegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import org.uva.sea.ql.ast.conditionals.IfThen;
import org.uva.sea.ql.ast.conditionals.IfThenElse;
import org.uva.sea.ql.ast.form.Computation;
import org.uva.sea.ql.ast.form.Element;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.operators.base.BinaryOperator;
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

// TODO: wrapping class for header and body to return instead of ST's, hierarchy so that form returns a single element
public class BootstrapGenerator implements IVisitor<ST> {
	private final STGroupFile templateGroup = new STGroupFile("codegeneration/index.stg", '$', '$');
	//private final ST bodyTemplate = templateGroup.getInstanceOf("body");
	private final ST headerTemplate = templateGroup.getInstanceOf("javascript_header");
	private final Set<Ident> initialVariables = new HashSet<Ident>();
	// identifier used for conditions in JS
	private int conditionalIdentifier = 0;
	// amount of references to a specific identifier
	private final Map<Ident, Integer> references = new HashMap<Ident, Integer>();

	
	public String generateFrontend(final Form form) {
		final ST formTemplate = form.accept(this);
		final ST pageTemplate = templateGroup.getInstanceOf("page");
		pageTemplate.add("title", form.getName());
		
		// only add dispatch for used references
		for (Ident ident : references.keySet()) {
			if (references.get(ident) > 0) {
				headerTemplate.add("line", templateGroup.getInstanceOf("generate_dispatch").add("id", ident.getName()));
			}
		}
		
		ST js = templateGroup.getInstanceOf("generate_map");
		js.add("variables", getVariables());
		js.add("variables", headerTemplate);
		pageTemplate.add("javascript", js);
		pageTemplate.add("fields", formTemplate);
		return pageTemplate.render();
	}
	
	private ST getVariables() {
		ST retval = templateGroup.getInstanceOf("javascript_header");

		for (Ident ident : initialVariables) {
			ST mapVars = templateGroup.getInstanceOf("generate_map_var");
			mapVars.add("name", ident.getName());
			retval.add("line", mapVars);
		}
		
		return retval;
	}
	
	public boolean generateFrontend(final Form form, final String outputFile) {
		BufferedWriter bufferedWriter = null; 
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(new File(outputFile)));
			bufferedWriter.write(generateFrontend(form));
		}
		catch (IOException e) {
			System.err.println("IO Exception: " + e.getMessage());
			return false;
		}
		finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) { }
			}
		}
		
		return true;
	}
	
	@Override
	public ST visit(final Add add) {
		return getBinaryOperationTemplate(add, "add");
	}

	@Override
	public ST visit(final And and) {
		return getBinaryOperationTemplate(and, "and");
	}

	@Override
	public ST visit(final Div div) {
		return getBinaryOperationTemplate(div, "div");
	}

	@Override
	public ST visit(final Eq eq) {
		return getBinaryOperationTemplate(eq, "eq");
	}

	@Override
	public ST visit(final GEq geq) {
		return getBinaryOperationTemplate(geq, "geq");
	}

	@Override
	public ST visit(final GT gt) {
		return getBinaryOperationTemplate(gt, "gt");
	}

	@Override
	public ST visit(final LEq leq) {
		return getBinaryOperationTemplate(leq, "leq");
	}

	@Override
	public ST visit(final LT lt) {
		return getBinaryOperationTemplate(lt, "lt");
	}

	@Override
	public ST visit(final Mul mul) {
		return getBinaryOperationTemplate(mul, "mul");
	}

	@Override
	public ST visit(final NEq neq) {
		return getBinaryOperationTemplate(neq, "neq");
	}

	@Override
	public ST visit(final Or or) {
		return getBinaryOperationTemplate(or, "or");
	}

	@Override
	public ST visit(final Sub sub) {
		return getBinaryOperationTemplate(sub, "sub");
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
		final Class<? extends DataType> type = computation.getExpectedType().getClass();
		final ST computationTemplate = templateGroup.getInstanceOf("computation");
		
		computationTemplate.add("id", computation.getIdent().getName());
		computationTemplate.add("text", computation.getDescription());
		computationTemplate.add("expression", computation.getExpression().accept(this));

		initIdentifier(computation.getIdent());
		// initialVariables.add(computation.getIdent());
		// headerTemplate.add("line", templateGroup.getInstanceOf("generate_dispatch").add("id", computation.getIdent().getName()));

		return computationTemplate;
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
			templates.add(element.accept(this));
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
		
		initIdentifier(question.getIdent());
		// initialVariables.add(question.getIdent());
		// headerTemplate.add("line", templateGroup.getInstanceOf("generate_dispatch").add("id", question.getIdent().getName()));
	
		return questionTemplate;
	}

	@Override
	public ST visit(final IfThen ifThen) {
		final ST template = templateGroup.getInstanceOf("if_then");
		template.add("id", getConditionIdentifier());
		template.add("condition", ifThen.getCondition().accept(this));
		template.add("success_elements", getFilledFormTemplates(ifThen.getSuccessElements()));
		return template;
	}

	@Override
	public ST visit(final IfThenElse ifThenElse) {
		final ST template = templateGroup.getInstanceOf("if_then_else");
		template.add("id", getConditionIdentifier());
		template.add("condition", ifThenElse.getCondition().accept(this));
		template.add("success_elements", getFilledFormTemplates(ifThenElse.getSuccessElements()));
		template.add("else_elements", getFilledFormTemplates(ifThenElse.getElseElements()));
		return template;
	}
	
	@Override
	public ST visit(final BoolLiteral bool) {
		final ST st = templateGroup.getInstanceOf("boolliteral");
		st.add("literal", bool.getValue());
		return st;
	}

	@Override
	public ST visit(final IntLiteral i) {
		final ST st = templateGroup.getInstanceOf("intliteral");
		st.add("literal", i.getValue());
		return st;
	}

	@Override
	public ST visit(final MoneyLiteral money) {
		final ST st = templateGroup.getInstanceOf("moneyliteral");
		st.add("literal", money.getValue());
		return st;
	}

	@Override
	public ST visit(final StringLiteral literal) {
		final ST st = templateGroup.getInstanceOf("stringliteral");
		st.add("literal", literal.getValue());
		return st;
	}

	@Override
	public ST visit(final Ident ident) {
		// only visited by computation
		final ST st = templateGroup.getInstanceOf("ident");
		st.add("name", ident.getName());
		
		references.put(ident, references.get(ident) + 1);
		
		return st;
	}
	
	private ST getBinaryOperationTemplate(final BinaryOperator operation, final String templateName) { 
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("lhs", operation.getLeftHandSide().accept(this));
		st.add("rhs", operation.getRightHandSide().accept(this));
		return st;
	}

	private String getConditionIdentifier() {
		final String conditionIdentifier = String.format("condition-%d", conditionalIdentifier);
		conditionalIdentifier++;	
		return conditionIdentifier;
	}
	
	private void initIdentifier(Ident ident) {
		references.put(ident, 0);
	}
}
