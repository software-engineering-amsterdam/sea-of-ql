// $ANTLR 3.4 C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-23 22:27:49

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.forms.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.*;
import org.uva.sea.ql.ast.expressions.binary.logical.*;
import org.uva.sea.ql.ast.expressions.binary.relational.*;
import org.uva.sea.ql.ast.expressions.literal.*;
import org.uva.sea.ql.ast.expressions.unary.*;
import org.uva.sea.ql.ast.statements.conditions.*;
import org.uva.sea.ql.ast.statements.questions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.ast.types.*;
import java.util.ArrayList;
import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "Ident", "Int", "Money", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'boolean'", "'else'", "'form'", "'if'", "'integer'", "'money'", "'string'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int Money=8;
    public static final int String=9;
    public static final int WS=10;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[43+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "form"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:1: form returns [Form result] : 'form' Ident '{' statementBody '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1=null;
        StatementBody statementBody2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:5: ( 'form' Ident '{' statementBody '}' )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:9: 'form' Ident '{' statementBody '}'
            {
            match(input,29,FOLLOW_29_in_form50); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_form52); if (state.failed) return result;

            match(input,34,FOLLOW_34_in_form54); if (state.failed) return result;

            pushFollow(FOLLOW_statementBody_in_form56);
            statementBody2=statementBody();

            state._fsp--;
            if (state.failed) return result;

            match(input,36,FOLLOW_36_in_form58); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form(new Ident((Ident1!=null?Ident1.getText():null)), statementBody2); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "formStatement"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:1: formStatement returns [FormStatement result] : ( question | conditionBlock );
    public final FormStatement formStatement() throws RecognitionException {
        FormStatement result = null;

        int formStatement_StartIndex = input.index();

        Question question3 =null;

        ConditionBlock conditionBlock4 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:5: ( question | conditionBlock )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==String) ) {
                alt1=1;
            }
            else if ( (LA1_0==30) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:9: question
                    {
                    pushFollow(FOLLOW_question_in_formStatement83);
                    question3=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question3; }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:34:9: conditionBlock
                    {
                    pushFollow(FOLLOW_conditionBlock_in_formStatement101);
                    conditionBlock4=conditionBlock();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = conditionBlock4; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, formStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "formStatement"



    // $ANTLR start "question"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: question returns [Question result] : ( String Ident ':' t= type | String Ident '=' e= expression );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token String5=null;
        Token Ident6=null;
        Token String7=null;
        Token Ident8=null;
        Type t =null;

        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: ( String Ident ':' t= type | String Ident '=' e= expression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==Ident) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==20) ) {
                        alt2=1;
                    }
                    else if ( (LA2_2==23) ) {
                        alt2=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:9: String Ident ':' t= type
                    {
                    String5=(Token)match(input,String,FOLLOW_String_in_question126); if (state.failed) return result;

                    Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_question128); if (state.failed) return result;

                    match(input,20,FOLLOW_20_in_question130); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question134);
                    t=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(new org.uva.sea.ql.ast.expressions.literal.Str((String5!=null?String5.getText():null)), new Ident((Ident6!=null?Ident6.getText():null)), t); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:9: String Ident '=' e= expression
                    {
                    String7=(Token)match(input,String,FOLLOW_String_in_question146); if (state.failed) return result;

                    Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_question148); if (state.failed) return result;

                    match(input,23,FOLLOW_23_in_question150); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_question154);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputedQuestion(new org.uva.sea.ql.ast.expressions.literal.Str((String7!=null?String7.getText():null)), new Ident((Ident8!=null?Ident8.getText():null)), e); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "conditionBlock"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: conditionBlock returns [ConditionBlock result] : ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= expression ')' ifBody= statementBody );
    public final ConditionBlock conditionBlock() throws RecognitionException {
        ConditionBlock result = null;

        int conditionBlock_StartIndex = input.index();

        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= expression ')' ifBody= statementBody )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==30) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred3_QL()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock179); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock181); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_conditionBlock185);
                    condition=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock187); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock191);
                    ifBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,28,FOLLOW_28_in_conditionBlock193); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock197);
                    elseBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThenElse(condition, ifBody, elseBody); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:9: 'if' '(' condition= expression ')' ifBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock217); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock219); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_conditionBlock223);
                    condition=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_conditionBlock225); if (state.failed) return result;

                    pushFollow(FOLLOW_statementBody_in_conditionBlock229);
                    ifBody=statementBody();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IfThen(condition, ifBody); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, conditionBlock_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionBlock"



    // $ANTLR start "statementBody"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:1: statementBody returns [StatementBody result] : ( '{' (statement= formStatement )+ '}' | (statement= formStatement )+ );
    public final StatementBody statementBody() throws RecognitionException {
        StatementBody result = null;

        int statementBody_StartIndex = input.index();

        FormStatement statement =null;


         StatementBody statements = new StatementBody(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:5: ( '{' (statement= formStatement )+ '}' | (statement= formStatement )+ )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==34) ) {
                alt6=1;
            }
            else if ( (LA6_0==String||LA6_0==30) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:9: '{' (statement= formStatement )+ '}'
                    {
                    match(input,34,FOLLOW_34_in_statementBody278); if (state.failed) return result;

                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:13: (statement= formStatement )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==String||LA4_0==30) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:14: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody283);
                    	    statement=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) { statements.add(statement); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return result;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match(input,36,FOLLOW_36_in_statementBody289); if (state.failed) return result;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:13: (statement= formStatement )+
                    {
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:13: (statement= formStatement )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==String) ) {
                            int LA5_2 = input.LA(2);

                            if ( (synpred6_QL()) ) {
                                alt5=1;
                            }


                        }
                        else if ( (LA5_0==30) ) {
                            int LA5_3 = input.LA(2);

                            if ( (synpred6_QL()) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:14: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody306);
                    	    statement=formStatement();

                    	    state._fsp--;
                    	    if (state.failed) return result;

                    	    if ( state.backtracking==0 ) { statements.add(statement); }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return result;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }
            if ( state.backtracking==0 ) { result = statements; }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, statementBody_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statementBody"



    // $ANTLR start "primary"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: primary returns [Expression result] : ( Int | Bool | Money | String | Ident | '(' x= expression ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Int9=null;
        Token Bool10=null;
        Token Money11=null;
        Token String12=null;
        Token Ident13=null;
        Expression x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:5: ( Int | Bool | Money | String | Ident | '(' x= expression ')' )
            int alt7=6;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt7=1;
                }
                break;
            case Bool:
                {
                alt7=2;
                }
                break;
            case Money:
                {
                alt7=3;
                }
                break;
            case String:
                {
                alt7=4;
                }
                break;
            case Ident:
                {
                alt7=5;
                }
                break;
            case 14:
                {
                alt7=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:9: Int
                    {
                    Int9=(Token)match(input,Int,FOLLOW_Int_in_primary333); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt((Int9!=null?Int9.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:9: Bool
                    {
                    Bool10=(Token)match(input,Bool,FOLLOW_Bool_in_primary348); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean((Bool10!=null?Bool10.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: Money
                    {
                    Money11=(Token)match(input,Money,FOLLOW_Money_in_primary362); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble((Money11!=null?Money11.getText():null).replace(',', '.'))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:9: String
                    {
                    String12=(Token)match(input,String,FOLLOW_String_in_primary375); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Str((String12!=null?String12.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:9: Ident
                    {
                    Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_primary387); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident13!=null?Ident13.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: '(' x= expression ')'
                    {
                    match(input,14,FOLLOW_14_in_primary400); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_primary404);
                    x=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary406); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unaryExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: unaryExpression returns [Expression result] : ( '+' x= unaryExpression | '-' x= unaryExpression | '!' x= unaryExpression |x= primary );
    public final Expression unaryExpression() throws RecognitionException {
        Expression result = null;

        int unaryExpression_StartIndex = input.index();

        Expression x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: ( '+' x= unaryExpression | '-' x= unaryExpression | '!' x= unaryExpression |x= primary )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt8=1;
                }
                break;
            case 18:
                {
                alt8=2;
                }
                break;
            case 11:
                {
                alt8=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case Money:
            case String:
            case 14:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: '+' x= unaryExpression
                    {
                    match(input,17,FOLLOW_17_in_unaryExpression434); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression438);
                    x=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new PositiveExpression(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:9: '-' x= unaryExpression
                    {
                    match(input,18,FOLLOW_18_in_unaryExpression450); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression454);
                    x=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegativeExpression(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:9: '!' x= unaryExpression
                    {
                    match(input,11,FOLLOW_11_in_unaryExpression466); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression470);
                    x=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegationalExpression(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:9: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpression484);
                    x=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = x; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, unaryExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "multiplicationExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: multiplicationExpression returns [Expression result] : lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )* ;
    public final Expression multiplicationExpression() throws RecognitionException {
        Expression result = null;

        int multiplicationExpression_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: (lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: lhs= unaryExpression (op= ( '*' | '/' ) rhs= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression522);
            lhs=unaryExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:54: (op= ( '*' | '/' ) rhs= unaryExpression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:56: op= ( '*' | '/' ) rhs= unaryExpression
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==16||input.LA(1)==19 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression542);
            	    rhs=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*")) { result = new Multiplication(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("/")) { result = new Division(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, multiplicationExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "multiplicationExpression"



    // $ANTLR start "additionExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:1: additionExpression returns [Expression result] : lhs= multiplicationExpression (op= ( '+' | '-' ) rhs= multiplicationExpression )* ;
    public final Expression additionExpression() throws RecognitionException {
        Expression result = null;

        int additionExpression_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: (lhs= multiplicationExpression (op= ( '+' | '-' ) rhs= multiplicationExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:9: lhs= multiplicationExpression (op= ( '+' | '-' ) rhs= multiplicationExpression )*
            {
            pushFollow(FOLLOW_multiplicationExpression_in_additionExpression580);
            lhs=multiplicationExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:63: (op= ( '+' | '-' ) rhs= multiplicationExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:65: op= ( '+' | '-' ) rhs= multiplicationExpression
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 17 && input.LA(1) <= 18) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_multiplicationExpression_in_additionExpression598);
            	    rhs=multiplicationExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("+")) { result = new Addition(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("-")) { result = new Subtraction(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, additionExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "additionExpression"



    // $ANTLR start "relationalExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: relationalExpression returns [Expression result] : lhs= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= additionExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression result = null;

        int relationalExpression_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: (lhs= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= additionExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:9: lhs= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= additionExpression )*
            {
            pushFollow(FOLLOW_additionExpression_in_relationalExpression633);
            lhs=additionExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:57: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= additionExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 22)||(LA11_0 >= 24 && LA11_0 <= 26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:59: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= additionExpression
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 22)||(input.LA(1) >= 24 && input.LA(1) <= 26) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_additionExpression_in_relationalExpression657);
            	    rhs=additionExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("<"))  { result = new LessThanExpression(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new LessThanOrEqualToExpression(result, rhs); }
            	            if ((op!=null?op.getText():null).equals(">"))  { result = new GreaterThanExpression(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals(">=")) { result = new GreaterThanOrEqualToExpression(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("==")) { result = new EqualToExpression(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("!=")) { result = new NotEqualToExpression(result, rhs); }
            	        }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, relationalExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relationalExpression"



    // $ANTLR start "logicallyEquivalentExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: logicallyEquivalentExpression returns [Expression result] : lhs= relationalExpression ( '&&' rhs= relationalExpression )* ;
    public final Expression logicallyEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyEquivalentExpression_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: (lhs= relationalExpression ( '&&' rhs= relationalExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:9: lhs= relationalExpression ( '&&' rhs= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression695);
            lhs=relationalExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:59: ( '&&' rhs= relationalExpression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:61: '&&' rhs= relationalExpression
            	    {
            	    match(input,13,FOLLOW_13_in_logicallyEquivalentExpression701); if (state.failed) return result;

            	    pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression705);
            	    rhs=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyEquivalentExpression(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, logicallyEquivalentExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "logicallyEquivalentExpression"



    // $ANTLR start "logicallyNotEquivalentExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:1: logicallyNotEquivalentExpression returns [Expression result] : lhs= logicallyEquivalentExpression ( '||' rhs= logicallyEquivalentExpression )* ;
    public final Expression logicallyNotEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyNotEquivalentExpression_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:5: (lhs= logicallyEquivalentExpression ( '||' rhs= logicallyEquivalentExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:9: lhs= logicallyEquivalentExpression ( '||' rhs= logicallyEquivalentExpression )*
            {
            pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression740);
            lhs=logicallyEquivalentExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:70: ( '||' rhs= logicallyEquivalentExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:72: '||' rhs= logicallyEquivalentExpression
            	    {
            	    match(input,35,FOLLOW_35_in_logicallyNotEquivalentExpression746); if (state.failed) return result;

            	    pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression750);
            	    rhs=logicallyEquivalentExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyNotEquivalentExpression(result, rhs); }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, logicallyNotEquivalentExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "logicallyNotEquivalentExpression"



    // $ANTLR start "expression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: expression returns [Expression result] : getExpression= logicallyNotEquivalentExpression ;
    public final Expression expression() throws RecognitionException {
        Expression result = null;

        int expression_StartIndex = input.index();

        Expression getExpression =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (getExpression= logicallyNotEquivalentExpression )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: getExpression= logicallyNotEquivalentExpression
            {
            pushFollow(FOLLOW_logicallyNotEquivalentExpression_in_expression780);
            getExpression=logicallyNotEquivalentExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = getExpression; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, expression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "expression"



    // $ANTLR start "type"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:5: ( 'integer' | 'string' | 'boolean' | 'money' )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt14=1;
                }
                break;
            case 33:
                {
                alt14=2;
                }
                break;
            case 27:
                {
                alt14=3;
                }
                break;
            case 32:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:9: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type805); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();   }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type817); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();   }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:116:9: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type830); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();  }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:9: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type842); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Money(); }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: ( 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: 'if' '(' condition= expression ')' ifBody= statementBody 'else' elseBody= statementBody
        {
        match(input,30,FOLLOW_30_in_synpred3_QL179); if (state.failed) return ;

        match(input,14,FOLLOW_14_in_synpred3_QL181); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred3_QL185);
        condition=expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,15,FOLLOW_15_in_synpred3_QL187); if (state.failed) return ;

        pushFollow(FOLLOW_statementBody_in_synpred3_QL191);
        ifBody=statementBody();

        state._fsp--;
        if (state.failed) return ;

        match(input,28,FOLLOW_28_in_synpred3_QL193); if (state.failed) return ;

        pushFollow(FOLLOW_statementBody_in_synpred3_QL197);
        elseBody=statementBody();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_QL

    // $ANTLR start synpred6_QL
    public final void synpred6_QL_fragment() throws RecognitionException {
        FormStatement statement =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:14: (statement= formStatement )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:14: statement= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred6_QL306);
        statement=formStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_QL

    // Delegated rules

    public final boolean synpred6_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_29_in_form50 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_form52 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form54 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_form56 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_form58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_formStatement83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionBlock_in_formStatement101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question126 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question128 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question130 = new BitSet(new long[]{0x0000000388000000L});
    public static final BitSet FOLLOW_type_in_question134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question146 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question148 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_question150 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_question154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock179 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock181 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_conditionBlock185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock187 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_conditionBlock193 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock217 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock219 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_conditionBlock223 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock225 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_statementBody278 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_formStatement_in_statementBody283 = new BitSet(new long[]{0x0000001040000200L});
    public static final BitSet FOLLOW_36_in_statementBody289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_statementBody306 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_Int_in_primary333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_primary362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary400 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_primary404 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unaryExpression434 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unaryExpression450 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unaryExpression466 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpression484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression522 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_multiplicationExpression530 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression542 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression580 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_additionExpression588 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression598 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression633 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_set_in_relationalExpression641 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression657 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression695 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_logicallyEquivalentExpression701 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression705 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression740 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_logicallyNotEquivalentExpression746 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression750 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_logicallyNotEquivalentExpression_in_expression780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred3_QL179 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred3_QL181 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_synpred3_QL185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred3_QL187 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3_QL193 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL306 = new BitSet(new long[]{0x0000000000000002L});

}