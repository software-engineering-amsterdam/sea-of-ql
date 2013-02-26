module TypeCheck::QuestionChecker

import Prelude;
import Message;
import syntax::Abstract;
import load::Load;
import TypeCheck::CheckExpression;
import util::IDE;

//alias TENV = tuple[ map[QuestionId, Type] question, list[tuple[loc l, str msg]] errors]; 

alias FORMTENV = tuple[ rel[str id,str label, Type tp, bool isComputed] question, list[tuple[loc l, str msg]] errors]; 

public FORMTENV addError(FORMTENV env, loc l, str msg) = env[errors = env.errors + <l, msg>];  

public FORMTENV addInstance(FORMTENV env,str id,str labelQuestion, Type tp, bool isComputed)= 
														env[question=env.question+ {<id,labelQuestion,tp,isComputed>}];

public set[Message]checkQLForm(Form form)=getErrors(checkQLForm(Form));
														
public set[Message]getErrors(FORMTENV env)
{
	set[Message]message={};
	for(x<-env.errors)
	{
		messageSet=messageSet+error(x.msg,x,l);
	}
	return messageSet;
}								

Type findExpressionType(Expression exp, FORMTENV env)
{
	str s = " ";
	if (arity(exp)>1)//exp(expr,"sentence",etc); arity=3==int
	{
	list [value id] k =getChildren(exp);
	list [Type id] t =getExpressionType(exp);
	s=toString (t[0]);
	return t[0];
	}
		else s=toString(getChildren(exp)[0]);
		for(b<-env.question)
		{
			if(b.id == s)
			return b.id;
		}

}

public list[Type] getExpressionType(Expression exp,FORMTENV env)
{
	list[Type] types=[];
	for(s<-getChildren(exp))
	{
		Type tp=findExpressionType(s,env);
		types +=tp;
	}
	return types;
}


FORMTENV checkIfStatement(statement:ifStat(Expression exp, list[Statement] Stats),FORMTENV env)
{println("Checking IfStat");
	list[Type]tp = getExpressionType(exp,env);
	if(tp[0]==integer())
	return checkIntExp(exp,tp[0],env); //check if the type is correct or give error msge
	else
	{
		env0 = checkExp(Exp, tp[0], env);
    	env1 = checkStatement(Stats, env0);
    	return env1;
	}
}


FORMTENV checkIfStatement(statement:ifElseStat(Expression exp, list[Statement] Stats1,list[Statement] Stats2),FORMTENV env)
{
	println("Checking ifElseStat");
	list[Type]tp = getExpressionType(exp,env);
	if(tp[0]==integer())
	{
		return checkIntExp(exp,tp[0],env); //check if the type is correct or give error msge
	}
	else
	{
		env0 = checkExp(Exp, tp[0], env);
    	env1 = checkStatement(Stats1, env0);
    	env2 = checkStatement(Stats2, env1);
    	return env2;
	}
}

FORMTENV checkStatement(list[Statement] Stats1, FORMTENV env) 
{                                 
	for(S <- Stats1)
  	{
    	env = checkIfStatement(S, env);
  	}
  	return env;
}


//check question duplication
FORMTENV checkQuestion(question:uncomputedQuestion(str id, str labelQuestion, Type tp),FORMTENV env)
{println("Uncomputed Question typechecking ");
	if(question.id in env.question.id)
	{
		return addError(env,question@location,"Identifier<id>is declared twice");
	}
	else
	{
	println("blabla blabla XXX");
	return addInstance(env,id,labelQuestion,tp,false);
	}
}    


FORMTENV checkQuestion(question:computedQuestion(str id, str labelQuestion, Type tp,Expression exp),FORMTENV env)
{
println("Computed Question Check");
	if(question.id in env.question.id)
	{
		return addError(env,question@location,"Identifier<id>is declared twice");
	}
	if(tp==integer())
	{
		env= checkIntExp(exp,tp,env);
		return addInstance(env,id,labelQuestion,tp,true);
	}
} 

FORMTENV checkComplete(list[Statement] Stats, FORMTENV env) 
{  println("Complete typechecking!");                     

	visit(Stats)
	{
		case Question q: env=checkQuestion(q,env);
		//case Statement t: env=checkStatement(t,env);
		//case Statement s: env=checkIfStatement(s,env);
	};
	
  	return env;
}

// check the QL program
public FORMTENV checkForm(Form P)
{ 
	println("Form Checking");                                               
	if(form(str id, list[Statement] Stats) := P)
	{
		FORMTENV env = <{},[]>;
		env = checkComplete(Stats, env);
		return  env;    	
    } 
  	else
    throw "Cannot happen";
}
                                                                                    
public list[tuple[loc l, str msg]] checkForm(str txt) = checkForm(load(txt)).errors;