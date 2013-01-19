package org.uva.sea.ql.parser.visitor.typechecking;

import org.uva.sea.ql.ast.ASTNode;

import java.util.HashMap;
import java.util.Map;

public class InstanceVariableTable {

    public Map<String, ASTNode> instanceMap;

    public InstanceVariableTable() {
        this.instanceMap = new HashMap<String, ASTNode>();
    }

    public void addInstanceVariable(String identifierName, ASTNode object) {
        instanceMap.put(identifierName, object);
    }

    public ASTNode getInstanceVariable(String identifierName) {
        return instanceMap.get(identifierName);
    }

    public boolean containsInstanceVariable(String identifierName) {
        return instanceMap.containsKey(identifierName);
    }
}
