package org.uva.sea.ql.gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;

import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.check.ValueEnvironment;

public class QuestionnaireSaver {
	
	private static BufferedWriter _file;
	
	public static void storeQuestionnaire(ValueEnvironment valueEnvironment) {
		try {
			createFile();
			writeToFile("Questionnaire results", "Taken on " + getCurrentDateTime() + "\n");
			storeValues(valueEnvironment);
			closeFile();
			printMessage("Questionnaire has been saved.");
		} catch (IOException e) {
			printMessage("Saving the Questionnaire has failed: " + e.getMessage());
		}
	}
	
	private static void createFile() throws IOException {
		// Store results in resources directory
		_file = new BufferedWriter(new FileWriter("resources/QuestionnaireResults.txt"));
	}

	private static void storeValues(ValueEnvironment valueEnvironment) throws IOException {
		for (Entry<Identifier, Value> valueEntry : valueEnvironment.getValueEntries()) {
			writeToFile(valueEntry.getKey(), valueEntry.getValue());
		}
	}
	
	private static void writeToFile(Identifier identifierName, Value identifierValue) throws IOException {
		_file.write(String.format("%-30s %-20s", identifierName.getValue() + ":", identifierValue.getValue().toString()) + "\n");
	}
	
	private static void writeToFile(String leftHandSide, String rightHandSide) throws IOException {
		_file.write(String.format("%-30s %-20s", leftHandSide + ":", rightHandSide + "\n"));
	}
	
	private static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(new Date());
	}
	
	private static void printMessage(String message) {
		System.out.println(message);
	}
	
	private static void closeFile() throws IOException {
		_file.close();
	}
}