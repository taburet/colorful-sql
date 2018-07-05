package prjx;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import prjx.psi.SqlTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SqlSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    private static final TextAttributesKey PROPERTY = createTextAttributesKey("HZ_SQL_PROPERTY",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    private static final TextAttributesKey OPERATOR = createTextAttributesKey("HZ_SQL_OPERATOR",
            DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey VALUE = createTextAttributesKey("HZ_SQL_LITERAL",
            DefaultLanguageHighlighterColors.NUMBER);
    private static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("HZ_SQL_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] PROPERTY_KEYS = new TextAttributesKey[]{PROPERTY};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public SyntaxHighlighter getSyntaxHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile) {
        return new SyntaxHighlighter() {
            @NotNull
            @Override
            public Lexer getHighlightingLexer() {
                return new SqlLexerAdapter();
            }

            @NotNull
            @Override
            public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
                if (tokenType.equals(SqlTypes.PROPERTY)) {
                    return PROPERTY_KEYS;
                } else if (tokenType.equals(SqlTypes.OPERATOR) || tokenType.equals(SqlTypes.LOGICAL)) {
                    return OPERATOR_KEYS;
                } else if (tokenType.equals(SqlTypes.LITERAL)) {
                    return VALUE_KEYS;
                } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
                    return BAD_CHAR_KEYS;
                } else {
                    return EMPTY_KEYS;
                }
            }
        };
    }

}
