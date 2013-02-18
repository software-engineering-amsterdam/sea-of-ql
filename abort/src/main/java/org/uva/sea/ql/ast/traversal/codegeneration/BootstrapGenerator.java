package org.uva.sea.ql.ast.traversal.codegeneration;

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
import org.uva.sea.ql.ast.traversal.codegeneration.base.*;
import org.uva.sea.ql.ast.types.Ident;
import org.uva.sea.ql.ast.types.datatypes.*;
import org.uva.sea.ql.ast.types.literals.*;

/**
 * Generates a Twitter Bootstrap Front-end.
 * 
 * @author J. Dijkstra
 */
public class BootstrapGenerator implements IVisitor<ST>, IWebGenerator {
	/**
	 * Filename of the template to use.
	 */
	private static final String TEMPLATE_FILE_NAME = "bootstrap_index.stg";
	/**
	 * Delimiter for the template.
	 */
	private static final char TEMPLATE_DELIMITER = '$';

	/**
	 * Javascript code generator to use.
	 */
	private final BootstrapJavascriptGenerator javascriptGenerator;
	
	/**
	 * TemplateGroup to use for the HTML contents;
	 */
	private final STGroupFile templateGroup;

	/**
	 * Identifier used for condition blocks (as they do not have a name by themselves).
	 */
	private int conditionalIdentifier = 0;
	
	/**
	 * Constructor.
	 * 
	 * @param templatesPath path to retrieve the code generation templates (stringtemplates) from.
	 * @param serverBaseURL base URL for the server to use in the front-end code.
	 */
	public BootstrapGenerator(final String templatesPath, final String serverBaseURL) {
		final String mainTemplateFilePath = String.format("%s/%s", templatesPath, TEMPLATE_FILE_NAME);
		
		// Init variables by path parameters provided from the config file.
		templateGroup = new STGroupFile(mainTemplateFilePath, TEMPLATE_DELIMITER, TEMPLATE_DELIMITER);
		javascriptGenerator = new BootstrapJavascriptGenerator(templatesPath, serverBaseURL);
	}

	@Override
	public void generateFrontEnd(final Form form, final String outputDirectory, final String outputFilename) throws WebGenerationException {
		try {
			final File outputFile = new File(outputDirectory, outputFilename);
			IOUtils.write(renderFrontEnd(form), new FileOutputStream(outputFile));
		}
		catch (IOException e) {
			throw new WebGenerationException(e);
		}
	}
	
	/**
	 * Renders complete Front-End to string.
	 * @param form input form to render.
	 * @return Front-End code in a string.
	 */
	private String renderFrontEnd(final Form form) {
		final ST formTemplate = form.accept(this);
		final ST pageTemplate = templateGroup.getInstanceOf("page");
		pageTemplate.add("title", form.getName());
		pageTemplate.add("javascript", javascriptGenerator.render());
		pageTemplate.add("fields", formTemplate);
		return pageTemplate.render();
	}

	@Override
	public ST visit(final Form form) {
		final ST st = templateGroup.getInstanceOf("form");
		st.add("name", form.getName());
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
		else if (type.equals(StringType.class)) {
			questionTemplate = templateGroup.getInstanceOf("question_string");
		}
		else {
			questionTemplate = templateGroup.getInstanceOf("question_int");
		}


		final Ident id = question.getIdent();
		questionTemplate.add("id", id.getName());
		questionTemplate.add("text", question.getText());

		// Start calculating references to this question.
		javascriptGenerator.initIdentReference(id);

		return questionTemplate;
	}

	@Override
	public ST visit(final IfThen ifThen) {
		final ST template = templateGroup.getInstanceOf("if_then");
		initConditionalTemplate(ifThen, template);
		return template;
	}

	@Override
	public ST visit(final IfThenElse ifThenElse) {
		final ST template = templateGroup.getInstanceOf("if_then_else");
		initConditionalTemplate(ifThenElse, template);
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
		// Should only visited by computation
		final ST st = templateGroup.getInstanceOf("ident");
		st.add("name", ident.getName());

		// Increase the count on references of the ident (to render code more efficiently)
		javascriptGenerator.increaseIdentReferenceCount(ident);
		return st;
	}
	
	/**
	 * Retrieve a filled in literal template.
	 * 
	 * @param literal literal
	 * @param templateName template name to use for the literal 
	 * @return filled literal template
	 */
	private <T> ST getLiteralTemplate(final LiteralType<T> literal, final String templateName) {
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("literal", literal.getValue());
		return st;
	}
	
	/**
	 * Retrieve a filled unary operation template.
	 * 
	 * @param operation operation
	 * @param templateName template name to use for the operation
	 * @return filled unary operation template
	 */
	private ST getUnaryOperationTemplate(final UnaryOperator operation, final String templateName) {
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("expression", operation.getExpression().accept(this));
		return st;
	}

	/**
	 * Retrieve a filled binary operation template.
	 * 
	 * @param operation operation
	 * @param templateName template name to use for the operation
	 * @return filled binary operation template
	 */
	private ST getBinaryOperationTemplate(final BinaryOperator operation, final String templateName) { 
		final ST st = templateGroup.getInstanceOf(templateName);
		st.add("lhs", operation.getLeftHandSide().accept(this));
		st.add("rhs", operation.getRightHandSide().accept(this));
		return st;
	}

	/**
	 * Initialize a conditional template code block.
	 * 
	 * @param statement IfStatement to fill in and initialize
	 * @param templateToInitialize template to initialize
	 */
	private void initConditionalTemplate(final IfStatement statement, final ST templateToInitialize) {
		final String id = getConditionIdentifier();
		final ST conditionTemplate = statement.getCondition().accept(this);
		templateToInitialize.add("id", id);
		templateToInitialize.add("condition", conditionTemplate);
		templateToInitialize.add("success_elements", getFilledFormTemplates(statement.getSuccessStatements()));

		// Generate a function for the condition to use for javascript evaluation of the condition
		javascriptGenerator.declareFunction(id, conditionTemplate);
	}
	
	/**
	 * Retrieve filled form templates by a list of statements.
	 * 
	 * @param statements statements to generate a template of (by visiting the nodes)
	 * @return list of filled form templates
	 */
	private List<ST> getFilledFormTemplates(final List<Statement> statements) {
		final List<ST> templates = new ArrayList<ST>();
		for (final Statement statement : statements) {
			templates.add(statement.accept(this));
		}

		return templates;
	}
	
	/**
	 * Retrieve an identifier for a conditional block, as they need a name in HTML and javascript.
	 * 
	 * @return identifier name for a conditional
	 */
	private String getConditionIdentifier() {
		final String conditionIdentifier = String.format("condition%d", conditionalIdentifier);
		conditionalIdentifier++;	
		return conditionIdentifier;
	}
}