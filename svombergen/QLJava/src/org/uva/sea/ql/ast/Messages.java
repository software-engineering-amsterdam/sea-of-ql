package org.uva.sea.ql.ast;

import java.awt.List;

public class Messages {
	protected List list = new List();
	protected String msgType = "";
	
	public Messages(String type) {
		msgType = type;
	}
	
	public void add(String s) {
		list.add(s);
	}
	
	@Override
	public String toString(){
		String returnStr = msgType + ": ";
		
		if ( list.getItemCount() == 0)
			return "No " + msgType;
		
		for(String s : list.getItems())
			returnStr += s + "\n";
		
		return returnStr;
	}
}
