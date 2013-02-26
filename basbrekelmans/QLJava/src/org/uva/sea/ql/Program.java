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
import org.uva.sea.ql.parser.QLError;
import org.uva.sea.ql.runtime.RuntimeValues;
import org.uva.sea.ql.runtime.ui.IUserInterfaceFactory;
import org.uva.sea.ql.runtime.ui.IWindow;
import org.uva.sea.ql.runtime.ui.swing.SwingUserInterfaceFactory;
import org.uva.sea.ql.typechecking.ITypeChecker;
import org.uva.sea.ql.typechecking.TypeChecker;

public class Program {

	public static void main(final String[] args) throws IOException {
		if (args.length == 0) {
			System.err.println("Please provide a file name as argument.");
		}
		final String fileName = args[0];
		final InputStream fileStream = new FileInputStream(new File(fileName));
		final IParser parser = new JACCParser();
		final Form root = (Form) parser.parse(readStream(fileStream), fileName);
		final ITypeChecker checker = new TypeChecker();
		checker.checkTypes(root);

		for (final QLError error : checker.getErrors()) {
			System.err.println(error.getMessage());
		}
		if (checker.hasErrors()) {
			System.in.read();
			return;
		}

		final IVariableResolver varResolver = new VariableResolver();
		final RuntimeValues variables = varResolver.getRuntimeValues(root);
		for (final QLError error : varResolver.getErrors()) {
			System.err.println(error.getMessage());
		}
		if (varResolver.hasErrors()) {
			System.in.read();
			return;
		}
		final IUserInterfaceFactory var = new SwingUserInterfaceFactory(
				checker.getSymbolTable(), variables);
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
