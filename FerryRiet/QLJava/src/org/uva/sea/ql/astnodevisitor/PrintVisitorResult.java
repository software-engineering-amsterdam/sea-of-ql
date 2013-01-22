package org.uva.sea.ql.astnodevisitor;

public class PrintVisitorResult implements VisitorResult {
	private String printResult;

	public PrintVisitorResult(String result) {
		printResult = result;
	}

	void appendResult(String string) {
		printResult = printResult.concat(string);
	}

	void appendResult(VisitorResult printVisitorResult) {
		printResult = printResult
				.concat(((PrintVisitorResult) printVisitorResult)
						.getPrintResult());
	}

	public String getPrintResult() {
		return printResult;
	}
}
