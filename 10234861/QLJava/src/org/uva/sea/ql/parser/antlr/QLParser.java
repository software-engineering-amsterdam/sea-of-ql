// $ANTLR 3.4 /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-03-05 23:45:43

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stmnt.*;
import org.uva.sea.ql.ast.type.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "Ident", "Int", "MLINE_COMMENT", "SLINE_COMMENT", "String", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'bool'", "'form'", "'if'", "'int'", "'string'", "'{'", "'||'", "'}'"
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
    public static final int Bool=4;
    public static final int Ident=5;
    public static final int Int=6;
    public static final int MLINE_COMMENT=7;
    public static final int SLINE_COMMENT=8;
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
        this.state.ruleMemo = new HashMap[39+1];
         

    }

    public String[] getTokenNames() { return QLParser.tokenNames; }
    public String getGrammarFileName() { return "/home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "ifStatement"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:1: ifStatement returns [IfStatement result] : 'if' '(' condition= orExpr ')' body ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement result = null;

        int ifStatement_StartIndex = input.index();

        Expr condition =null;

        Body body1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:3: ( 'if' '(' condition= orExpr ')' body )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:3: 'if' '(' condition= orExpr ')' body
            {
            match(input,28,FOLLOW_28_in_ifStatement44); if (state.failed) return result;

            match(input,14,FOLLOW_14_in_ifStatement46); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_ifStatement50);
            condition=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_ifStatement52); if (state.failed) return result;

            pushFollow(FOLLOW_body_in_ifStatement54);
            body1=body();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new IfStatement(condition, body1); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, ifStatement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "ifStatement"



    // $ANTLR start "question"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:1: question returns [Question result] : ( computedQuestion | normalQuestion ) ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        ComputedQuestion computedQuestion2 =null;

        Question normalQuestion3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:3: ( ( computedQuestion | normalQuestion ) )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:3: ( computedQuestion | normalQuestion )
            {
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:3: ( computedQuestion | normalQuestion )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Ident) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==20) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==String) ) {
                        switch ( input.LA(4) ) {
                        case 29:
                            {
                            int LA1_4 = input.LA(5);

                            if ( (LA1_4==14) ) {
                                alt1=1;
                            }
                            else if ( (LA1_4==EOF||LA1_4==Ident||LA1_4==28||LA1_4==33) ) {
                                alt1=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 4, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 26:
                            {
                            int LA1_5 = input.LA(5);

                            if ( (LA1_5==14) ) {
                                alt1=1;
                            }
                            else if ( (LA1_5==EOF||LA1_5==Ident||LA1_5==28||LA1_5==33) ) {
                                alt1=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case 30:
                            {
                            int LA1_6 = input.LA(5);

                            if ( (LA1_6==14) ) {
                                alt1=1;
                            }
                            else if ( (LA1_6==EOF||LA1_6==Ident||LA1_6==28||LA1_6==33) ) {
                                alt1=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 1, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:5: computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_question71);
                    computedQuestion2=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = computedQuestion2; }

                    }
                    break;
                case 2 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:63: normalQuestion
                    {
                    pushFollow(FOLLOW_normalQuestion_in_question77);
                    normalQuestion3=normalQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = normalQuestion3; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "normalQuestion"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:1: normalQuestion returns [Question result] : Ident ':' String type ;
    public final Question normalQuestion() throws RecognitionException {
        Question result = null;

        int normalQuestion_StartIndex = input.index();

        Token Ident4=null;
        Token String5=null;
        Type type6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:3: ( Ident ':' String type )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:3: Ident ':' String type
            {
            Ident4=(Token)match(input,Ident,FOLLOW_Ident_in_normalQuestion94); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_normalQuestion96); if (state.failed) return result;

            String5=(Token)match(input,String,FOLLOW_String_in_normalQuestion98); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_normalQuestion100);
            type6=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Question(new Ident((Ident4!=null?Ident4.getText():null)), new StringLiteral((String5!=null?String5.getText():null)), type6); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, normalQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "normalQuestion"



    // $ANTLR start "computedQuestion"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:1: computedQuestion returns [ComputedQuestion result] : Ident ':' String type '(' orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident7=null;
        Token String8=null;
        Type type9 =null;

        Expr orExpr10 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:3: ( Ident ':' String type '(' orExpr ')' )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:3: Ident ':' String type '(' orExpr ')'
            {
            Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion115); if (state.failed) return result;

            match(input,20,FOLLOW_20_in_computedQuestion117); if (state.failed) return result;

            String8=(Token)match(input,String,FOLLOW_String_in_computedQuestion119); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion121);
            type9=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,14,FOLLOW_14_in_computedQuestion123); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion125);
            orExpr10=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,15,FOLLOW_15_in_computedQuestion127); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new ComputedQuestion(new Ident((Ident7!=null?Ident7.getText():null)), new StringLiteral((String8!=null?String8.getText():null)), type9, orExpr10); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "type"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: type returns [Type result] : ( 'int' | 'bool' | 'string' );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:3: ( 'int' | 'bool' | 'string' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt2=1;
                }
                break;
            case 26:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:3: 'int'
                    {
                    match(input,29,FOLLOW_29_in_type142); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntType(); }

                    }
                    break;
                case 2 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:38:3: 'bool'
                    {
                    match(input,26,FOLLOW_26_in_type148); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolType(); }

                    }
                    break;
                case 3 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:3: 'string'
                    {
                    match(input,30,FOLLOW_30_in_type154); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringType(); }

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
            if ( state.backtracking>0 ) { memoize(input, 5, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "statement"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: statement returns [Statement result] : ( question | ifStatement ) ;
    public final Statement statement() throws RecognitionException {
        Statement result = null;

        int statement_StartIndex = input.index();

        Question question11 =null;

        IfStatement ifStatement12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( ( question | ifStatement ) )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( question | ifStatement )
            {
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( question | ifStatement )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Ident) ) {
                alt3=1;
            }
            else if ( (LA3_0==28) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: question
                    {
                    pushFollow(FOLLOW_question_in_statement170);
                    question11=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = question11; }

                    }
                    break;
                case 2 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:3: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement176);
                    ifStatement12=ifStatement();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ifStatement12; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, statement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "body"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: body returns [Body result] : '{' ( statement )* '}' ;
    public final Body body() throws RecognitionException {
        Body result = null;

        int body_StartIndex = input.index();

        Statement statement13 =null;


         List<Statement> statements = new ArrayList<Statement>(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:3: ( '{' ( statement )* '}' )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:3: '{' ( statement )* '}'
            {
            match(input,31,FOLLOW_31_in_body198); if (state.failed) return result;

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:7: ( statement )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Ident||LA4_0==28) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:9: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_body202);
            	    statement13=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { statements.add(statement13); }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input,33,FOLLOW_33_in_body209); if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Body(statements); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, body_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "body"



    // $ANTLR start "form"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:52:1: form returns [Form result] : 'form' Ident body ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident14=null;
        Body body15 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:5: ( 'form' Ident body )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:53:7: 'form' Ident body
            {
            match(input,27,FOLLOW_27_in_form228); if (state.failed) return result;

            Ident14=(Token)match(input,Ident,FOLLOW_Ident_in_form230); if (state.failed) return result;

            pushFollow(FOLLOW_body_in_form232);
            body15=body();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = new Form (new Ident((Ident14!=null?Ident14.getText():null)), body15); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, form_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "form"



    // $ANTLR start "primary"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:1: primary returns [Expr result] : ( Int | Bool | String | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int16=null;
        Token Bool17=null;
        Token String18=null;
        Token Ident19=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:4: ( Int | Bool | String | Ident | '(' x= orExpr ')' )
            int alt5=5;
            switch ( input.LA(1) ) {
            case Int:
                {
                alt5=1;
                }
                break;
            case Bool:
                {
                alt5=2;
                }
                break;
            case String:
                {
                alt5=3;
                }
                break;
            case Ident:
                {
                alt5=4;
                }
                break;
            case 14:
                {
                alt5=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:57:6: Int
                    {
                    Int16=(Token)match(input,Int,FOLLOW_Int_in_primary254); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntLiteral(Integer.parseInt((Int16!=null?Int16.getText():null))); }

                    }
                    break;
                case 2 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:6: Bool
                    {
                    Bool17=(Token)match(input,Bool,FOLLOW_Bool_in_primary263); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new BoolLiteral ((Bool17!=null?Bool17.getText():null)); }

                    }
                    break;
                case 3 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:6: String
                    {
                    String18=(Token)match(input,String,FOLLOW_String_in_primary272); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new StringLiteral ((String18!=null?String18.getText():null)); }

                    }
                    break;
                case 4 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:6: Ident
                    {
                    Ident19=(Token)match(input,Ident,FOLLOW_Ident_in_primary281); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident19!=null?Ident19.getText():null)); }

                    }
                    break;
                case 5 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:6: '(' x= orExpr ')'
                    {
                    match(input,14,FOLLOW_14_in_primary290); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary294);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,15,FOLLOW_15_in_primary296); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 9, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt6=1;
                }
                break;
            case 18:
                {
                alt6=2;
                }
                break;
            case 11:
                {
                alt6=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case String:
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:7: '+' x= unExpr
                    {
                    match(input,17,FOLLOW_17_in_unExpr321); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr325);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:7: '-' x= unExpr
                    {
                    match(input,18,FOLLOW_18_in_unExpr335); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr339);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:7: '!' x= unExpr
                    {
                    match(input,11,FOLLOW_11_in_unExpr349); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr353);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr365);
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
            if ( state.backtracking>0 ) { memoize(input, 10, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:7: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr394);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:43: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16||LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:45: op= ( '*' | '/' ) rhs= unExpr
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


            	    pushFollow(FOLLOW_unExpr_in_mulExpr414);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
            	            result = new Div(result, rhs);
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop7;
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
            if ( state.backtracking>0 ) { memoize(input, 11, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr449);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 17 && LA8_0 <= 18)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:46: op= ( '+' | '-' ) rhs= mulExpr
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


            	    pushFollow(FOLLOW_mulExpr_in_addExpr467);
            	    rhs=mulExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {
            	          if ((op!=null?op.getText():null).equals("+")) {
            	            result = new Add(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("-")) {
            	            result = new Sub(result, rhs);
            	          }
            	        }

            	    }
            	    break;

            	default :
            	    break loop8;
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
            if ( state.backtracking>0 ) { memoize(input, 12, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr500);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==12||(LA9_0 >= 21 && LA9_0 <= 25)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==12||(input.LA(1) >= 21 && input.LA(1) <= 25) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr524);
            	    rhs=addExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) {
            	          if ((op!=null?op.getText():null).equals("<")) {
            	            result = new LT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("<=")) {
            	            result = new LEq(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals(">")) {
            	            result = new GT(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals(">=")) {
            	            result = new GEq(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("==")) {
            	            result = new Eq(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("!=")) {
            	            result = new NEq(result, rhs);
            	          }
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
            if ( state.backtracking>0 ) { memoize(input, 13, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr559);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:44: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:46: '&&' rhs= relExpr
            	    {
            	    match(input,13,FOLLOW_13_in_andExpr565); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr569);
            	    rhs=relExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new And(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 14, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return result; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr602);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:46: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==32) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/khho/workspace/sea-of-ql/10234861/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:125:48: '||' rhs= andExpr
            	    {
            	    match(input,32,FOLLOW_32_in_orExpr608); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr612);
            	    rhs=andExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { result = new Or(result, rhs); }

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
            if ( state.backtracking>0 ) { memoize(input, 15, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // Delegated rules


 

    public static final BitSet FOLLOW_28_in_ifStatement44 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ifStatement46 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_ifStatement50 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ifStatement52 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_body_in_ifStatement54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_question71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalQuestion_in_question77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_normalQuestion94 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_normalQuestion96 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_normalQuestion98 = new BitSet(new long[]{0x0000000064000000L});
    public static final BitSet FOLLOW_type_in_normalQuestion100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion115 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_computedQuestion117 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_String_in_computedQuestion119 = new BitSet(new long[]{0x0000000064000000L});
    public static final BitSet FOLLOW_type_in_computedQuestion121 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computedQuestion123 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion125 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computedQuestion127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_type142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_type148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_type154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_statement170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_body198 = new BitSet(new long[]{0x0000000210000020L});
    public static final BitSet FOLLOW_statement_in_body202 = new BitSet(new long[]{0x0000000210000020L});
    public static final BitSet FOLLOW_33_in_body209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_form228 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_Ident_in_form230 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_body_in_form232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_primary272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary290 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_orExpr_in_primary294 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr321 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_unExpr325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr335 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_unExpr339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr349 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_unExpr353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr394 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr402 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr414 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr449 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr457 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr467 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr500 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_set_in_relExpr508 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_addExpr_in_relExpr524 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr559 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr565 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_relExpr_in_andExpr569 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr602 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_orExpr608 = new BitSet(new long[]{0x0000000000064A70L});
    public static final BitSet FOLLOW_andExpr_in_orExpr612 = new BitSet(new long[]{0x0000000100000002L});

}