// $ANTLR 3.5 /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g 2013-02-20 21:34:49

package org.uva.sea.ql.parsing.antlr;

import org.antlr.runtime.*;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.SourceCodeInformation;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.primary.Bool;
import org.uva.sea.ql.ast.expression.primary.Ident;
import org.uva.sea.ql.ast.expression.primary.Int;
import org.uva.sea.ql.ast.expression.primary.Str;
import org.uva.sea.ql.ast.expression.unary.Negative;
import org.uva.sea.ql.ast.expression.unary.Not;
import org.uva.sea.ql.ast.expression.unary.Positive;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parsing.error.SyntacticErrorReporter;
import org.uva.sea.ql.parsing.error.SyntacticQLError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class QLParser extends Parser {
    public static final String[] tokenNames = new String[]{
            "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Bool", "COMMENT", "EscapedCharacterSequence",
            "Ident", "Int", "Str", "WS", "'!'", "'!='", "'&&'", "'('", "')'", "'*'",
            "'+'", "'-'", "'/'", "':'", "'<'", "'<='", "'=='", "'>'", "'>='", "'boolean'",
            "'else'", "'form'", "'if'", "'integer'", "'string'", "'{'", "'||'", "'}'"
    };
    public static final int EOF = -1;
    public static final int T__11 = 11;
    public static final int T__12 = 12;
    public static final int T__13 = 13;
    public static final int T__14 = 14;
    public static final int T__15 = 15;
    public static final int T__16 = 16;
    public static final int T__17 = 17;
    public static final int T__18 = 18;
    public static final int T__19 = 19;
    public static final int T__20 = 20;
    public static final int T__21 = 21;
    public static final int T__22 = 22;
    public static final int T__23 = 23;
    public static final int T__24 = 24;
    public static final int T__25 = 25;
    public static final int T__26 = 26;
    public static final int T__27 = 27;
    public static final int T__28 = 28;
    public static final int T__29 = 29;
    public static final int T__30 = 30;
    public static final int T__31 = 31;
    public static final int T__32 = 32;
    public static final int T__33 = 33;
    public static final int T__34 = 34;
    public static final int Bool = 4;
    public static final int COMMENT = 5;
    public static final int EscapedCharacterSequence = 6;
    public static final int Ident = 7;
    public static final int Int = 8;
    public static final int Str = 9;
    public static final int WS = 10;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[]{};
    }

    // delegators


    public QLParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public QLParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[40 + 1];


    }

    @Override
    public String[] getTokenNames() {
        return QLParser.tokenNames;
    }

    @Override
    public String getGrammarFileName() {
        return "/home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g";
    }


    private SyntacticErrorReporter syntacticErrorReporter = null;

    public void setErrorReporter(SyntacticErrorReporter syntacticErrorReporter) {
        this.syntacticErrorReporter = syntacticErrorReporter;
    }

    private String removeOuterQuotes(String original) {
        return original.substring(1, original.length() - 1);
    }

    private SourceCodeInformation createSourceCodeInformation(Token token) {
        return new SourceCodeInformation(token.getLine(), token.getCharPositionInLine());
    }

    @Override
    public void reportError(RecognitionException e) {
        if (syntacticErrorReporter == null) {
            super.reportError(e);
        } else {
            String antlrMessage = getErrorMessage(e, this.getTokenNames());
            syntacticErrorReporter.reportError(new SyntacticQLError(e, antlrMessage));
        }
    }


    // $ANTLR start "form"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:50:1: form returns [Form result] : 'form' Ident '{' statementList '}' ;
    public final Form form() throws RecognitionException {
        Form result = null;

        int form_StartIndex = input.index();

        Token Ident1 = null;
        List<Statement> statementList2 = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 1)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:51:3: ( 'form' Ident '{' statementList '}' )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:51:5: 'form' Ident '{' statementList '}'
            {
                match(input, 28, FOLLOW_28_in_form56);
                if (state.failed) return result;
                Ident1 = (Token) match(input, Ident, FOLLOW_Ident_in_form58);
                if (state.failed) return result;
                match(input, 32, FOLLOW_32_in_form60);
                if (state.failed) return result;
                pushFollow(FOLLOW_statementList_in_form62);
                statementList2 = statementList();
                state._fsp--;
                if (state.failed) return result;
                match(input, 34, FOLLOW_34_in_form64);
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = new Form((Ident1 != null ? Ident1.getText() : null), statementList2);
                }
            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 1, form_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "form"


    // $ANTLR start "block"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:57:1: block returns [List<Statement> result] : '{' statementList '}' ;
    public final List<Statement> block() throws RecognitionException {
        List<Statement> result = null;

        int block_StartIndex = input.index();

        List<Statement> statementList3 = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 2)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:58:3: ( '{' statementList '}' )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:58:5: '{' statementList '}'
            {
                match(input, 32, FOLLOW_32_in_block90);
                if (state.failed) return result;
                pushFollow(FOLLOW_statementList_in_block92);
                statementList3 = statementList();
                state._fsp--;
                if (state.failed) return result;
                match(input, 34, FOLLOW_34_in_block94);
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = statementList3;
                }
            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 2, block_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "block"


    // $ANTLR start "statementList"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:64:1: statementList returns [List<Statement> result] : (stmnt= statement )* ;
    public final List<Statement> statementList() throws RecognitionException {
        List<Statement> result = null;

        int statementList_StartIndex = input.index();

        Statement stmnt = null;


        result = new ArrayList<Statement>();

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 3)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:69:3: ( (stmnt= statement )* )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:69:5: (stmnt= statement )*
            {
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:69:5: (stmnt= statement )*
                loop1:
                while (true) {
                    int alt1 = 2;
                    int LA1_0 = input.LA(1);
                    if ((LA1_0 == Ident || LA1_0 == 29)) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                        case 1:
                            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:69:6: stmnt= statement
                        {
                            pushFollow(FOLLOW_statement_in_statementList132);
                            stmnt = statement();
                            state._fsp--;
                            if (state.failed) return result;
                            if (state.backtracking == 0) {
                                result.add(stmnt);
                            }
                        }
                        break;

                        default:
                            break loop1;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 3, statementList_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "statementList"


    // $ANTLR start "statement"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:72:1: statement returns [Statement result] : ( question | computation | conditional );
    public final Statement statement() throws RecognitionException {
        Statement result = null;

        int statement_StartIndex = input.index();

        Question question4 = null;
        Computation computation5 = null;
        Conditional conditional6 = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 4)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:73:3: ( question | computation | conditional )
            int alt2 = 3;
            int LA2_0 = input.LA(1);
            if ((LA2_0 == Ident)) {
                int LA2_1 = input.LA(2);
                if ((LA2_1 == 20)) {
                    int LA2_3 = input.LA(3);
                    if ((LA2_3 == Str)) {
                        int LA2_4 = input.LA(4);
                        if ((LA2_4 == 14)) {
                            alt2 = 2;
                        } else if ((LA2_4 == 26 || (LA2_4 >= 30 && LA2_4 <= 31))) {
                            alt2 = 1;
                        } else {
                            if (state.backtracking > 0) {
                                state.failed = true;
                                return result;
                            }
                            int nvaeMark = input.mark();
                            try {
                                for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
                                    input.consume();
                                }
                                NoViableAltException nvae =
                                        new NoViableAltException("", 2, 4, input);
                                throw nvae;
                            } finally {
                                input.rewind(nvaeMark);
                            }
                        }

                    } else {
                        if (state.backtracking > 0) {
                            state.failed = true;
                            return result;
                        }
                        int nvaeMark = input.mark();
                        try {
                            for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
                                input.consume();
                            }
                            NoViableAltException nvae =
                                    new NoViableAltException("", 2, 3, input);
                            throw nvae;
                        } finally {
                            input.rewind(nvaeMark);
                        }
                    }

                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return result;
                    }
                    int nvaeMark = input.mark();
                    try {
                        input.consume();
                        NoViableAltException nvae =
                                new NoViableAltException("", 2, 1, input);
                        throw nvae;
                    } finally {
                        input.rewind(nvaeMark);
                    }
                }

            } else if ((LA2_0 == 29)) {
                alt2 = 3;
            } else {
                if (state.backtracking > 0) {
                    state.failed = true;
                    return result;
                }
                NoViableAltException nvae =
                        new NoViableAltException("", 2, 0, input);
                throw nvae;
            }

            switch (alt2) {
                case 1:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:73:5: question
                {
                    pushFollow(FOLLOW_question_in_statement153);
                    question4 = question();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = question4;
                    }
                }
                break;
                case 2:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:74:5: computation
                {
                    pushFollow(FOLLOW_computation_in_statement161);
                    computation5 = computation();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = computation5;
                    }
                }
                break;
                case 3:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:75:5: conditional
                {
                    pushFollow(FOLLOW_conditional_in_statement169);
                    conditional6 = conditional();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = conditional6;
                    }
                }
                break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 4, statement_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "statement"


    // $ANTLR start "question"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:78:1: question returns [Question result] : Ident ':' Str datatype ;
    public final Question question() throws RecognitionException {
        Question result = null;

        int question_StartIndex = input.index();

        Token Ident7 = null;
        Token Str8 = null;
        Type datatype9 = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 5)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:79:3: ( Ident ':' Str datatype )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:79:5: Ident ':' Str datatype
            {
                Ident7 = (Token) match(input, Ident, FOLLOW_Ident_in_question188);
                if (state.failed) return result;
                match(input, 20, FOLLOW_20_in_question190);
                if (state.failed) return result;
                Str8 = (Token) match(input, Str, FOLLOW_Str_in_question192);
                if (state.failed) return result;
                pushFollow(FOLLOW_datatype_in_question194);
                datatype9 = datatype();
                state._fsp--;
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    Ident ident = new Ident((Ident7 != null ? Ident7.getText() : null), createSourceCodeInformation(Ident7));
                    Str label = new Str(removeOuterQuotes((Str8 != null ? Str8.getText() : null)), createSourceCodeInformation(Str8));
                    Type datatype = datatype9;
                    result = new Question(ident, label, datatype);
                }
            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 5, question_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "question"


    // $ANTLR start "datatype"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:88:1: datatype returns [Type result] : ( 'boolean' | 'string' | 'integer' );
    public final Type datatype() throws RecognitionException {
        Type result = null;

        int datatype_StartIndex = input.index();

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 6)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:89:3: ( 'boolean' | 'string' | 'integer' )
            int alt3 = 3;
            switch (input.LA(1)) {
                case 26: {
                    alt3 = 1;
                }
                break;
                case 31: {
                    alt3 = 2;
                }
                break;
                case 30: {
                    alt3 = 3;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return result;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);
                    throw nvae;
            }
            switch (alt3) {
                case 1:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:89:5: 'boolean'
                {
                    match(input, 26, FOLLOW_26_in_datatype220);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new BooleanType();
                    }
                }
                break;
                case 2:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:90:5: 'string'
                {
                    match(input, 31, FOLLOW_31_in_datatype228);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new StringType();
                    }
                }
                break;
                case 3:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:91:5: 'integer'
                {
                    match(input, 30, FOLLOW_30_in_datatype236);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new IntegerType();
                    }
                }
                break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 6, datatype_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "datatype"


    // $ANTLR start "computation"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:94:1: computation returns [Computation result] : Ident ':' Str '(' orExpr ')' ;
    public final Computation computation() throws RecognitionException {
        Computation result = null;

        int computation_StartIndex = input.index();

        Token Ident10 = null;
        Token Str11 = null;
        Expression orExpr12 = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 7)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:95:3: ( Ident ':' Str '(' orExpr ')' )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:95:5: Ident ':' Str '(' orExpr ')'
            {
                Ident10 = (Token) match(input, Ident, FOLLOW_Ident_in_computation257);
                if (state.failed) return result;
                match(input, 20, FOLLOW_20_in_computation259);
                if (state.failed) return result;
                Str11 = (Token) match(input, Str, FOLLOW_Str_in_computation261);
                if (state.failed) return result;
                match(input, 14, FOLLOW_14_in_computation263);
                if (state.failed) return result;
                pushFollow(FOLLOW_orExpr_in_computation265);
                orExpr12 = orExpr();
                state._fsp--;
                if (state.failed) return result;
                match(input, 15, FOLLOW_15_in_computation267);
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    Ident ident = new Ident((Ident10 != null ? Ident10.getText() : null), createSourceCodeInformation(Ident10));
                    Str label = new Str(removeOuterQuotes((Str11 != null ? Str11.getText() : null)), createSourceCodeInformation(Str11));
                    Expression expression = orExpr12;
                    result = new Computation(ident, label, expression);
                }
            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 7, computation_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "computation"


    // $ANTLR start "conditional"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:104:1: conditional returns [Conditional result] : 'if' '(' condition= orExpr ')' success= block ( ( 'else' )=> 'else' failure= block | () ) ;
    public final Conditional conditional() throws RecognitionException {
        Conditional result = null;

        int conditional_StartIndex = input.index();

        Expression condition = null;
        List<Statement> success = null;
        List<Statement> failure = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 8)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:105:3: ( 'if' '(' condition= orExpr ')' success= block ( ( 'else' )=> 'else' failure= block | () ) )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:105:5: 'if' '(' condition= orExpr ')' success= block ( ( 'else' )=> 'else' failure= block | () )
            {
                match(input, 29, FOLLOW_29_in_conditional292);
                if (state.failed) return result;
                match(input, 14, FOLLOW_14_in_conditional294);
                if (state.failed) return result;
                pushFollow(FOLLOW_orExpr_in_conditional298);
                condition = orExpr();
                state._fsp--;
                if (state.failed) return result;
                match(input, 15, FOLLOW_15_in_conditional300);
                if (state.failed) return result;
                pushFollow(FOLLOW_block_in_conditional304);
                success = block();
                state._fsp--;
                if (state.failed) return result;
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:106:5: ( ( 'else' )=> 'else' failure= block | () )
                int alt4 = 2;
                int LA4_0 = input.LA(1);
                if ((LA4_0 == 27) && (synpred6_QL())) {
                    alt4 = 1;
                } else if ((LA4_0 == EOF || LA4_0 == Ident || LA4_0 == 29 || LA4_0 == 34)) {
                    alt4 = 2;
                } else {
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return result;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);
                    throw nvae;
                }

                switch (alt4) {
                    case 1:
                        // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:106:7: ( 'else' )=> 'else' failure= block
                    {
                        match(input, 27, FOLLOW_27_in_conditional318);
                        if (state.failed) return result;
                        pushFollow(FOLLOW_block_in_conditional322);
                        failure = block();
                        state._fsp--;
                        if (state.failed) return result;
                        if (state.backtracking == 0) {
                            result = new IfElseStatement(condition, success, failure);
                        }
                    }
                    break;
                    case 2:
                        // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:107:7: ()
                    {
                        // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:107:7: ()
                        // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:107:9:
                        {
                        }

                        if (state.backtracking == 0) {
                            result = new IfStatement(condition, success);
                        }
                    }
                    break;

                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 8, conditional_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "conditional"


    // $ANTLR start "primary"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:111:1: primary returns [Expression result] : ( Int | Bool | Str | Ident | '(' x= orExpr ')' );
    public final Expression primary() throws RecognitionException {
        Expression result = null;

        int primary_StartIndex = input.index();

        Token Int13 = null;
        Token Bool14 = null;
        Token Str15 = null;
        Token Ident16 = null;
        Expression x = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 9)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:112:3: ( Int | Bool | Str | Ident | '(' x= orExpr ')' )
            int alt5 = 5;
            switch (input.LA(1)) {
                case Int: {
                    alt5 = 1;
                }
                break;
                case Bool: {
                    alt5 = 2;
                }
                break;
                case Str: {
                    alt5 = 3;
                }
                break;
                case Ident: {
                    alt5 = 4;
                }
                break;
                case 14: {
                    alt5 = 5;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return result;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);
                    throw nvae;
            }
            switch (alt5) {
                case 1:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:112:5: Int
                {
                    Int13 = (Token) match(input, Int, FOLLOW_Int_in_primary359);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Int(Integer.parseInt((Int13 != null ? Int13.getText() : null)), createSourceCodeInformation(Int13));
                    }
                }
                break;
                case 2:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:113:5: Bool
                {
                    Bool14 = (Token) match(input, Bool, FOLLOW_Bool_in_primary369);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Bool(Boolean.parseBoolean((Bool14 != null ? Bool14.getText() : null)), createSourceCodeInformation(Bool14));
                    }
                }
                break;
                case 3:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:114:5: Str
                {
                    Str15 = (Token) match(input, Str, FOLLOW_Str_in_primary378);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Str(removeOuterQuotes((Str15 != null ? Str15.getText() : null)), createSourceCodeInformation(Str15));
                    }
                }
                break;
                case 4:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:115:5: Ident
                {
                    Ident16 = (Token) match(input, Ident, FOLLOW_Ident_in_primary388);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Ident((Ident16 != null ? Ident16.getText() : null), createSourceCodeInformation(Ident16));
                    }
                }
                break;
                case 5:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:116:5: '(' x= orExpr ')'
                {
                    match(input, 14, FOLLOW_14_in_primary396);
                    if (state.failed) return result;
                    pushFollow(FOLLOW_orExpr_in_primary400);
                    x = orExpr();
                    state._fsp--;
                    if (state.failed) return result;
                    match(input, 15, FOLLOW_15_in_primary402);
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = x;
                    }
                }
                break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 9, primary_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "primary"


    // $ANTLR start "unExpr"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:119:1: unExpr returns [Expression result] : (op= '+' x= unExpr |op= '-' x= unExpr |op= '!' x= unExpr |x= primary );
    public final Expression unExpr() throws RecognitionException {
        Expression result = null;

        int unExpr_StartIndex = input.index();

        Token op = null;
        Expression x = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 10)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:120:5: (op= '+' x= unExpr |op= '-' x= unExpr |op= '!' x= unExpr |x= primary )
            int alt6 = 4;
            switch (input.LA(1)) {
                case 17: {
                    alt6 = 1;
                }
                break;
                case 18: {
                    alt6 = 2;
                }
                break;
                case 11: {
                    alt6 = 3;
                }
                break;
                case Bool:
                case Ident:
                case Int:
                case Str:
                case 14: {
                    alt6 = 4;
                }
                break;
                default:
                    if (state.backtracking > 0) {
                        state.failed = true;
                        return result;
                    }
                    NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);
                    throw nvae;
            }
            switch (alt6) {
                case 1:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:120:8: op= '+' x= unExpr
                {
                    op = (Token) match(input, 17, FOLLOW_17_in_unExpr425);
                    if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr429);
                    x = unExpr();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Positive(x, createSourceCodeInformation(op));
                    }
                }
                break;
                case 2:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:121:8: op= '-' x= unExpr
                {
                    op = (Token) match(input, 18, FOLLOW_18_in_unExpr442);
                    if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr446);
                    x = unExpr();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Negative(x, createSourceCodeInformation(op));
                    }
                }
                break;
                case 3:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:122:8: op= '!' x= unExpr
                {
                    op = (Token) match(input, 11, FOLLOW_11_in_unExpr459);
                    if (state.failed) return result;
                    pushFollow(FOLLOW_unExpr_in_unExpr463);
                    x = unExpr();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = new Not(x, createSourceCodeInformation(op));
                    }
                }
                break;
                case 4:
                    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:123:8: x= primary
                {
                    pushFollow(FOLLOW_primary_in_unExpr476);
                    x = primary();
                    state._fsp--;
                    if (state.failed) return result;
                    if (state.backtracking == 0) {
                        result = x;
                    }
                }
                break;

            }
        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 10, unExpr_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "unExpr"


    // $ANTLR start "mulExpr"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:126:1: mulExpr returns [Expression result] : lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* ;
    public final Expression mulExpr() throws RecognitionException {
        Expression result = null;

        int mulExpr_StartIndex = input.index();

        Token op = null;
        Expression lhs = null;
        Expression rhs = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 11)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:127:5: (lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )* )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:127:9: lhs= unExpr (op= ( '*' | '/' ) rhs= unExpr )*
            {
                pushFollow(FOLLOW_unExpr_in_mulExpr514);
                lhs = unExpr();
                state._fsp--;
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = lhs;
                }
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:127:45: (op= ( '*' | '/' ) rhs= unExpr )*
                loop7:
                while (true) {
                    int alt7 = 2;
                    int LA7_0 = input.LA(1);
                    if ((LA7_0 == 16 || LA7_0 == 19)) {
                        alt7 = 1;
                    }

                    switch (alt7) {
                        case 1:
                            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:127:47: op= ( '*' | '/' ) rhs= unExpr
                        {
                            op = input.LT(1);
                            if (input.LA(1) == 16 || input.LA(1) == 19) {
                                input.consume();
                                state.errorRecovery = false;
                                state.failed = false;
                            } else {
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return result;
                                }
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                throw mse;
                            }
                            pushFollow(FOLLOW_unExpr_in_mulExpr534);
                            rhs = unExpr();
                            state._fsp--;
                            if (state.failed) return result;
                            if (state.backtracking == 0) {
                                SourceCodeInformation sourceCodeInformation = createSourceCodeInformation(op);
                                if ((op != null ? op.getText() : null).equals("*")) {
                                    result = new Multiply(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals("/")) {
                                    result = new Divide(result, rhs, sourceCodeInformation);
                                }
                            }
                        }
                        break;

                        default:
                            break loop7;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 11, mulExpr_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "mulExpr"


    // $ANTLR start "addExpr"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:140:1: addExpr returns [Expression result] : lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* ;
    public final Expression addExpr() throws RecognitionException {
        Expression result = null;

        int addExpr_StartIndex = input.index();

        Token op = null;
        Expression lhs = null;
        Expression rhs = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 12)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:141:5: (lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )* )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:141:9: lhs= mulExpr (op= ( '+' | '-' ) rhs= mulExpr )*
            {
                pushFollow(FOLLOW_mulExpr_in_addExpr576);
                lhs = mulExpr();
                state._fsp--;
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = lhs;
                }
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:141:46: (op= ( '+' | '-' ) rhs= mulExpr )*
                loop8:
                while (true) {
                    int alt8 = 2;
                    int LA8_0 = input.LA(1);
                    if (((LA8_0 >= 17 && LA8_0 <= 18))) {
                        alt8 = 1;
                    }

                    switch (alt8) {
                        case 1:
                            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:141:48: op= ( '+' | '-' ) rhs= mulExpr
                        {
                            op = input.LT(1);
                            if ((input.LA(1) >= 17 && input.LA(1) <= 18)) {
                                input.consume();
                                state.errorRecovery = false;
                                state.failed = false;
                            } else {
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return result;
                                }
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                throw mse;
                            }
                            pushFollow(FOLLOW_mulExpr_in_addExpr594);
                            rhs = mulExpr();
                            state._fsp--;
                            if (state.failed) return result;
                            if (state.backtracking == 0) {
                                SourceCodeInformation sourceCodeInformation = createSourceCodeInformation(op);
                                if ((op != null ? op.getText() : null).equals("+")) {
                                    result = new Add(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals("-")) {
                                    result = new Subtract(result, rhs, sourceCodeInformation);
                                }
                            }
                        }
                        break;

                        default:
                            break loop8;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 12, addExpr_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "addExpr"


    // $ANTLR start "relExpr"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:153:1: relExpr returns [Expression result] : lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* ;
    public final Expression relExpr() throws RecognitionException {
        Expression result = null;

        int relExpr_StartIndex = input.index();

        Token op = null;
        Expression lhs = null;
        Expression rhs = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 13)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:154:5: (lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )* )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:154:9: lhs= addExpr (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
            {
                pushFollow(FOLLOW_addExpr_in_relExpr630);
                lhs = addExpr();
                state._fsp--;
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = lhs;
                }
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:154:46: (op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr )*
                loop9:
                while (true) {
                    int alt9 = 2;
                    int LA9_0 = input.LA(1);
                    if ((LA9_0 == 12 || (LA9_0 >= 21 && LA9_0 <= 25))) {
                        alt9 = 1;
                    }

                    switch (alt9) {
                        case 1:
                            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:154:48: op= ( '<' | '<=' | '>' | '>=' | '==' | '!=' ) rhs= addExpr
                        {
                            op = input.LT(1);
                            if (input.LA(1) == 12 || (input.LA(1) >= 21 && input.LA(1) <= 25)) {
                                input.consume();
                                state.errorRecovery = false;
                                state.failed = false;
                            } else {
                                if (state.backtracking > 0) {
                                    state.failed = true;
                                    return result;
                                }
                                MismatchedSetException mse = new MismatchedSetException(null, input);
                                throw mse;
                            }
                            pushFollow(FOLLOW_addExpr_in_relExpr654);
                            rhs = addExpr();
                            state._fsp--;
                            if (state.failed) return result;
                            if (state.backtracking == 0) {
                                SourceCodeInformation sourceCodeInformation = createSourceCodeInformation(op);
                                if ((op != null ? op.getText() : null).equals("<")) {
                                    result = new LessThan(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals("<=")) {
                                    result = new LessThanOrEqualTo(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals(">")) {
                                    result = new GreaterThan(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals(">=")) {
                                    result = new GreaterThanOrEqualTo(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals("==")) {
                                    result = new EqualTo(result, rhs, sourceCodeInformation);
                                }
                                if ((op != null ? op.getText() : null).equals("!=")) {
                                    result = new NotEqualTo(result, rhs, sourceCodeInformation);
                                }
                            }
                        }
                        break;

                        default:
                            break loop9;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 13, relExpr_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "relExpr"


    // $ANTLR start "andExpr"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:178:1: andExpr returns [Expression result] : lhs= relExpr (op= '&&' rhs= relExpr )* ;
    public final Expression andExpr() throws RecognitionException {
        Expression result = null;

        int andExpr_StartIndex = input.index();

        Token op = null;
        Expression lhs = null;
        Expression rhs = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 14)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:179:5: (lhs= relExpr (op= '&&' rhs= relExpr )* )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:179:9: lhs= relExpr (op= '&&' rhs= relExpr )*
            {
                pushFollow(FOLLOW_relExpr_in_andExpr693);
                lhs = relExpr();
                state._fsp--;
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = lhs;
                }
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:179:46: (op= '&&' rhs= relExpr )*
                loop10:
                while (true) {
                    int alt10 = 2;
                    int LA10_0 = input.LA(1);
                    if ((LA10_0 == 13)) {
                        alt10 = 1;
                    }

                    switch (alt10) {
                        case 1:
                            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:179:48: op= '&&' rhs= relExpr
                        {
                            op = (Token) match(input, 13, FOLLOW_13_in_andExpr701);
                            if (state.failed) return result;
                            pushFollow(FOLLOW_relExpr_in_andExpr705);
                            rhs = relExpr();
                            state._fsp--;
                            if (state.failed) return result;
                            if (state.backtracking == 0) {
                                result = new And(result, rhs, createSourceCodeInformation(op));
                            }
                        }
                        break;

                        default:
                            break loop10;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 14, andExpr_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "andExpr"


    // $ANTLR start "orExpr"
    // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:183:1: orExpr returns [Expression result] : lhs= andExpr (op= '||' rhs= andExpr )* ;
    public final Expression orExpr() throws RecognitionException {
        Expression result = null;

        int orExpr_StartIndex = input.index();

        Token op = null;
        Expression lhs = null;
        Expression rhs = null;

        try {
            if (state.backtracking > 0 && alreadyParsedRule(input, 15)) {
                return result;
            }

            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:184:5: (lhs= andExpr (op= '||' rhs= andExpr )* )
            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:184:9: lhs= andExpr (op= '||' rhs= andExpr )*
            {
                pushFollow(FOLLOW_andExpr_in_orExpr740);
                lhs = andExpr();
                state._fsp--;
                if (state.failed) return result;
                if (state.backtracking == 0) {
                    result = lhs;
                }
                // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:184:48: (op= '||' rhs= andExpr )*
                loop11:
                while (true) {
                    int alt11 = 2;
                    int LA11_0 = input.LA(1);
                    if ((LA11_0 == 33)) {
                        alt11 = 1;
                    }

                    switch (alt11) {
                        case 1:
                            // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:184:50: op= '||' rhs= andExpr
                        {
                            op = (Token) match(input, 33, FOLLOW_33_in_orExpr748);
                            if (state.failed) return result;
                            pushFollow(FOLLOW_andExpr_in_orExpr752);
                            rhs = andExpr();
                            state._fsp--;
                            if (state.failed) return result;
                            if (state.backtracking == 0) {
                                result = new Or(result, rhs, createSourceCodeInformation(op));
                            }
                        }
                        break;

                        default:
                            break loop11;
                    }
                }

            }

        } catch (RecognitionException re) {
            reportError(re);
            recover(input, re);
        } finally {
            // do for sure before leaving
            if (state.backtracking > 0) {
                memoize(input, 15, orExpr_StartIndex);
            }

        }
        return result;
    }
    // $ANTLR end "orExpr"

    // $ANTLR start synpred6_QL
    public final void synpred6_QL_fragment() throws RecognitionException {
        // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:106:7: ( 'else' )
        // /home/sander/Documents/workspace/freshSeaOfQL/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parsing/antlr/QL.g:106:8: 'else'
        {
            match(input, 27, FOLLOW_27_in_synpred6_QL313);
            if (state.failed) return;
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
            System.err.println("impossible: " + re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed = false;
        return success;
    }


    public static final BitSet FOLLOW_28_in_form56 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Ident_in_form58 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_form60 = new BitSet(new long[]{0x0000000420000080L});
    public static final BitSet FOLLOW_statementList_in_form62 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_form64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_block90 = new BitSet(new long[]{0x0000000420000080L});
    public static final BitSet FOLLOW_statementList_in_block92 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_block94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statementList132 = new BitSet(new long[]{0x0000000020000082L});
    public static final BitSet FOLLOW_question_in_statement153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_computation_in_statement161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_in_statement169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_question188 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_question190 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Str_in_question192 = new BitSet(new long[]{0x00000000C4000000L});
    public static final BitSet FOLLOW_datatype_in_question194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_datatype220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_datatype228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_datatype236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_computation257 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_computation259 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Str_in_computation261 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_computation263 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_orExpr_in_computation265 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_computation267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_conditional292 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_conditional294 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_orExpr_in_conditional298 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_conditional300 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_conditional304 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_conditional318 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_conditional322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Int_in_primary359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Bool_in_primary369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Str_in_primary378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ident_in_primary388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_primary396 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_orExpr_in_primary400 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_primary402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_unExpr425 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_unExpr_in_unExpr429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unExpr442 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_unExpr_in_unExpr446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_unExpr459 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_unExpr_in_unExpr463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unExpr476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr514 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_set_in_mulExpr522 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_unExpr_in_mulExpr534 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr576 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_addExpr584 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_mulExpr_in_addExpr594 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_addExpr_in_relExpr630 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_set_in_relExpr638 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_addExpr_in_relExpr654 = new BitSet(new long[]{0x0000000003E01002L});
    public static final BitSet FOLLOW_relExpr_in_andExpr693 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_andExpr701 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_relExpr_in_andExpr705 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr740 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_orExpr748 = new BitSet(new long[]{0x0000000000064B90L});
    public static final BitSet FOLLOW_andExpr_in_orExpr752 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_27_in_synpred6_QL313 = new BitSet(new long[]{0x0000000000000002L});
}
