package org.uva.sea.ql.ast;

import java.util.List;

public class Form {
	
	private String ident;
	private List<FormUnit> formUnits;
	
	public Form(String string, List<FormUnit> formUnits) {
		
			this.ident = string;
			this.formUnits = formUnits;
		}

		public String getIdentity() {
			return ident;
		}

		public List<FormUnit> getFormUnits() {
			return formUnits;
		}

}
