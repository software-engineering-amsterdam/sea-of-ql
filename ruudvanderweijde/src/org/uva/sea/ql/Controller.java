package org.uva.sea.ql;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.message.Error;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.renderer.FormRenderer;
import org.uva.sea.ql.visitor.typeCheck.FormTypeCheckVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;
import org.uva.sea.ql.visitor.valueCheck.ExpressionValueVisitor;
import org.uva.sea.ql.visitor.valueCheck.ValueMapper;

/**
 * Controller can will list available forms Can parse, validate and save forms
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final IParse parser = new ANTLRParser();
	private static List<Message> errors = new ArrayList<Message>();
	private final String inputDirectory = "forms/";
	private final String outputDirectory = "c:/tmp/forms/";
	private final String templateDirectory = "templates/";;
	private Map<String, TypeMapper> formTypeMapper = new HashMap<String, TypeMapper>();
	private Map<String, ValueMapper> formValueMapper = new HashMap<String, ValueMapper>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			errors.clear();
			
			String formRequest = request.getParameter("form");
			boolean isFormRequested = !(formRequest == null || formRequest.isEmpty());
			
			List<File> qlFiles = getQLFilesFromDirectory(new File(getServletContext().getRealPath(inputDirectory)));

			if (!qlFiles.isEmpty()) {
				if (isFormRequested) {
					File qlFile = new File(getServletContext().getRealPath(
							inputDirectory + "/" + formRequest + ".ql"));
					if (qlFile.exists()) {
						generateForm(qlFile, out);
					} else {
						addError("Unable to find form: " + formRequest);
					}
				} else {
					printListOfForms(out, qlFiles);
				}
			} else {
				addError("No QL files found. Please check the .ql files in the directory: " + inputDirectory);
			}
			if (hasErrors()) {
				printErrorsAsText(out);
			}
		} finally {
			out.close(); // Always close the output writer
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			errors.clear();

			@SuppressWarnings("unchecked")
			Map<String, String> postValues = getFormattedPostValues(request.getParameterMap());
			
			String formRequest = request.getParameter("form");
			boolean isFormRequested = !(formRequest == null || formRequest.isEmpty());
			
			if (isFormRequested) {
				validateInput(formRequest, postValues);
			} else {
				addError("Internal Error. Form not found.");
			}

			if (errors.isEmpty()) {
				String randomFileName = getRandomFileName(new File(outputDirectory), formRequest);
				writeFormValuesToFile(postValues, randomFileName);
			}
			
			printJSONOutput(out);
			
		} finally {
			out.close(); // Always close the output writer
		}
	}

	protected boolean generateForm(File qlFile, PrintWriter output) {
		TypeMapper typeMapper = new TypeMapper();
		ValueMapper valueMapper = new ValueMapper();

		String strInput = null;
		try {
			strInput = readFile(qlFile);
		} catch (FileNotFoundException e) {
			addError("Failed to find input file '" + qlFile.getName() + "'.");
			return false;
		} catch (IOException e) {
			addError("IO Error: " + e.getMessage());
			return false;
		}

		try {
			Form form = parser.parseForm(strInput);

			form.accept(new FormTypeCheckVisitor(typeMapper, errors));
			if (!errors.isEmpty()) {
				return false;
			}
			// Render the form
			File dir = new File(getServletContext().getRealPath(templateDirectory));
			FormRenderer renderer = new FormRenderer(valueMapper, errors, dir.getAbsolutePath());

			form.accept(renderer);
			if (!errors.isEmpty()) {
				return false;
			}
			String formName = qlFile.getName().replaceAll(".ql$", "");
			formTypeMapper.put(formName, typeMapper);
			formValueMapper.put(formName, valueMapper);
			output.println(renderer.getOutput());
		} catch (ParseError e) {
			addError("Error while trying to parse: " + e.getMessage());
			return false;
		}
		return true;
	}

	private boolean validateInput(String formName, Map<String, String> postValues) {
		TypeMapper typeMapper;
		ValueMapper valueMapper;
		if (formTypeMapper.containsKey(formName) && formValueMapper.containsKey(formName)) {
			typeMapper = formTypeMapper.get(formName);
			valueMapper = formValueMapper.get(formName);
		} else {
			addError("Error: Failed to read typeMapper or valueMapper from memory for form '"
					+ formName + "'. Please reload the form.");
			return false;
		}

		for (String key : postValues.keySet()) {
			Ident id = new Ident(key);
			String inputToCheck = postValues.get(key).trim();
			boolean isValidInput = typeMapper.hasTypeKey(id);
			if (isValidInput) {
				if (!inputToCheck.isEmpty()) {
					try {
						Value value = parser.parseExpression(inputToCheck).accept(
								new ExpressionValueVisitor(valueMapper, errors));
						Type questionType = typeMapper.getType(id);
						if (!questionType.isCompatibleTo(value)) {
							addError("Invalid value for '" + key + "'. Please correct the field.");
						}
					} catch (ParseError e) {
						addError("Unable to parse expression '" + key + "'. Please correct the field.");
					}
				}
			} else {
				addError("Internal Error: Key '" + key + "' not found.");
			}
		}
		if (hasErrors()) {
			return false;
		}
		return true;
	}
	
	private Map<String, String> getFormattedPostValues(Map<String, String[]> parameterMap) {
		Map<String, String> postValues = new HashMap<String, String>();
		for (String key : parameterMap.keySet()) {
			if (!key.equals("form")) {
				postValues.put(key, parameterMap.get(key)[0]);
			}
		}
		return postValues;
	}

	public static List<File> getQLFilesFromDirectory(File dir) {
		if (dir.isDirectory()) {
			return Arrays.asList(dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.endsWith(".ql");
				}
			}));
		}
		return Arrays.asList();
	}

	private static String readFile(File file) throws IOException {
		FileInputStream stream = new FileInputStream(file);
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			/* Instead of using default, pass in a decoder. */
			return Charset.defaultCharset().decode(bb).toString();
		} finally {
			stream.close();
		}
	}

	private static void printErrorsAsText(PrintWriter output) throws IOException {
		output.println("<PRE>");
		output.println("Errors found! Please correct the following " + errors.size() + " errors.");
		output.println("---------------------------------------------------------------------");
		for (Message message : errors) {
			output.println(" -" + message);
		}
		output.println("---------------------------------------------------------------------");
		output.println("Please correct the errors and try again.");
		output.println("</PRE>");
		errors.clear();
	}

	private static void printJSONOutput(PrintWriter output) throws IOException {
		StringBuilder json = new StringBuilder();
		
		json.append("{\"Errors\":[");
		if (!errors.isEmpty()) {
			json.append("\"");
			for (Message error : errors) {
				json.append(error.getMessage().replaceAll("\"", "'"));
				json.append("\\r\\n");
			}
			json.append("\"");
		}
		json.append("]}");

		output.println(json.toString());
		errors.clear();
	}

	private void printListOfForms(PrintWriter output, List<File> qlFiles) {
		for (File qlFile : qlFiles) {
			String name = qlFile.getName().replaceAll(".ql$", "");
			output.append("<pre>");
			output.append("Click <a href='?form=" + name + "'>here</a> to fill in " + name);
			output.append("</pre>");
		}

	}

	private static void writeFormValuesToFile(Map<String, String> formValuesMap, String fileName) {
		try {
			String formValues = "";
			for (Map.Entry<String, String> entry : formValuesMap.entrySet()) {
				formValues += entry.getKey() + ";" + entry.getValue() + "\r\n";
			}
			FileWriter file = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(file);
			try {
				out.write(formValues);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			addError("IOException: " + e.getMessage());
		}
	}
	
	private String getRandomFileName(File dir, String formName) {
		String randomFileName = dir.getAbsolutePath();
		randomFileName += "/" + formName + "." + System.nanoTime() + ".values";
		return randomFileName;
	}
	
	private static void addError(String message) {
		errors.add(new Error(message));
	}
	
	private boolean hasErrors() {
		return !errors.isEmpty();
	}
}