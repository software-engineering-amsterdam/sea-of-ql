package org.uva.sea.ql.ast.visitor;

public class PrintResult {
	private StringBuilder stringBuilder = new StringBuilder();

	public PrintResult(String result) {
		stringBuilder.append(result);
	}

	public PrintResult appendResult(String string) {
		stringBuilder.append(string);
		return this;
	}

	public PrintResult appendResult(PrintResult printVisitorResult) {
		stringBuilder.append((printVisitorResult).getPrintResult());
		return this;
	}

	public String getPrintResult() {
		return stringBuilder.toString();
	}
}
