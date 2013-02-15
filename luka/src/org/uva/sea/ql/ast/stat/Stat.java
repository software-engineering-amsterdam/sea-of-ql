package org.uva.sea.ql.ast.stat;

import org.uva.sea.ql.ast.visitor.StatementVisitor;


public interface  Stat  {

	 public  void accept(StatementVisitor visitor);
}
