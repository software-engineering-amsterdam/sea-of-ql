package org.uva.sea.ql.ast;

public interface Node {

    <T> T accept(NodeVisitor<T> visitor);
}
