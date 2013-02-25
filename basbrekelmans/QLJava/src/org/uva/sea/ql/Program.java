package org.uva.sea.ql;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.dependencies.IVariableResolver;
import org.uva.sea.ql.dependencies.VariableResolver;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.runtime.ExpressionEvaluator;
import org.uva.sea.ql.runtime.IExpressionEvaluator;
import org.uva.sea.ql.runtime.RuntimeEnvironment;
import org.uva.sea.ql.runtime.Variables;
import org.uva.sea.ql.runtime.ui.IUserInterfaceFactory;
import org.uva.sea.ql.runtime.ui.IWindow;
import org.uva.sea.ql.runtime.ui.swing.SwingUserInterfaceFactory;
import org.uva.sea.ql.typechecking.ITypeChecker;
import org.uva.sea.ql.typechecking.ITypeResolver;
import org.uva.sea.ql.typechecking.TypeCheckerFactory;

public class Program {

	public static void main(final String[] args) throws IOException {
		final String fileName = args[0];
		final InputStream fileStream = new FileInputStream(new File(fileName));
		final IParser parser = new JACCParser();
		final Form root = (Form) parser.parse(readStream(fileStream), fileName);

		final ITypeChecker checker = TypeCheckerFactory.createTypeChecker();
		checker.checkTypes(root);

		for (final ParseError error : checker.getContext().getErrors()) {
			System.out.println(error.getMessage());
		}
		if (checker.getContext().hasErrors()) {
			System.in.read();
			return;
		}

		final IVariableResolver varResolver = new VariableResolver();
		final Variables variables = varResolver.getVariables(root);
		for (final ParseError error : varResolver.getErrors()) {
			System.out.println(error.getMessage());
		}
		if (varResolver.hasErrors()) {
			System.in.read();
			return;
		}
		final IExpressionEvaluator evaluator = new ExpressionEvaluator(
				variables);
		final RuntimeEnvironment runtime = new RuntimeEnvironment(variables,
				evaluator);
		final ITypeResolver resolver = checker.getResolver();
		final IUserInterfaceFactory var = new SwingUserInterfaceFactory(
				resolver, variables);
		final IWindow window = var.create(root);
		window.show();
	}

	private static String readStream(final InputStream is) {
		final StringBuilder sb = new StringBuilder(512);
		try {
			final Reader r = new InputStreamReader(is);
			int c = 0;
			while (c != -1) {
				c = r.read();
				sb.append((char) c);
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

}
