module lang::ql::IDE::Outline

import lang::ql::ast::AST;
import lang::ql::syntax::Syntax;
import lang::ql::ast::load;
import lang::ql::util::prettyPrint;

import ParseTree;
import util::IDE;

anno loc node@location;

public data OutlineNode = qlListNode(list[node] children)
				 | qlSimpleNode(node child)
				 | qlLeaf();
				 
data QlOutline = qlOutline(
	OutlineNode question, 
	OutlineNode ifNode, 
	OutlineNode elseIfNode,
	OutlineNode elseNode
	);


public node qlOutliner(FORM tree){

	list[OutlineNode] initLeaf(str name, node N) = [qlLeaf()[@label=name][@\loc=N@location]];
	
	QlOutline outline = qlOutline(
		qlListNode([])[@label="Questions"],
		qlListNode([])[@label="If"],
		qlListNode([])[@label="ElseIf"],
		qlListNode([])[@label="Else"]);
	
	visit (tree){
		case A:statement(QUESTION q)					:	outline.question.children += initLeaf(q.identifier, A);
		case B:ifStat(EXPR x,_)							:	outline.ifNode.children += initLeaf("<idGenerator(x)>", B);
		case C:elseIfStat(EXPR x,_)						:	outline.elseIfNode.children += initLeaf("<idGenerator(x)>", C);			
		case D:elseStat(list[STATEMENT] stat)			:	outline.elseIfNode.children += initLeaf("", D);					
	}
	return qlSimpleNode(outline);	
}
