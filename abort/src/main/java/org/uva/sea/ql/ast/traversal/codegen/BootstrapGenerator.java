package org.uva.sea.ql.ast.traversal.codegen;

import java.io.*;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.stringtemplate.v4.*;
import org.uva.sea.ql.ast.conditionals.*;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.operators.base.*;
import org.uva.sea.ql.ast.operators.binary.*;
import org.uva.sea.ql.ast.operators.unary.*;
import org.uva.sea.ql.ast.traversal.base.IVisitor;
import org.uva.sea.ql.ast.traversal.codegen.base.WebGenerationException;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.ast.types.literals.*;

public class BootstrapGenerator implements IVisitor<ST>, IWebGenerator {
	private final BootstrapJavascriptGenerator javascriptGenerator = new BootstrapJavascriptGenerator();
	private final STGroupFile templateGroup = new STGroupFile("codegeneration/bootstrap_index.stg", '$', '$');

	// Identifier used for condition blocks
	private int conditionalIdentifier = 0;

	public String generateFrontend(final Form form) {
		final ST formTemplate = form.accept(this);
		final ST pageTemplate = templateGroup.getInstanceOf("page");
		pageTemplate.add("title", form.getName());
		pageTemplate.add("javascript", javascriptGenerator.render());
		pageTemplate.add("fields", formTemplate);
		return pageTemplate.render();
	}

	@Override
	public void generateFrontend(final Form form, final String outputFile) throws WebGenerationException {
		try {
			IOUtils.write(generateFrontend(form), new FileOutputStream(outputFile));
		}
		catch (IOException e) {
			throw new WebGenerationException(e);
		}
		/*BufferedWriter bufferedWriter = null; 
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
		*/
	}

	@Override
	public ST visit(final Form form) {
		final ST st = templateGroup.getInstanceOf("form");
		st.add("fields", getFilledFormTemplates(form.getStatements()));
		return st;
	}
	
	@Override
	public ST visit(final Computation computation) {
		final ST computationTemplate = templateGroup.getInstanceOf("computation");
		final ST expressionTemplate = computation.getExpression().accept(this);

		computationTemplate.add("id", computation.getIdent().getName());
		computationTemplate.add("text", computation.getDescription());
		computationTemplate.add("expression", expressionTemplate);
		
		// TODO: create toString method everywhere
		computationTemplate.add("type", computation.getClass().getName());

		javascriptGenerator.declareFunction(computation.getIdent(), expressionTemplate);

		return computationTemplate;
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

		final Ident id = question.getIdent();
		questionTemplate.add("id", id.getName());
		questionTemplate.add("text", question.getText());

		javascriptGenerator.initIdentReference(id);
		return questionTemplate;
	}

	@Override
	public ST visit(final IfThen ifThen) {
		final ST template = templateGroup.getInstanceOf("if_then");
		initConditionalTemplate(template, ifThen);
		return template;
	}

	@Override
	public ST visit(final IfThenElse ifThenElse) {
		final ST template = templateGroup.getInstanceOf("if_then_else");
		initConditionalTemplate(template, ifThenElse);
		template.add("else_elements", getFilledFormTemplates(ifThenElse.getElseStatements()));
		return template;
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
		return getUnaryOperationTemplate(neg, "neg");
	}

	@Override
	public ST visit(final Not not) {
		return getUnaryOperationTemplate(not, "not");
	}

	@Override
	public ST visit(final Pos pos) {
		return getUnaryOperationTemplate(pos, "pos");
	}

	@Override
	public ST visit(final BoolLiteral literal) {
		return getLiteralTemplate(literal, "boolliteral");
	}

	@Override
	public ST visit(final IntLiteral literal) {
		return getLiteralTemplate(literal, "intliteral");
	}

	@Override
	public ST visit(final MoneyLiteral literal) {
		return getLiteralTemplate(literal, "moneyliteral");
	}

	@Override
	public ST visit(final StringLiteral literal) {
		return getLiteralTemplate(literal, "stringliteral");
	}

	@Override
	public ST visit(final Ident ident) {
		// Only visited by computation
		final ST st = templateGroup.getInstanceOf("ident");
		st.add("name", ident.getName());

		javascriptGenerator.increaseIdentReferenceCount(ident);
		return st;
	}
	
	private <T> ST getLiteralTemplate(final LiteralType<T> literal, final String templateName) {
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("literal", literal.getValue());
		return st;
	}
	
	private ST getUnaryOperationTemplate(final UnaryOperator operation, final String templateName) {
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("expression", operation.getExpression().accept(this));
		return st;
	}

	private ST getBinaryOperationTemplate(final BinaryOperator operation, final String templateName) { 
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("lhs", operation.getLeftHandSide().accept(this));
		st.add("rhs", operation.getRightHandSide().accept(this));
		return st;
	}

	private void initConditionalTemplate(final ST template, final IfStatement statement) {
		final String id = getConditionIdentifier();
		final ST conditionTemplate = statement.getCondition().accept(this);
		template.add("id", id);
		template.add("condition", conditionTemplate);
		template.add("success_elements", getFilledFormTemplates(statement.getSuccessStatements()));

		javascriptGenerator.declareFunction(id, conditionTemplate);
	}
	
	private List<ST> getFilledFormTemplates(final List<Statement> statements) {
		final List<ST> templates = new ArrayList<ST>();
		for (final Statement statement : statements) {
			templates.add(statement.accept(this));
		}

		return templates;
	}
	
	private String getConditionIdentifier() {
		final String conditionIdentifier = String.format("condition%d", conditionalIdentifier);
		conditionalIdentifier++;	
		return conditionIdentifier;
	}
}