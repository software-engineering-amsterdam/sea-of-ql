module controlFlow::ControlFlowQuestion

import controlFlow::ControlFlowTypes;
import syntax::AbstractSyntax;
import Prelude;


/** Method to to get the first questions of a form 
* @param Body Body of the QL program
* @return CFGraph
* @author Philipp
*/
public CFGraph getFirstQuestionsOfForm(list[Body] Body){
	list[Question] questions = [];
	for(s <- Body){
		if(getName(s) == "question"){
			visit(s){
				case Question q : questions += q;
			}
		}
	}
	return cflowQues(questions);
}

/** Method to get the CFGraph of an easy question
* @param easyQuestion the easy question
* @return CFGraph
* @author Philipp
*/
public CFGraph cflowQuestion(question:easyQuestion(str id, str labelQuestion, Type tp)){
	 Q = q(question@location, question);
	 return <{Q}, {}, {Q}>;
}

/** Method to get the CFGraph of a computed question
* @param computedQuestion the computed question
* @return CFGraph
* @author Philipp
*/
public CFGraph cflowQuestion(question:computedQuestion(str id, str labelQuestion, Type tp, Expression exp)){
	 Q = q(question@location, question);
	 return <{Q}, {}, {Q}>;
}

/** Method to to get the CFGraph of one or more questions
* @param questions a list with questions
* @return CFGraph
* @author Philipp
*/
public CFGraph cflowQues(list[Question] questions){	
	if(size(questions) == 1) return cflowQuestion(questions[0]);
	CF1 = cflowQuestion(questions[0]);
  	CF2 = cflowQues(tail(questions));
  	return < CF1.entry, CF1.graph + CF2.graph + (CF1.exit * CF2.entry), CF2.exit >;
}