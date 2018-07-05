package prjx.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import prjx.SqlLanguage;

public class SqlElementType extends IElementType {
    public SqlElementType(@NotNull @NonNls String debugName) {
        super(debugName, SqlLanguage.INSTANCE);
    }
}