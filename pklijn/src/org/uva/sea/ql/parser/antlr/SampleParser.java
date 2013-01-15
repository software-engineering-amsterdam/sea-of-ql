// $ANTLR 3.4 /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g 2013-01-15 10:57:53

  package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SampleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "WS", "'.'", "'='", "'begin'", "'end'", "'program'"
    };

    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int IDENT=4;
    public static final int WS=5;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public SampleParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SampleParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SampleParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g"; }



    // $ANTLR start "program"
    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:15:1: program : 'program' IDENT '=' 'begin' 'end' IDENT '.' ;
    public final void program() throws RecognitionException {
        try {
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:16:3: ( 'program' IDENT '=' 'begin' 'end' IDENT '.' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:16:5: 'program' IDENT '=' 'begin' 'end' IDENT '.'
            {
            match(input,10,FOLLOW_10_in_program41); 

            match(input,IDENT,FOLLOW_IDENT_in_program43); 

            match(input,7,FOLLOW_7_in_program45); 

            match(input,8,FOLLOW_8_in_program51); 

            match(input,9,FOLLOW_9_in_program57); 

            match(input,IDENT,FOLLOW_IDENT_in_program59); 

            match(input,6,FOLLOW_6_in_program61); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"

    // Delegated rules


 

    public static final BitSet FOLLOW_10_in_program41 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program43 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_program45 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_program51 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_program57 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program59 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_6_in_program61 = new BitSet(new long[]{0x0000000000000002L});

}