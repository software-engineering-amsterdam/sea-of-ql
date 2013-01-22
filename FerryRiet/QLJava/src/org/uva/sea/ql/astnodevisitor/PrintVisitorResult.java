package org.uva.sea.ql.astnodevisitor;

public class PrintVisitorResult implements VisitorResult {
	private String printResult;

	public PrintVisitorResult(String result) {
		printResult = result;
	}

	public PrintVisitorResult appendResult(String string) {
		printResult = printResult.concat(string);
		return this;
	}

	public PrintVisitorResult appendResult(VisitorResult printVisitorResult) {
		printResult = printResult
				.concat(((PrintVisitorResult) printVisitorResult)
						.getPrintResult());
		return this;
	}

	public String getPrintResult() {
		return printResult;
	}
}
