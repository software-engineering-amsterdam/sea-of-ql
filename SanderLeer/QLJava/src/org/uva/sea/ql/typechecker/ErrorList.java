package org.uva.sea.ql.typechecker;

import java.util.ArrayList;

public class ErrorList {
	private final ArrayList<String> list = new ArrayList<>();

	public void add(String s) {
		list.add(s);
	}

	public boolean hasErrors() {
		return !list.isEmpty();
	}

	public void clear() {
		list.clear();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String error : list) {
			if (sb.length() > 0) {
				sb.append("\n");
			}
			sb.append(error);
		}
		return sb.toString();
	}
}
