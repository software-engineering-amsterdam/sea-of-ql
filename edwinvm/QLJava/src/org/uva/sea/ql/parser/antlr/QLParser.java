// $ANTLR 3.4 C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-23 21:10:52

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
        this.state.ruleMemo = new HashMap[42+1];
         

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:1: question returns [Question result] : ( String Ident ':' t= type | String Ident '=' e= orExpression );
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

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:5: ( String Ident ':' t= type | String Ident '=' e= orExpression )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:9: String Ident '=' e= orExpression
                    {
                    String7=(Token)match(input,String,FOLLOW_String_in_question146); if (state.failed) return result;

                    Ident8=(Token)match(input,Ident,FOLLOW_Ident_in_question148); if (state.failed) return result;

                    match(input,23,FOLLOW_23_in_question150); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpression_in_question154);
                    e=orExpression();

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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: conditionBlock returns [ConditionBlock result] : ( 'if' '(' condition= orExpression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= orExpression ')' ifBody= statementBody );
    public final ConditionBlock conditionBlock() throws RecognitionException {
        ConditionBlock result = null;

        int conditionBlock_StartIndex = input.index();

        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:5: ( 'if' '(' condition= orExpression ')' ifBody= statementBody 'else' elseBody= statementBody | 'if' '(' condition= orExpression ')' ifBody= statementBody )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: 'if' '(' condition= orExpression ')' ifBody= statementBody 'else' elseBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock179); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock181); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpression_in_conditionBlock185);
                    condition=orExpression();

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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:45:9: 'if' '(' condition= orExpression ')' ifBody= statementBody
                    {
                    match(input,30,FOLLOW_30_in_conditionBlock217); if (state.failed) return result;

                    match(input,14,FOLLOW_14_in_conditionBlock219); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpression_in_conditionBlock223);
                    condition=orExpression();

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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:9: (statement= formStatement )+
                    {
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:9: (statement= formStatement )+
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
                    	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:10: statement= formStatement
                    	    {
                    	    pushFollow(FOLLOW_formStatement_in_statementBody302);
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
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: primary returns [Expression result] : ( Int | Bool | Money | String | Ident | '(' x= orExpression ')' );
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

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:5: ( Int | Bool | Money | String | Ident | '(' x= orExpression ')' )
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
                    Int9=(Token)match(input,Int,FOLLOW_Int_in_primary329); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Int(Integer.parseInt((Int9!=null?Int9.getText():null))); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:9: Bool
                    {
                    Bool10=(Token)match(input,Bool,FOLLOW_Bool_in_primary344); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Bool(Boolean.parseBoolean((Bool10!=null?Bool10.getText():null))); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:9: Money
                    {
                    Money11=(Token)match(input,Money,FOLLOW_Money_in_primary358); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Money(Double.parseDouble((Money11!=null?Money11.getText():null).replace(',', '.'))); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:9: String
                    {
                    String12=(Token)match(input,String,FOLLOW_String_in_primary371); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.expressions.literal.Str((String12!=null?String12.getText():null)); }

                    }
                    break;
                case 5 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:9: Ident
                    {
                    Ident13=(Token)match(input,Ident,FOLLOW_Ident_in_primary383); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident13!=null?Ident13.getText():null)); }

                    }
                    break;
                case 6 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:62:9: '(' x= orExpression ')'
                    {
                    match(input,14,FOLLOW_14_in_primary396); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpression_in_primary400);
                    x=orExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary402); if (state.failed) return result;

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



    // $ANTLR start "unExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:1: unExpression returns [Expression result] : ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary );
    public final Expression unExpression() throws RecognitionException {
        Expression result = null;

        int unExpression_StartIndex = input.index();

        Expression x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:5: ( '+' x= unExpression | '-' x= unExpression | '!' x= unExpression |x= primary )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:9: '+' x= unExpression
                    {
                    match(input,17,FOLLOW_17_in_unExpression430); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpression_in_unExpression434);
                    x=unExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:9: '-' x= unExpression
                    {
                    match(input,18,FOLLOW_18_in_unExpression446); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpression_in_unExpression450);
                    x=unExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:9: '!' x= unExpression
                    {
                    match(input,11,FOLLOW_11_in_unExpression462); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpression_in_unExpression466);
                    x=unExpression();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:69:9: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpression480);
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
            if ( state.backtracking>0 ) { memoize(input, 7, unExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpression"



    // $ANTLR start "mulExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:1: mulExpression returns [Expression result] : lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* ;
    public final Expression mulExpression() throws RecognitionException {
        Expression result = null;

        int mulExpression_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:5: (lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:9: lhs= unExpression (op= ( '*' | '/' ) rhs= unExpression )*
            {
            pushFollow(FOLLOW_unExpression_in_mulExpression518);
            lhs=unExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:51: (op= ( '*' | '/' ) rhs= unExpression )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16||LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:73:53: op= ( '*' | '/' ) rhs= unExpression
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


            	    pushFollow(FOLLOW_unExpression_in_mulExpression538);
            	    rhs=unExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("*")) { result = new Mul(result, rhs); }
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
            if ( state.backtracking>0 ) { memoize(input, 8, mulExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpression"



    // $ANTLR start "addExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:80:1: addExpression returns [Expression result] : lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* ;
    public final Expression addExpression() throws RecognitionException {
        Expression result = null;

        int addExpression_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:5: (lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:9: lhs= mulExpression (op= ( '+' | '-' ) rhs= mulExpression )*
            {
            pushFollow(FOLLOW_mulExpression_in_addExpression576);
            lhs=mulExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:52: (op= ( '+' | '-' ) rhs= mulExpression )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= 17 && LA10_0 <= 18)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:81:54: op= ( '+' | '-' ) rhs= mulExpression
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


            	    pushFollow(FOLLOW_mulExpression_in_addExpression594);
            	    rhs=mulExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("+")) { result = new Addition(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("-")) { result = new Sub(result, rhs); }
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
            if ( state.backtracking>0 ) { memoize(input, 9, addExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpression"



    // $ANTLR start "relExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:88:1: relExpression returns [Expression result] : lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* ;
    public final Expression relExpression() throws RecognitionException {
        Expression result = null;

        int relExpression_StartIndex = input.index();

        Token op=null;
        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:5: (lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:9: lhs= addExpression (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
            {
            pushFollow(FOLLOW_addExpression_in_relExpression629);
            lhs=addExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:52: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||(LA11_0 >= 21 && LA11_0 <= 22)||(LA11_0 >= 24 && LA11_0 <= 26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:89:54: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpression
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


            	    pushFollow(FOLLOW_addExpression_in_relExpression653);
            	    rhs=addExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	            if ((op!=null?op.getText():null).equals("<"))  { result = new LT(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("<=")) { result = new LEq(result, rhs); }
            	            if ((op!=null?op.getText():null).equals(">"))  { result = new GT(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals(">=")) { result = new GEq(result, rhs); }
            	            if ((op!=null?op.getText():null).equals("==")) { result = new Eq(result, rhs);  }
            	            if ((op!=null?op.getText():null).equals("!=")) { result = new NEq(result, rhs); }
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
            if ( state.backtracking>0 ) { memoize(input, 10, relExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpression"



    // $ANTLR start "andExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:1: andExpression returns [Expression result] : lhs= relExpression ( '&&' rhs= relExpression )* ;
    public final Expression andExpression() throws RecognitionException {
        Expression result = null;

        int andExpression_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:5: (lhs= relExpression ( '&&' rhs= relExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:9: lhs= relExpression ( '&&' rhs= relExpression )*
            {
            pushFollow(FOLLOW_relExpression_in_andExpression691);
            lhs=relExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:52: ( '&&' rhs= relExpression )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:101:54: '&&' rhs= relExpression
            	    {
            	    match(input,13,FOLLOW_13_in_andExpression697); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpression_in_andExpression701);
            	    rhs=relExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 11, andExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpression"



    // $ANTLR start "orExpression"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:105:1: orExpression returns [Expression result] : lhs= andExpression ( '||' rhs= andExpression )* ;
    public final Expression orExpression() throws RecognitionException {
        Expression result = null;

        int orExpression_StartIndex = input.index();

        Expression lhs =null;

        Expression rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:5: (lhs= andExpression ( '||' rhs= andExpression )* )
            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:9: lhs= andExpression ( '||' rhs= andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_orExpression736);
            lhs=andExpression();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:54: ( '||' rhs= andExpression )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:56: '||' rhs= andExpression
            	    {
            	    match(input,35,FOLLOW_35_in_orExpression742); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpression_in_orExpression746);
            	    rhs=andExpression();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 12, orExpression_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpression"



    // $ANTLR start "type"
    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:1: type returns [Type result] : ( 'integer' | 'string' | 'boolean' | 'money' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:5: ( 'integer' | 'string' | 'boolean' | 'money' )
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
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:9: 'integer'
                    {
                    match(input,31,FOLLOW_31_in_type774); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Int();   }

                    }
                    break;
                case 2 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:9: 'string'
                    {
                    match(input,33,FOLLOW_33_in_type786); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Str();   }

                    }
                    break;
                case 3 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:112:9: 'boolean'
                    {
                    match(input,27,FOLLOW_27_in_type799); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new org.uva.sea.ql.ast.types.Bool();  }

                    }
                    break;
                case 4 :
                    // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:9: 'money'
                    {
                    match(input,32,FOLLOW_32_in_type811); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 13, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"

    // $ANTLR start synpred3_QL
    public final void synpred3_QL_fragment() throws RecognitionException {
        Expression condition =null;

        StatementBody ifBody =null;

        StatementBody elseBody =null;


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: ( 'if' '(' condition= orExpression ')' ifBody= statementBody 'else' elseBody= statementBody )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:9: 'if' '(' condition= orExpression ')' ifBody= statementBody 'else' elseBody= statementBody
        {
        match(input,30,FOLLOW_30_in_synpred3_QL179); if (state.failed) return ;

        match(input,14,FOLLOW_14_in_synpred3_QL181); if (state.failed) return ;

        pushFollow(FOLLOW_orExpression_in_synpred3_QL185);
        condition=orExpression();

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


        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:10: (statement= formStatement )
        // C:\\Users\\Edwin\\Documents\\GitHub\\sea-of-ql\\edwinvm\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:10: statement= formStatement
        {
        pushFollow(FOLLOW_formStatement_in_synpred6_QL302);
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
    public static final BitSet FOLLOW_orExpression_in_question154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock179 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock181 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpression_in_conditionBlock185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock187 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_conditionBlock193 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_conditionBlock217 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditionBlock219 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpression_in_conditionBlock223 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditionBlock225 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_conditionBlock229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_statementBody278 = new BitSet(new long[]{0x0000000040000200L});
    public static final BitSet FOLLOW_formStatement_in_statementBody283 = new BitSet(new long[]{0x0000001040000200L});
    public static final BitSet FOLLOW_36_in_statementBody289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_statementBody302 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_Int_in_primary329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Money_in_primary358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary396 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpression_in_primary400 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpression430 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpression_in_unExpression434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpression446 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpression_in_unExpression450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpression462 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpression_in_unExpression466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpression480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpression_in_mulExpression518 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpression526 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_unExpression_in_mulExpression538 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpression_in_addExpression576 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpression584 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_mulExpression_in_addExpression594 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpression_in_relExpression629 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_set_in_relExpression637 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_addExpression_in_relExpression653 = new BitSet(new long[]{0x0000000007601002L});
    public static final BitSet FOLLOW_relExpression_in_andExpression691 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpression697 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_relExpression_in_andExpression701 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpression_in_orExpression736 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_orExpression742 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_andExpression_in_orExpression746 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_31_in_type774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_type786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_type799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_type811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred3_QL179 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_synpred3_QL181 = new BitSet(new long[]{0x0000000000064BD0L});
    public static final BitSet FOLLOW_orExpression_in_synpred3_QL185 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_synpred3_QL187 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_synpred3_QL193 = new BitSet(new long[]{0x0000000440000200L});
    public static final BitSet FOLLOW_statementBody_in_synpred3_QL197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_formStatement_in_synpred6_QL302 = new BitSet(new long[]{0x0000000000000002L});

}