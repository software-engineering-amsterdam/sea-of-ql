package org.uva.sea.ql.ast;

public class QLProgram {
	private String programName;
	private CompoundBlock compound;

	public QLProgram(String string, CompoundBlock c) {
		programName = string;
		compound = c;
	}
	public void eval() {
		System.out.println("form: " + programName) ;
		compound.eval() ;
	}
}
