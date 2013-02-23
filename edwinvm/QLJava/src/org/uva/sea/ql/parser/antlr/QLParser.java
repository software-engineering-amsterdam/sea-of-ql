// $ANTLR 3.4 C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-23 23:00:22

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: question returns [Question result] : ( String Ident ':' type | String Ident '=' expression );
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token String5=null;
        Token Ident6=null;
        Token String8=null;
        Token Ident9=null;
        Type type7 =null;

        Expression expression10 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: ( String Ident ':' type | String Ident '=' expression )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:9: String Ident ':' type
                    {
                    String5=(Token)match(input,String,FOLLOW_String_in_question126); if (state.failed) return result;

                    Ident6=(Token)match(input,Ident,FOLLOW_Ident_in_question128); if (state.failed) return result;

                    match(input,20,FOLLOW_20_in_question130); if (state.failed) return result;

                    pushFollow(FOLLOW_type_in_question132);
                    type7=type();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new AnswerableQuestion(new org.uva.sea.ql.ast.expressions.literal.Str((String5!=null?String5.getText():null)), new Ident((Ident6!=null?Ident6.getText():null)), type7); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:9: String Ident '=' expression
                    {
                    String8=(Token)match(input,String,FOLLOW_String_in_question148); if (state.failed) return result;

                    Ident9=(Token)match(input,Ident,FOLLOW_Ident_in_question150); if (state.failed) return result;

                    match(input,23,FOLLOW_23_in_question152); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_question154);
                    expression10=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new ComputedQuestion(new org.uva.sea.ql.ast.expressions.literal.Str((String8!=null?String8.getText():null)), new Ident((Ident9!=null?Ident9.getText():null)), expression10); }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: primary returns [Expression result] : ( Int | Bool | Money | String | Ident | '(' e= expression ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Int11=null;
        Token Bool12=null;
        Token Money13=null;
        Token String14=null;
        Token Ident15=null;
        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:5: ( Int | Bool | Money | String | Ident | '(' e= expression ')' )
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
                    Int11=(Token)match(input,Int,FOLLOW_Int_in_primary333); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt((Int11!=null?Int11.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:9: Bool
                    {
                    Bool12=(Token)match(input,Bool,FOLLOW_Bool_in_primary348); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean((Bool12!=null?Bool12.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: Money
                    {
                    Money13=(Token)match(input,Money,FOLLOW_Money_in_primary362); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble((Money13!=null?Money13.getText():null).replace(',', '.'))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:9: String
                    {
                    String14=(Token)match(input,String,FOLLOW_String_in_primary375); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Str((String14!=null?String14.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:9: Ident
                    {
                    Ident15=(Token)match(input,Ident,FOLLOW_Ident_in_primary387); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident15!=null?Ident15.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: '(' e= expression ')'
                    {
                    match(input,14,FOLLOW_14_in_primary400); if (state.failed) return result;

                    pushFollow(FOLLOW_expression_in_primary404);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary406); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = e; }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: unaryExpression returns [Expression result] : ( '+' e= unaryExpression | '-' e= unaryExpression | '!' e= unaryExpression |e= primary );
    public final Expression unaryExpression() throws RecognitionException {
        Expression result = null;

        int unaryExpression_StartIndex = input.index();

        Expression e =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: ( '+' e= unaryExpression | '-' e= unaryExpression | '!' e= unaryExpression |e= primary )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: '+' e= unaryExpression
                    {
                    match(input,17,FOLLOW_17_in_unaryExpression434); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression438);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new PositiveExpression(e); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:9: '-' e= unaryExpression
                    {
                    match(input,18,FOLLOW_18_in_unaryExpression450); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression454);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegativeExpression(e); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:9: '!' e= unaryExpression
                    {
                    match(input,11,FOLLOW_11_in_unaryExpression466); if (state.failed) return result;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression470);
                    e=unaryExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new NegationalExpression(e); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:9: e= primary
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpression484);
                    e=primary();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = e; }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: multiplicationExpression returns [Expression result] : leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )* ;
    public final Expression multiplicationExpression() throws RecognitionException {
        Expression result = null;

        int multiplicationExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: (leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: leftHandSide= unaryExpression (op= ( '*' | '/' ) rightHandSide= unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression534);
            leftHandSide=unaryExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:69: (op= ( '*' | '/' ) rightHandSide= unaryExpression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:71: op= ( '*' | '/' ) rightHandSide= unaryExpression
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


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicationExpression565);
            	    rightHandSide=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*")) { result = new Multiplication(leftHandSide, rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("/")) { result = new Division(leftHandSide,       rightHandSide); }
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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:1: additionExpression returns [Expression result] : leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )* ;
    public final Expression additionExpression() throws RecognitionException {
        Expression result = null;

        int additionExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:5: (leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:9: leftHandSide= multiplicationExpression (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )*
            {
            pushFollow(FOLLOW_multiplicationExpression_in_additionExpression606);
            leftHandSide=multiplicationExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:78: (op= ( '+' | '-' ) rightHandSide= multiplicationExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:82:80: op= ( '+' | '-' ) rightHandSide= multiplicationExpression
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


            	    pushFollow(FOLLOW_multiplicationExpression_in_additionExpression637);
            	    rightHandSide=multiplicationExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("+")) { result = new Addition(leftHandSide,    rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("-")) { result = new Subtraction(leftHandSide, rightHandSide); }
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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:1: relationalExpression returns [Expression result] : leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )* ;
    public final Expression relationalExpression() throws RecognitionException {
        Expression result = null;

        int relationalExpression_StartIndex = input.index();

        Token op=null;
        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:5: (leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:9: leftHandSide= additionExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )*
            {
            pushFollow(FOLLOW_additionExpression_in_relationalExpression675);
            leftHandSide=additionExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:72: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 22)||(LA11_0 >= 24 && LA11_0 <= 26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:91:74: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rightHandSide= additionExpression
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


            	    pushFollow(FOLLOW_additionExpression_in_relationalExpression712);
            	    rightHandSide=additionExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("<"))  { result = new LessThanExpression(leftHandSide,             rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new LessThanOrEqualToExpression(leftHandSide,    rightHandSide); }
            	            if ((op!=null?op.getText():null).equals(">"))  { result = new GreaterThanExpression(leftHandSide,          rightHandSide); }
            	            if ((op!=null?op.getText():null).equals(">=")) { result = new GreaterThanOrEqualToExpression(leftHandSide, rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("==")) { result = new EqualToExpression(leftHandSide,              rightHandSide); }
            	            if ((op!=null?op.getText():null).equals("!=")) { result = new NotEqualToExpression(leftHandSide,           rightHandSide); }
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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:103:1: logicallyEquivalentExpression returns [Expression result] : leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )* ;
    public final Expression logicallyEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyEquivalentExpression_StartIndex = input.index();

        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: (leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:9: leftHandSide= relationalExpression ( '&&' rightHandSide= relationalExpression )*
            {
            pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression753);
            leftHandSide=relationalExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:74: ( '&&' rightHandSide= relationalExpression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:76: '&&' rightHandSide= relationalExpression
            	    {
            	    match(input,13,FOLLOW_13_in_logicallyEquivalentExpression759); if (state.failed) return result;

            	    pushFollow(FOLLOW_relationalExpression_in_logicallyEquivalentExpression774);
            	    rightHandSide=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyEquivalentExpression(leftHandSide, rightHandSide); }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: logicallyNotEquivalentExpression returns [Expression result] : leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )* ;
    public final Expression logicallyNotEquivalentExpression() throws RecognitionException {
        Expression result = null;

        int logicallyNotEquivalentExpression_StartIndex = input.index();

        Expression leftHandSide =null;

        Expression rightHandSide =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: (leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: leftHandSide= logicallyEquivalentExpression ( '||' rightHandSide= logicallyEquivalentExpression )*
            {
            pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression812);
            leftHandSide=logicallyEquivalentExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = leftHandSide; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:83: ( '||' rightHandSide= logicallyEquivalentExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:85: '||' rightHandSide= logicallyEquivalentExpression
            	    {
            	    match(input,35,FOLLOW_35_in_logicallyNotEquivalentExpression818); if (state.failed) return result;

            	    pushFollow(FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression833);
            	    rightHandSide=logicallyEquivalentExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new LogicallyNotEquivalentExpression(leftHandSide, rightHandSide); }

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:114:1: expression returns [Expression result] : getExpression= logicallyNotEquivalentExpression ;
    public final Expression expression() throws RecognitionException {
        Expression result = null;

        int expression_StartIndex = input.index();

        Expression getExpression =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:5: (getExpression= logicallyNotEquivalentExpression )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: getExpression= logicallyNotEquivalentExpression
            {
            pushFollow(FOLLOW_logicallyNotEquivalentExpression_in_expression863);
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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:118:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:5: ( 'integer' | 'string' | 'boolean' | 'money' )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:9: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type888); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();   }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:9: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type900); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();   }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:121:9: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type913); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();  }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:122:9: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type925); if (state.failed) return result;

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
    public static final BitSet FOLLOW_type_in_question132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_question148 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Ident_in_question150 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_question152 = new BitSet(new long[]{0x0000000000064BD0L});
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
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression534 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_multiplicationExpression544 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicationExpression565 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression606 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_additionExpression616 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_multiplicationExpression_in_additionExpression637 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression675 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_set_in_relationalExpression685 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_additionExpression_in_relationalExpression712 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression753 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_logicallyEquivalentExpression759 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_relationalExpression_in_logicallyEquivalentExpression774 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression812 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_logicallyNotEquivalentExpression818 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_logicallyEquivalentExpression_in_logicallyNotEquivalentExpression833 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_logicallyNotEquivalentExpression_in_expression863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_type888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred3_QL179 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred3_QL181 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_expression_in_synpred3_QL185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred3_QL187 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3_QL193 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL306 = new BitSet(new long[]{0x0000000000000002L});

}