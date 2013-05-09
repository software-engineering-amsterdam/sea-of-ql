module TypeCheck::QuestionChecker

import Prelude;
import Message;
import syntax::Abstract;
import load::Load;
import TypeCheck::CheckExpression;
import util::IDE;

public alias FORMTENV = tuple[ rel[str id,str label, Type tp, bool isComputed] question, list[tuple[loc l, str msg]] errors]; 
 
public FORMTENV addError(FORMTENV qlenv, loc l, str msg) = qlenv[errors = qlenv.errors + <l, msg>];  
 
public FORMTENV addInstance(FORMTENV qlenv,str id,str labelQuestion, Type tp, bool isComputed)= 
														qlenv[question=qlenv.question+ {<id,labelQuestion,tp,isComputed>}];
							
public set[Message]getErrors(FORMTENV qlenv)
{
	set[Message]message={};
	for(x<-qlenv.errors)
	{
		messageSet=messageSet+error(x.msg,x,l);
	}
	return messageSet;
}
//check for the type of the expressions.example adding a bool to a string is not possible 
Type checkExpressionType(Expression exp, FORMTENV env)
{
println("we got:<exp>");
	str s = " ";
	if(getName(exp)=="id")
	{
		if (arity(exp)>1) 
		{
			list [value id] k =getChildren(exp);
			list [Type id] typ =getExpressionType(exp,env);
			s=toString (typ[0]);
			return typ[0];
		}
		else 
			s=toString(getChildren(exp)[0]);
		for(b<-env.question)  	
		{
			if(b.id == s)
			return b.tp;
		}	
	}
}

public list[Type] getExpressionType(Expression exp,FORMTENV env)
{
	list[Type] types=[];
	for(s<-getChildren(exp))
	{
		Type typ=checkExpressionType(exp,env); //check for expression type
		types +=typ; 						//add typ to the list of types if its not already there
	}
	println("Type : <types>");
	return types;
}

FORMTENV checkStatement(list[Body] Stats, FORMTENV env)
{
	visit(Stats)
	{
    	case Statement s: env = checkIfStatement(s,env);    
	};
	return env;
}

FORMTENV checkIfStatement(statement:ifStat(Expression exp, list[Body] Stats),FORMTENV env)
{
	FORMTENV env0 = <{},[]>;
	list[Type]typ = getExpressionType(exp,env);
	if(typ[0]==integer())	
	return checkIntExp(exp,typ[0],env); 
	
	else
	{	
	set[Type]s =toSet(typ);
		if(size(s)==1)
		{
			return checkExp(exp,typ[0],env);
		}
	
		else
		{		
			return checkExp(exp,typ[0],env);
		}
	}
}

FORMTENV checkIfStatement(statement:ifElseStat(Expression exp, list[Body] Stats1,list[Body] Stats2),FORMTENV env)
{

	list[Type]tp = getExpressionType(exp,env);
	if(tp[0]==integer())
	{
		return checkIntExp(exp,tp[0],env);  
	}
	else
	{
		env0 = checkExp(exp, tp[0], env);
    	env1 = checkStatement(Stats1, env0);
    	env2 = checkStatement(Stats2, env1);
    	return env2;
	}
}
//check question duplication
FORMTENV checkQuestion(question:uncomputedQuestion(str id, str labelQuestion, Type tp),FORMTENV env)
{
	if(question.id in env.question.id)
		return addError(env,question@location,"Identifier <id> is declared twice");
	else
		return addInstance(env,id,labelQuestion,tp,false);
}    

FORMTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type typ,Expression exp),FORMTENV env)
{
	if(question.id in env.question.id)
		return addError(env,question@location,"Identifier <id> is declared twice");
	if(typ==integer())
	{
		env= checkIntExp(exp,typ,env);
		return addInstance(env,id,labelQuestion,typ,true);
	}
		env= checkExp(exp, typ, env);
		return addInstance(env,id,labelQuestion,typ,true);
} 

FORMTENV checkComplete(list[Body] Stats, FORMTENV env) 
{                      
	visit(Stats)
	{
		case Question q: env=checkQuestion(q,env);		
		case Statement s: env=checkIfStatement(s,env);
	};
	return env;
}
// check the QL Form
public FORMTENV checkForm(Form P)
{ 
	if(form(str id, list[Body] Stats) := P)
	{   
		FORMTENV env = <{},[]>;
		env = checkComplete(Stats, env);
		return  env;    	
    } 
  	else
    throw "Cannot happen";
}                                                                           
public list[tuple[loc l, str msg]] checkForm(str txt) = checkForm(load(txt)).errors;

public set[Message]checkQLForm(Form p)=getErrors(checkForm(p));

