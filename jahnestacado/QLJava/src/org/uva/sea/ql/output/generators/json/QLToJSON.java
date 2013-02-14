package org.uva.sea.ql.output.generators.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class QLToJSON {

	private final List<String> questionLabels;
	private final List<String> questionValues;
	private final JSONObject qlForm = new JSONObject();

	private QLToJSON(List<String> questionLabels, List<String> questionValues) {
		this.questionLabels = questionLabels;
		this.questionValues = questionValues;
	}

	public static void generateJson(String frameName,List<String> questionLabels, List<String> questionValues) {
		QLToJSON generator = new QLToJSON(questionLabels, questionValues);
		generator.createForm(frameName);
		generator.writeToFile(frameName);

	}

	@SuppressWarnings("unchecked")
	private void createForm(String frameName) {
		JSONObject title = new JSONObject();
		title.put("formName", frameName);
		
		JSONArray structure = new JSONArray();
		structure.add(title);
		
		JSONObject content = getContentList();
		structure.add(content);
		qlForm.put("qlForm", structure);
	}

	private void writeToFile(String frameName) {
		try {
			String path = "src/org/uva/sea/ql/output/json/" + frameName
					+ ".json";
			File filePath = new File(path);
			FileWriter file = new FileWriter(filePath.getAbsolutePath());
			file.write(qlForm.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private JSONObject getContentList() {
		int contentsSize = questionLabels.size() - 1;
		JSONArray contentList = new JSONArray();
		for (int i = 0; i <= contentsSize; i++) {
			JSONObject question = new JSONObject();
			question.put("question", questionLabels.get(i));
			question.put("answer", questionValues.get(i));
			contentList.add(question);
		}
		JSONObject questionsList = new JSONObject();
		questionsList.put("questions", contentList);

		return questionsList;
	}

}
