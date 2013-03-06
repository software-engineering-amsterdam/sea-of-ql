// $ANTLR 3.4 /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-18 15:27:12

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.rel.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.ast.ql.*;
import org.uva.sea.ql.ast.type.*;
import org.uva.sea.ql.semanticchecker.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BOOLEAN", "Bool", "COMMENT", "Decimal", "INTEGER", "Ident", "Int", "STRING", "StringLit", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'else'", "'form'", "'if'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int BOOLEAN=4;
    public static final int Bool=5;
    public static final int COMMENT=6;
    public static final int Decimal=7;
    public static final int INTEGER=8;
    public static final int Ident=9;
    public static final int Int=10;
    public static final int STRING=11;
    public static final int StringLit=12;
    public static final int WS=13;

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
    public String getGrammarFileName() { return "/home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }



    // $ANTLR start "qlform"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:1: qlform returns [QLForm result] : 'form' Ident '{' block '}' ;
    public final QLForm qlform() throws RecognitionException {
        QLForm result = null;

        int qlform_StartIndex = input.index();

        Token Ident1=null;
        Block block2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:2: ( 'form' Ident '{' block '}' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:4: 'form' Ident '{' block '}'
            {
            match(input,30,FOLLOW_30_in_qlform45); if (state.failed) return result;

            Ident1=(Token)match(input,Ident,FOLLOW_Ident_in_qlform47); if (state.failed) return result;

            match(input,32,FOLLOW_32_in_qlform49); if (state.failed) return result;

            pushFollow(FOLLOW_block_in_qlform51);
            block2=block();

            state._fsp--;
            if (state.failed) return result;

            match(input,34,FOLLOW_34_in_qlform53); if (state.failed) return result;

            if ( state.backtracking==0 ) {result = new QLForm(new Ident((Ident1!=null?Ident1.getText():null)),  block2); }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, qlform_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "qlform"



    // $ANTLR start "block"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:1: block returns [Block result] : ( statement )* ;
    public final Block block() throws RecognitionException {
        Block result = null;

        int block_StartIndex = input.index();

        Statement statement3 =null;


         Block block= new Block(); 
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:2: ( ( statement )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:5: ( statement )*
            {
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:5: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Ident||LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:6: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block79);
            	    statement3=statement();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { block.addBlockElement(statement3); }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {result = block; }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, block_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "block"



    // $ANTLR start "statement"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:1: statement returns [Statement result] : ( question | computedQuestion | conditionalQuestion );
    public final Statement statement() throws RecognitionException {
        Statement result = null;

        int statement_StartIndex = input.index();

        Question question4 =null;

        ComputedQuestion computedQuestion5 =null;

        ConditionalQuestion conditionalQuestion6 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:2: ( question | computedQuestion | conditionalQuestion )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Ident) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==23) ) {
                    int LA2_3 = input.LA(3);

                    if ( (LA2_3==StringLit) ) {
                        switch ( input.LA(4) ) {
                        case BOOLEAN:
                            {
                            int LA2_5 = input.LA(5);

                            if ( (LA2_5==EOF||LA2_5==Ident||LA2_5==31||LA2_5==34) ) {
                                alt2=1;
                            }
                            else if ( (LA2_5==17) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 5, input);

                                throw nvae;

                            }
                            }
                            break;
                        case INTEGER:
                            {
                            int LA2_6 = input.LA(5);

                            if ( (LA2_6==EOF||LA2_6==Ident||LA2_6==31||LA2_6==34) ) {
                                alt2=1;
                            }
                            else if ( (LA2_6==17) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 6, input);

                                throw nvae;

                            }
                            }
                            break;
                        case STRING:
                            {
                            int LA2_7 = input.LA(5);

                            if ( (LA2_7==EOF||LA2_7==Ident||LA2_7==31||LA2_7==34) ) {
                                alt2=1;
                            }
                            else if ( (LA2_7==17) ) {
                                alt2=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return result;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 7, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 3, input);

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
            else if ( (LA2_0==31) ) {
                alt2=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:4: question
                    {
                    pushFollow(FOLLOW_question_in_statement104);
                    question4=question();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =question4;}

                    }
                    break;
                case 2 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:4: computedQuestion
                    {
                    pushFollow(FOLLOW_computedQuestion_in_statement111);
                    computedQuestion5=computedQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = computedQuestion5;}

                    }
                    break;
                case 3 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:33:4: conditionalQuestion
                    {
                    pushFollow(FOLLOW_conditionalQuestion_in_statement118);
                    conditionalQuestion6=conditionalQuestion();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = conditionalQuestion6;}

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
            if ( state.backtracking>0 ) { memoize(input, 3, statement_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "statement"



    // $ANTLR start "question"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:36:1: question returns [Question result] : Ident ':' StringLit type ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident7=null;
        Token StringLit8=null;
        Type type9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:2: ( Ident ':' StringLit type )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:37:4: Ident ':' StringLit type
            {
            Ident7=(Token)match(input,Ident,FOLLOW_Ident_in_question136); if (state.failed) return result;

            match(input,23,FOLLOW_23_in_question138); if (state.failed) return result;

            StringLit8=(Token)match(input,StringLit,FOLLOW_StringLit_in_question140); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_question142);
            type9=type();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new Question(new Ident((Ident7!=null?Ident7.getText():null)),(StringLit8!=null?StringLit8.getText():null), type9);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, question_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "question"



    // $ANTLR start "computedQuestion"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:39:1: computedQuestion returns [ComputedQuestion result] : Ident ':' StringLit type '(' expr= orExpr ')' ;
    public final ComputedQuestion computedQuestion() throws RecognitionException {
        ComputedQuestion result = null;

        int computedQuestion_StartIndex = input.index();

        Token Ident10=null;
        Token StringLit11=null;
        Expr expr =null;

        Type type12 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:3: ( Ident ':' StringLit type '(' expr= orExpr ')' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:40:5: Ident ':' StringLit type '(' expr= orExpr ')'
            {
            Ident10=(Token)match(input,Ident,FOLLOW_Ident_in_computedQuestion159); if (state.failed) return result;

            match(input,23,FOLLOW_23_in_computedQuestion161); if (state.failed) return result;

            StringLit11=(Token)match(input,StringLit,FOLLOW_StringLit_in_computedQuestion163); if (state.failed) return result;

            pushFollow(FOLLOW_type_in_computedQuestion165);
            type12=type();

            state._fsp--;
            if (state.failed) return result;

            match(input,17,FOLLOW_17_in_computedQuestion167); if (state.failed) return result;

            pushFollow(FOLLOW_orExpr_in_computedQuestion171);
            expr=orExpr();

            state._fsp--;
            if (state.failed) return result;

            match(input,18,FOLLOW_18_in_computedQuestion173); if (state.failed) return result;

            if ( state.backtracking==0 ) {result =new ComputedQuestion(new Ident((Ident10!=null?Ident10.getText():null)),(StringLit11!=null?StringLit11.getText():null),type12,expr);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, computedQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "computedQuestion"



    // $ANTLR start "conditionalQuestion"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:42:1: conditionalQuestion returns [ConditionalQuestion result] : ( 'if' '(' expr= orExpr ')' '{' b1= block '}' 'else' '{' b2= block '}' | 'if' '(' expr= orExpr ')' '{' block '}' );
    public final ConditionalQuestion conditionalQuestion() throws RecognitionException {
        ConditionalQuestion result = null;

        int conditionalQuestion_StartIndex = input.index();

        Expr expr =null;

        Block b1 =null;

        Block b2 =null;

        Block block13 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:3: ( 'if' '(' expr= orExpr ')' '{' b1= block '}' 'else' '{' b2= block '}' | 'if' '(' expr= orExpr ')' '{' block '}' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==31) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred4_QL()) ) {
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
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: 'if' '(' expr= orExpr ')' '{' b1= block '}' 'else' '{' b2= block '}'
                    {
                    match(input,31,FOLLOW_31_in_conditionalQuestion188); if (state.failed) return result;

                    match(input,17,FOLLOW_17_in_conditionalQuestion190); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionalQuestion194);
                    expr=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,18,FOLLOW_18_in_conditionalQuestion196); if (state.failed) return result;

                    match(input,32,FOLLOW_32_in_conditionalQuestion198); if (state.failed) return result;

                    pushFollow(FOLLOW_block_in_conditionalQuestion202);
                    b1=block();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,34,FOLLOW_34_in_conditionalQuestion204); if (state.failed) return result;

                    match(input,29,FOLLOW_29_in_conditionalQuestion206); if (state.failed) return result;

                    match(input,32,FOLLOW_32_in_conditionalQuestion208); if (state.failed) return result;

                    pushFollow(FOLLOW_block_in_conditionalQuestion212);
                    b2=block();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,34,FOLLOW_34_in_conditionalQuestion214); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =new ConditionalElseQuestion(expr,b1,b2);}

                    }
                    break;
                case 2 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:44:4: 'if' '(' expr= orExpr ')' '{' block '}'
                    {
                    match(input,31,FOLLOW_31_in_conditionalQuestion222); if (state.failed) return result;

                    match(input,17,FOLLOW_17_in_conditionalQuestion224); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_conditionalQuestion228);
                    expr=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,18,FOLLOW_18_in_conditionalQuestion230); if (state.failed) return result;

                    match(input,32,FOLLOW_32_in_conditionalQuestion232); if (state.failed) return result;

                    pushFollow(FOLLOW_block_in_conditionalQuestion234);
                    block13=block();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,34,FOLLOW_34_in_conditionalQuestion236); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result =new ConditionalQuestion(expr,block13);}

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
            if ( state.backtracking>0 ) { memoize(input, 6, conditionalQuestion_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "conditionalQuestion"



    // $ANTLR start "type"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:47:1: type returns [Type result] : ( BOOLEAN | INTEGER | STRING );
    public final Type type() throws RecognitionException {
        Type result = null;

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:2: ( BOOLEAN | INTEGER | STRING )
            int alt4=3;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt4=1;
                }
                break;
            case INTEGER:
                {
                alt4=2;
                }
                break;
            case STRING:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:48:4: BOOLEAN
                    {
                    match(input,BOOLEAN,FOLLOW_BOOLEAN_in_type255); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ReturnTypeHolder.getBoolType();}

                    }
                    break;
                case 2 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:49:4: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_type262); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = ReturnTypeHolder.getIntType();}

                    }
                    break;
                case 3 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:51:4: STRING
                    {
                    match(input,STRING,FOLLOW_STRING_in_type270); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = ReturnTypeHolder.getStringType();}

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
            if ( state.backtracking>0 ) { memoize(input, 7, type_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "type"



    // $ANTLR start "primary"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:55:1: primary returns [Expr result] : ( Int | Bool | StringLit | Ident | '(' x= orExpr ')' );
    public final Expr primary() throws RecognitionException {
        Expr result = null;

        int primary_StartIndex = input.index();

        Token Int14=null;
        Token Bool15=null;
        Token StringLit16=null;
        Token Ident17=null;
        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:3: ( Int | Bool | StringLit | Ident | '(' x= orExpr ')' )
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
            case StringLit:
                {
                alt5=3;
                }
                break;
            case Ident:
                {
                alt5=4;
                }
                break;
            case 17:
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
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:56:5: Int
                    {
                    Int14=(Token)match(input,Int,FOLLOW_Int_in_primary292); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new IntegerVal(Integer.parseInt((Int14!=null?Int14.getText():null))); }

                    }
                    break;
                case 2 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:58:5: Bool
                    {
                    Bool15=(Token)match(input,Bool,FOLLOW_Bool_in_primary303); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new BooleanVal(Boolean.parseBoolean((Bool15!=null?Bool15.getText():null))); }

                    }
                    break;
                case 3 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:59:5: StringLit
                    {
                    StringLit16=(Token)match(input,StringLit,FOLLOW_StringLit_in_primary311); if (state.failed) return result;

                    if ( state.backtracking==0 ) {result = new StringVal((StringLit16!=null?StringLit16.getText():null)); }

                    }
                    break;
                case 4 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:60:5: Ident
                    {
                    Ident17=(Token)match(input,Ident,FOLLOW_Ident_in_primary319); if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Ident((Ident17!=null?Ident17.getText():null)); }

                    }
                    break;
                case 5 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:61:5: '(' x= orExpr ')'
                    {
                    match(input,17,FOLLOW_17_in_primary327); if (state.failed) return result;

                    pushFollow(FOLLOW_orExpr_in_primary331);
                    x=orExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input,18,FOLLOW_18_in_primary333); if (state.failed) return result;

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
            if ( state.backtracking>0 ) { memoize(input, 8, primary_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "primary"



    // $ANTLR start "unExpr"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:64:1: unExpr returns [Expr result] : ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary );
    public final Expr unExpr() throws RecognitionException {
        Expr result = null;

        int unExpr_StartIndex = input.index();

        Expr x =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:5: ( '+' x= unExpr | '-' x= unExpr | '!' x= unExpr |x= primary )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            case Bool:
            case Ident:
            case Int:
            case StringLit:
            case 17:
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
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:65:7: '+' x= unExpr
                    {
                    match(input,20,FOLLOW_20_in_unExpr354); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr358);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Pos(x); }

                    }
                    break;
                case 2 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:66:7: '-' x= unExpr
                    {
                    match(input,21,FOLLOW_21_in_unExpr368); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr372);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Neg(x); }

                    }
                    break;
                case 3 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:67:7: '!' x= unExpr
                    {
                    match(input,14,FOLLOW_14_in_unExpr382); if (state.failed) return result;

                    pushFollow(FOLLOW_unExpr_in_unExpr386);
                    x=unExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    if ( state.backtracking==0 ) { result = new Not(x); }

                    }
                    break;
                case 4 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:68:7: x= primary
                    {
                    pushFollow(FOLLOW_primary_in_unExpr398);
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
            if ( state.backtracking>0 ) { memoize(input, 9, unExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "unExpr"



    // $ANTLR start "mulExpr"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:71:1: mulExpr returns [Expr result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expr mulExpr() throws RecognitionException {
        Expr result = null;

        int mulExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:2: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:4: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
            pushFollow(FOLLOW_unExpr_in_mulExpr431);
            lhs=unExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:40: (op= ( '*' | '/' ) rhs= unExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19||LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:72:42: op= ( '*' | '/' ) rhs= unExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==19||input.LA(1)==22 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unExpr_in_mulExpr451);
            	    rhs=unExpr();

            	    state._fsp--;
            	    if (state.failed) return result;

            	    if ( state.backtracking==0 ) { 
            	          if ((op!=null?op.getText():null).equals("*")) {
            	            result = new Mul(result, rhs);
            	          }
            	          if ((op!=null?op.getText():null).equals("/")) {
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
            if ( state.backtracking>0 ) { memoize(input, 10, mulExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "mulExpr"



    // $ANTLR start "addExpr"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:83:1: addExpr returns [Expr result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expr addExpr() throws RecognitionException {
        Expr result = null;

        int addExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:7: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
            pushFollow(FOLLOW_mulExpr_in_addExpr487);
            lhs=mulExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:44: (op= ( '+' | '-' ) rhs= mulExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= 20 && LA8_0 <= 21)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:84:46: op= ( '+' | '-' ) rhs= mulExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( (input.LA(1) >= 20 && input.LA(1) <= 21) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_mulExpr_in_addExpr505);
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
            if ( state.backtracking>0 ) { memoize(input, 11, addExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "addExpr"



    // $ANTLR start "relExpr"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:1: relExpr returns [Expr result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expr relExpr() throws RecognitionException {
        Expr result = null;

        int relExpr_StartIndex = input.index();

        Token op=null;
        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:7: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
            pushFollow(FOLLOW_addExpr_in_relExpr538);
            lhs=addExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:44: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15||(LA9_0 >= 24 && LA9_0 <= 28)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:96:46: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
            	    {
            	    op=(Token)input.LT(1);

            	    if ( input.LA(1)==15||(input.LA(1) >= 24 && input.LA(1) <= 28) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return result;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_addExpr_in_relExpr562);
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
            if ( state.backtracking>0 ) { memoize(input, 12, relExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "relExpr"



    // $ANTLR start "andExpr"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:1: andExpr returns [Expr result] : lhs= relExpr ( '&&' rhs= relExpr )* ;
    public final Expr andExpr() throws RecognitionException {
        Expr result = null;

        int andExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:5: (lhs= relExpr ( '&&' rhs= relExpr )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:7: lhs= relExpr ( '&&' rhs= relExpr )*
            {
            pushFollow(FOLLOW_relExpr_in_andExpr598);
            lhs=relExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result =lhs; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:44: ( '&&' rhs= relExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:120:46: '&&' rhs= relExpr
            	    {
            	    match(input,16,FOLLOW_16_in_andExpr604); if (state.failed) return result;

            	    pushFollow(FOLLOW_relExpr_in_andExpr608);
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
            if ( state.backtracking>0 ) { memoize(input, 13, andExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "andExpr"



    // $ANTLR start "orExpr"
    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:123:1: orExpr returns [Expr result] : lhs= andExpr ( '||' rhs= andExpr )* ;
    public final Expr orExpr() throws RecognitionException {
        Expr result = null;

        int orExpr_StartIndex = input.index();

        Expr lhs =null;

        Expr rhs =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return result; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:5: (lhs= andExpr ( '||' rhs= andExpr )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:7: lhs= andExpr ( '||' rhs= andExpr )*
            {
            pushFollow(FOLLOW_andExpr_in_orExpr640);
            lhs=andExpr();

            state._fsp--;
            if (state.failed) return result;

            if ( state.backtracking==0 ) { result = lhs; }

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:46: ( '||' rhs= andExpr )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==33) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:124:48: '||' rhs= andExpr
            	    {
            	    match(input,33,FOLLOW_33_in_orExpr646); if (state.failed) return result;

            	    pushFollow(FOLLOW_andExpr_in_orExpr650);
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
            if ( state.backtracking>0 ) { memoize(input, 14, orExpr_StartIndex); }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred4_QL
    public final void synpred4_QL_fragment() throws RecognitionException {
        Expr expr =null;

        Block b1 =null;

        Block b2 =null;


        // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: ( 'if' '(' expr= orExpr ')' '{' b1= block '}' 'else' '{' b2= block '}' )
        // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:43:4: 'if' '(' expr= orExpr ')' '{' b1= block '}' 'else' '{' b2= block '}'
        {
        match(input,31,FOLLOW_31_in_synpred4_QL188); if (state.failed) return ;

        match(input,17,FOLLOW_17_in_synpred4_QL190); if (state.failed) return ;

        pushFollow(FOLLOW_orExpr_in_synpred4_QL194);
        expr=orExpr();

        state._fsp--;
        if (state.failed) return ;

        match(input,18,FOLLOW_18_in_synpred4_QL196); if (state.failed) return ;

        match(input,32,FOLLOW_32_in_synpred4_QL198); if (state.failed) return ;

        pushFollow(FOLLOW_block_in_synpred4_QL202);
        b1=block();

        state._fsp--;
        if (state.failed) return ;

        match(input,34,FOLLOW_34_in_synpred4_QL204); if (state.failed) return ;

        match(input,29,FOLLOW_29_in_synpred4_QL206); if (state.failed) return ;

        match(input,32,FOLLOW_32_in_synpred4_QL208); if (state.failed) return ;

        pushFollow(FOLLOW_block_in_synpred4_QL212);
        b2=block();

        state._fsp--;
        if (state.failed) return ;

        match(input,34,FOLLOW_34_in_synpred4_QL214); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_QL

    // Delegated rules

    public final boolean synpred4_QL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_QL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_30_in_qlform45 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Ident_in_qlform47 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_qlform49 = new BitSet(new long[]{0x0000000480000200L});
    public static final BitSet FOLLOW_block_in_qlform51 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_qlform53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_block79 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_question_in_statement104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computedQuestion_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalQuestion_in_statement118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question136 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_question138 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_StringLit_in_question140 = new BitSet(new long[]{0x0000000000000910L});
    public static final BitSet FOLLOW_type_in_question142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computedQuestion159 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_computedQuestion161 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_StringLit_in_computedQuestion163 = new BitSet(new long[]{0x0000000000000910L});
    public static final BitSet FOLLOW_type_in_computedQuestion165 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_computedQuestion167 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_orExpr_in_computedQuestion171 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_computedQuestion173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_conditionalQuestion188 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_conditionalQuestion190 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_orExpr_in_conditionalQuestion194 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_conditionalQuestion196 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_conditionalQuestion198 = new BitSet(new long[]{0x0000000480000200L});
    public static final BitSet FOLLOW_block_in_conditionalQuestion202 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_conditionalQuestion204 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_conditionalQuestion206 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_conditionalQuestion208 = new BitSet(new long[]{0x0000000480000200L});
    public static final BitSet FOLLOW_block_in_conditionalQuestion212 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_conditionalQuestion214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_conditionalQuestion222 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_conditionalQuestion224 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_orExpr_in_conditionalQuestion228 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_conditionalQuestion230 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_conditionalQuestion232 = new BitSet(new long[]{0x0000000480000200L});
    public static final BitSet FOLLOW_block_in_conditionalQuestion234 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_conditionalQuestion236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_type255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_type262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_type270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLit_in_primary311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_primary327 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_orExpr_in_primary331 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_primary333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_unExpr354 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_unExpr_in_unExpr358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_unExpr368 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_unExpr_in_unExpr372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_unExpr382 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_unExpr_in_unExpr386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr431 = new BitSet(new long[]{0x0000000000480002L});
    public static final BitSet FOLLOW_set_in_mulExpr439 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr451 = new BitSet(new long[]{0x0000000000480002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr487 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_set_in_addExpr495 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr505 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr538 = new BitSet(new long[]{0x000000001F008002L});
    public static final BitSet FOLLOW_set_in_relExpr546 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_addExpr_in_relExpr562 = new BitSet(new long[]{0x000000001F008002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr598 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_andExpr604 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_relExpr_in_andExpr608 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr640 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr646 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_andExpr_in_orExpr650 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_31_in_synpred4_QL188 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_synpred4_QL190 = new BitSet(new long[]{0x0000000000325620L});
    public static final BitSet FOLLOW_orExpr_in_synpred4_QL194 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_synpred4_QL196 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_synpred4_QL198 = new BitSet(new long[]{0x0000000480000200L});
    public static final BitSet FOLLOW_block_in_synpred4_QL202 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred4_QL204 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_synpred4_QL206 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_synpred4_QL208 = new BitSet(new long[]{0x0000000480000200L});
    public static final BitSet FOLLOW_block_in_synpred4_QL212 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_synpred4_QL214 = new BitSet(new long[]{0x0000000000000002L});

}