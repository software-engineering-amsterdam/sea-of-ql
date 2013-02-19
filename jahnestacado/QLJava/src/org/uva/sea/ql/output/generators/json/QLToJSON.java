package org.uva.sea.ql.output.generators.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ui.qlform.QLNumField;

public class QLToJSON {

	private final Map<String,Value> allRunTimeValues;
	private final static Map<String, Type> nullVarEnv=new HashMap<String, Type>();

	private final JSONObject qlForm = new JSONObject();

	private QLToJSON(Map<String,Value> allRunTimeValues) {
		this.allRunTimeValues=allRunTimeValues;
	}

	public static void generateJson(String frameName,Map<String,Value> allRunTimeValues) {
		QLToJSON generator = new QLToJSON(allRunTimeValues);
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
		JSONArray contentList = new JSONArray();
		Iterator<String> iterator = allRunTimeValues.keySet().iterator();

		while (iterator.hasNext()) {
			JSONObject question = new JSONObject();
			String key = iterator.next().toString();
			question.put("ident", key);
			question.put("answer", valueToString(allRunTimeValues.get(key)));
			contentList.add(question);

		}
		JSONObject questionsList = new JSONObject();
		questionsList.put("questions", contentList);
		return questionsList;
	}
	
	private String valueToString(Value value){
		Type type=value.getExprType(nullVarEnv);
		if(type.isCompatibleToIntType()){
			return String.valueOf(((IntegerLit) value).getValue());
		}
		else if(type.isCompatibleToMoneyType()){
			float result=((DecimalLit) value).getValue();
			float roundedValue=QLNumField.roundTo2Decimals(result);
			return String.valueOf(roundedValue);
		}
		else if(type.isCompatibleToBoolType()){
			return String.valueOf(((BoolLit) value).getValue());
		}
		return (((StringLit) value).getValue());
		
	}

}
