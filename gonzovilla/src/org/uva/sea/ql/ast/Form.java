package org.uva.sea.ql.ast;

import java.util.List;

public class Form {
	
	private String name;
	private List<FormUnit> body;
	
	public Form(String name, List<FormUnit> body) {
		
			this.name = name;
			this.body = body;
		}

		public String getName() {
			return name;
		}

		public List<FormUnit> getBody() {
			return body;
		}

}
