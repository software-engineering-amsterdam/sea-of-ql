package org.uva.sea.ql.ast.nodevisitor;

public class PrintVisitorResult implements VisitorResult {
	private StringBuilder stringBuilder = new StringBuilder() ;
	
	public PrintVisitorResult(String result) {
		stringBuilder.append(result);
	}

	public PrintVisitorResult appendResult(String string) {
		stringBuilder.append(string);
		return this;
	}

	public PrintVisitorResult appendResult(VisitorResult printVisitorResult) {
		stringBuilder.append(((PrintVisitorResult) printVisitorResult)
						.getPrintResult());
		return this;
	}

	public String getPrintResult() {
		return stringBuilder.toString();
	}
}
