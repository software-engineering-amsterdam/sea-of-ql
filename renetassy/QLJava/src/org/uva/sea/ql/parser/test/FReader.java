package org.uva.sea.ql.parser.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FReader {

	private String path = "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/test/sample.ql";
	private String content = "";
	
	public FReader () throws IOException {
		
		FileReader file = new FileReader(this.path);
		
		BufferedReader reader = new BufferedReader(file);
		
		String fileLine = reader.readLine();
		
		while(fileLine != null) {
		
			this.setContent(this.getContent() + fileLine);
			fileLine = reader.readLine();
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
}
	

