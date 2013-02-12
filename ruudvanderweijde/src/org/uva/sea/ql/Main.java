package org.uva.sea.ql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.visitor.FormRenderer;
import org.uva.sea.ql.visitor.ValueMapper;
import org.uva.sea.ql.visitor.typeCheck.FormTypeCheckVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

/*
 * This file is added to test the QL program
 * and will be removed in the future.
 */
public class Main {

	static public void main(String[] args) throws ParseError {
		ANTLRParser parser = new ANTLRParser();

		TypeMapper typeMapper = new TypeMapper();
		ValueMapper valueMapper = new ValueMapper();
		List<Message> errors = new ArrayList<Message>();

		String qlFile = System.getProperty("user.dir") + "/input/form.ql";
		String strInput = null;

		try {
			strInput = readFile(qlFile);
		} catch (FileNotFoundException e) {
			System.out.println("Failed to find input file '" + qlFile + "'.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("IO Error: " + e.getMessage());
			System.exit(0);
		}

		Form form = parser.parseForm(strInput);
		if (parser.hasErrors()) {
			printErrorsAndQuit(parser.getErrors());
		}

		form.accept(new FormTypeCheckVisitor(typeMapper, errors));

		if (!errors.isEmpty()) {
			printErrorsAndQuit(errors);
		}

		// Render the form
		form.accept(new FormRenderer(valueMapper, errors));

	}

	private static String readFile(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

	private static void printErrorsAndQuit(List<Message> errors) {
		System.out.println("Unable to run the QL form. Please correct the following "
				+ errors.size() + " errors.");
		System.out.println("---------------------------------------------------------------------");
		for (Message message : errors) {
			System.out.println(" -" + message);
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Please correct the errors and try again.");
		System.exit(0);
	}
}