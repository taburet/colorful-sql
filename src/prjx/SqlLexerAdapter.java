package prjx;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class SqlLexerAdapter extends FlexAdapter {
    public SqlLexerAdapter() {
        super(new SqlLexer((Reader) null));
    }
}