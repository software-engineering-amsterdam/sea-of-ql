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
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.renderer.FormRenderer;
import org.uva.sea.ql.visitor.typeCheck.FormTypeCheckVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;
import org.uva.sea.ql.visitor.valueCheck.ValueMapper;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Message> errors = new ArrayList<Message>();
	private final static String templateDirectory = "templates/";
	private final static String inputDirectory = "forms/";
	private Map<String, TypeMapper> forms = new HashMap<String, TypeMapper>();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		errors.clear();
		String formRequest = request.getParameter("form");
		PrintWriter out = response.getWriter();
		
		File dir = new File(getServletContext().getRealPath(inputDirectory));
		List<File> qlFiles = getQLFilesFromDirectory(dir);
		
		if (qlFiles.isEmpty()) {
			errors.add(new Error("No QL files found."));
			printErrors(out);
		} else {
			if (formRequest == null || formRequest.isEmpty()) {
				for (File qlFile : qlFiles) {
					printLinkToForm(out, qlFile.getName());
				}
			} else {
				boolean formFound = false;
				for (File qlFile : qlFiles) {
					if (qlFile.getName().equals(formRequest + ".ql")) {
						formFound = true;
						generateForm(qlFile, out);
					}
				}
				if (!formFound) {
					errors.add(new Error("Unable to find form: " + formRequest));
					printErrors(out);
				}
			}
		}
		// Always close the output writer
		out.close();  
	}

	protected boolean generateForm(File qlFile, PrintWriter output) {
		ANTLRParser parser = new ANTLRParser();

		TypeMapper typeMapper = new TypeMapper();
		ValueMapper valueMapper = new ValueMapper();

		String strInput = null;
		try {
			strInput = readFile(qlFile);
		} catch (FileNotFoundException e) {
			errors.add(new Error("Failed to find input file '" + qlFile.getName() + "'."));
			return false;
		} catch (IOException e) {
			errors.add(new Error("IO Error: " + e.getMessage()));
			return false;
		}

		try {
			Form form = parser.parseForm(strInput);
			if (parser.hasErrors()) {
				errors.addAll(parser.getErrors());
				return false;
			}
	
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
			forms.put(formName, typeMapper);
			output.println(renderer.getOutput());
			
		} catch (ParseError e) {
			errors.add(new Error("Error while trying to parse: " + e.getMessage()));
			return false;
		}
		return true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		errors.clear();

		Map<String, String> postValues = getFormattedPostValues(request.getParameterMap());
		String formRequest = request.getParameter("form");
		if (formRequest != null) {
			validateInput(formRequest, postValues); 
		} else {
			errors.add(new Error("Internal Error. Form not found."));
		}
		
		if (errors.isEmpty()) {
			// no errors.
			// save to file
			File dir = new File(getServletContext().getRealPath(inputDirectory));
			String randomFileName = dir.getAbsolutePath() + "/" + formRequest + "." + System.nanoTime() + ".values";
			writeFormValuesToFile(postValues, randomFileName);
		}
		String json = "{\"Errors\":[";
		if (!errors.isEmpty()) {
			json += "\"";
			for (Message error : errors) {
				json += error;
			}
			json += "\"";
		}
		json += "]}";
		PrintWriter out = response.getWriter();
		
		try {
			out.println(json);
		} finally {
			out.close();  // Always close the output writer
		}
	}

	private Map<String, String> getFormattedPostValues(Map<String, String[]> parameterMap) {
		Map<String, String> postValues = new HashMap<String, String>();
		for (String key: parameterMap.keySet()) {
		    postValues.put(key, parameterMap.get(key)[0]);
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

	private static void printErrors(PrintWriter output) throws IOException {
		try {
			output.println("<PRE>");
			output.println("Unable to create the QL form. Please correct the following "
					+ errors.size() + " errors.");
			output.println("---------------------------------------------------------------------");
			for (Message message : errors) {
				output.println(" -" + message);
			}
			output.println("---------------------------------------------------------------------");
			output.println("Please correct the errors and try again.");
			output.println("</PRE>");
		} finally {
			output.close();
		}
	}

	private void printLinkToForm(PrintWriter output, String name) {
		name = name.replaceAll(".ql$", "");
		output.println("<PRE>");
		output.println("Click <a href='?form="+name+"'>here</a> to fill in "+name);
		output.println("</PRE>");
		
	}
	
	private boolean validateInput(String formName, Map<String, String> postValues) {
		
		TypeMapper typeMapper;
		if (forms.containsKey(formName)) {
			typeMapper = forms.get(formName);
		} else {
			errors.add(new Error("Error: Failed to get typeMapper for form '" + formName + "'. Please reload the form."));
			return false;
		}

		for(String key : postValues.keySet()) {
			Ident id = new Ident(key);
			if (typeMapper.hasTypeKey(id)) {
				boolean valueCheck = checkValue(postValues.get(key), typeMapper.getType(id));
				if (!valueCheck) {
					errors.add(new Error("Invalid value for '" + key + "'. Please correct the field."));
				}
			}
		}
		return true;
	}

	private boolean checkValue(String value, Type type) {
		if (value.isEmpty()) {
			return true;
		}
		return type.validate(value.trim());
	}
	
	private static void writeFormValuesToFile(Map<String, String> formValuesMap, String fileName) {
		try {
			String formValues = "";
			for(String key : formValuesMap.keySet()) {
				formValues += key + ":" + formValuesMap.get(key) + "\r\n";
			}
			FileWriter file = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(file);
			out.write(formValues);
			out.close();
		} catch (IOException e) {
			errors.add(new Error("IOException: " + e.getMessage()));
		}
	}
}