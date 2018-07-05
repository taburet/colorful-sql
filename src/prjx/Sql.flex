package prjx;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import prjx.psi.SqlTypes;
import com.intellij.psi.TokenType;

%%

%class SqlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[\ \n\t\f\R]
LOGICAL=and|or
PROPERTY_CHAR=[A-Za-z]
OPERATOR=>|>=|=|<|<=
LITERAL=[0-9]+|'[^']*'

%state WAITING_VALUE

%%

{LOGICAL}                                                   { yybegin(YYINITIAL); return SqlTypes.LOGICAL; }

{PROPERTY_CHAR}+                                            { yybegin(YYINITIAL); return SqlTypes.PROPERTY; }

{OPERATOR}                                                  { yybegin(YYINITIAL); return SqlTypes.OPERATOR; }

{LITERAL}                                                   { yybegin(YYINITIAL); return SqlTypes.LITERAL; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }
