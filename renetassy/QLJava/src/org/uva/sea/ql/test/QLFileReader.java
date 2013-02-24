package org.uva.sea.ql.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QLFileReader {
	
	private String filePath = "";
	private String content = "";
	
	public QLFileReader(String filePath) throws IOException {
		
		this.filePath = filePath;
		
		FileReader file = new FileReader(this.filePath);
		
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
