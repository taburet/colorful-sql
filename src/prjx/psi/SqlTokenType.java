package prjx.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import prjx.SqlLanguage;

public class SqlTokenType extends IElementType {
    public SqlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SqlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SqlTokenType." + super.toString();
    }
}